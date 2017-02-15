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
			processBA = new BA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.map");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _maptimer = null;
public static int _selectedid = 0;
public static boolean _getlocationflag = false;
public static anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper _location = null;
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

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
mostCurrent._activity.LoadLayout("MainScreen",mostCurrent.activityBA);
 //BA.debugLineNum = 33;BA.debugLine="Activity.Title = \"Map\"";
mostCurrent._activity.setTitle((Object)("Map"));
 //BA.debugLineNum = 35;BA.debugLine="If MainMap.IsGooglePlayServicesAvailable = False";
if (mostCurrent._mainmap.IsGooglePlayServicesAvailable(mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 36;BA.debugLine="ToastMessageShow(\"Please install Google Play";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please install Google Play Services.",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 39;BA.debugLine="Location.Initialize(0,0)";
_location.Initialize(0,0);
 //BA.debugLineNum = 42;BA.debugLine="MapSetupCompleted = False";
_mapsetupcompleted = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 43;BA.debugLine="MapTimer.Initialize(\"LootTimer\",1000)";
_maptimer.Initialize(processBA,"LootTimer",(long) (1000));
 //BA.debugLineNum = 45;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 46;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY ID ASC")));
 //BA.debugLineNum = 47;BA.debugLine="SpeciesList.clear";
mostCurrent._specieslist.Clear();
 //BA.debugLineNum = 49;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step12 = 1;
final int limit12 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
 //BA.debugLineNum = 50;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
 //BA.debugLineNum = 51;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStri";
mostCurrent._specieslist.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 70;BA.debugLine="MapTimer.Enabled = False";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 63;BA.debugLine="If (MapSetupCompleted = False) Then";
if ((_mapsetupcompleted==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 64;BA.debugLine="MapTimer.Enabled = True";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _getlocation() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Public Sub GetLocation";
 //BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
mostCurrent._activity.LoadLayout("MainScreen",mostCurrent.activityBA);
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private gmap As GoogleMap";
mostCurrent._gmap = new anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private MapSetupCompleted As Boolean";
_mapsetupcompleted = false;
 //BA.debugLineNum = 21;BA.debugLine="Private MainMap As MapFragment";
mostCurrent._mainmap = new anywheresoftware.b4a.objects.MapFragmentWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private SpeciesList As ListView";
mostCurrent._specieslist = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private BirdImage As ImageView";
mostCurrent._birdimage = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private MoreInfo As Button";
mostCurrent._moreinfo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private DateTime1 As EditText";
mostCurrent._datetime1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private Name As EditText";
mostCurrent._name = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _loadbird(int _id) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _mapsql = null;
boolean _errorflag = false;
int _i = 0;
anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper _sightingmarker = null;
 //BA.debugLineNum = 164;BA.debugLine="Sub LoadBird(ID As Int)";
 //BA.debugLineNum = 165;BA.debugLine="ID = ID +1";
_id = (int) (_id+1);
 //BA.debugLineNum = 167;BA.debugLine="gmap.Clear";
mostCurrent._gmap.Clear();
 //BA.debugLineNum = 169;BA.debugLine="Name.Text = \"\"";
mostCurrent._name.setText((Object)(""));
 //BA.debugLineNum = 170;BA.debugLine="DateTime1.Text = \"\"";
mostCurrent._datetime1.setText((Object)(""));
 //BA.debugLineNum = 172;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 173;BA.debugLine="Dim MapSQL As StringBuilder";
_mapsql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 174;BA.debugLine="Dim ErrorFlag As Boolean = False";
_errorflag = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 175;BA.debugLine="MapSQL.Initialize";
_mapsql.Initialize();
 //BA.debugLineNum = 177;BA.debugLine="MapSQL.Append(\"SELECT * FROM Sightings\").Append(C";
_mapsql.Append("SELECT * FROM Sightings").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 178;BA.debugLine="MapSQL.Append(\"WHERE ID = ?\").Append(CRLF)";
_mapsql.Append("WHERE ID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 179;BA.debugLine="MapSQL.Append(\"ORDER BY ID Asc\").Append(CRLF)";
_mapsql.Append("ORDER BY ID Asc").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 180;BA.debugLine="ErrorFlag= False";
_errorflag = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 181;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(MapSQ";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_mapsql),new String[]{BA.NumberToString(_id)})));
 //BA.debugLineNum = 184;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step14 = 1;
final int limit14 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
 //BA.debugLineNum = 186;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
 //BA.debugLineNum = 188;BA.debugLine="Dim SightingMarker As Marker";
_sightingmarker = new anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper();
 //BA.debugLineNum = 192;BA.debugLine="Log(\"LAT: \" & SpeciesCursor.GetDouble(\"Lat\"))";
anywheresoftware.b4a.keywords.Common.Log("LAT: "+BA.NumberToString(_speciescursor.GetDouble("Lat")));
 //BA.debugLineNum = 193;BA.debugLine="Log(\"LNG: \" & SpeciesCursor.GetDouble(\"Lng\"))";
anywheresoftware.b4a.keywords.Common.Log("LNG: "+BA.NumberToString(_speciescursor.GetDouble("Lng")));
 //BA.debugLineNum = 197;BA.debugLine="If SpeciesCursor.GetDouble(\"Lat\") = \"0\" Then";
if (_speciescursor.GetDouble("Lat")==(double)(Double.parseDouble("0"))) { 
 //BA.debugLineNum = 198;BA.debugLine="If SpeciesCursor.GetDouble(\"Lng\") = \"0\" Then";
if (_speciescursor.GetDouble("Lng")==(double)(Double.parseDouble("0"))) { 
 //BA.debugLineNum = 199;BA.debugLine="ErrorFlag = True";
_errorflag = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 204;BA.debugLine="If ErrorFlag = False Then";
if (_errorflag==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 205;BA.debugLine="SightingMarker = gmap.AddMarker2(SpeciesCursor.";
_sightingmarker = mostCurrent._gmap.AddMarker2(_speciescursor.GetDouble("Lat"),_speciescursor.GetDouble("Lng"),_speciescursor.GetString("SpeciesID"),mostCurrent._gmap.HUE_RED);
 //BA.debugLineNum = 207;BA.debugLine="SightingMarker.Draggable = False";
_sightingmarker.setDraggable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 208;BA.debugLine="SightingMarker.Snippet = SpeciesCursor.GetInt(\"";
_sightingmarker.setSnippet(BA.NumberToString(_speciescursor.GetInt("ID")));
 //BA.debugLineNum = 209;BA.debugLine="SightingMarker.Visible = True";
_sightingmarker.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
 }
};
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static String  _loadbirdpic(int _birdid) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
 //BA.debugLineNum = 155;BA.debugLine="Sub LoadBirdPic(BirdID As Int)";
 //BA.debugLineNum = 156;BA.debugLine="BirdID = BirdID +1";
_birdid = (int) (_birdid+1);
 //BA.debugLineNum = 158;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 159;BA.debugLine="NewBird.InitializeSample(File.DirAssets,BirdID  &";
_newbird.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.NumberToString(_birdid)+".jpg",(int) (240),(int) (240));
 //BA.debugLineNum = 160;BA.debugLine="BirdImage.Bitmap = NewBird";
mostCurrent._birdimage.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _loottimer_tick() throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub LootTimer_Tick";
 //BA.debugLineNum = 77;BA.debugLine="If ((gmap.IsInitialized) And (gmap.MyLocation.IsI";
if (((mostCurrent._gmap.IsInitialized()) && (mostCurrent._gmap.getMyLocation().IsInitialized()))) { 
 //BA.debugLineNum = 78;BA.debugLine="MapSetupCompleted = True";
_mapsetupcompleted = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 79;BA.debugLine="MapTimer.Enabled = False";
_maptimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _mainmap_longclick(anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper _point) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Sub MainMap_LongClick (Point As LatLng)";
 //BA.debugLineNum = 231;BA.debugLine="If GetLocationFlag = True Then";
if (_getlocationflag==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 232;BA.debugLine="Location = Point";
_location = _point;
 //BA.debugLineNum = 233;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public static boolean  _mainmap_markerclick(anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper _selectedmarker) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _birdcursor = null;
String _mapsql = "";
 //BA.debugLineNum = 128;BA.debugLine="Sub MainMap_MarkerClick (SelectedMarker As Marker)";
 //BA.debugLineNum = 130;BA.debugLine="Dim BirdCursor As Cursor";
_birdcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 131;BA.debugLine="Dim MapSQL As String";
_mapsql = "";
 //BA.debugLineNum = 134;BA.debugLine="If (SelectedMarker.Snippet = \"0\") Then";
if (((_selectedmarker.getSnippet()).equals("0"))) { 
 //BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"Location new loot to be added";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Location new loot to be added at",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 136;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 141;BA.debugLine="MapSQL = \"SELECT * FROM Sightings WHERE ID = ?\"";
_mapsql = "SELECT * FROM Sightings WHERE ID = ?";
 //BA.debugLineNum = 143;BA.debugLine="BirdCursor = Starter.Database.ExecQuery2(MapSQL,";
_birdcursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(_mapsql,new String[]{_selectedmarker.getSnippet()})));
 //BA.debugLineNum = 144;BA.debugLine="BirdCursor.Position = 0";
_birdcursor.setPosition((int) (0));
 //BA.debugLineNum = 147;BA.debugLine="Name.Text = BirdCursor.GetString(\"Weather\")";
mostCurrent._name.setText((Object)(_birdcursor.GetString("Weather")));
 //BA.debugLineNum = 148;BA.debugLine="DateTime1.Text = DateTime.Date(BirdCursor.GetStri";
mostCurrent._datetime1.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date((long)(Double.parseDouble(_birdcursor.GetString("Epoch"))))+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time((long)(Double.parseDouble(_birdcursor.GetString("Epoch"))))));
 //BA.debugLineNum = 152;BA.debugLine="Return True 'stop the little pop up text box from";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return false;
}
public static String  _mainmap_ready() throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Sub MainMap_Ready";
 //BA.debugLineNum = 91;BA.debugLine="gmap = MainMap.GetMap";
mostCurrent._gmap = mostCurrent._mainmap.GetMap();
 //BA.debugLineNum = 93;BA.debugLine="Log(\"Mylocation:\" & gmap.MyLocationEnabled)";
anywheresoftware.b4a.keywords.Common.Log("Mylocation:"+BA.ObjectToString(mostCurrent._gmap.getMyLocationEnabled()));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _mainscreen_click() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub MainScreen_Click";
 //BA.debugLineNum = 87;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _maptestbutton_click() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Sub MapTestButton_Click";
 //BA.debugLineNum = 124;BA.debugLine="SetupMapLocation";
_setupmaplocation();
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _moreinfo_click() throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Sub MoreInfo_Click";
 //BA.debugLineNum = 226;BA.debugLine="Sightings.MapLookupFlag = True";
mostCurrent._sightings._maplookupflag = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 227;BA.debugLine="StartActivity(Sightings)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sightings.getObject()));
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public MapTimer As Timer";
_maptimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 10;BA.debugLine="Public SelectedID As Int";
_selectedid = 0;
 //BA.debugLineNum = 11;BA.debugLine="Public GetLocationFlag As Boolean = False";
_getlocationflag = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 12;BA.debugLine="Public Location As LatLng";
_location = new anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _setupmaplocation() throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper _newmapposition = null;
 //BA.debugLineNum = 97;BA.debugLine="Sub SetupMapLocation";
 //BA.debugLineNum = 99;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 103;BA.debugLine="If ((Starter.GPS1.GPSEnabled) And (p.IsAirplaneMo";
if (((mostCurrent._starter._gps1.getGPSEnabled()) && (_p.IsAirplaneModeOn()==anywheresoftware.b4a.keywords.Common.False))) { 
 //BA.debugLineNum = 105;BA.debugLine="Dim NewMapPosition As CameraPosition";
_newmapposition = new anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper();
 //BA.debugLineNum = 106;BA.debugLine="NewMapPosition.Initialize(gmap.MyLocation.Latitu";
_newmapposition.Initialize(mostCurrent._gmap.getMyLocation().getLatitude(),mostCurrent._gmap.getMyLocation().getLongitude(),(float) (12));
 //BA.debugLineNum = 107;BA.debugLine="gmap.MoveCamera(NewMapPosition)";
mostCurrent._gmap.MoveCamera((com.google.android.gms.maps.model.CameraPosition)(_newmapposition.getObject()));
 }else {
 //BA.debugLineNum = 109;BA.debugLine="If (p.IsAirplaneModeOn) Then";
if ((_p.IsAirplaneModeOn())) { 
 //BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"Airplane mode is enabled. Int";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Airplane mode is enabled. Internet connection needed for maps",anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 114;BA.debugLine="ToastMessageShow(\"Device GPS is disabled. Pleas";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Device GPS is disabled. Please enable now",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 115;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInte";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 };
 };
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _specieslist_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 215;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
 //BA.debugLineNum = 216;BA.debugLine="SelectedID = Value -1";
_selectedid = (int) ((double)(BA.ObjectToNumber(_value))-1);
 //BA.debugLineNum = 217;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
 //BA.debugLineNum = 218;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 220;BA.debugLine="LoadBirdPic(SelectedID)";
_loadbirdpic(_selectedid);
 //BA.debugLineNum = 221;BA.debugLine="LoadBird(SelectedID)";
_loadbird(_selectedid);
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
}
