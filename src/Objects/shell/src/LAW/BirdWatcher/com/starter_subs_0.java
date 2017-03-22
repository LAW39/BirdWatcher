package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,60);
if (RapidSub.canDelegate("application_error")) return starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 60;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim database As SQL";
starter._database = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="Dim GPS1 As GPS";
starter._gps1 = RemoteObject.createNew ("anywheresoftware.b4a.gps.GPS");
 //BA.debugLineNum = 11;BA.debugLine="Public CC As ContentChooser";
starter._cc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 12;BA.debugLine="Dim L1 As Location";
starter._l1 = RemoteObject.createNew ("anywheresoftware.b4a.gps.LocationWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Dim list As List";
starter._list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,16);
if (RapidSub.canDelegate("service_create")) return starter.remoteMe.runUserSub(false, "starter","service_create");
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(32768);
 BA.debugLineNum = 19;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(262144);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 20;BA.debugLine="If Not (File.Exists(File.DirDefaultExternal,\"data";
Debug.ShouldStop(524288);
if (starter.mostCurrent.__c.runMethod(true,"Not",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("database.db"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 21;BA.debugLine="File.Copy(File.DirAssets,\"database.db\",File.DirD";
Debug.ShouldStop(1048576);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("database.db")),(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("database.db")));
 };
 BA.debugLineNum = 24;BA.debugLine="list.Initialize";
Debug.ShouldStop(8388608);
starter._list.runVoidMethod ("Initialize");
 BA.debugLineNum = 26;BA.debugLine="database.Initialize(File.DirDefaultExternal,\"data";
Debug.ShouldStop(33554432);
starter._database.runVoidMethod ("Initialize",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("database.db")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 27;BA.debugLine="SpeciesCursor = database.ExecQuery(\"SELECT ID FR";
Debug.ShouldStop(67108864);
_speciescursor.setObject(starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID FROM Species"))));
 BA.debugLineNum = 30;BA.debugLine="If Not (File.Exists(Main.BirdPhotoPath,\"0.jpg\"))";
Debug.ShouldStop(536870912);
if (starter.mostCurrent.__c.runMethod(true,"Not",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(starter.mostCurrent._main._birdphotopath),(Object)(RemoteObject.createImmutable("0.jpg"))))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 31;BA.debugLine="File.MakeDir(File.DirDefaultExternal,\"BirdPhotos";
Debug.ShouldStop(1073741824);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("BirdPhotos")));
 BA.debugLineNum = 32;BA.debugLine="File.Copy(File.DirAssets, \"0.jpg\", Main.BirdPhot";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("0.jpg")),(Object)(starter.mostCurrent._main._birdphotopath),(Object)(RemoteObject.createImmutable("0.jpg")));
 BA.debugLineNum = 33;BA.debugLine="For i = 1 To SpeciesCursor.RowCount";
Debug.ShouldStop(1);
{
final int step11 = 1;
final int limit11 = _speciescursor.runMethod(true,"getRowCount").<Integer>get().intValue();
for (_i = 1 ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 34;BA.debugLine="File.Copy(File.DirAssets,i & \".jpg\",Main.BirdPh";
Debug.ShouldStop(2);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))),(Object)(starter.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 35;BA.debugLine="Log(\"Bird image \" & i & \" copied over\")";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Bird image "),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(" copied over"))));
 BA.debugLineNum = 36;BA.debugLine="File.Delete(File.DirAssets,i & \".jpg\")";
Debug.ShouldStop(8);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 39;BA.debugLine="Log(\"All assets copied over\")";
Debug.ShouldStop(64);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("All assets copied over")));
 };
 BA.debugLineNum = 45;BA.debugLine="GPS1.Initialize(\"GPS1\")";
Debug.ShouldStop(4096);
starter._gps1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("GPS1")));
 BA.debugLineNum = 46;BA.debugLine="L1.Initialize";
Debug.ShouldStop(8192);
starter._l1.runVoidMethod ("Initialize");
 BA.debugLineNum = 47;BA.debugLine="CC.Initialize(\"CC\")";
Debug.ShouldStop(16384);
starter._cc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("CC")));
 BA.debugLineNum = 48;BA.debugLine="GPS1.Start(0,0)";
Debug.ShouldStop(32768);
starter._gps1.runVoidMethodAndSync ("Start",starter.processBA,(Object)(BA.numberCast(long.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,64);
if (RapidSub.canDelegate("service_destroy")) return starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 64;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,51);
if (RapidSub.canDelegate("service_start")) return starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 51;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,55);
if (RapidSub.canDelegate("service_taskremoved")) return starter.remoteMe.runUserSub(false, "starter","service_taskremoved");
 BA.debugLineNum = 55;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}