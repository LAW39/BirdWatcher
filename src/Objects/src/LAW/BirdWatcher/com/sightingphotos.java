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

public class sightingphotos extends Activity implements B4AActivity{
	public static sightingphotos mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.sightingphotos");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sightingphotos).");
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
		activityBA = new BA(this, layout, processBA, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.sightingphotos");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "LAW.BirdWatcher.com.sightingphotos", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sightingphotos) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sightingphotos) Resume **");
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
		return sightingphotos.class;
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
        BA.LogInfo("** Activity (sightingphotos) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (sightingphotos) Resume **");
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
public static anywheresoftware.b4a.objects.collections.List _sightingphotolist = null;
public static int _sightid = 0;
public anywheresoftware.b4a.objects.TabStripViewPager _phototab = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _sightingphoto = null;
public anywheresoftware.b4a.objects.ButtonWrapper _removebtn = null;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.species _species = null;
public LAW.BirdWatcher.com.sightings _sightings = null;
public LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public LAW.BirdWatcher.com.map _map = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="sightingphotos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
int _i = 0;
String _photoint = "";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="Log(SightID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_sightid));
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="Activity.LoadLayout(\"SightingPhotos\")";
mostCurrent._activity.LoadLayout("SightingPhotos",mostCurrent.activityBA);
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",\"Species Picture\")";
mostCurrent._phototab.LoadLayout("PhotoTab",(java.lang.CharSequence)("Species Picture"));
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="Load_Photos(SightID)";
_load_photos(_sightid);
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Activity.Title = (\"Photos\")";
mostCurrent._activity.setTitle((Object)(("Photos")));
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Log(SightingPhotoList.Size)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_sightingphotolist.getSize()));
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="For i = 0 To SightingPhotoList.Size-1";
{
final int step7 = 1;
final int limit7 = (int) (_sightingphotolist.getSize()-1);
for (_i = (int) (0) ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="Dim PhotoInt As String = i+1";
_photoint = BA.NumberToString(_i+1);
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",PhotoInt)";
mostCurrent._phototab.LoadLayout("PhotoTab",(java.lang.CharSequence)(_photoint));
 }
};
RDebugUtils.currentLine=3473423;
 //BA.debugLineNum = 3473423;BA.debugLine="Phototab_PageSelected (0)";
_phototab_pageselected((int) (0));
RDebugUtils.currentLine=3473425;
 //BA.debugLineNum = 3473425;BA.debugLine="End Sub";
return "";
}
public static String  _load_photos(int _sightingid) throws Exception{
RDebugUtils.currentModule="sightingphotos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "load_photos"))
	return (String) Debug.delegate(mostCurrent.activityBA, "load_photos", new Object[] {_sightingid});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sqlquery = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _sightingpicture = null;
double _birdphotofile = 0;
int _counter = 0;
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Load_Photos(SightingID As Int)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="SightingPhotoList.Initialize";
_sightingphotolist.Initialize();
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Log(SightingID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_sightingid));
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="Dim SQLQuery As StringBuilder";
_sqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="Dim SightingPicture As Bitmap";
_sightingpicture = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="Dim BirdPhotoFile As Double";
_birdphotofile = 0;
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="SQLQuery.Initialize";
_sqlquery.Initialize();
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="SQLQuery.Append(\"SELECT PhotoDir\").Append(CRLF)";
_sqlquery.Append("SELECT PhotoDir").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="SQLQuery.Append(\"FROM SightingPhoto\").Append(CRLF";
_sqlquery.Append("FROM SightingPhoto").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
_sqlquery.Append("LEFT JOIN Sightings ON Sightings.ID = SightingPhoto.SightingID").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
_sqlquery.Append("WHERE Sightings.ID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_sqlquery),new String[]{BA.NumberToString(_sightingid)})));
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="Log(SpeciesCursor.RowCount & \"Test\")";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_speciescursor.getRowCount())+"Test");
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="For counter = 0 To SpeciesCursor.RowCount";
{
final int step15 = 1;
final int limit15 = _speciescursor.getRowCount();
for (_counter = (int) (0) ; (step15 > 0 && _counter <= limit15) || (step15 < 0 && _counter >= limit15); _counter = ((int)(0 + _counter + step15)) ) {
RDebugUtils.currentLine=3538962;
 //BA.debugLineNum = 3538962;BA.debugLine="BirdPhotoFile = SpeciesCursor.GetInt(\"PhotoDir\"";
_birdphotofile = _speciescursor.GetInt("PhotoDir");
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="SightingPicture.Initialize(Main.BirdPhotoPath,B";
_sightingpicture.Initialize(mostCurrent._main._birdphotopath,BA.NumberToString(_birdphotofile)+".jpg");
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="SightingPhotoList.Add(SightingPicture)";
_sightingphotolist.Add((Object)(_sightingpicture.getObject()));
 }
};
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="End Sub";
return "";
}
public static String  _phototab_pageselected(int _position) throws Exception{
RDebugUtils.currentModule="sightingphotos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "phototab_pageselected"))
	return (String) Debug.delegate(mostCurrent.activityBA, "phototab_pageselected", new Object[] {_position});
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub Phototab_PageSelected (Position As Int)";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Log(Position)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_position));
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Log(\"Code Run\")";
anywheresoftware.b4a.keywords.Common.Log("Code Run");
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="If Position = 0 Then";
if (_position==0) { 
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="SightingPhoto.bitmap = LoadBirdPic(SightID)";
mostCurrent._sightingphoto.setBitmap((android.graphics.Bitmap)(_loadbirdpic(_sightid)));
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="RemoveBtn.Visible = False";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="Position = Position - 1";
_position = (int) (_position-1);
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="RemoveBtn.Visible = True";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="SightingPhoto.bitmap =  SightingPhotoList.Get(Po";
mostCurrent._sightingphoto.setBitmap((android.graphics.Bitmap)(_sightingphotolist.Get(_position)));
RDebugUtils.currentLine=3801109;
 //BA.debugLineNum = 3801109;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="sightingphotos";
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="sightingphotos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="End Sub";
return "";
}
public static Object  _loadbirdpic(int _sightingid) throws Exception{
RDebugUtils.currentModule="sightingphotos";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadbirdpic"))
	return (Object) Debug.delegate(mostCurrent.activityBA, "loadbirdpic", new Object[] {_sightingid});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sqlquery = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub LoadBirdPic(SightingID As Int) As Object";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Log(SightingID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_sightingid));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Dim SQLQuery As StringBuilder";
_sqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="SQLQuery.Initialize";
_sqlquery.Initialize();
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="ToastMessageShow(SightingID,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.NumberToString(_sightingid),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="SQLQuery.Append(\"SELECT ImagePath\").Append(CRLF)";
_sqlquery.Append("SELECT ImagePath").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="SQLQuery.append(\"FROM Species\").Append(CRLF)";
_sqlquery.Append("FROM Species").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
_sqlquery.Append("LEFT JOIN Sightings ON Sightings.SpeciesID = Species.ID").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
_sqlquery.Append("WHERE Sightings.ID = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery2(BA.ObjectToString(_sqlquery),new String[]{BA.NumberToString(_sightingid)})));
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,BA.NumberToString(_speciescursor.GetLong("ImagePath"))+".jpg",(int) (620),(int) (480));
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="Return(NewBird)";
if (true) return (Object)((_newbird).getObject());
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="End Sub";
return null;
}
}