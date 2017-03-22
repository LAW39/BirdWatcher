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

	Activity.Title = ("Photos")
	Private Phototab As TabStrip
	Private SightingPhoto As ImageView
	Private RemoveBtn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("SightingPhotos")
	Phototab.LoadLayout("PhotoTab","Species Picture")
	SightingPhotoList.Initialize
	SightingPhotoList = Starter.list
	Log(SightingPhotoList.Size)
	For i = 0 To SightingPhotoList.Size-1
		
		Dim PhotoInt As String = i+1
		Phototab.LoadLayout("PhotoTab",PhotoInt)
		
	Next
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
	Try
		NewBird.InitializeSample(Main.BirdPhotoPath,SpeciesCursor.GetLong("ImagePath") & ".jpg", 240, 240)
	Catch
		NewBird.InitializeSample(Main.BirdPhotoPath,"0.jpg", 240, 240)
		Log("Image not Found " & SightingID)
		ToastMessageShow("Image not found", True)
	End Try

	Return(NewBird)
End Sub

Sub Phototab_PageSelected (Position As Int)
	Log(Position)
	
	If Position = 1 Then
		SightingPhoto.bitmap = LoadBirdPic(Position)
		RemoveBtn.Visible = False		
		Return		
	End If
	
	Position = Position - 1
	RemoveBtn.Visible = True
	Try
		SightingPhoto.bitmap =  SightingPhotoList.Get(Position)
	Catch
		Dim Photo As Bitmap
		Photo.InitializeSample(Main.BirdPhotoPath,"0.jpg", 240, 240)
		SightingPhoto.bitmap = Photo
		Log("Image not Found " & Position)
		ToastMessageShow("Image not found", True)
	End Try

End Sub