Type=StaticCode
Version=6.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub


Sub GetPathFromContentResult(UriString As String) As String
   Dim Proj() As String
   Proj = Array As String("_data")
   Dim Cursor As Cursor
   Dim r As Reflector
   Dim Uri As Object
   Uri = r.RunStaticMethod("android.net.Uri", "parse", _
      Array As Object(UriString), _
      Array As String("java.lang.String"))
   r.Target = r.GetContext
   r.Target = r.RunMethod("getContentResolver")
   Cursor = r.RunMethod4("query", _
   Array As Object(Uri, Proj, Null, Null, Null), _
   Array As String("android.net.Uri", _
      "[Ljava.lang.String;", "java.lang.String", _
      "[Ljava.lang.String;", "java.lang.String"))
 
   Cursor.Position = 0
   Dim res As String
   res = Cursor.GetString("_data")
   Cursor.Close
   Return res
End Sub

