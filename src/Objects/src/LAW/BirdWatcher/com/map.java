package LAW.BirdWatcher.com;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class map extends Activity implements B4AActivity{
	public static map mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.map");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (map).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.map");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "LAW.BirdWatcher.com.map", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (map) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (map) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return map.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (map) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (map) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        Object[] o;
        if (permissions.length > 0)
            o = new Object[] {permissions[0], grantResults[0] == 0};
        else
            o = new Object[] {"", false};
        processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _maptimer = null;
public static int _selectedid = 0;
public static boolean _getlocationflag = false;
public static anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper _location = null;
public static boolean _selectedbird = false;
public anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper _gmap = null;
public static boolean _mapsetupcompleted = false;
public anywheresoftware.b4a.objects.MapFragmentWrapper _mainmap = null;
public anywheresoftware.b4a.objects.ListViewWrapper _specieslist = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _birdimage = null;
public anywheresoftware.b4a.objects.ButtonWrapper _moreinfo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _datetime1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _name = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.sightings _sightings = null;
public LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
mostCurrent._activity.LoadLayout("MainScreen",mostCurrent.activityBA);
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Activity.Title = \"Map\"";
mostCurrent._activity.setTitle((Object)("Map"));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="If MainMap.IsGooglePlayServicesAvailable = False";
if (mostCurrent._mainmap.IsGooglePlayServicesAvailable(mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="ToastMessageShow(\"Please install Google Play";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please install Google Play Services.",anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="SpeciesList.SingleLineLayout.Label.TextColor = Co";
mostCurrent._specieslist.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="Location.Initialize(0,0)";
_location.Initialize(0,0);
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="MapSetupCompleted = False";
_mapsetupcompleted = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="MapTimer.Initialize(\"LootTimer\",1000)";
_maptimer.Initialize(processBA,"LootTimer",(long) (1000));
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3735570;
 //BA.debugLineNum = 3735570;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")));
RDebugUtils.currentLine=3735571;
 //BA.debugLineNum = 3735571;BA.debugLine="SpeciesList.clear";
mostCurrent._specieslist.Clear();
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step13 = 1;
final int limit13 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStri";
mostCurrent._specieslist.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
RDebugUtils.currentLine=3735577;
 //BA.debugLineNum = 3735577;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="map";
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="MapTimer.Enabled = False";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="If (MapSetupCompleted = False) Then";
if ((_mapsetupcompleted==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="MapTimer.Enabled = True";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="End Sub";
return "";
}
public static String  _getlocation() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getlocation"))
	return (String) Debug.delegate(mostCurrent.activityBA, "getlocation", null);
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Public Sub GetLocation";
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
mostCurrent._activity.LoadLayout("MainScreen",mostCurrent.activityBA);
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="End Sub";
return "";
}
public static String  _loadbird(int _id) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadbird"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loadbird", new Object[] {_id});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _mapsql = null;
boolean _errorflag = false;
int _i = 0;
anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper _sightingmarker = null;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub LoadBird(ID As Int)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="ID = ID +1";
_id = (int) (_id+1);
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="gmap.Clear";
mostCurrent._gmap.Clear();
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="Name.Text = \"\"";
mostCurrent._name.setText((Object)(""));
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="DateTime1.Text = \"\"";
mostCurrent._datetime1.setText((Object)(""));
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="Dim MapSQL As StringBuilder";
_mapsql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="Dim ErrorFlag As Boolean = False";
_errorflag = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="MapSQL.Initialize";
_mapsql.Initialize();
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="MapSQL.Append(\"SELECT * FROM Sightings\").Append(C";
_mapsql.Append("SELECT * FROM Sightings").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="MapSQL.Append(\"WHERE ID = ?\").Append(CRLF)";
_mapsql.Append("WHERE ID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=4456463;
 //BA.debugLineNum = 4456463;BA.debugLine="MapSQL.Append(\"ORDER BY ID Asc\").Append(CRLF)";
_mapsql.Append("ORDER BY ID Asc").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="ErrorFlag= False";
_errorflag = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4456465;
 //BA.debugLineNum = 4456465;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(MapSQ";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_mapsql),new String[]{BA.NumberToString(_id)})));
RDebugUtils.currentLine=4456468;
 //BA.debugLineNum = 4456468;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step14 = 1;
final int limit14 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
RDebugUtils.currentLine=4456470;
 //BA.debugLineNum = 4456470;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
RDebugUtils.currentLine=4456472;
 //BA.debugLineNum = 4456472;BA.debugLine="Dim SightingMarker As Marker";
_sightingmarker = new anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper();
RDebugUtils.currentLine=4456476;
 //BA.debugLineNum = 4456476;BA.debugLine="Log(\"LAT: \" & SpeciesCursor.GetDouble(\"Lat\"))";
anywheresoftware.b4a.keywords.Common.Log("LAT: "+BA.NumberToString(_speciescursor.GetDouble("Lat")));
RDebugUtils.currentLine=4456477;
 //BA.debugLineNum = 4456477;BA.debugLine="Log(\"LNG: \" & SpeciesCursor.GetDouble(\"Lng\"))";
anywheresoftware.b4a.keywords.Common.Log("LNG: "+BA.NumberToString(_speciescursor.GetDouble("Lng")));
RDebugUtils.currentLine=4456481;
 //BA.debugLineNum = 4456481;BA.debugLine="If SpeciesCursor.GetDouble(\"Lat\") = \"0\" Then";
if (_speciescursor.GetDouble("Lat")==(double)(Double.parseDouble("0"))) { 
RDebugUtils.currentLine=4456482;
 //BA.debugLineNum = 4456482;BA.debugLine="If SpeciesCursor.GetDouble(\"Lng\") = \"0\" Then";
if (_speciescursor.GetDouble("Lng")==(double)(Double.parseDouble("0"))) { 
RDebugUtils.currentLine=4456483;
 //BA.debugLineNum = 4456483;BA.debugLine="ErrorFlag = True";
_errorflag = anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=4456488;
 //BA.debugLineNum = 4456488;BA.debugLine="If ErrorFlag = False Then";
if (_errorflag==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=4456489;
 //BA.debugLineNum = 4456489;BA.debugLine="SightingMarker = gmap.AddMarker2(SpeciesCursor.";
_sightingmarker = mostCurrent._gmap.AddMarker2(_speciescursor.GetDouble("Lat"),_speciescursor.GetDouble("Lng"),_speciescursor.GetString("SpeciesID"),mostCurrent._gmap.HUE_RED);
RDebugUtils.currentLine=4456491;
 //BA.debugLineNum = 4456491;BA.debugLine="SightingMarker.Draggable = False";
_sightingmarker.setDraggable(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456492;
 //BA.debugLineNum = 4456492;BA.debugLine="SightingMarker.Snippet = SpeciesCursor.GetInt(\"";
_sightingmarker.setSnippet(BA.NumberToString(_speciescursor.GetInt("ID")));
RDebugUtils.currentLine=4456493;
 //BA.debugLineNum = 4456493;BA.debugLine="SightingMarker.Visible = True";
_sightingmarker.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 }
};
RDebugUtils.currentLine=4456497;
 //BA.debugLineNum = 4456497;BA.debugLine="End Sub";
return "";
}
public static String  _loadbirdpic(int _birdid) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadbirdpic"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loadbirdpic", new Object[] {_birdid});
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub LoadBirdPic(BirdID As Int)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="BirdID = BirdID +1";
_birdid = (int) (_birdid+1);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="NewBird.InitializeSample(File.DirAssets,BirdID  &";
_newbird.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.NumberToString(_birdid)+".jpg",(int) (240),(int) (240));
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="BirdImage.Bitmap = NewBird";
mostCurrent._birdimage.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="End Sub";
return "";
}
public static String  _loottimer_tick() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loottimer_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loottimer_tick", null);
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub LootTimer_Tick";
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="If ((gmap.IsInitialized) And (gmap.MyLocation.IsI";
if (((mostCurrent._gmap.IsInitialized()) && (mostCurrent._gmap.getMyLocation().IsInitialized()))) { 
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="MapSetupCompleted = True";
_mapsetupcompleted = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="MapTimer.Enabled = False";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="End Sub";
return "";
}
public static String  _mainmap_longclick(anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper _point) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mainmap_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mainmap_longclick", new Object[] {_point});
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub MainMap_LongClick (Point As LatLng)";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="If GetLocationFlag = True Then";
if (_getlocationflag==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="Location = Point";
_location = _point;
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="End Sub";
return "";
}
public static boolean  _mainmap_markerclick(anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper _selectedmarker) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mainmap_markerclick"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "mainmap_markerclick", new Object[] {_selectedmarker});
anywheresoftware.b4a.sql.SQL.CursorWrapper _birdcursor = null;
String _mapsql = "";
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub MainMap_MarkerClick (SelectedMarker As Marker)";
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Dim BirdCursor As Cursor";
_birdcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim MapSQL As String";
_mapsql = "";
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="If (SelectedMarker.Snippet = \"0\") Then";
if (((_selectedmarker.getSnippet()).equals("0"))) { 
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="ToastMessageShow(\"Location new loot to be added";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Location new loot to be added at",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="MapSQL = \"SELECT * FROM Sightings WHERE ID = ?\"";
_mapsql = "SELECT * FROM Sightings WHERE ID = ?";
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="BirdCursor = Starter.Database.ExecQuery2(MapSQL,";
_birdcursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(_mapsql,new String[]{_selectedmarker.getSnippet()})));
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="BirdCursor.Position = 0";
_birdcursor.setPosition((int) (0));
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="Name.Text = BirdCursor.GetString(\"Weather\")";
mostCurrent._name.setText((Object)(_birdcursor.GetString("Weather")));
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="DateTime1.Text = DateTime.Date(BirdCursor.GetStri";
mostCurrent._datetime1.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_birdcursor.GetString("Epoch"))))+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time((long)(Double.parseDouble(_birdcursor.GetString("Epoch"))))));
RDebugUtils.currentLine=4325398;
 //BA.debugLineNum = 4325398;BA.debugLine="SelectedBird = True";
_selectedbird = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4325400;
 //BA.debugLineNum = 4325400;BA.debugLine="Return True 'stop the pop up text box from being";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4325401;
 //BA.debugLineNum = 4325401;BA.debugLine="End Sub";
return false;
}
public static String  _mainmap_ready() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mainmap_ready"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mainmap_ready", null);
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub MainMap_Ready";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="gmap = MainMap.GetMap";
mostCurrent._gmap = mostCurrent._mainmap.GetMap();
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Log(\"Mylocation:\" & gmap.MyLocationEnabled)";
anywheresoftware.b4a.keywords.Common.Log("Mylocation:"+BA.ObjectToString(mostCurrent._gmap.getMyLocationEnabled()));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="End Sub";
return "";
}
public static String  _mainscreen_click() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mainscreen_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mainscreen_click", null);
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub MainScreen_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
return "";
}
public static String  _maptestbutton_click() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maptestbutton_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "maptestbutton_click", null);
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub MapTestButton_Click";
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="SetupMapLocation";
_setupmaplocation();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="End Sub";
return "";
}
public static String  _setupmaplocation() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setupmaplocation"))
	return (String) Debug.delegate(mostCurrent.activityBA, "setupmaplocation", null);
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper _newmapposition = null;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub SetupMapLocation";
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="If ((Starter.GPS1.GPSEnabled) And (p.IsAirplaneMo";
if (((mostCurrent._starter._gps1.getGPSEnabled()) && (_p.IsAirplaneModeOn()==anywheresoftware.b4a.keywords.Common.False))) { 
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="Dim NewMapPosition As CameraPosition";
_newmapposition = new anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper();
RDebugUtils.currentLine=4194313;
 //BA.debugLineNum = 4194313;BA.debugLine="NewMapPosition.Initialize(gmap.MyLocation.Latitu";
_newmapposition.Initialize(mostCurrent._gmap.getMyLocation().getLatitude(),mostCurrent._gmap.getMyLocation().getLongitude(),(float) (12));
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="gmap.MoveCamera(NewMapPosition)";
mostCurrent._gmap.MoveCamera((com.google.android.gms.maps.model.CameraPosition)(_newmapposition.getObject()));
 }else {
RDebugUtils.currentLine=4194316;
 //BA.debugLineNum = 4194316;BA.debugLine="If (p.IsAirplaneModeOn) Then";
if ((_p.IsAirplaneModeOn())) { 
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="ToastMessageShow(\"Airplane mode is enabled. Int";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Airplane mode is enabled. Internet connection needed for maps",anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="ToastMessageShow(\"Device GPS is disabled. Pleas";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Device GPS is disabled. Please enable now",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInte";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 };
 };
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="End Sub";
return "";
}
public static String  _moreinfo_click() throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "moreinfo_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "moreinfo_click", null);
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub MoreInfo_Click";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="If SelectedBird = True Then";
if (_selectedbird==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Sightings.MapLookupFlag = True";
mostCurrent._sightings._maplookupflag = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="StartActivity(Sightings)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sightings.getObject()));
 }else {
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="Msgbox(\"Please select a sighting using the map a";
anywheresoftware.b4a.keywords.Common.Msgbox("Please select a sighting using the map above first","Error",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="End Sub";
return "";
}
public static String  _specieslist_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="map";
if (Debug.shouldDelegate(mostCurrent.activityBA, "specieslist_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "specieslist_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="SelectedID = Value -1";
_selectedid = (int) ((double)(BA.ObjectToNumber(_value))-1);
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="LoadBirdPic(SelectedID)";
_loadbirdpic(_selectedid);
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="LoadBird(SelectedID)";
_loadbird(_selectedid);
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="End Sub";
return "";
}
}