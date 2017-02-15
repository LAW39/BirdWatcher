package LAW.BirdWatcher.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class codefunctions {
private static codefunctions mostCurrent = new codefunctions();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.sightings _sightings = null;
public LAW.BirdWatcher.com.map _map = null;
public static String  _getpathfromcontentresult(anywheresoftware.b4a.BA _ba,String _uristring) throws Exception{
String[] _proj = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _uri = null;
String _res = "";
 //BA.debugLineNum = 10;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
 //BA.debugLineNum = 11;BA.debugLine="Dim Proj() As String";
_proj = new String[(int) (0)];
java.util.Arrays.fill(_proj,"");
 //BA.debugLineNum = 12;BA.debugLine="Proj = Array As String(\"_data\")";
_proj = new String[]{"_data"};
 //BA.debugLineNum = 13;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 15;BA.debugLine="Dim Uri As Object";
_uri = new Object();
 //BA.debugLineNum = 16;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"par";
_uri = _r.RunStaticMethod("android.net.Uri","parse",new Object[]{(Object)(_uristring)},new String[]{"java.lang.String"});
 //BA.debugLineNum = 19;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext((_ba.processBA == null ? _ba : _ba.processBA)));
 //BA.debugLineNum = 20;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
_r.Target = _r.RunMethod("getContentResolver");
 //BA.debugLineNum = 21;BA.debugLine="Cursor = r.RunMethod4(\"query\", _    Array As Ob";
_cursor.setObject((android.database.Cursor)(_r.RunMethod4("query",new Object[]{_uri,(Object)(_proj),anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null},new String[]{"android.net.Uri","[Ljava.lang.String;","java.lang.String","[Ljava.lang.String;","java.lang.String"})));
 //BA.debugLineNum = 27;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 28;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 29;BA.debugLine="res = Cursor.GetString(\"_data\")";
_res = _cursor.GetString("_data");
 //BA.debugLineNum = 30;BA.debugLine="Cursor.Close";
_cursor.Close();
 //BA.debugLineNum = 31;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
}
