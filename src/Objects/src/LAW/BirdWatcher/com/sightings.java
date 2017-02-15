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
			processBA = new BA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.sightings");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _maplookupflag = false;
public anywheresoftware.b4a.objects.ListViewWrapper _specieslist = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addnow = null;
public anywheresoftware.b4a.objects.EditTextWrapper _flocksize = null;
public anywheresoftware.b4a.objects.EditTextWrapper _birdappearance = null;
public anywheresoftware.b4a.objects.EditTextWrapper _weatherconditions = null;
public anywheresoftware.b4a.objects.LabelWrapper _time = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _birdphotoview = null;
public static int _selectedid = 0;
public anywheresoftware.b4a.objects.LabelWrapper _date = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _mapcheck = null;
public anywheresoftware.b4a.gps.LocationWrapper _location = null;
public static long _datetimeticks = 0L;
public anywheresoftware.b4a.objects.ButtonWrapper _getlocation = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.map _map = null;
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
 //BA.debugLineNum = 31;BA.debugLine="Log(Starter.GPS1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._gps1));
 //BA.debugLineNum = 32;BA.debugLine="Log(Starter.L1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._l1));
 //BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"sightingadd\")";
mostCurrent._activity.LoadLayout("sightingadd",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Activity.Title = \"Sightings\"";
mostCurrent._activity.setTitle((Object)("Sightings"));
 //BA.debugLineNum = 37;BA.debugLine="DateTime.Dateformat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
 //BA.debugLineNum = 38;BA.debugLine="DateTime.TimeFormat= \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 39;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 40;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")));
 //BA.debugLineNum = 41;BA.debugLine="SpeciesList.clear";
mostCurrent._specieslist.Clear();
 //BA.debugLineNum = 42;BA.debugLine="If MapLookupFlag Then";
if (_maplookupflag) { 
 //BA.debugLineNum = 43;BA.debugLine="OpenSightingInfo(Map.SelectedID)";
_opensightinginfo(mostCurrent._map._selectedid);
 //BA.debugLineNum = 44;BA.debugLine="MapLookupFlag = False";
_maplookupflag = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 46;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
{
final int step14 = 1;
final int limit14 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
 //BA.debugLineNum = 47;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
 //BA.debugLineNum = 48;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStr";
mostCurrent._specieslist.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
 };
 //BA.debugLineNum = 52;BA.debugLine="Location.Initialize";
mostCurrent._location.Initialize();
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 59;BA.debugLine="If Starter.GPS1.GPSEnabled = False Then";
if (mostCurrent._starter._gps1.getGPSEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"Please enable the GPS device.\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please enable the GPS device.",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 61;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsIntent";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 };
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _addnow_click() throws Exception{
String[] _date_time = null;
 //BA.debugLineNum = 70;BA.debugLine="Sub AddNow_Click";
 //BA.debugLineNum = 72;BA.debugLine="If MapCheck.Checked = False Then";
if (mostCurrent._mapcheck.getChecked()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 73;BA.debugLine="Location.Latitude = Starter.L1.Latitude";
mostCurrent._location.setLatitude(mostCurrent._starter._l1.getLatitude());
 //BA.debugLineNum = 74;BA.debugLine="Location.Longitude = Starter.L1.longitude";
mostCurrent._location.setLongitude(mostCurrent._starter._l1.getLongitude());
 }else {
 //BA.debugLineNum = 76;BA.debugLine="Map.GetLocationFlag = True";
mostCurrent._map._getlocationflag = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 77;BA.debugLine="Location.Latitude = Map.Location.Latitude";
mostCurrent._location.setLatitude(mostCurrent._map._location.getLatitude());
 //BA.debugLineNum = 78;BA.debugLine="Location.Longitude = Map.Location.Longitude";
mostCurrent._location.setLongitude(mostCurrent._map._location.getLongitude());
 };
 //BA.debugLineNum = 81;BA.debugLine="Dim Date_Time(2) As String";
_date_time = new String[(int) (2)];
java.util.Arrays.fill(_date_time,"");
 //BA.debugLineNum = 82;BA.debugLine="Date_Time(0) = Date.text";
_date_time[(int) (0)] = mostCurrent._date.getText();
 //BA.debugLineNum = 83;BA.debugLine="Date_Time(1) = Time.Text";
_date_time[(int) (1)] = mostCurrent._time.getText();
 //BA.debugLineNum = 85;BA.debugLine="If Date_Time(0) = \"\" Then";
if ((_date_time[(int) (0)]).equals("")) { 
 //BA.debugLineNum = 86;BA.debugLine="Date_Time(0) = DateTime.GetDayOfMonth(DateTime.N";
_date_time[(int) (0)] = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 };
 //BA.debugLineNum = 89;BA.debugLine="If Date_Time(1) = \"\" Then";
if ((_date_time[(int) (1)]).equals("")) { 
 //BA.debugLineNum = 90;BA.debugLine="Date_Time(1) = DateTime.GetHour(DateTime.Now) &";
_date_time[(int) (1)] = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetSecond(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 };
 //BA.debugLineNum = 93;BA.debugLine="Log(Starter.L1)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._starter._l1));
 //BA.debugLineNum = 94;BA.debugLine="DateTimeTicks = DateTime.DateTimeParse(Date_Time(";
_datetimeticks = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_date_time[(int) (0)],_date_time[(int) (1)]);
 //BA.debugLineNum = 95;BA.debugLine="Log(DateTimeTicks)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_datetimeticks));
 //BA.debugLineNum = 97;BA.debugLine="ExportData";
_exportdata();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _date_click() throws Exception{
anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog _datedialog = null;
int _dialogret = 0;
 //BA.debugLineNum = 188;BA.debugLine="Sub Date_Click";
 //BA.debugLineNum = 189;BA.debugLine="Dim DateDialog As DateDialog";
_datedialog = new anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog();
 //BA.debugLineNum = 190;BA.debugLine="Dim DialogRet As Int";
_dialogret = 0;
 //BA.debugLineNum = 192;BA.debugLine="DateDialog.DateTicks = DateTime.Now";
_datedialog.setDateTicks(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 194;BA.debugLine="DialogRet = DateDialog.Show(\"\",\"Select date\",\"Ok\"";
_dialogret = _datedialog.Show("","Select date","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 196;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
if (_dialogret==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 197;BA.debugLine="Date.Text = DateTime.Date(DateDialog.DateTicks)";
mostCurrent._date.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date(_datedialog.getDateTicks())));
 };
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _exportdata() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sightingsql = null;
String[] _insertdata = null;
 //BA.debugLineNum = 101;BA.debugLine="Sub ExportData";
 //BA.debugLineNum = 105;BA.debugLine="Dim SightingSQL As StringBuilder";
_sightingsql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 106;BA.debugLine="Dim InsertData(7) As String";
_insertdata = new String[(int) (7)];
java.util.Arrays.fill(_insertdata,"");
 //BA.debugLineNum = 108;BA.debugLine="SightingSQL.Initialize";
_sightingsql.Initialize();
 //BA.debugLineNum = 109;BA.debugLine="InsertData(0) = SelectedID";
_insertdata[(int) (0)] = BA.NumberToString(_selectedid);
 //BA.debugLineNum = 110;BA.debugLine="InsertData(1) = FlockSize.Text";
_insertdata[(int) (1)] = mostCurrent._flocksize.getText();
 //BA.debugLineNum = 111;BA.debugLine="InsertData(2) = WeatherConditions.Text";
_insertdata[(int) (2)] = mostCurrent._weatherconditions.getText();
 //BA.debugLineNum = 112;BA.debugLine="InsertData(3) =	 BirdAppearance.Text";
_insertdata[(int) (3)] = mostCurrent._birdappearance.getText();
 //BA.debugLineNum = 113;BA.debugLine="InsertData(4) = DateTimeTicks";
_insertdata[(int) (4)] = BA.NumberToString(_datetimeticks);
 //BA.debugLineNum = 114;BA.debugLine="InsertData(5) = Location.Latitude";
_insertdata[(int) (5)] = BA.NumberToString(mostCurrent._location.getLatitude());
 //BA.debugLineNum = 115;BA.debugLine="InsertData(6) = Location.Longitude";
_insertdata[(int) (6)] = BA.NumberToString(mostCurrent._location.getLongitude());
 //BA.debugLineNum = 118;BA.debugLine="SightingSQL.Append(\"INSERT INTO Sightings (Specie";
_sightingsql.Append("INSERT INTO Sightings (SpeciesID,FlockSize,Weather,Appearance,Epoch,Lat,Lng) VALUES (?, ?, ?, ?, ?, ?, ?)");
 //BA.debugLineNum = 120;BA.debugLine="Starter.database.ExecNonQuery2(SightingSQL, Inser";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_sightingsql),anywheresoftware.b4a.keywords.Common.ArrayToList(_insertdata));
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static String  _getlocation_click() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Sub GetLocation_Click";
 //BA.debugLineNum = 142;BA.debugLine="If MapCheck.Checked = False Then";
if (mostCurrent._mapcheck.getChecked()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 143;BA.debugLine="GPSReady";
_gpsready();
 }else {
 //BA.debugLineNum = 145;BA.debugLine="Map.GetLocationFlag = True";
mostCurrent._map._getlocationflag = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 146;BA.debugLine="StartActivity(\"Map\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Map"));
 };
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private SpeciesList As ListView";
mostCurrent._specieslist = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private AddNow As Button";
mostCurrent._addnow = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private FlockSize As EditText";
mostCurrent._flocksize = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private BirdAppearance As EditText";
mostCurrent._birdappearance = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private WeatherConditions As EditText";
mostCurrent._weatherconditions = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private Time As Label";
mostCurrent._time = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private BirdPhotoView As ImageView";
mostCurrent._birdphotoview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private SelectedID As Int = 0";
_selectedid = (int) (0);
 //BA.debugLineNum = 23;BA.debugLine="Private Date As Label";
mostCurrent._date = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private MapCheck As CheckBox";
mostCurrent._mapcheck = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private Location As Location";
mostCurrent._location = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private DateTimeTicks As Long";
_datetimeticks = 0L;
 //BA.debugLineNum = 27;BA.debugLine="Private GetLocation As Button";
mostCurrent._getlocation = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _gps1_locationchanged(anywheresoftware.b4a.gps.LocationWrapper _gpslocation) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Sub GPS1_LocationChanged (gpsLocation As Location)";
 //BA.debugLineNum = 135;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 136;BA.debugLine="Starter.L1=gpsLocation";
mostCurrent._starter._l1 = _gpslocation;
 //BA.debugLineNum = 137;BA.debugLine="Starter.gps1.Stop";
mostCurrent._starter._gps1.Stop();
 //BA.debugLineNum = 138;BA.debugLine="StartActivity(\"actDisplayMap\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("actDisplayMap"));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _gpsready() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Sub GPSReady";
 //BA.debugLineNum = 125;BA.debugLine="If Starter.GPS1.GPSEnabled= False Then";
if (mostCurrent._starter._gps1.getGPSEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 126;BA.debugLine="ToastMessageShow(\"Please enable your device's G";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Please enable your device's GPS capabilities",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 127;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInten";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._starter._gps1.getLocationSettingsIntent()));
 }else {
 //BA.debugLineNum = 129;BA.debugLine="Starter.gps1.Start(0,0)";
mostCurrent._starter._gps1.Start(processBA,(long) (0),(float) (0));
 //BA.debugLineNum = 130;BA.debugLine="ProgressDialogShow(\"Waiting for GPS location\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Waiting for GPS location");
 };
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _loadattributes(int _id) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 176;BA.debugLine="Sub LoadAttributes(ID As Int)";
 //BA.debugLineNum = 177;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 178;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
_cursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT * FROM Sightings WHERE ID ="+BA.NumberToString(_id))));
 //BA.debugLineNum = 179;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 180;BA.debugLine="FlockSize.Text = Cursor.GetString(\"FlockSize\")";
mostCurrent._flocksize.setText((Object)(_cursor.GetString("FlockSize")));
 //BA.debugLineNum = 181;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearan";
mostCurrent._birdappearance.setText((Object)(_cursor.GetString("Appearance")));
 //BA.debugLineNum = 182;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weath";
mostCurrent._weatherconditions.setText((Object)(_cursor.GetString("Weather")));
 //BA.debugLineNum = 183;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\"";
mostCurrent._date.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Date(_cursor.GetLong("Epoch"))));
 //BA.debugLineNum = 184;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\"";
mostCurrent._time.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Time(_cursor.GetLong("Epoch"))));
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public static String  _loadbirdpic(int _id) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
 //BA.debugLineNum = 159;BA.debugLine="Sub LoadBirdPic(ID As Int)";
 //BA.debugLineNum = 160;BA.debugLine="ID = ID +1";
_id = (int) (_id+1);
 //BA.debugLineNum = 162;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 163;BA.debugLine="NewBird.InitializeSample(File.DirAssets, ID & \".j";
_newbird.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.NumberToString(_id)+".jpg",(int) (240),(int) (240));
 //BA.debugLineNum = 164;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
mostCurrent._birdphotoview.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _opensightinginfo(int _id) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Public Sub OpenSightingInfo(ID As Int)";
 //BA.debugLineNum = 169;BA.debugLine="ID = ID + 1";
_id = (int) (_id+1);
 //BA.debugLineNum = 170;BA.debugLine="SpeciesList_ItemClick (ID,ID)";
_specieslist_itemclick(_id,(Object)(_id));
 //BA.debugLineNum = 171;BA.debugLine="LoadAttributes(ID)";
_loadattributes(_id);
 //BA.debugLineNum = 173;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim MapLookupFlag As Boolean = False";
_maplookupflag = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _specieslist_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
 //BA.debugLineNum = 151;BA.debugLine="SelectedID = Value -1";
_selectedid = (int) ((double)(BA.ObjectToNumber(_value))-1);
 //BA.debugLineNum = 152;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
 //BA.debugLineNum = 153;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 155;BA.debugLine="LoadBirdPic(SelectedID)";
_loadbirdpic(_selectedid);
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _time_click() throws Exception{
anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog _timedialog = null;
int _dialogret = 0;
 //BA.debugLineNum = 201;BA.debugLine="Sub Time_Click";
 //BA.debugLineNum = 202;BA.debugLine="Dim TimeDialog As TimeDialog";
_timedialog = new anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog();
 //BA.debugLineNum = 203;BA.debugLine="Dim DialogRet As Int";
_dialogret = 0;
 //BA.debugLineNum = 205;BA.debugLine="TimeDialog.TimeTicks = DateTime.Now";
_timedialog.setTimeTicks(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 207;BA.debugLine="DialogRet = TimeDialog.Show(\"\",\"Select time\",\"Ok\"";
_dialogret = _timedialog.Show("","Select time","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 209;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
if (_dialogret==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 210;BA.debugLine="Time.Text = DateTime.Time(TimeDialog.TimeTicks)";
mostCurrent._time.setText((Object)(anywheresoftware.b4a.keywords.Common.DateTime.Time(_timedialog.getTimeTicks())));
 };
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
}
