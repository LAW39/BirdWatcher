package LAW.BirdWatcher.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service {
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "LAW.BirdWatcher.com.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("** Service (starter) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.waitForLayout != null)
				BA.handler.post(ServiceHelper.StarterHelper.waitForLayout);
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA))
			handleStart(intent);
		else {
			ServiceHelper.StarterHelper.waitForLayout = new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (starter) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _database = null;
public static anywheresoftware.b4a.gps.GPS _gps1 = null;
public static anywheresoftware.b4a.phone.Phone.ContentChooser _cc = null;
public static anywheresoftware.b4a.gps.LocationWrapper _l1 = null;
public static anywheresoftware.b4a.objects.collections.List _list = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.sightings _sightings = null;
public LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public LAW.BirdWatcher.com.map _map = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error"))
	return (Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace});
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="If Not (File.Exists(File.DirDefaultExternal,\"data";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"database.db"))) { 
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="File.Copy(File.DirAssets,\"database.db\",File.DirD";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"database.db",anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"database.db");
 };
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="list.Initialize";
_list.Initialize();
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="database.Initialize(File.DirDefaultExternal,\"data";
_database.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"database.db",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="SpeciesCursor = database.ExecQuery(\"SELECT ID FR";
_speciescursor.setObject((android.database.Cursor)(_database.ExecQuery("SELECT ID FROM Species")));
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="If Not (File.Exists(Main.BirdPhotoPath,\"0.jpg\"))";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._main._birdphotopath,"0.jpg"))) { 
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="File.MakeDir(File.DirDefaultExternal,\"BirdPhotos";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"BirdPhotos");
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="File.Copy(File.DirAssets, \"0.jpg\", Main.BirdPhot";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"0.jpg",mostCurrent._main._birdphotopath,"0.jpg");
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="For i = 1 To SpeciesCursor.RowCount";
{
final int step11 = 1;
final int limit11 = _speciescursor.getRowCount();
for (_i = (int) (1) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="File.Copy(File.DirAssets,i & \".jpg\",Main.BirdPh";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.NumberToString(_i)+".jpg",mostCurrent._main._birdphotopath,BA.NumberToString(_i)+".jpg");
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="Log(\"Bird image \" & i & \" copied over\")";
anywheresoftware.b4a.keywords.Common.Log("Bird image "+BA.NumberToString(_i)+" copied over");
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="File.Delete(File.DirAssets,i & \".jpg\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.NumberToString(_i)+".jpg");
 }
};
RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="Log(\"All assets copied over\")";
anywheresoftware.b4a.keywords.Common.Log("All assets copied over");
 };
RDebugUtils.currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="GPS1.Initialize(\"GPS1\")";
_gps1.Initialize("GPS1");
RDebugUtils.currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="L1.Initialize";
_l1.Initialize();
RDebugUtils.currentLine=393247;
 //BA.debugLineNum = 393247;BA.debugLine="CC.Initialize(\"CC\")";
_cc.Initialize("CC");
RDebugUtils.currentLine=393248;
 //BA.debugLineNum = 393248;BA.debugLine="GPS1.Start(0,0)";
_gps1.Start(processBA,(long) (0),(float) (0));
RDebugUtils.currentLine=393249;
 //BA.debugLineNum = 393249;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved"))
	return (String) Debug.delegate(processBA, "service_taskremoved", null);
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
}