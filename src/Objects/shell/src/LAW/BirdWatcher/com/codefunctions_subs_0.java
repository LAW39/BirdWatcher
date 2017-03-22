package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class codefunctions_subs_0 {


public static RemoteObject  _getpathfromcontentresult(RemoteObject _ba,RemoteObject _uristring) throws Exception{
try {
		Debug.PushSubsStack("GetPathFromContentResult (codefunctions) ","codefunctions",4,_ba,codefunctions.mostCurrent,10);
if (RapidSub.canDelegate("getpathfromcontentresult")) return codefunctions.remoteMe.runUserSub(false, "codefunctions","getpathfromcontentresult", _ba, _uristring);
RemoteObject _proj = null;
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _uri = RemoteObject.declareNull("Object");
RemoteObject _res = RemoteObject.createImmutable("");
;
Debug.locals.put("UriString", _uristring);
 BA.debugLineNum = 10;BA.debugLine="Sub GetPathFromContentResult(UriString As String)";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="Dim Proj() As String";
Debug.ShouldStop(1024);
_proj = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("Proj", _proj);
 BA.debugLineNum = 12;BA.debugLine="Proj = Array As String(\"_data\")";
Debug.ShouldStop(2048);
_proj = RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("_data")});Debug.locals.put("Proj", _proj);
 BA.debugLineNum = 13;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(4096);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 14;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(8192);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 15;BA.debugLine="Dim Uri As Object";
Debug.ShouldStop(16384);
_uri = RemoteObject.createNew ("Object");Debug.locals.put("Uri", _uri);
 BA.debugLineNum = 16;BA.debugLine="Uri = r.RunStaticMethod(\"android.net.Uri\", \"par";
Debug.ShouldStop(32768);
_uri = _r.runMethod(false,"RunStaticMethod",(Object)(BA.ObjectToString("android.net.Uri")),(Object)(BA.ObjectToString("parse")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_uristring)})),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("java.lang.String")})));Debug.locals.put("Uri", _uri);
 BA.debugLineNum = 19;BA.debugLine="r.Target = r.GetContext";
Debug.ShouldStop(262144);
_r.setField ("Target",(_r.runMethod(false,"GetContext",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba))));
 BA.debugLineNum = 20;BA.debugLine="r.Target = r.RunMethod(\"getContentResolver\")";
Debug.ShouldStop(524288);
_r.setField ("Target",_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getContentResolver"))));
 BA.debugLineNum = 21;BA.debugLine="Cursor = r.RunMethod4(\"query\", _    Array As Ob";
Debug.ShouldStop(1048576);
_cursor.setObject(_r.runMethod(false,"RunMethod4",(Object)(BA.ObjectToString("query")),(Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {_uri,(_proj),codefunctions.mostCurrent.__c.getField(false,"Null"),codefunctions.mostCurrent.__c.getField(false,"Null"),codefunctions.mostCurrent.__c.getField(false,"Null")})),(Object)(RemoteObject.createNewArray("String",new int[] {5},new Object[] {BA.ObjectToString("android.net.Uri"),BA.ObjectToString("[Ljava.lang.String;"),BA.ObjectToString("java.lang.String"),BA.ObjectToString("[Ljava.lang.String;"),RemoteObject.createImmutable("java.lang.String")}))));
 BA.debugLineNum = 27;BA.debugLine="Cursor.Position = 0";
Debug.ShouldStop(67108864);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 28;BA.debugLine="Dim res As String";
Debug.ShouldStop(134217728);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 29;BA.debugLine="res = Cursor.GetString(\"_data\")";
Debug.ShouldStop(268435456);
_res = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("_data")));Debug.locals.put("res", _res);
 BA.debugLineNum = 30;BA.debugLine="Cursor.Close";
Debug.ShouldStop(536870912);
_cursor.runVoidMethod ("Close");
 BA.debugLineNum = 31;BA.debugLine="Return res";
Debug.ShouldStop(1073741824);
if (true) return _res;
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}