package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="If (File.Exists(File.DirDefaultExternal,\"database";
Debug.ShouldStop(-2147483648);
if ((main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("database.db")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 33;BA.debugLine="Log(\"Database already exists on device, no need";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Database already exists on device, no need to copy over")));
 BA.debugLineNum = 34;BA.debugLine="Log(BirdPhotoPath)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(main._birdphotopath));
 }else {
 BA.debugLineNum = 36;BA.debugLine="File.Copy(File.DirAssets,\"database.db\",File.DirD";
Debug.ShouldStop(8);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("database.db")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("database.db")));
 BA.debugLineNum = 37;BA.debugLine="Log(\"Copied database file to device\")";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Copied database file to device")));
 };
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"LaunchScreen\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("LaunchScreen")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="StartService(Starter)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private Reload_BTN As Button";
main.mostCurrent._reload_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private SpeciesCursor As Cursor";
main.mostCurrent._speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mapscreen_click() throws Exception{
try {
		Debug.PushSubsStack("MapScreen_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("mapscreen_click")) return main.remoteMe.runUserSub(false, "main","mapscreen_click");
 BA.debugLineNum = 53;BA.debugLine="Sub MapScreen_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="StartActivity(\"Map\")";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Map"))));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
species_subs_0._process_globals();
sightings_subs_0._process_globals();
map_subs_0._process_globals();
codefunctions_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.main");
starter.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.starter");
species.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.species");
sightings.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.sightings");
map.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.map");
codefunctions.myClass = BA.getDeviceClass ("LAW.BirdWatcher.com.codefunctions");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim BirdPhotoPath As String = File.DirDefaultExte";
main._birdphotopath = RemoteObject.concat(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal"),RemoteObject.createImmutable("/BirdPhotos"));
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reload_btn_click() throws Exception{
try {
		Debug.PushSubsStack("Reload_BTN_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("reload_btn_click")) return main.remoteMe.runUserSub(false, "main","reload_btn_click");
int _i = 0;
 BA.debugLineNum = 66;BA.debugLine="Sub Reload_BTN_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="File.Copy(File.DirAssets,\"database.db\",File.DirDe";
Debug.ShouldStop(4);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("database.db")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("database.db")));
 BA.debugLineNum = 68;BA.debugLine="SpeciesCursor = Starter.database.ExecQuery(\"SELEC";
Debug.ShouldStop(8);
main.mostCurrent._speciescursor.setObject(main.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID FROM Species"))));
 BA.debugLineNum = 69;BA.debugLine="Starter.database.Initialize(File.DirDefaultExtern";
Debug.ShouldStop(16);
main.mostCurrent._starter._database.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("database.db")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 70;BA.debugLine="For i = 0 To 6";
Debug.ShouldStop(32);
{
final int step4 = 1;
final int limit4 = 6;
for (_i = 0 ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 71;BA.debugLine="File.Copy(File.DirAssets,i & \".jpg\",BirdPhotoPat";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))),(Object)(main._birdphotopath),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 72;BA.debugLine="Log(\"Bird image \" & i & \" copied over\")";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Bird image "),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(" copied over"))));
 BA.debugLineNum = 73;BA.debugLine="File.Delete(File.DirAssets,i & \".jpg\")";
Debug.ShouldStop(256);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(RemoteObject.createImmutable(_i),RemoteObject.createImmutable(".jpg"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 76;BA.debugLine="Log(\"All assets copied over\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("All assets copied over")));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sightingsscreen_click() throws Exception{
try {
		Debug.PushSubsStack("SightingsScreen_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,57);
if (RapidSub.canDelegate("sightingsscreen_click")) return main.remoteMe.runUserSub(false, "main","sightingsscreen_click");
 BA.debugLineNum = 57;BA.debugLine="Sub SightingsScreen_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Sightings.MapLookupFlag = False";
Debug.ShouldStop(33554432);
main.mostCurrent._sightings._maplookupflag = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 59;BA.debugLine="StartActivity(\"Sightings\")";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Sightings"))));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _speciesscreen_click() throws Exception{
try {
		Debug.PushSubsStack("SpeciesScreen_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("speciesscreen_click")) return main.remoteMe.runUserSub(false, "main","speciesscreen_click");
 BA.debugLineNum = 62;BA.debugLine="Sub SpeciesScreen_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="StartActivity(\"Species\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Species"))));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
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
}