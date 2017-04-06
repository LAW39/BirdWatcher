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
	Dim SightingPhotoList As List
	Dim SightID As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	
	Private Phototab As TabStrip
	Private SightingPhoto As ImageView
	Private RemoveBtn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Log(SightID)
	Activity.LoadLayout("SightingPhotos")
	Phototab.LoadLayout("PhotoTab","Species Picture")
	Load_Photos(SightID)
	Activity.Title = ("Photos")
	Log(SightingPhotoList.Size)
	For i = 0 To SightingPhotoList.Size-1
		
		Dim PhotoInt As String = i+1
		Phototab.LoadLayout("PhotoTab",PhotoInt)
		
	Next
	Phototab_PageSelected (0)
	
End Sub

Sub Load_Photos(SightingID As Int)
	SightingPhotoList.Initialize
	Log(SightingID)
	Dim SpeciesCursor As Cursor
	Dim SQLQuery As StringBuilder
	Dim SightingPicture As Bitmap
	Dim BirdPhotoFile As Double
	SQLQuery.Initialize
	SQLQuery.Append("SELECT PhotoDir").Append(CRLF)
	SQLQuery.Append("FROM SightingPhoto").Append(CRLF)
	SQLQuery.Append("LEFT JOIN Sightings ON Sightings.ID = SightingPhoto.SightingID").Append(CRLF)
	SQLQuery.Append("WHERE Sightings.ID = ?").Append(CRLF)
	
	SpeciesCursor = Starter.Database.ExecQuery2(SQLQuery,Array As String(SightingID))
	SpeciesCursor.Position = 0
	Log(SpeciesCursor.RowCount & "Test")
'	Try
		For counter = 0 To SpeciesCursor.RowCount
			BirdPhotoFile = SpeciesCursor.GetInt("PhotoDir")
			SightingPicture.Initialize(Main.BirdPhotoPath,BirdPhotoFile & ".jpg")
			SightingPhotoList.Add(SightingPicture)
		Next
'	Catch
'		ToastMessageShow("No sighting images",True)
'	End Try
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub LoadBirdPic(SightingID As Int) As Object
	
	Log(SightingID)
	Dim SpeciesCursor As Cursor
	Dim SQLQuery As StringBuilder
	Dim NewBird As Bitmap
	SQLQuery.Initialize
	ToastMessageShow(SightingID,True)
	SQLQuery.Append("SELECT ImagePath").Append(CRLF)
	SQLQuery.append("FROM Species").Append(CRLF)
	SQLQuery.Append("LEFT JOIN Sightings ON Sightings.SpeciesID = Species.ID").Append(CRLF)
	SQLQuery.Append("WHERE Sightings.ID = ?").Append(CRLF)
	SpeciesCursor = Starter.Database.ExecQuery2(SQLQuery,Array As String(SightingID))
	SpeciesCursor.Position = 0
'	Try
		NewBird.InitializeSample(Main.BirdPhotoPath,SpeciesCursor.GetLong("ImagePath") & ".jpg", 620, 480)
'	Catch
'		NewBird.InitializeSample(Main.BirdPhotoPath,"0.jpg", 2400, 2400)
'		Log("Image not Found " & SightingID)
'		ToastMessageShow("Image not found", True)
'	End Try

	Return(NewBird)
End Sub

Sub Phototab_PageSelected (Position As Int)
	Log(Position)
	Log("Code Run")
	If Position = 0 Then
		SightingPhoto.bitmap = LoadBirdPic(SightID)
		RemoveBtn.Visible = False		
		Return		
	End If
	
	Position = Position - 1
	RemoveBtn.Visible = True
'	Try
		SightingPhoto.bitmap =  SightingPhotoList.Get(Position)
'	Catch
'		Dim Photo As Bitmap
'		Photo.InitializeSample(Main.BirdPhotoPath,"0.jpg", 2400, 2400)
'		SightingPhoto.bitmap = Photo
'		Log("Image not Found " & Position)
'		ToastMessageShow("Image not found", True)
'	End Try

End Sub