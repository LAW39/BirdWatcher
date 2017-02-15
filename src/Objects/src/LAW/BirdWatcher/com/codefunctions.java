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
RDebugUtils.currentModule="codefunctions";
if (Debug.shouldDelegate(null, "getpathfromcontentresult"))
	return (String) Debug.delegate(null, "getpathfromcontentresult", new Object[] {_ba,_uristring});
String[] _proj = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object _uri = null;
String _res = "";
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Dim Proj() As String";
_proj = new String[(int) (0)];
java.util.Arrays.fill(_proj,"");
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Proj = Array As String(\"_data\")";
_proj = new String[]{"_data"};
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="Dim Uri As Object";
_uri = new Object();
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"par";
_uri = _r.RunStaticMethod("android.net.Uri","parse",new Object[]{(Object)(_uristring)},new String[]{"java.lang.String"});
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="r.Target = r.GetContext";
_r.Target = (Object)(_r.GetContext((_ba.processBA == null ? _ba : _ba.processBA)));
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
_r.Target = _r.RunMethod("getContentResolver");
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="Cursor = r.RunMethod4(\"query\", _    Array As Ob";
_cursor.setObject((android.database.Cursor)(_r.RunMethod4("query",new Object[]{_uri,(Object)(_proj),anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null,anywheresoftware.b4a.keywords.Common.Null},new String[]{"android.net.Uri","[Ljava.lang.String;","java.lang.String","[Ljava.lang.String;","java.lang.String"})));
RDebugUtils.currentLine=3997713;
 //BA.debugLineNum = 3997713;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=3997714;
 //BA.debugLineNum = 3997714;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=3997715;
 //BA.debugLineNum = 3997715;BA.debugLine="res = Cursor.GetString(\"_data\")";
_res = _cursor.GetString("_data");
RDebugUtils.currentLine=3997716;
 //BA.debugLineNum = 3997716;BA.debugLine="Cursor.Close";
_cursor.Close();
RDebugUtils.currentLine=3997717;
 //BA.debugLineNum = 3997717;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=3997718;
 //BA.debugLineNum = 3997718;BA.debugLine="End Sub";
return "";
}
}