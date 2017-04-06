Type=Activity
Version=6.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public MapTimer As Timer
	Public SelectedID As Int
	Public GetLocationFlag As Boolean = False
	Public Location As LatLng
	Public SelectedBird As Boolean
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private gmap As GoogleMap
	
	Private MapSetupCompleted As Boolean
	Private MainMap As MapFragment
	Private SpeciesList As ListView
	Private BirdImage As ImageView
	Private MoreInfo As Button

	Private DateTime1 As EditText
	Private Name As EditText

End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("MainScreen")
	Activity.Title = "Map"
	
	If MainMap.IsGooglePlayServicesAvailable = False Then
    	ToastMessageShow("Please install Google Play Services.", True)
    End If
	
	SpeciesList.SingleLineLayout.Label.TextColor = Colors.black
	
	Location.Initialize(0,0)
		
	'prepare the map setup
	MapSetupCompleted = False
	MapTimer.Initialize("LootTimer",1000)
	
	Dim SpeciesCursor As Cursor
	SpeciesCursor = Starter.Database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")
	SpeciesList.clear
		
	For i=0 To SpeciesCursor.RowCount-1
		SpeciesCursor.Position = i
		SpeciesList.AddSingleLine2(SpeciesCursor.GetString("Name"),SpeciesCursor.GetString("ID"))	
	Next
End Sub

Public Sub GetLocation
	
	
	Activity.LoadLayout("MainScreen")
End Sub

Sub Activity_Resume
	'SetupMapLocation
	If (MapSetupCompleted = False) Then
		MapTimer.Enabled = True	
	End If
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	MapTimer.Enabled = False
End Sub

Sub LootTimer_Tick
	'this timer runs every 3 seconds and checks if the map has been set up
	
	'try to run the map setup code, but only if the Gmap object is ready
	If ((gmap.IsInitialized) And (gmap.MyLocation.IsInitialized)) Then
		MapSetupCompleted = True
		MapTimer.Enabled = False		
	End If
	
End Sub



Sub MainScreen_Click
	StartActivity(Main)	
End Sub

Sub MainMap_Ready
	gmap = MainMap.GetMap
 		
	Log("Mylocation:" & gmap.MyLocationEnabled)
	
End Sub

Sub SetupMapLocation
	
	Dim p As Phone
	

	'move to my location
	If ((Starter.GPS1.GPSEnabled) And (p.IsAirplaneModeOn = False)) Then
		'location is enabled, move to location
		Dim NewMapPosition As CameraPosition
		NewMapPosition.Initialize(gmap.MyLocation.Latitude, gmap.MyLocation.Longitude, 12)	
		gmap.MoveCamera(NewMapPosition)		
	Else
		If (p.IsAirplaneModeOn) Then
			ToastMessageShow("Airplane mode is enabled. Internet connection needed for maps",True)
		Else
				
			'tell the user that need to enable the GPS on the device
			ToastMessageShow("Device GPS is disabled. Please enable now",True)
			StartActivity(Starter.GPS1.LocationSettingsIntent)	
		End If	
		
	End If		
	
End Sub

Sub MapTestButton_Click
	
	SetupMapLocation
	
End Sub

Sub MainMap_MarkerClick (SelectedMarker As Marker) As Boolean 'Return True to consume the click
	
	Dim BirdCursor As Cursor
	Dim MapSQL As String
	
	'check if marker clicked was a new marker
	If (SelectedMarker.Snippet = "0") Then
		ToastMessageShow("Location new loot to be added at",False)
		Return True		
	End If
	
	
	
	MapSQL = "SELECT * FROM Sightings WHERE ID = ?"
	
	BirdCursor = Starter.Database.ExecQuery2(MapSQL, Array As String(SelectedMarker.Snippet))
	BirdCursor.Position = 0	
	
	
	Name.Text = BirdCursor.GetString("Weather")
	DateTime1.Text = DateTime.Date(BirdCursor.GetString("Epoch")) & " " & DateTime.Time(BirdCursor.GetString("Epoch"))

	SelectedBird = True
	
	Return True 'stop the pop up text box from being shown
End Sub

Sub LoadBirdPic(BirdID As Int)
	
	Dim NewBird As Bitmap
	NewBird.InitializeSample(File.DirAssets,BirdID  & ".jpg", 240, 240)
	BirdImage.Bitmap = NewBird

End Sub

Sub LoadBird(ID As Int)
	ID = ID +1
	'clear out the current marks on the map
	gmap.Clear
	
	Name.Text = ""
	DateTime1.Text = ""
	
	Dim SpeciesCursor As Cursor
	Dim MapSQL As StringBuilder
	Dim ErrorFlag As Boolean = False
	MapSQL.Initialize
	
	MapSQL.Append("SELECT * FROM Sightings").Append(CRLF)
	MapSQL.Append("WHERE ID = ?").Append(CRLF)
	MapSQL.Append("ORDER BY ID Asc").Append(CRLF)
	ErrorFlag= False
	SpeciesCursor = Starter.Database.ExecQuery2(MapSQL,Array As String(ID))
	
	'add all loot records to the map
	For i=0 To SpeciesCursor.RowCount-1
		
		SpeciesCursor.Position = i
		
		Dim SightingMarker As Marker
		
		'setup the marker bitmap
		
		Log("LAT: " & SpeciesCursor.GetDouble("Lat"))
		Log("LNG: " & SpeciesCursor.GetDouble("Lng"))
		
		
		'add the marker - vary colour based on Loot type
		If SpeciesCursor.GetDouble("Lat") = "0" Then
			If SpeciesCursor.GetDouble("Lng") = "0" Then
				ErrorFlag = True
			End If
			
		End If	
		
		If ErrorFlag = False Then
			SightingMarker = gmap.AddMarker2(SpeciesCursor.GetDouble("Lat"),SpeciesCursor.GetDouble("Lng"),SpeciesCursor.GetString("SpeciesID"), gmap.HUE_RED)	
			
			SightingMarker.Draggable = False
			SightingMarker.Snippet = SpeciesCursor.GetInt("ID")	
			SightingMarker.Visible = True
		End If
	Next	
	
End Sub

Sub SpeciesList_ItemClick (Position As Int, Value As Object)
	SelectedID = Value
	If Position = -1 Then
		Return
	End If
	LoadBirdPic(SelectedID)
	LoadBird(SelectedID)
End Sub


Sub MoreInfo_Click
	If SelectedBird = True Then
		Sightings.MapLookupFlag = True
		StartActivity(Sightings)
	Else
		Msgbox("Please select a sighting using the map above first", "Error")
	End If
End Sub

Sub MainMap_LongClick (Point As LatLng)
	If GetLocationFlag = True Then
		Location = Point
		Activity.Finish
	End If
End Sub