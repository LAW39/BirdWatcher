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
	Dim MapLookupFlag As Boolean = False
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private SpeciesList As ListView
	Private AddNow As Button
	Private FlockSize As EditText
	Private BirdAppearance As EditText
	Private WeatherConditions As EditText
	Private Time As Label
	Private BirdPhotoView As ImageView
	Private SelectedID As Int = 0
	Private Date As Label
	Private MapCheck As CheckBox
	Private Location As Location
	Private DateTimeTicks As Long
	Private GetLocation As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Log(Starter.GPS1)
	Log(Starter.L1)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("sightingadd")
	Activity.Title = "Sightings"
	DateTime.Dateformat = "dd/MM/yyyy"
	DateTime.TimeFormat= "HH:mm"
	Dim SpeciesCursor As Cursor
	SpeciesCursor = Starter.Database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")
	SpeciesList.clear
	If MapLookupFlag Then
		OpenSightingInfo(Map.SelectedID)
		MapLookupFlag = False
	Else
		For i=0 To SpeciesCursor.RowCount-1
			SpeciesCursor.Position = i
			SpeciesList.AddSingleLine2(SpeciesCursor.GetString("Name"),SpeciesCursor.GetString("ID"))	
		Next
	
	End If
	Location.Initialize
End Sub

Sub Activity_Resume



If Starter.GPS1.GPSEnabled = False Then
	ToastMessageShow("Please enable the GPS device.", True)
	StartActivity(Starter.GPS1.LocationSettingsIntent) 'Will open the relevant settings screen.
End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub AddNow_Click
	
	If MapCheck.Checked = False Then
		Location.Latitude = Starter.L1.Latitude
		Location.Longitude = Starter.L1.longitude
	Else
		Map.GetLocationFlag = True
		Location.Latitude = Map.Location.Latitude
		Location.Longitude = Map.Location.Longitude
	End If

	Dim Date_Time(2) As String
	Date_Time(0) = Date.text
	Date_Time(1) = Time.Text
	
	If Date_Time(0) = "" Then
		Date_Time(0) = DateTime.GetDayOfMonth(DateTime.Now) & "/" & DateTime.GetMonth(DateTime.Now) & "/" & DateTime.GetYear(DateTime.Now)
	End If
	
	If Date_Time(1) = "" Then
		Date_Time(1) = DateTime.GetHour(DateTime.Now) & ":" & DateTime.Getminute(DateTime.Now) & ":" & DateTime.Getsecond(DateTime.Now)
	End If
	
	Log(Starter.L1)
	DateTimeTicks = DateTime.DateTimeParse(Date_Time(0), Date_Time(1))
	Log(DateTimeTicks)
	
	ExportData

End Sub

Sub ExportData
	

	 
	Dim SightingSQL As StringBuilder
	Dim InsertData(7) As String

	SightingSQL.Initialize
	InsertData(0) = SelectedID
	InsertData(1) = FlockSize.Text
	InsertData(2) = WeatherConditions.Text
	InsertData(3) =	 BirdAppearance.Text
	InsertData(4) = DateTimeTicks
	InsertData(5) = Location.Latitude
	InsertData(6) = Location.Longitude
	
	
	SightingSQL.Append("INSERT INTO Sightings (SpeciesID,FlockSize,Weather,Appearance,Epoch,Lat,Lng) VALUES (?, ?, ?, ?, ?, ?, ?)")
	
	Starter.database.ExecNonQuery2(SightingSQL, InsertData)

End Sub

Sub GPSReady
	If Starter.GPS1.GPSEnabled= False Then
 		ToastMessageShow("Please enable your device's GPS capabilities", True)
 	StartActivity(Starter.GPS1.LocationSettingsIntent)
	Else
		Starter.gps1.Start(0,0)
		ProgressDialogShow("Waiting for GPS location")
	End If
End Sub

Sub GPS1_LocationChanged (gpsLocation As Location)
   ProgressDialogHide
   Starter.L1=gpsLocation
   Starter.gps1.Stop
 End Sub

Sub GetLocation_Click
	If MapCheck.Checked = False Then
		GPSReady
	Else
		Map.GetLocationFlag = True
		StartActivity("Map")
	End If
End Sub

Sub SpeciesList_ItemClick (Position As Int, Value As Object)
	SelectedID = Value -1
	If Position = -1 Then
		Return
	End If
	LoadBirdPic(SelectedID)
	
End Sub

Sub LoadBirdPic(ID As Int)
	ID = ID +1
	
	Dim NewBird As Bitmap
	NewBird.InitializeSample(File.DirAssets, ID & ".jpg", 240, 240)
	BirdPhotoView.Bitmap = NewBird

End Sub

Public Sub OpenSightingInfo(ID As Int)
	ID = ID + 1
	SpeciesList_ItemClick (ID,ID)
	LoadAttributes(ID)

	Return 
End Sub

Sub LoadAttributes(ID As Int)
	Dim Cursor As Cursor
		Cursor = Starter.database.ExecQuery("SELECT * FROM Sightings WHERE ID =" & ID)
		Cursor.Position = 0
		FlockSize.Text = Cursor.GetString("FlockSize")
		BirdAppearance.Text = Cursor.GetString("Appearance")
		WeatherConditions.Text = Cursor.GetString("Weather")
		Date.Text = DateTime.Date(Cursor.GetLong("Epoch"))
		Time.Text = DateTime.Time(Cursor.GetLong("Epoch"))
End Sub


Sub Date_Click
			Dim DateDialog As DateDialog
	Dim DialogRet As Int
	
	DateDialog.DateTicks = DateTime.Now
	
	DialogRet = DateDialog.Show("","Select date","Ok","Cancel","",Null)
	 
	 If DialogRet = DialogResponse.POSITIVE Then
	 	Date.Text = DateTime.Date(DateDialog.DateTicks)	
	End If
End Sub

Sub Time_Click
	Dim TimeDialog As TimeDialog
	Dim DialogRet As Int
	
	TimeDialog.TimeTicks = DateTime.Now
	
	DialogRet = TimeDialog.Show("","Select time","Ok","Cancel","",Null)
	 
	 If DialogRet = DialogResponse.POSITIVE Then
	 	Time.Text = DateTime.Time(TimeDialog.TimeTicks)	
	End If
End Sub
