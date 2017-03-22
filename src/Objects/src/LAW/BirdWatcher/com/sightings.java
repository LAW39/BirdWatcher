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

public class sightings extends Activity implements B4AActivity{
	public static sightings mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.sightings");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sightings).");
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
		activityBA = new BA(this, layout, processBA, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.sightings");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "LAW.BirdWatcher.com.sightings", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sightings) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sightings) Resume **");
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
		return sightings.class;
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
        BA.LogInfo("** Activity (sightings) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (sightings) Resume **");
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
public static boolean _maplookupflag = false;
public static anywheresoftware.b4a.objects.collections.List _sightingphotolist = null;
public anywheresoftware.b4a.objects.ListViewWrapper _specieslist = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addnow = null;
public anywheresoftware.b4a.objects.EditTextWrapper _flocksize = null;
public anywheresoftware.b4a.objects.EditTextWrapper _birdappearance = null;
public anywheresoftware.b4a.objects.EditTextWrapper _weatherconditions = null;
public anywheresoftware.b4a.objects.LabelWrapper _time = null;
public static int _selectedid = 0;
public anywheresoftware.b4a.objects.LabelWrapper _date = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _mapcheck = null;
public anywheresoftware.b4a.gps.LocationWrapper _location = null;
public static long _datetimeticks = 0L;
public anywheresoftware.b4a.objects.ButtonWrapper _getlocation = null;
public anywheresoftware.b4a.objects.ButtonWrapper _viewphotos = null;
public anywheresoftware.b4a.objects.ListViewWrapper _sightinglist = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public LAW.BirdWatcher.com.map _map = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Log(Starter.GPS1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._gps1));
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Log(Starter.L1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._l1));
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="Activity.LoadLayout(\"sightingadd\")";
mostCurrent._activity.LoadLayout("sightingadd",mostCurrent.activityBA);
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="Activity.Title = \"Sightings\"";
mostCurrent._activity.setTitle((Object)("Sightings"));
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="SpeciesList.SingleLineLayout.Label.TextColor = Co";
mostCurrent._specieslist.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="SightingList.SingleLineLayout.Label.TextColor = C";
mostCurrent._sightinglist.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="DateTime.Dateformat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="DateTime.TimeFormat= \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="Populate_List";
_populate_list();
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="Location.Initialize";
mostCurrent._location.Initialize();
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="Map.SelectedBird=False";
mostCurrent._map._selectedbird = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="End Sub";
return "";
}
public static String  _populate_list() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "populate_list"))
	return (String) Debug.delegate(mostCurrent.activityBA, "populate_list", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Populate_List";
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="MapCheck.Visible = True";
mostCurrent._mapcheck.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="GetLocation.Visible = True";
mostCurrent._getlocation.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="AddNow.Visible = False";
mostCurrent._addnow.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="SpeciesList.clear";
mostCurrent._specieslist.Clear();
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="If MapLookupFlag Then";
if (_maplookupflag) { 
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="OpenSightingInfo(Map.SelectedID)";
_opensightinginfo(mostCurrent._map._selectedid);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="MapLookupFlag = False";
_maplookupflag = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="GetLocation.Visible = False";
mostCurrent._getlocation.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="MapCheck.Visible = False";
mostCurrent._mapcheck.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="AddNow.Visible = False";
mostCurrent._addnow.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="SpeciesList.AddSingleLine2(\"Add Sighting\",\"-1\")";
mostCurrent._specieslist.AddSingleLine2("Add Sighting",(Object)("-1"));
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step15 = 1;
final int limit15 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStr";
mostCurrent._specieslist.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
 };
RDebugUtils.currentLine=2031642;
 //BA.debugLineNum = 2031642;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="sightings";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="If Starter.GPS1.GPSEnabled = False Then";
if (mostCurrent._starter._gps1.getGPSEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="ToastMessageShow(\"Please enable the GPS device.\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please enable the GPS device.",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsIntent";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 };
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="End Sub";
return "";
}
public static String  _addnow_click() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addnow_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "addnow_click", null);
String[] _date_time = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub AddNow_Click";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="If MapCheck.Checked = False Then";
if (mostCurrent._mapcheck.getChecked()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Location.Latitude = Starter.L1.Latitude";
mostCurrent._location.setLatitude(mostCurrent._starter._l1.getLatitude());
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Location.Longitude = Starter.L1.longitude";
mostCurrent._location.setLongitude(mostCurrent._starter._l1.getLongitude());
 }else {
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="Map.GetLocationFlag = True";
mostCurrent._map._getlocationflag = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="Location.Latitude = Map.Location.Latitude";
mostCurrent._location.setLatitude(mostCurrent._map._location.getLatitude());
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="Location.Longitude = Map.Location.Longitude";
mostCurrent._location.setLongitude(mostCurrent._map._location.getLongitude());
 };
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="Dim Date_Time(2) As String";
_date_time = new String[(int) (2)];
java.util.Arrays.fill(_date_time,"");
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="Date_Time(0) = Date.text";
_date_time[(int) (0)] = mostCurrent._date.getText();
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="Date_Time(1) = Time.Text";
_date_time[(int) (1)] = mostCurrent._time.getText();
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="If Date_Time(0) = \"\" Then";
if ((_date_time[(int) (0)]).equals("")) { 
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="Date_Time(0) = DateTime.GetDayOfMonth(DateTime.N";
_date_time[(int) (0)] = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 };
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="If Date_Time(1) = \"\" Then";
if ((_date_time[(int) (1)]).equals("")) { 
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="Date_Time(1) = DateTime.GetHour(DateTime.Now) &";
_date_time[(int) (1)] = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetSecond(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 };
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="Log(Starter.L1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._l1));
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="DateTimeTicks = DateTime.DateTimeParse(Date_Time(";
_datetimeticks = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_date_time[(int) (0)],_date_time[(int) (1)]);
RDebugUtils.currentLine=2162713;
 //BA.debugLineNum = 2162713;BA.debugLine="Log(DateTimeTicks)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_datetimeticks));
RDebugUtils.currentLine=2162715;
 //BA.debugLineNum = 2162715;BA.debugLine="ExportData";
_exportdata();
RDebugUtils.currentLine=2162717;
 //BA.debugLineNum = 2162717;BA.debugLine="End Sub";
return "";
}
public static String  _exportdata() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "exportdata"))
	return (String) Debug.delegate(mostCurrent.activityBA, "exportdata", null);
anywheresoftware.b4a.keywords.StringBuilderWrapper _sightingsql = null;
String[] _insertdata = null;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub ExportData";
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="Dim SightingSQL As StringBuilder";
_sightingsql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Dim InsertData(7) As String";
_insertdata = new String[(int) (7)];
java.util.Arrays.fill(_insertdata,"");
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="SightingSQL.Initialize";
_sightingsql.Initialize();
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="InsertData(0) = SelectedID";
_insertdata[(int) (0)] = BA.NumberToString(_selectedid);
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="InsertData(1) = FlockSize.Text";
_insertdata[(int) (1)] = mostCurrent._flocksize.getText();
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="InsertData(2) = WeatherConditions.Text";
_insertdata[(int) (2)] = mostCurrent._weatherconditions.getText();
RDebugUtils.currentLine=2228235;
 //BA.debugLineNum = 2228235;BA.debugLine="InsertData(3) =	 BirdAppearance.Text";
_insertdata[(int) (3)] = mostCurrent._birdappearance.getText();
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="InsertData(4) = DateTimeTicks";
_insertdata[(int) (4)] = BA.NumberToString(_datetimeticks);
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="InsertData(5) = Location.Latitude";
_insertdata[(int) (5)] = BA.NumberToString(mostCurrent._location.getLatitude());
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="InsertData(6) = Location.Longitude";
_insertdata[(int) (6)] = BA.NumberToString(mostCurrent._location.getLongitude());
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="SightingSQL.Append(\"INSERT INTO Sightings (Specie";
_sightingsql.Append("INSERT INTO Sightings (SpeciesID,FlockSize,Weather,Appearance,Epoch,Lat,Lng) VALUES (?, ?, ?, ?, ?, ?, ?)");
RDebugUtils.currentLine=2228243;
 //BA.debugLineNum = 2228243;BA.debugLine="Starter.database.ExecNonQuery2(SightingSQL, Inser";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_sightingsql),anywheresoftware.b4a.keywords.Common.ArrayToList(_insertdata));
RDebugUtils.currentLine=2228245;
 //BA.debugLineNum = 2228245;BA.debugLine="End Sub";
return "";
}
public static String  _date_click() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "date_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "date_click", null);
anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog _datedialog = null;
int _dialogret = 0;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Date_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Dim DateDialog As DateDialog";
_datedialog = new anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog();
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Dim DialogRet As Int";
_dialogret = 0;
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="DateDialog.DateTicks = DateTime.Now";
_datedialog.setDateTicks(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="DialogRet = DateDialog.Show(\"\",\"Select date\",\"Ok\"";
_dialogret = _datedialog.Show("","Select date","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
if (_dialogret==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="Date.Text = DateTime.Date(DateDialog.DateTicks)";
mostCurrent._date.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date(_datedialog.getDateTicks())));
 };
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="End Sub";
return "";
}
public static String  _getlocation_click() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getlocation_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "getlocation_click", null);
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub GetLocation_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="If MapCheck.Checked = False Then";
if (mostCurrent._mapcheck.getChecked()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="GPSReady";
_gpsready();
 }else {
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="Map.GetLocationFlag = True";
mostCurrent._map._getlocationflag = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="StartActivity(\"Map\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Map"));
 };
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="End Sub";
return "";
}
public static String  _gpsready() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gpsready"))
	return (String) Debug.delegate(mostCurrent.activityBA, "gpsready", null);
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub GPSReady";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="If Starter.GPS1.GPSEnabled= False Then";
if (mostCurrent._starter._gps1.getGPSEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="ToastMessageShow(\"Please enable your device's G";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please enable your device's GPS capabilities",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInten";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 }else {
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Starter.gps1.Start(0,0)";
mostCurrent._starter._gps1.Start(processBA,(long) (0),(float) (0));
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="ProgressDialogShow(\"Waiting for GPS location\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Waiting for GPS location");
 };
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="End Sub";
return "";
}
public static String  _gps1_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _gpslocation) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "gps1_locationchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "gps1_locationchanged", new Object[] {_gpslocation});
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub GPS1_LocationChanged (gpsLocation As Location)";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Starter.L1=gpsLocation";
mostCurrent._starter._l1 = _gpslocation;
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Starter.gps1.Stop";
mostCurrent._starter._gps1.Stop();
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="End Sub";
return "";
}
public static String  _load_photos(int _sightingid) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "load_photos"))
	return (String) Debug.delegate(mostCurrent.activityBA, "load_photos", new Object[] {_sightingid});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sqlquery = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _sightingpicture = null;
double _birdphotofile = 0;
int _counter = 0;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Load_Photos(SightingID As Int)";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="SightingPhotoList.Initialize";
_sightingphotolist.Initialize();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Log(SightingID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_sightingid));
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Dim SQLQuery As StringBuilder";
_sqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Dim SightingPicture As Bitmap";
_sightingpicture = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="Dim BirdPhotoFile As Double";
_birdphotofile = 0;
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="SQLQuery.Initialize";
_sqlquery.Initialize();
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="SQLQuery.Append(\"SELECT PhotoDir\").Append(CRLF)";
_sqlquery.Append("SELECT PhotoDir").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="SQLQuery.append(\"FROM SightingPhoto\").Append(CRLF";
_sqlquery.Append("FROM SightingPhoto").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
_sqlquery.Append("LEFT JOIN Sightings ON Sightings.ID = SightingPhoto.SightingID").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
_sqlquery.Append("WHERE Sightings.ID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_sqlquery),new String[]{BA.NumberToString(_sightingid)})));
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="Log(SpeciesCursor.RowCount & \"Test\")";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_speciescursor.getRowCount())+"Test");
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="Try";
try {RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="For counter = 0 To SpeciesCursor.RowCount";
{
final int step16 = 1;
final int limit16 = _speciescursor.getRowCount();
for (_counter = (int) (0) ; (step16 > 0 && _counter <= limit16) || (step16 < 0 && _counter >= limit16); _counter = ((int)(0 + _counter + step16)) ) {
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="BirdPhotoFile = SpeciesCursor.GetDouble(\"PhotoD";
_birdphotofile = _speciescursor.GetDouble("PhotoDir");
RDebugUtils.currentLine=2621460;
 //BA.debugLineNum = 2621460;BA.debugLine="SightingPicture.Initialize(Main.BirdPhotoPath,B";
_sightingpicture.Initialize(mostCurrent._main._birdphotopath,BA.NumberToString(_birdphotofile)+".jpg");
RDebugUtils.currentLine=2621461;
 //BA.debugLineNum = 2621461;BA.debugLine="SightingPhotoList.Add(SightingPicture)";
_sightingphotolist.Add((Object)(_sightingpicture.getObject()));
 }
};
 } 
       catch (Exception e22) {
			processBA.setLastException(e22);RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="ToastMessageShow(\"No sighting images\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("No sighting images",anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2621466;
 //BA.debugLineNum = 2621466;BA.debugLine="SightingPhotos.SightingPhotoList.Initialize";
mostCurrent._sightingphotos._sightingphotolist.Initialize();
RDebugUtils.currentLine=2621467;
 //BA.debugLineNum = 2621467;BA.debugLine="SightingPhotos.SightingPhotoList.Clear";
mostCurrent._sightingphotos._sightingphotolist.Clear();
RDebugUtils.currentLine=2621468;
 //BA.debugLineNum = 2621468;BA.debugLine="SightingPhotos.SightingPhotoList = SightingPhotoL";
mostCurrent._sightingphotos._sightingphotolist = _sightingphotolist;
RDebugUtils.currentLine=2621469;
 //BA.debugLineNum = 2621469;BA.debugLine="End Sub";
return "";
}
public static String  _loadattributes(int _id) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadattributes"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loadattributes", new Object[] {_id});
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub LoadAttributes(ID As Int)";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
_cursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT * FROM Sightings WHERE ID ="+BA.NumberToString(_id))));
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="FlockSize.Text = Cursor.GetString(\"FlockSize\")";
mostCurrent._flocksize.setText((Object)(_cursor.GetString("FlockSize")));
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearan";
mostCurrent._birdappearance.setText((Object)(_cursor.GetString("Appearance")));
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weath";
mostCurrent._weatherconditions.setText((Object)(_cursor.GetString("Weather")));
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\"";
mostCurrent._date.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date(_cursor.GetLong("Epoch"))));
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\"";
mostCurrent._time.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Time(_cursor.GetLong("Epoch"))));
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="End Sub";
return "";
}
public static String  _opensightinginfo(int _id) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opensightinginfo"))
	return (String) Debug.delegate(mostCurrent.activityBA, "opensightinginfo", new Object[] {_id});
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Public Sub OpenSightingInfo(ID As Int)";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="ID = ID + 1";
_id = (int) (_id+1);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="SpeciesList_ItemClick (ID,ID)";
_specieslist_itemclick(_id,(Object)(_id));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="LoadAttributes(ID)";
_loadattributes(_id);
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="Return";
if (true) return "";
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="End Sub";
return "";
}
public static String  _specieslist_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "specieslist_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "specieslist_itemclick", new Object[] {_position,_value});
anywheresoftware.b4a.sql.SQL.CursorWrapper _sightingcursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sqlquery = null;
int _i = 0;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="SelectedID = Value -1";
_selectedid = (int) ((double)(BA.ObjectToNumber(_value))-1);
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="If Value = -2 Then";
if ((_value).equals((Object)(-2))) { 
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="AddNow.Width = 100dip";
mostCurrent._addnow.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="AddNow.Visible = True";
mostCurrent._addnow.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="AddNow.Width = 200dip";
mostCurrent._addnow.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="AddNow.Visible = True";
mostCurrent._addnow.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="Load_Photos(Value)";
_load_photos((int)(BA.ObjectToNumber(_value)));
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="Dim SightingCursor As Cursor";
_sightingcursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="Dim SQLQuery As StringBuilder";
_sqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2490384;
 //BA.debugLineNum = 2490384;BA.debugLine="SQLQuery.Initialize";
_sqlquery.Initialize();
RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="SQLQuery.Append(\"SELECT * FROM Sightings\").append";
_sqlquery.Append("SELECT * FROM Sightings").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="Log(SelectedID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_selectedid));
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="SQLQuery.Append(\"WHERE SpeciesID = ?\").append(CRL";
_sqlquery.Append("WHERE SpeciesID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="SightingCursor = Starter.Database.ExecQuery2(SQLQ";
_sightingcursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_sqlquery),new String[]{BA.ObjectToString(_value)})));
RDebugUtils.currentLine=2490390;
 //BA.debugLineNum = 2490390;BA.debugLine="SightingList.clear 'Clears list";
mostCurrent._sightinglist.Clear();
RDebugUtils.currentLine=2490392;
 //BA.debugLineNum = 2490392;BA.debugLine="SightingList.AddSingleLine2(\"<Add Sighting>\", 0)";
mostCurrent._sightinglist.AddSingleLine2("<Add Sighting>",(Object)(0));
RDebugUtils.currentLine=2490394;
 //BA.debugLineNum = 2490394;BA.debugLine="For i=0 To SightingCursor.RowCount-1 ' Loop to po";
{
final int step22 = 1;
final int limit22 = (int) (_sightingcursor.getRowCount()-1);
for (_i = (int) (0) ; (step22 > 0 && _i <= limit22) || (step22 < 0 && _i >= limit22); _i = ((int)(0 + _i + step22)) ) {
RDebugUtils.currentLine=2490396;
 //BA.debugLineNum = 2490396;BA.debugLine="SightingCursor.Position = i";
_sightingcursor.setPosition(_i);
RDebugUtils.currentLine=2490397;
 //BA.debugLineNum = 2490397;BA.debugLine="SightingList.AddSingleLine2(i+1,SightingCursor.G";
mostCurrent._sightinglist.AddSingleLine2(BA.NumberToString(_i+1),(Object)(_sightingcursor.GetString("ID")));
 }
};
RDebugUtils.currentLine=2490399;
 //BA.debugLineNum = 2490399;BA.debugLine="End Sub";
return "";
}
public static String  _populatesightings(int _sightingid) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "populatesightings"))
	return (String) Debug.delegate(mostCurrent.activityBA, "populatesightings", new Object[] {_sightingid});
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub PopulateSightings(sightingID As Int)";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
_cursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT * FROM Sightings WHERE ID = "+BA.NumberToString(_sightingid))));
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="FlockSize.Text = Cursor.GetString(\"Flock\")";
mostCurrent._flocksize.setText((Object)(_cursor.GetString("Flock")));
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearan";
mostCurrent._birdappearance.setText((Object)(_cursor.GetString("Appearance")));
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weath";
mostCurrent._weatherconditions.setText((Object)(_cursor.GetString("Weather")));
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\"";
mostCurrent._date.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date(_cursor.GetLong("Epoch"))));
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\"";
mostCurrent._time.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Time(_cursor.GetLong("Epoch"))));
RDebugUtils.currentLine=5832717;
 //BA.debugLineNum = 5832717;BA.debugLine="End Sub";
return "";
}
public static String  _sightinglist_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sightinglist_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sightinglist_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub SightingList_ItemClick (Position As Int, Value";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="PopulateSightings(Value)";
_populatesightings((int)(BA.ObjectToNumber(_value)));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
public static String  _time_click() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "time_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "time_click", null);
anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog _timedialog = null;
int _dialogret = 0;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Time_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim TimeDialog As TimeDialog";
_timedialog = new anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog();
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Dim DialogRet As Int";
_dialogret = 0;
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="TimeDialog.TimeTicks = DateTime.Now";
_timedialog.setTimeTicks(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="DialogRet = TimeDialog.Show(\"\",\"Select time\",\"Ok\"";
_dialogret = _timedialog.Show("","Select time","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=2818056;
 //BA.debugLineNum = 2818056;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
if (_dialogret==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2818057;
 //BA.debugLineNum = 2818057;BA.debugLine="Time.Text = DateTime.Time(TimeDialog.TimeTicks)";
mostCurrent._time.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Time(_timedialog.getTimeTicks())));
 };
RDebugUtils.currentLine=2818059;
 //BA.debugLineNum = 2818059;BA.debugLine="End Sub";
return "";
}
public static String  _viewphotos_click() throws Exception{
RDebugUtils.currentModule="sightings";
if (Debug.shouldDelegate(mostCurrent.activityBA, "viewphotos_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "viewphotos_click", null);
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub ViewPhotos_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="StartActivity(SightingPhotos)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sightingphotos.getObject()));
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Starter.list.Initialize";
mostCurrent._starter._list.Initialize();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Starter.list.Clear";
mostCurrent._starter._list.Clear();
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Starter.list = SightingPhotoList";
mostCurrent._starter._list = _sightingphotolist;
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="End Sub";
return "";
}
}