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

End Sub

	Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private SpeciesName As EditText			'<Defining elements on designer>
	Private SpeciesHabitat As EditText
	Private SpeciesColour As EditText
'	Private SpeciesAppearance As EditText
	Private AddBtn As Button
	Private SpeciesListView As ListView
	Private ID As Int = 0
	Private RemoveBtn As Button
	Private AddPhotoBtn As Button
	Private BirdPhotoView As ImageView 		'</Defining elements on designer>
	
	
	Private SelectedIndex As Int = -1		
	Dim ImageTime As Long
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("speciesadd")
 	Activity.Title = "Species"

	SpeciesListView.SingleLineLayout.Label.TextColor = Colors.black
	PopulateList ' Subroutine to populate list from DB
End Sub

Sub PopulateList
	Dim SpeciesCursor As Cursor
	SpeciesCursor = Starter.Database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC") ' Selects fields from DB
	SpeciesListView.clear 'Clears list
	
	SpeciesListView.AddSingleLine2("<Add Species>", 0) 'Adds placeholder to add new species
	
	For i=0 To SpeciesCursor.RowCount-1 ' Loop to populate list from DB
	
		SpeciesCursor.Position = i
		SpeciesListView.AddSingleLine2(SpeciesCursor.GetString("Name"),SpeciesCursor.GetString("ID"))	
	Next
End Sub


Sub Activity_Resume
	PopulateList
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub AddBtn_Click
		
	Dim SpeciesSQL As StringBuilder
	Dim InsertData(5) As String

	SpeciesSQL.Initialize
	InsertData(0) = SpeciesName.Text
	InsertData(1) = SpeciesHabitat.Text
	InsertData(2) = SpeciesColour.Text
'	InsertData(3) = SpeciesAppearance.Text
	InsertData(4) = ImageTime
	If SpeciesListView.GetItem(SelectedIndex) = -1 Then
		Return
	End If
	
	If SpeciesListView.GetItem(SelectedIndex) = 0 Then
		SpeciesSQL.Append("INSERT INTO Species (Name,Habitat,Colour,Appearance,ImagePath) VALUES (?, ?, ?, ?,?)")
	Else
		SpeciesSQL.Append("UPDATE Species").Append(CRLF)
		SpeciesSQL.Append("SET Name = ?, Habitat = ?, Colour = ?, Appearance = ?, ImagePath = ?").append(CRLF)
		SpeciesSQL.Append("WHERE ID =" & (ID + 1)).Append(CRLF)		
	End If
	
	Starter.database.ExecNonQuery2(SpeciesSQL, InsertData)
		PopulateList
End Sub

Sub SpeciesListView_ItemClick (Position As Int, Value As Object)	
	ID = Value
	If Position = -1 Then
		Return
	End If
	SelectedIndex = Position
	If Value <> 0 Then
		AddBtn.Text = "Save"
		AddBtn.Width = 200dip
		RemoveBtn.Visible = True
	Else
		AddBtn.Text = "Add"
		AddBtn.Width = 430dip
		RemoveBtn.Visible = False
	End If
	AddBtn.Visible = True
	
	If Position <> 0 Then
		Dim Cursor As Cursor
		Cursor = Starter.database.ExecQuery("SELECT * FROM Species WHERE ID = " & ID)
		Cursor.Position = 0
		SpeciesName.Text = Cursor.GetString("Name")
		SpeciesHabitat.Text = Cursor.GetString("Habitat")
		SpeciesColour.Text = Cursor.GetString("Colour")
		'SpeciesAppearance.Text = Cursor.GetString("Appearance")
		LoadBirdPick(ID)
	Else
		SpeciesName.Text = ""
		SpeciesHabitat.Text = ""
		SpeciesColour.Text = ""
		'SpeciesAppearance.Text = ""
		LoadBirdPick(ID)
	End If
	

End Sub

Sub RemoveBtn_Click
	Dim DeleteSQLQuery As StringBuilder
	DeleteSQLQuery.Initialize
	Dim SpeciesCursor As Cursor
	
	If ID = 0 Then
		Return
	End If
	
	DeleteSQLQuery.Append("DELETE FROM Species").Append(CRLF)
	DeleteSQLQuery.Append("WHERE [ID] = ?").Append(CRLF)
	Try
		SpeciesCursor = Starter.Database.ExecQuery("SELECT ImagePath FROM Species WHERE ID = " & ID)
		SpeciesCursor.Position = 0
		File.Delete(Main.BirdPhotoPath, SpeciesCursor.GetLong("ImagePath") & ".jpg")
	Catch
		Log(LastException.Message)
	End Try	
	Starter.database.ExecNonQuery2(DeleteSQLQuery,Array As String(ID))
	StartActivity("Species")
End Sub

Sub AddPhotoBtn_Click
	Starter.CC.Show("image/*","Choose image")
End Sub

Sub CC_Result (Success As Boolean, Dir As String, FileName As String)

	If (Success) Then
		
		Msgbox("Dir: " & Dir & " File: " & FileName, "Selected File - DEFAULT")
		
		Dim ContentPathFile As String
		Dim FileNameIndex As Int
		Dim ImgFileName As String

		Dim ImgFolderPath As String
		Dim sf As StringFunctions
		sf.Initialize
				
		ContentPathFile = CodeFunctions.GetPathFromContentResult(FileName)
		ImageTime = DateTime.now
		If ContentPathFile = Null Then
			Msgbox( "Please select photo from the photos app by selecting from drawer on left","Error")
			AddPhotoBtn_Click
			Return
		End If
		
		FileNameIndex = ContentPathFile.LastIndexOf("/")
		ImgFileName = ContentPathFile.SubString(FileNameIndex+1)
		ImgFolderPath = ContentPathFile.SubString2(1,FileNameIndex)
		
		File.Copy(ImgFolderPath,ImgFileName,Main.BirdPhotoPath,ImageTime & ".jpg")
		
		Dim NewBird As Bitmap
		NewBird.InitializeSample(Main.BirdPhotoPath,ImageTime & ".jpg", 240, 240)
		BirdPhotoView.Bitmap = NewBird
			
	End If
	
End Sub

Sub LoadBirdPick(BirdID As Int)
	
	Log(BirdID)
	Dim SpeciesCursor As Cursor
	Dim NewBird As Bitmap
	ToastMessageShow(BirdID,True)
	SpeciesCursor = Starter.Database.ExecQuery("SELECT ID,ImagePath FROM Species WHERE ID = " & BirdID)
	SpeciesCursor.Position = 0
	Try
		Log(Main.BirdPhotoPath & SpeciesCursor.GetLong("ImagePath"))
	Catch
		Log("Add new Species")
	End Try
	Try
		NewBird.InitializeSample(Main.BirdPhotoPath,SpeciesCursor.GetLong("ImagePath") & ".jpg", 240, 240)
	Catch
		NewBird.InitializeSample(Main.BirdPhotoPath,"0.jpg", 240, 240)
		Log("Image not Found " & BirdID)
		ToastMessageShow("Image not found", True)
	End Try

	BirdPhotoView.Bitmap = NewBird
End Sub

