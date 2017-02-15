Type=Service
Version=6.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim database As SQL
	Dim GPS1 As GPS
	Public CC As ContentChooser
	Dim L1 As Location
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	Dim SpeciesCursor As Cursor
	If Not (File.Exists(File.DirDefaultExternal,"database.db")) Then	
		File.Copy(File.DirAssets,"database.db",File.DirDefaultExternal,"database.db")		
	End If

	
	database.Initialize(File.DirDefaultExternal,"database.db",False) ' Code to initilise Database and other controls
 	SpeciesCursor = database.ExecQuery("SELECT ID FROM Species")


	If Not (File.Exists(Main.BirdPhotoPath,"0.jpg")) Then 	'Code to check bird assets and copy over missing items
		File.MakeDir(File.DirDefaultExternal,"BirdPhotos") 								'Code to copy over bird photo assets
		File.Copy(File.DirAssets, "0.jpg", Main.BirdPhotoPath,"0.jpg")
		For i = 1 To SpeciesCursor.RowCount
			File.Copy(File.DirAssets,i & ".jpg",Main.BirdPhotoPath, i & ".jpg")
			Log("Bird image " & i & " copied over")	
			File.Delete(File.DirAssets,i & ".jpg")
		Next
		
		Log("All assets copied over")
	End If
	

		

	GPS1.Initialize("GPS1")
	L1.Initialize
	CC.Initialize("CC")
	GPS1.Start(0,0)
End Sub

Sub Service_Start (StartingIntent As Intent)

End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
