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
			processBA = new BA(this.getApplicationContext(), null, null, "LAW.BirdWatcher.com", "LAW.BirdWatcher.com.species");
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

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"speciesadd\")";
mostCurrent._activity.LoadLayout("speciesadd",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Activity.Title = \"Species\"";
mostCurrent._activity.setTitle((Object)("Species"));
 //BA.debugLineNum = 37;BA.debugLine="PopulateList ' Subroutine to populate list from D";
_populatelist();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 56;BA.debugLine="PopulateList";
_populatelist();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _addbtn_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _speciessql = null;
String[] _insertdata = null;
 //BA.debugLineNum = 65;BA.debugLine="Sub AddBtn_Click";
 //BA.debugLineNum = 67;BA.debugLine="Dim SpeciesSQL As StringBuilder";
_speciessql = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Dim InsertData(5) As String";
_insertdata = new String[(int) (5)];
java.util.Arrays.fill(_insertdata,"");
 //BA.debugLineNum = 70;BA.debugLine="SpeciesSQL.Initialize";
_speciessql.Initialize();
 //BA.debugLineNum = 71;BA.debugLine="InsertData(0) = SpeciesName.Text";
_insertdata[(int) (0)] = mostCurrent._speciesname.getText();
 //BA.debugLineNum = 72;BA.debugLine="InsertData(1) = SpeciesHabitat.Text";
_insertdata[(int) (1)] = mostCurrent._specieshabitat.getText();
 //BA.debugLineNum = 73;BA.debugLine="InsertData(2) = SpeciesColour.Text";
_insertdata[(int) (2)] = mostCurrent._speciescolour.getText();
 //BA.debugLineNum = 75;BA.debugLine="InsertData(4) = ImageTime";
_insertdata[(int) (4)] = BA.NumberToString(_imagetime);
 //BA.debugLineNum = 76;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = -1 Th";
if ((mostCurrent._specieslistview.GetItem(_selectedindex)).equals((Object)(-1))) { 
 //BA.debugLineNum = 77;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 80;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = 0 The";
if ((mostCurrent._specieslistview.GetItem(_selectedindex)).equals((Object)(0))) { 
 //BA.debugLineNum = 81;BA.debugLine="SpeciesSQL.Append(\"INSERT INTO Species (Name,Hab";
_speciessql.Append("INSERT INTO Species (Name,Habitat,Colour,Appearance,ImagePath) VALUES (?, ?, ?, ?,?)");
 }else {
 //BA.debugLineNum = 83;BA.debugLine="SpeciesSQL.Append(\"UPDATE Species\").Append(CRLF)";
_speciessql.Append("UPDATE Species").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 84;BA.debugLine="SpeciesSQL.Append(\"SET Name = ?, Habitat = ?, Co";
_speciessql.Append("SET Name = ?, Habitat = ?, Colour = ?, Appearance = ?, ImagePath = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 85;BA.debugLine="SpeciesSQL.Append(\"WHERE ID =\" & (ID + 1)).Appen";
_speciessql.Append("WHERE ID ="+BA.NumberToString((_id+1))).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 };
 //BA.debugLineNum = 88;BA.debugLine="Starter.database.ExecNonQuery2(SpeciesSQL, Insert";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_speciessql),anywheresoftware.b4a.keywords.Common.ArrayToList(_insertdata));
 //BA.debugLineNum = 89;BA.debugLine="PopulateList";
_populatelist();
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _addphotobtn_click() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Sub AddPhotoBtn_Click";
 //BA.debugLineNum = 152;BA.debugLine="Starter.CC.Show(\"image/*\",\"Choose image\")";
mostCurrent._starter._cc.Show(processBA,"image/*","Choose image");
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
String _contentpathfile = "";
int _filenameindex = 0;
String _imgfilename = "";
String _imgfolderpath = "";
adr.stringfunctions.stringfunctions _sf = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
 //BA.debugLineNum = 155;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
 //BA.debugLineNum = 157;BA.debugLine="If (Success) Then";
if ((_success)) { 
 //BA.debugLineNum = 159;BA.debugLine="Msgbox(\"Dir: \" & Dir & \" File: \" & FileName, \"Se";
anywheresoftware.b4a.keywords.Common.Msgbox("Dir: "+_dir+" File: "+_filename,"Selected File - DEFAULT",mostCurrent.activityBA);
 //BA.debugLineNum = 161;BA.debugLine="Dim ContentPathFile As String";
_contentpathfile = "";
 //BA.debugLineNum = 162;BA.debugLine="Dim FileNameIndex As Int";
_filenameindex = 0;
 //BA.debugLineNum = 163;BA.debugLine="Dim ImgFileName As String";
_imgfilename = "";
 //BA.debugLineNum = 165;BA.debugLine="Dim ImgFolderPath As String";
_imgfolderpath = "";
 //BA.debugLineNum = 166;BA.debugLine="Dim sf As StringFunctions";
_sf = new adr.stringfunctions.stringfunctions();
 //BA.debugLineNum = 167;BA.debugLine="sf.Initialize";
_sf._initialize(processBA);
 //BA.debugLineNum = 169;BA.debugLine="ContentPathFile = CodeFunctions.GetPathFromConte";
_contentpathfile = mostCurrent._codefunctions._getpathfromcontentresult(mostCurrent.activityBA,_filename);
 //BA.debugLineNum = 170;BA.debugLine="ImageTime = DateTime.now";
_imagetime = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 171;BA.debugLine="If ContentPathFile = Null Then";
if (_contentpathfile== null) { 
 //BA.debugLineNum = 172;BA.debugLine="Msgbox( \"Please select photo from the photos ap";
anywheresoftware.b4a.keywords.Common.Msgbox("Please select photo from the photos app by selecting from drawer on left","Error",mostCurrent.activityBA);
 //BA.debugLineNum = 173;BA.debugLine="AddPhotoBtn_Click";
_addphotobtn_click();
 //BA.debugLineNum = 174;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 177;BA.debugLine="FileNameIndex = ContentPathFile.LastIndexOf(\"/\")";
_filenameindex = _contentpathfile.lastIndexOf("/");
 //BA.debugLineNum = 178;BA.debugLine="ImgFileName = ContentPathFile.SubString(FileName";
_imgfilename = _contentpathfile.substring((int) (_filenameindex+1));
 //BA.debugLineNum = 179;BA.debugLine="ImgFolderPath = ContentPathFile.SubString2(1,Fil";
_imgfolderpath = _contentpathfile.substring((int) (1),_filenameindex);
 //BA.debugLineNum = 181;BA.debugLine="File.Copy(ImgFolderPath,ImgFileName,Main.BirdPho";
anywheresoftware.b4a.keywords.Common.File.Copy(_imgfolderpath,_imgfilename,mostCurrent._main._birdphotopath,BA.NumberToString(_imagetime)+".jpg");
 //BA.debugLineNum = 183;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 184;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Imag";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,BA.NumberToString(_imagetime)+".jpg",(int) (240),(int) (240));
 //BA.debugLineNum = 185;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
mostCurrent._birdphotoview.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
 };
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private SpeciesName As EditText			'<Defining elem";
mostCurrent._speciesname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private SpeciesHabitat As EditText";
mostCurrent._specieshabitat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private SpeciesColour As EditText";
mostCurrent._speciescolour = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private AddBtn As Button";
mostCurrent._addbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private SpeciesListView As ListView";
mostCurrent._specieslistview = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private ID As Int = 0";
_id = (int) (0);
 //BA.debugLineNum = 22;BA.debugLine="Private RemoveBtn As Button";
mostCurrent._removebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private AddPhotoBtn As Button";
mostCurrent._addphotobtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private BirdPhotoView As ImageView 		'</Defining";
mostCurrent._birdphotoview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private SelectedIndex As Int = -1";
_selectedindex = (int) (-1);
 //BA.debugLineNum = 28;BA.debugLine="Dim ImageTime As Long";
_imagetime = 0L;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _loadbirdpick(int _birdid) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _newbird = null;
 //BA.debugLineNum = 191;BA.debugLine="Sub LoadBirdPick(BirdID As Int)";
 //BA.debugLineNum = 193;BA.debugLine="Log(BirdID)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_birdid));
 //BA.debugLineNum = 194;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 195;BA.debugLine="Dim NewBird As Bitmap";
_newbird = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 196;BA.debugLine="ToastMessageShow(BirdID,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.NumberToString(_birdid),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 197;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID,ImagePath FROM Species WHERE ID = "+BA.NumberToString(_birdid))));
 //BA.debugLineNum = 198;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
 //BA.debugLineNum = 199;BA.debugLine="Try";
try { //BA.debugLineNum = 200;BA.debugLine="Log(Main.BirdPhotoPath & SpeciesCursor.GetLong(\"";
anywheresoftware.b4a.keywords.Common.Log(mostCurrent._main._birdphotopath+BA.NumberToString(_speciescursor.GetLong("ImagePath")));
 } 
       catch (Exception e10) {
			processBA.setLastException(e10); //BA.debugLineNum = 202;BA.debugLine="Log(\"Add new Species\")";
anywheresoftware.b4a.keywords.Common.Log("Add new Species");
 };
 //BA.debugLineNum = 204;BA.debugLine="Try";
try { //BA.debugLineNum = 205;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,BA.NumberToString(_speciescursor.GetLong("ImagePath"))+".jpg",(int) (240),(int) (240));
 } 
       catch (Exception e15) {
			processBA.setLastException(e15); //BA.debugLineNum = 207;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,\"0.j";
_newbird.InitializeSample(mostCurrent._main._birdphotopath,"0.jpg",(int) (240),(int) (240));
 //BA.debugLineNum = 208;BA.debugLine="Log(\"Image not Found \" & BirdID)";
anywheresoftware.b4a.keywords.Common.Log("Image not Found "+BA.NumberToString(_birdid));
 //BA.debugLineNum = 209;BA.debugLine="ToastMessageShow(\"Image not found\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Image not found",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 212;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
mostCurrent._birdphotoview.setBitmap((android.graphics.Bitmap)(_newbird.getObject()));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static String  _populatelist() throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
int _i = 0;
 //BA.debugLineNum = 40;BA.debugLine="Sub PopulateList";
 //BA.debugLineNum = 41;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 42;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ID, Name FROM Species ORDER BY Name ASC")));
 //BA.debugLineNum = 43;BA.debugLine="SpeciesListView.clear 'Clears list";
mostCurrent._specieslistview.Clear();
 //BA.debugLineNum = 45;BA.debugLine="SpeciesListView.AddSingleLine2(\"<Add Species>\", 0";
mostCurrent._specieslistview.AddSingleLine2("<Add Species>",(Object)(0));
 //BA.debugLineNum = 47;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1 ' Loop to pop";
{
final int step5 = 1;
final int limit5 = (int) (_speciescursor.getRowCount()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
 //BA.debugLineNum = 49;BA.debugLine="SpeciesCursor.Position = i";
_speciescursor.setPosition(_i);
 //BA.debugLineNum = 50;BA.debugLine="SpeciesListView.AddSingleLine2(SpeciesCursor.Get";
mostCurrent._specieslistview.AddSingleLine2(_speciescursor.GetString("Name"),(Object)(_speciescursor.GetString("ID")));
 }
};
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _removebtn_click() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _deletesqlquery = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _speciescursor = null;
 //BA.debugLineNum = 129;BA.debugLine="Sub RemoveBtn_Click";
 //BA.debugLineNum = 130;BA.debugLine="Dim DeleteSQLQuery As StringBuilder";
_deletesqlquery = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 131;BA.debugLine="DeleteSQLQuery.Initialize";
_deletesqlquery.Initialize();
 //BA.debugLineNum = 132;BA.debugLine="Dim SpeciesCursor As Cursor";
_speciescursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 134;BA.debugLine="If ID = 0 Then";
if (_id==0) { 
 //BA.debugLineNum = 135;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 138;BA.debugLine="DeleteSQLQuery.Append(\"DELETE FROM Species\").Appe";
_deletesqlquery.Append("DELETE FROM Species").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 139;BA.debugLine="DeleteSQLQuery.Append(\"WHERE [ID] = ?\").Append(CR";
_deletesqlquery.Append("WHERE [ID] = ?").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 140;BA.debugLine="Try";
try { //BA.debugLineNum = 141;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELE";
_speciescursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT ImagePath FROM Species WHERE ID = "+BA.NumberToString(_id))));
 //BA.debugLineNum = 142;BA.debugLine="SpeciesCursor.Position = 0";
_speciescursor.setPosition((int) (0));
 //BA.debugLineNum = 143;BA.debugLine="File.Delete(Main.BirdPhotoPath, SpeciesCursor.Ge";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._main._birdphotopath,BA.NumberToString(_speciescursor.GetLong("ImagePath"))+".jpg");
 } 
       catch (Exception e14) {
			processBA.setLastException(e14); //BA.debugLineNum = 145;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 147;BA.debugLine="Starter.database.ExecNonQuery2(DeleteSQLQuery,Arr";
mostCurrent._starter._database.ExecNonQuery2(BA.ObjectToString(_deletesqlquery),anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{BA.NumberToString(_id)}));
 //BA.debugLineNum = 148;BA.debugLine="StartActivity(\"Species\")";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Species"));
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _specieslistview_itemclick(int _position,Object _value) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
 //BA.debugLineNum = 92;BA.debugLine="Sub SpeciesListView_ItemClick (Position As Int, Va";
 //BA.debugLineNum = 93;BA.debugLine="ID = Value";
_id = (int)(BA.ObjectToNumber(_value));
 //BA.debugLineNum = 94;BA.debugLine="If Position = -1 Then";
if (_position==-1) { 
 //BA.debugLineNum = 95;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 97;BA.debugLine="SelectedIndex = Position";
_selectedindex = _position;
 //BA.debugLineNum = 98;BA.debugLine="If Value <> 0 Then";
if ((_value).equals((Object)(0)) == false) { 
 //BA.debugLineNum = 99;BA.debugLine="AddBtn.Text = \"Save\"";
mostCurrent._addbtn.setText((Object)("Save"));
 //BA.debugLineNum = 100;BA.debugLine="AddBtn.Width = 200dip";
mostCurrent._addbtn.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
 //BA.debugLineNum = 101;BA.debugLine="RemoveBtn.Visible = True";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 103;BA.debugLine="AddBtn.Text = \"Add\"";
mostCurrent._addbtn.setText((Object)("Add"));
 //BA.debugLineNum = 104;BA.debugLine="AddBtn.Width = 430dip";
mostCurrent._addbtn.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (430)));
 //BA.debugLineNum = 105;BA.debugLine="RemoveBtn.Visible = False";
mostCurrent._removebtn.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 107;BA.debugLine="AddBtn.Visible = True";
mostCurrent._addbtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 109;BA.debugLine="If Position <> 0 Then";
if (_position!=0) { 
 //BA.debugLineNum = 110;BA.debugLine="Dim Cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
_cursor.setObject((android.database.Cursor)(mostCurrent._starter._database.ExecQuery("SELECT * FROM Species WHERE ID = "+BA.NumberToString(_id))));
 //BA.debugLineNum = 112;BA.debugLine="Cursor.Position = 0";
_cursor.setPosition((int) (0));
 //BA.debugLineNum = 113;BA.debugLine="SpeciesName.Text = Cursor.GetString(\"Name\")";
mostCurrent._speciesname.setText((Object)(_cursor.GetString("Name")));
 //BA.debugLineNum = 114;BA.debugLine="SpeciesHabitat.Text = Cursor.GetString(\"Habitat\"";
mostCurrent._specieshabitat.setText((Object)(_cursor.GetString("Habitat")));
 //BA.debugLineNum = 115;BA.debugLine="SpeciesColour.Text = Cursor.GetString(\"Colour\")";
mostCurrent._speciescolour.setText((Object)(_cursor.GetString("Colour")));
 //BA.debugLineNum = 117;BA.debugLine="LoadBirdPick(ID)";
_loadbirdpick(_id);
 }else {
 //BA.debugLineNum = 119;BA.debugLine="SpeciesName.Text = \"\"";
mostCurrent._speciesname.setText((Object)(""));
 //BA.debugLineNum = 120;BA.debugLine="SpeciesHabitat.Text = \"\"";
mostCurrent._specieshabitat.setText((Object)(""));
 //BA.debugLineNum = 121;BA.debugLine="SpeciesColour.Text = \"\"";
mostCurrent._speciescolour.setText((Object)(""));
 //BA.debugLineNum = 123;BA.debugLine="LoadBirdPick(ID)";
_loadbirdpick(_id);
 };
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
}
