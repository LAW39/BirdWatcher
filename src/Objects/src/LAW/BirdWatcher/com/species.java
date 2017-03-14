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

public class species extends Activity implements B4AActivity{
	public static species mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.species");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (species).");
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
		activityBA = new BA(this, layout, processBA, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.species");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "LAW.BirdWatcher.com.species", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (species) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (species) Resume **");
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
		return species.class;
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
        BA.LogInfo("** Activity (species) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (species) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _speciesname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _specieshabitat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _speciescolour = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addbtn = null;
public anywheresoftware.b4a.objects.ListViewWrapper _specieslistview = null;
public static int _id = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _removebtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addphotobtn = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _birdphotoview = null;
public static int _selectedindex = 0;
public static long _imagetime = 0L;
public LAW.BirdWatcher.com.main _main = null;
public LAW.BirdWatcher.com.starter _starter = null;
public LAW.BirdWatcher.com.sightings _sightings = null;
public LAW.BirdWatcher.com.map _map = null;
public LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Activity.LoadLayout(\"speciesadd\")";
mostCurrent._activity.LoadLayout("speciesadd",mostCurrent.activityBA);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Activity.Title = \"Species\"";
mostCurrent._activity.setTitle((Object)("Species"));
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="SpeciesListView.Color = 0";
mostCurrent._specieslistview.setColor((int) (0));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="PopulateList ' Subroutine to populate list from D";
_populatelist();
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="End Sub";
return "";
}
public static String  _populatelist() throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "populatelist"))
	return (String) Debug.delegate(mostCurrent.activityBA, "populatelist", null);
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub PopulateList";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="SpeciesListView.clear 'Clears list";
mostCurrent._specieslistview.Clear();
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="SpeciesListView.AddSingleLine2(\"<Add Species>\", 0";
mostCurrent._specieslistview.AddSingleLine2("<Add Species>",(Object)(0));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1 ' Loop to pop";
{
final int step5 = 1;
final int limit5 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="SpeciesListView.AddSingleLine2(SpeciesCursor.Get";
mostCurrent._specieslistview.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="species";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="PopulateList";
_populatelist();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addbtn_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "addbtn_click", null);
anywheresoftware.b4a.keywords.StringBuilderWrapper _speciessql = null;
String[] _insertdata = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub AddBtn_Click";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim SpeciesSQL As StringBuilder";
_speciessql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim InsertData(5) As String";
_insertdata = new String[(int) (5)];
java.util.Arrays.fill(_insertdata,"");
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="SpeciesSQL.Initialize";
_speciessql.Initialize();
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="InsertData(0) = SpeciesName.Text";
_insertdata[(int) (0)] = mostCurrent._speciesname.getText();
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="InsertData(1) = SpeciesHabitat.Text";
_insertdata[(int) (1)] = mostCurrent._specieshabitat.getText();
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="InsertData(2) = SpeciesColour.Text";
_insertdata[(int) (2)] = mostCurrent._speciescolour.getText();
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="InsertData(4) = ImageTime";
_insertdata[(int) (4)] = BA.NumberToString(_imagetime);
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = -1 Th";
if ((mostCurrent._specieslistview.GetItem(_selectedindex)).equals((Object)(-1))) { 
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = 0 The";
if ((mostCurrent._specieslistview.GetItem(_selectedindex)).equals((Object)(0))) { 
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="SpeciesSQL.Append(\"INSERT INTO Species (Name,Hab";
_speciessql.Append("INSERT INTO Species (Name,Habitat,Colour,Appearance,ImagePath) VALUES (?, ?, ?, ?,?)");
 }else {
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="SpeciesSQL.Append(\"UPDATE Species\").Append(CRLF)";
_speciessql.Append("UPDATE Species").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="SpeciesSQL.Append(\"SET Name = ?, Habitat = ?, Co";
_speciessql.Append("SET Name = ?, Habitat = ?, Colour = ?, Appearance = ?, ImagePath = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="SpeciesSQL.Append(\"WHERE ID =\" & (ID + 1)).Appen";
_speciessql.Append("WHERE ID ="+BA.NumberToString((_id+1))).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="Starter.database.ExecNonQuery2(SpeciesSQL, Insert";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_speciessql),anywheresoftware.b4a.keywords.Common.ArrayToList(_insertdata));
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="PopulateList";
_populatelist();
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="End Sub";
return "";
}
public static String  _addphotobtn_click() throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addphotobtn_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "addphotobtn_click", null);
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub AddPhotoBtn_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Starter.CC.Show(\"image/*\",\"Choose image\")";
mostCurrent._starter._cc.Show(processBA,"image/*","Choose image");
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cc_result"))
	return (String) Debug.delegate(mostCurrent.activityBA, "cc_result", new Object[] {_success,_dir,_filename});
String _contentpathfile = "";
int _filenameindex = 0;
String _imgfilename = "";
String _imgfolderpath = "";
adr.stringfunctions.stringfunctions _sf = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="If (Success) Then";
if ((_success)) { 
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Msgbox(\"Dir: \" & Dir & \" File: \" & FileName, \"Se";
anywheresoftware.b4a.keywords.Common.Msgbox("Dir: "+_dir+" File: "+_filename,"Selected File - DEFAULT",mostCurrent.activityBA);
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="Dim ContentPathFile As String";
_contentpathfile = "";
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="Dim FileNameIndex As Int";
_filenameindex = 0;
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="Dim ImgFileName As String";
_imgfilename = "";
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="Dim ImgFolderPath As String";
_imgfolderpath = "";
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="Dim sf As StringFunctions";
_sf = new adr.stringfunctions.stringfunctions();
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="sf.Initialize";
_sf._initialize(processBA);
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="ContentPathFile = CodeFunctions.GetPathFromConte";
_contentpathfile = mostCurrent._codefunctions._getpathfromcontentresult(mostCurrent.activityBA,_filename);
RDebugUtils.currentLine=1638415;
 //BA.debugLineNum = 1638415;BA.debugLine="ImageTime = DateTime.now";
_imagetime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="If ContentPathFile = Null Then";
if (_contentpathfile== null) { 
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="Msgbox( \"Please select photo from the photos ap";
anywheresoftware.b4a.keywords.Common.Msgbox("Please select photo from the photos app by selecting from drawer on left","Error",mostCurrent.activityBA);
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="AddPhotoBtn_Click";
_addphotobtn_click();
RDebugUtils.currentLine=1638419;
 //BA.debugLineNum = 1638419;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1638422;
 //BA.debugLineNum = 1638422;BA.debugLine="FileNameIndex = ContentPathFile.LastIndexOf(\"/\")";
_filenameindex = _contentpathfile.lastIndexOf("/");
RDebugUtils.currentLine=1638423;
 //BA.debugLineNum = 1638423;BA.debugLine="ImgFileName = ContentPathFile.SubString(FileName";
_imgfilename = _contentpathfile.substring((int) (_filenameindex+1));
RDebugUtils.currentLine=1638424;
 //BA.debugLineNum = 1638424;BA.debugLine="ImgFolderPath = ContentPathFile.SubString2(1,Fil";
_imgfolderpath = _contentpathfile.substring((int) (1),_filenameindex);
RDebugUtils.currentLine=1638426;
 //BA.debugLineNum = 1638426;BA.debugLine="File.Copy(ImgFolderPath,ImgFileName,Main.BirdPho";
anywheresoftware.b4a.keywords.Common.File.Copy(_imgfolderpath,_imgfilename,mostCurrent._main._birdphotopath,BA.NumberToString(_imagetime)+".jpg");
RDebugUtils.currentLine=1638428;
 //BA.debugLineNum = 1638428;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1638429;
 //BA.debugLineNum = 1638429;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Imag";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,BA.NumberToString(_imagetime)+".jpg",(int) (240),(int) (240));
RDebugUtils.currentLine=1638430;
 //BA.debugLineNum = 1638430;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
mostCurrent._birdphotoview.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
 };
RDebugUtils.currentLine=1638434;
 //BA.debugLineNum = 1638434;BA.debugLine="End Sub";
return "";
}
public static String  _loadbirdpick(int _birdid) throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadbirdpick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loadbirdpick", new Object[] {_birdid});
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub LoadBirdPick(BirdID As Int)";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Log(BirdID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_birdid));
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="ToastMessageShow(BirdID,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.NumberToString(_birdid),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID,ImagePath FROM Species WHERE ID = "+BA.NumberToString(_birdid))));
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="Log(Main.BirdPhotoPath & SpeciesCursor.GetLong(\"";
anywheresoftware.b4a.keywords.Common.Log(mostCurrent._main._birdphotopath+BA.NumberToString(_speciescursor.GetLong("ImagePath")));
 } 
       catch (Exception e10) {
			processBA.setLastException(e10);RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="Log(\"Add new Species\")";
anywheresoftware.b4a.keywords.Common.Log("Add new Species");
 };
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,BA.NumberToString(_speciescursor.GetLong("ImagePath"))+".jpg",(int) (240),(int) (240));
 } 
       catch (Exception e15) {
			processBA.setLastException(e15);RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,\"0.j";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,"0.jpg",(int) (240),(int) (240));
RDebugUtils.currentLine=1703953;
 //BA.debugLineNum = 1703953;BA.debugLine="Log(\"Image not Found \" & BirdID)";
anywheresoftware.b4a.keywords.Common.Log("Image not Found "+BA.NumberToString(_birdid));
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="ToastMessageShow(\"Image not found\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Image not found",anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1703957;
 //BA.debugLineNum = 1703957;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
mostCurrent._birdphotoview.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
RDebugUtils.currentLine=1703958;
 //BA.debugLineNum = 1703958;BA.debugLine="End Sub";
return "";
}
public static String  _removebtn_click() throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "removebtn_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "removebtn_click", null);
anywheresoftware.b4a.keywords.StringBuilderWrapper _deletesqlquery = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub RemoveBtn_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim DeleteSQLQuery As StringBuilder";
_deletesqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="DeleteSQLQuery.Initialize";
_deletesqlquery.Initialize();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="If ID = 0 Then";
if (_id==0) { 
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="DeleteSQLQuery.Append(\"DELETE FROM Species\").Appe";
_deletesqlquery.Append("DELETE FROM Species").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="DeleteSQLQuery.Append(\"WHERE [ID] = ?\").Append(CR";
_deletesqlquery.Append("WHERE [ID] = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Try";
try {RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELE";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ImagePath FROM Species WHERE ID = "+BA.NumberToString(_id))));
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="File.Delete(Main.BirdPhotoPath, SpeciesCursor.Ge";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._main._birdphotopath,BA.NumberToString(_speciescursor.GetLong("ImagePath"))+".jpg");
 } 
       catch (Exception e14) {
			processBA.setLastException(e14);RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="Starter.database.ExecNonQuery2(DeleteSQLQuery,Arr";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_deletesqlquery),anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(_id)}));
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="StartActivity(\"Species\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Species"));
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="End Sub";
return "";
}
public static String  _specieslistview_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="species";
if (Debug.shouldDelegate(mostCurrent.activityBA, "specieslistview_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "specieslistview_itemclick", new Object[] {_position,_value});
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub SpeciesListView_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="ID = Value";
_id = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="SelectedIndex = Position";
_selectedindex = _position;
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="If Value <> 0 Then";
if ((_value).equals((Object)(0)) == false) { 
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="AddBtn.Text = \"Save\"";
mostCurrent._addbtn.setText((Object)("Save"));
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="AddBtn.Width = 200dip";
mostCurrent._addbtn.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="RemoveBtn.Visible = True";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="AddBtn.Text = \"Add\"";
mostCurrent._addbtn.setText((Object)("Add"));
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="AddBtn.Width = 430dip";
mostCurrent._addbtn.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (430)));
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="RemoveBtn.Visible = False";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="AddBtn.Visible = True";
mostCurrent._addbtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441809;
 //BA.debugLineNum = 1441809;BA.debugLine="If Position <> 0 Then";
if (_position!=0) { 
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1441811;
 //BA.debugLineNum = 1441811;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
_cursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT * FROM Species WHERE ID = "+BA.NumberToString(_id))));
RDebugUtils.currentLine=1441812;
 //BA.debugLineNum = 1441812;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=1441813;
 //BA.debugLineNum = 1441813;BA.debugLine="SpeciesName.Text = Cursor.GetString(\"Name\")";
mostCurrent._speciesname.setText((Object)(_cursor.GetString("Name")));
RDebugUtils.currentLine=1441814;
 //BA.debugLineNum = 1441814;BA.debugLine="SpeciesHabitat.Text = Cursor.GetString(\"Habitat\"";
mostCurrent._specieshabitat.setText((Object)(_cursor.GetString("Habitat")));
RDebugUtils.currentLine=1441815;
 //BA.debugLineNum = 1441815;BA.debugLine="SpeciesColour.Text = Cursor.GetString(\"Colour\")";
mostCurrent._speciescolour.setText((Object)(_cursor.GetString("Colour")));
RDebugUtils.currentLine=1441817;
 //BA.debugLineNum = 1441817;BA.debugLine="LoadBirdPick(ID)";
_loadbirdpick(_id);
 }else {
RDebugUtils.currentLine=1441819;
 //BA.debugLineNum = 1441819;BA.debugLine="SpeciesName.Text = \"\"";
mostCurrent._speciesname.setText((Object)(""));
RDebugUtils.currentLine=1441820;
 //BA.debugLineNum = 1441820;BA.debugLine="SpeciesHabitat.Text = \"\"";
mostCurrent._specieshabitat.setText((Object)(""));
RDebugUtils.currentLine=1441821;
 //BA.debugLineNum = 1441821;BA.debugLine="SpeciesColour.Text = \"\"";
mostCurrent._speciescolour.setText((Object)(""));
RDebugUtils.currentLine=1441823;
 //BA.debugLineNum = 1441823;BA.debugLine="LoadBirdPick(ID)";
_loadbirdpick(_id);
 };
RDebugUtils.currentLine=1441827;
 //BA.debugLineNum = 1441827;BA.debugLine="End Sub";
return "";
}
}