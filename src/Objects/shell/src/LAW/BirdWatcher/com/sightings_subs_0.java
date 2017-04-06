package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sightings_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) return sightings.remoteMe.runUserSub(false, "sightings","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Log(Starter.GPS1)";
Debug.ShouldStop(4);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._gps1)));
 BA.debugLineNum = 36;BA.debugLine="Log(Starter.L1)";
Debug.ShouldStop(8);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._l1)));
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"sightingadd\")";
Debug.ShouldStop(64);
sightings.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sightingadd")),sightings.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="Activity.Title = \"Sightings\"";
Debug.ShouldStop(128);
sightings.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Sightings")));
 BA.debugLineNum = 41;BA.debugLine="SpeciesList.SingleLineLayout.Label.TextColor = Co";
Debug.ShouldStop(256);
sightings.mostCurrent._specieslist.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",sightings.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 42;BA.debugLine="SightingList.SingleLineLayout.Label.TextColor = C";
Debug.ShouldStop(512);
sightings.mostCurrent._sightinglist.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",sightings.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 43;BA.debugLine="DateTime.Dateformat = \"dd/MM/yyyy\"";
Debug.ShouldStop(1024);
sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 44;BA.debugLine="DateTime.TimeFormat= \"HH:mm\"";
Debug.ShouldStop(2048);
sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 45;BA.debugLine="Populate_List";
Debug.ShouldStop(4096);
_populate_list();
 BA.debugLineNum = 46;BA.debugLine="Location.Initialize";
Debug.ShouldStop(8192);
sightings.mostCurrent._location.runVoidMethod ("Initialize");
 BA.debugLineNum = 47;BA.debugLine="Map.SelectedBird=False";
Debug.ShouldStop(16384);
sightings.mostCurrent._map._selectedbird = sightings.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Pause (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,88);
if (RapidSub.canDelegate("activity_pause")) return sightings.remoteMe.runUserSub(false, "sightings","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 88;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Resume (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,50);
if (RapidSub.canDelegate("activity_resume")) return sightings.remoteMe.runUserSub(false, "sightings","activity_resume");
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 54;BA.debugLine="If Starter.GPS1.GPSEnabled = False Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"Please enable the GPS device.\",";
Debug.ShouldStop(4194304);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please enable the GPS device.")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 56;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsIntent";
Debug.ShouldStop(8388608);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 };
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_photo_db(RemoteObject _imagetime) throws Exception{
try {
		Debug.PushSubsStack("Add_Photo_DB (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,350);
if (RapidSub.canDelegate("add_photo_db")) return sightings.remoteMe.runUserSub(false, "sightings","add_photo_db", _imagetime);
RemoteObject _speciessql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
Debug.locals.put("ImageTime", _imagetime);
 BA.debugLineNum = 350;BA.debugLine="Sub Add_Photo_DB(ImageTime As Long) As Int";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 352;BA.debugLine="Dim SpeciesSQL As StringBuilder";
Debug.ShouldStop(-2147483648);
_speciessql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SpeciesSQL", _speciessql);
 BA.debugLineNum = 354;BA.debugLine="SpeciesSQL.Initialize";
Debug.ShouldStop(2);
_speciessql.runVoidMethod ("Initialize");
 BA.debugLineNum = 355;BA.debugLine="SpeciesSQL.Append(\"INSERT INTO SightingPhoto (Sig";
Debug.ShouldStop(4);
_speciessql.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("INSERT INTO SightingPhoto (SightingID,PhotoDir) VALUES (?, ?)")));
 BA.debugLineNum = 357;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 358;BA.debugLine="Starter.database.ExecNonQuery2(SpeciesSQL,Array";
Debug.ShouldStop(32);
sightings.mostCurrent._starter._database.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString(_speciessql)),(Object)(sightings.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.NumberToString(sightings._selectedsightingid),BA.NumberToString(_imagetime)})))));
 BA.debugLineNum = 359;BA.debugLine="Return(0)";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return BA.numberCast(int.class, (0));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",sightings.processBA, e8.toString()); BA.debugLineNum = 361;BA.debugLine="Return(1)";
Debug.ShouldStop(256);
if (true) return BA.numberCast(int.class, (1));
 };
 BA.debugLineNum = 363;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addnow_click() throws Exception{
try {
		Debug.PushSubsStack("AddNow_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,93);
if (RapidSub.canDelegate("addnow_click")) return sightings.remoteMe.runUserSub(false, "sightings","addnow_click");
RemoteObject _date_time = null;
 BA.debugLineNum = 93;BA.debugLine="Sub AddNow_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 95;BA.debugLine="If MapCheck.Checked = False Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._mapcheck.runMethod(true,"getChecked"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 96;BA.debugLine="Location.Latitude = Starter.L1.Latitude";
Debug.ShouldStop(-2147483648);
sightings.mostCurrent._location.runMethod(true,"setLatitude",sightings.mostCurrent._starter._l1.runMethod(true,"getLatitude"));
 BA.debugLineNum = 97;BA.debugLine="Location.Longitude = Starter.L1.longitude";
Debug.ShouldStop(1);
sightings.mostCurrent._location.runMethod(true,"setLongitude",sightings.mostCurrent._starter._l1.runMethod(true,"getLongitude"));
 }else {
 BA.debugLineNum = 99;BA.debugLine="Map.GetLocationFlag = True";
Debug.ShouldStop(4);
sightings.mostCurrent._map._getlocationflag = sightings.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 100;BA.debugLine="Location.Latitude = Map.Location.Latitude";
Debug.ShouldStop(8);
sightings.mostCurrent._location.runMethod(true,"setLatitude",sightings.mostCurrent._map._location.runMethod(true,"getLatitude"));
 BA.debugLineNum = 101;BA.debugLine="Location.Longitude = Map.Location.Longitude";
Debug.ShouldStop(16);
sightings.mostCurrent._location.runMethod(true,"setLongitude",sightings.mostCurrent._map._location.runMethod(true,"getLongitude"));
 };
 BA.debugLineNum = 104;BA.debugLine="Dim Date_Time(2) As String";
Debug.ShouldStop(128);
_date_time = RemoteObject.createNewArray ("String", new int[] {2}, new Object[]{});Debug.locals.put("Date_Time", _date_time);
 BA.debugLineNum = 105;BA.debugLine="Date_Time(0) = Date.text";
Debug.ShouldStop(256);
_date_time.setArrayElement (sightings.mostCurrent._date.runMethod(true,"getText"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 106;BA.debugLine="Date_Time(1) = Time.Text";
Debug.ShouldStop(512);
_date_time.setArrayElement (sightings.mostCurrent._time.runMethod(true,"getText"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 108;BA.debugLine="If Date_Time(0) = \"\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_date_time.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 109;BA.debugLine="Date_Time(0) = DateTime.GetDayOfMonth(DateTime.N";
Debug.ShouldStop(4096);
_date_time.setArrayElement (RemoteObject.concat(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable("/"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable("/"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 112;BA.debugLine="If Date_Time(1) = \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_date_time.getArrayElement(true,BA.numberCast(int.class, 1)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 113;BA.debugLine="Date_Time(1) = DateTime.GetHour(DateTime.Now) &";
Debug.ShouldStop(65536);
_date_time.setArrayElement (RemoteObject.concat(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(":"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(":"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetSecond",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 116;BA.debugLine="Log(Starter.L1)";
Debug.ShouldStop(524288);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._l1)));
 BA.debugLineNum = 117;BA.debugLine="DateTimeTicks = DateTime.DateTimeParse(Date_Time(";
Debug.ShouldStop(1048576);
sightings._datetimeticks = sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(_date_time.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_date_time.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 118;BA.debugLine="Log(DateTimeTicks)";
Debug.ShouldStop(2097152);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightings._datetimeticks)));
 BA.debugLineNum = 120;BA.debugLine="ExportData";
Debug.ShouldStop(8388608);
_exportdata();
 BA.debugLineNum = 121;BA.debugLine="Populate_SightingList";
Debug.ShouldStop(16777216);
_populate_sightinglist();
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addphoto_click() throws Exception{
try {
		Debug.PushSubsStack("AddPhoto_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,302);
if (RapidSub.canDelegate("addphoto_click")) return sightings.remoteMe.runUserSub(false, "sightings","addphoto_click");
 BA.debugLineNum = 302;BA.debugLine="Sub AddPhoto_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="If SelectedSightingID = 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",sightings._selectedsightingid,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 304;BA.debugLine="Msgbox(\"Please select or enter a sighting first\"";
Debug.ShouldStop(32768);
sightings.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Please select or enter a sighting first")),(Object)(RemoteObject.createImmutable("Error")),sightings.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 306;BA.debugLine="Starter.CC.Show(\"image/*\",\"Choose image\")";
Debug.ShouldStop(131072);
sightings.mostCurrent._starter._cc.runVoidMethod ("Show",sightings.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 };
 BA.debugLineNum = 308;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cc_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CC_Result (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,310);
if (RapidSub.canDelegate("cc_result")) return sightings.remoteMe.runUserSub(false, "sightings","cc_result", _success, _dir, _filename);
RemoteObject _imagetime = RemoteObject.createImmutable(0L);
RemoteObject _contentpathfile = RemoteObject.createImmutable("");
RemoteObject _filenameindex = RemoteObject.createImmutable(0);
RemoteObject _imgfilename = RemoteObject.createImmutable("");
RemoteObject _imgfolderpath = RemoteObject.createImmutable("");
RemoteObject _sf = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 310;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 311;BA.debugLine="Dim ImageTime As Long";
Debug.ShouldStop(4194304);
_imagetime = RemoteObject.createImmutable(0L);Debug.locals.put("ImageTime", _imagetime);
 BA.debugLineNum = 312;BA.debugLine="If (Success) Then";
Debug.ShouldStop(8388608);
if ((_success).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 314;BA.debugLine="Msgbox(\"Dir: \" & Dir & \" File: \" & FileName, \"Se";
Debug.ShouldStop(33554432);
sightings.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dir: "),_dir,RemoteObject.createImmutable(" File: "),_filename)),(Object)(RemoteObject.createImmutable("Selected File - DEFAULT")),sightings.mostCurrent.activityBA);
 BA.debugLineNum = 316;BA.debugLine="Dim ContentPathFile As String";
Debug.ShouldStop(134217728);
_contentpathfile = RemoteObject.createImmutable("");Debug.locals.put("ContentPathFile", _contentpathfile);
 BA.debugLineNum = 317;BA.debugLine="Dim FileNameIndex As Int";
Debug.ShouldStop(268435456);
_filenameindex = RemoteObject.createImmutable(0);Debug.locals.put("FileNameIndex", _filenameindex);
 BA.debugLineNum = 318;BA.debugLine="Dim ImgFileName As String";
Debug.ShouldStop(536870912);
_imgfilename = RemoteObject.createImmutable("");Debug.locals.put("ImgFileName", _imgfilename);
 BA.debugLineNum = 320;BA.debugLine="Dim ImgFolderPath As String";
Debug.ShouldStop(-2147483648);
_imgfolderpath = RemoteObject.createImmutable("");Debug.locals.put("ImgFolderPath", _imgfolderpath);
 BA.debugLineNum = 321;BA.debugLine="Dim sf As StringFunctions";
Debug.ShouldStop(1);
_sf = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("sf", _sf);
 BA.debugLineNum = 322;BA.debugLine="sf.Initialize";
Debug.ShouldStop(2);
_sf.runVoidMethod ("_initialize",sightings.processBA);
 BA.debugLineNum = 324;BA.debugLine="ContentPathFile = CodeFunctions.GetPathFromConte";
Debug.ShouldStop(8);
_contentpathfile = sightings.mostCurrent._codefunctions.runMethod(true,"_getpathfromcontentresult",sightings.mostCurrent.activityBA,(Object)(_filename));Debug.locals.put("ContentPathFile", _contentpathfile);
 BA.debugLineNum = 325;BA.debugLine="ImageTime = DateTime.now";
Debug.ShouldStop(16);
_imagetime = sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("ImageTime", _imagetime);
 BA.debugLineNum = 326;BA.debugLine="If ContentPathFile = Null Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("n",_contentpathfile)) { 
 BA.debugLineNum = 327;BA.debugLine="Msgbox( \"Please select photo from the photos ap";
Debug.ShouldStop(64);
sightings.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Please select photo from the photos app by selecting from drawer on left")),(Object)(RemoteObject.createImmutable("Error")),sightings.mostCurrent.activityBA);
 BA.debugLineNum = 328;BA.debugLine="AddPhoto_Click";
Debug.ShouldStop(128);
_addphoto_click();
 BA.debugLineNum = 329;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 332;BA.debugLine="FileNameIndex = ContentPathFile.LastIndexOf(\"/\")";
Debug.ShouldStop(2048);
_filenameindex = _contentpathfile.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("FileNameIndex", _filenameindex);
 BA.debugLineNum = 333;BA.debugLine="ImgFileName = ContentPathFile.SubString(FileName";
Debug.ShouldStop(4096);
_imgfilename = _contentpathfile.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_filenameindex,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("ImgFileName", _imgfilename);
 BA.debugLineNum = 334;BA.debugLine="ImgFolderPath = ContentPathFile.SubString2(1,Fil";
Debug.ShouldStop(8192);
_imgfolderpath = _contentpathfile.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(_filenameindex));Debug.locals.put("ImgFolderPath", _imgfolderpath);
 BA.debugLineNum = 336;BA.debugLine="File.Copy(ImgFolderPath,ImgFileName,Main.BirdPho";
Debug.ShouldStop(32768);
sightings.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_imgfolderpath),(Object)(_imgfilename),(Object)(sightings.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_imagetime,RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 338;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(131072);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 339;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Imag";
Debug.ShouldStop(262144);
_newbird.runVoidMethod ("InitializeSample",(Object)(sightings.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_imagetime,RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 340;BA.debugLine="If Add_Photo_DB(ImageTime) = 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_add_photo_db(_imagetime),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 341;BA.debugLine="ToastMessageShow(\"Great success\",True)";
Debug.ShouldStop(1048576);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Great success")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 342;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 }else {
 BA.debugLineNum = 344;BA.debugLine="ToastMessageShow(\"An Error has occured, please";
Debug.ShouldStop(8388608);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("An Error has occured, please try again later")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 345;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 348;BA.debugLine="End Sub";
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
public static RemoteObject  _date_click() throws Exception{
try {
		Debug.PushSubsStack("Date_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,244);
if (RapidSub.canDelegate("date_click")) return sightings.remoteMe.runUserSub(false, "sightings","date_click");
RemoteObject _datedialog = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");
RemoteObject _dialogret = RemoteObject.createImmutable(0);
 BA.debugLineNum = 244;BA.debugLine="Sub Date_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 245;BA.debugLine="Dim DateDialog As DateDialog";
Debug.ShouldStop(1048576);
_datedialog = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");Debug.locals.put("DateDialog", _datedialog);
 BA.debugLineNum = 246;BA.debugLine="Dim DialogRet As Int";
Debug.ShouldStop(2097152);
_dialogret = RemoteObject.createImmutable(0);Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 248;BA.debugLine="DateDialog.DateTicks = DateTime.Now";
Debug.ShouldStop(8388608);
_datedialog.runMethod(true,"setDateTicks",sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 250;BA.debugLine="DialogRet = DateDialog.Show(\"\",\"Select date\",\"Ok\"";
Debug.ShouldStop(33554432);
_dialogret = _datedialog.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Select date")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 252;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_dialogret,BA.numberCast(double.class, sightings.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 253;BA.debugLine="Date.Text = DateTime.Date(DateDialog.DateTicks)";
Debug.ShouldStop(268435456);
sightings.mostCurrent._date.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_datedialog.runMethod(true,"getDateTicks")))));
 };
 BA.debugLineNum = 255;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exportdata() throws Exception{
try {
		Debug.PushSubsStack("ExportData (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,125);
if (RapidSub.canDelegate("exportdata")) return sightings.remoteMe.runUserSub(false, "sightings","exportdata");
RemoteObject _sightingsql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _insertdata = null;
 BA.debugLineNum = 125;BA.debugLine="Sub ExportData";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 129;BA.debugLine="Dim SightingSQL As StringBuilder";
Debug.ShouldStop(1);
_sightingsql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SightingSQL", _sightingsql);
 BA.debugLineNum = 130;BA.debugLine="Dim InsertData(7) As String";
Debug.ShouldStop(2);
_insertdata = RemoteObject.createNewArray ("String", new int[] {7}, new Object[]{});Debug.locals.put("InsertData", _insertdata);
 BA.debugLineNum = 132;BA.debugLine="SightingSQL.Initialize";
Debug.ShouldStop(8);
_sightingsql.runVoidMethod ("Initialize");
 BA.debugLineNum = 133;BA.debugLine="InsertData(0) = SelectedSpeciesID";
Debug.ShouldStop(16);
_insertdata.setArrayElement (BA.NumberToString(sightings._selectedspeciesid),BA.numberCast(int.class, 0));
 BA.debugLineNum = 134;BA.debugLine="InsertData(1) = FlockSize.Text";
Debug.ShouldStop(32);
_insertdata.setArrayElement (sightings.mostCurrent._flocksize.runMethod(true,"getText"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 135;BA.debugLine="InsertData(2) = WeatherConditions.Text";
Debug.ShouldStop(64);
_insertdata.setArrayElement (sightings.mostCurrent._weatherconditions.runMethod(true,"getText"),BA.numberCast(int.class, 2));
 BA.debugLineNum = 136;BA.debugLine="InsertData(3) =	 BirdAppearance.Text";
Debug.ShouldStop(128);
_insertdata.setArrayElement (sightings.mostCurrent._birdappearance.runMethod(true,"getText"),BA.numberCast(int.class, 3));
 BA.debugLineNum = 137;BA.debugLine="InsertData(4) = DateTimeTicks";
Debug.ShouldStop(256);
_insertdata.setArrayElement (BA.NumberToString(sightings._datetimeticks),BA.numberCast(int.class, 4));
 BA.debugLineNum = 138;BA.debugLine="InsertData(5) = Location.Latitude";
Debug.ShouldStop(512);
_insertdata.setArrayElement (BA.NumberToString(sightings.mostCurrent._location.runMethod(true,"getLatitude")),BA.numberCast(int.class, 5));
 BA.debugLineNum = 139;BA.debugLine="InsertData(6) = Location.Longitude";
Debug.ShouldStop(1024);
_insertdata.setArrayElement (BA.NumberToString(sightings.mostCurrent._location.runMethod(true,"getLongitude")),BA.numberCast(int.class, 6));
 BA.debugLineNum = 141;BA.debugLine="Log(\"Selected ID:\" & SelectedSpeciesID)";
Debug.ShouldStop(4096);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Selected ID:"),sightings._selectedspeciesid)));
 BA.debugLineNum = 142;BA.debugLine="SightingSQL.Append(\"INSERT INTO Sightings (Specie";
Debug.ShouldStop(8192);
_sightingsql.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("INSERT INTO Sightings (SpeciesID,FlockSize,Weather,Appearance,Epoch,Lat,Lng) VALUES (?, ?, ?, ?, ?, ?, ?)")));
 BA.debugLineNum = 144;BA.debugLine="Starter.database.ExecNonQuery2(SightingSQL,Insert";
Debug.ShouldStop(32768);
sightings.mostCurrent._starter._database.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString(_sightingsql)),(Object)(sightings.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_insertdata))));
 BA.debugLineNum = 145;BA.debugLine="Populate_List";
Debug.ShouldStop(65536);
_populate_list();
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getlocation_click() throws Exception{
try {
		Debug.PushSubsStack("GetLocation_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,165);
if (RapidSub.canDelegate("getlocation_click")) return sightings.remoteMe.runUserSub(false, "sightings","getlocation_click");
 BA.debugLineNum = 165;BA.debugLine="Sub GetLocation_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="If MapCheck.Checked = False Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._mapcheck.runMethod(true,"getChecked"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 167;BA.debugLine="GPSReady";
Debug.ShouldStop(64);
_gpsready();
 }else {
 BA.debugLineNum = 169;BA.debugLine="Map.GetLocationFlag = True";
Debug.ShouldStop(256);
sightings.mostCurrent._map._getlocationflag = sightings.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 170;BA.debugLine="StartActivity(\"Map\")";
Debug.ShouldStop(512);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Map"))));
 };
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private SpeciesList As ListView";
sightings.mostCurrent._specieslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private AddNow As Button";
sightings.mostCurrent._addnow = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private FlockSize As EditText";
sightings.mostCurrent._flocksize = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private BirdAppearance As EditText";
sightings.mostCurrent._birdappearance = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private WeatherConditions As EditText";
sightings.mostCurrent._weatherconditions = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Time As Label";
sightings.mostCurrent._time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private SelectedSpeciesID As Int = 0";
sightings._selectedspeciesid = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 23;BA.debugLine="Private SelectedSightingID As Int = 0";
sightings._selectedsightingid = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 24;BA.debugLine="Private Date As Label";
sightings.mostCurrent._date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private MapCheck As CheckBox";
sightings.mostCurrent._mapcheck = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Location As Location";
sightings.mostCurrent._location = RemoteObject.createNew ("anywheresoftware.b4a.gps.LocationWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private DateTimeTicks As Long";
sightings._datetimeticks = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 28;BA.debugLine="Private GetLocation As Button";
sightings.mostCurrent._getlocation = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private ViewPhotos As Button";
sightings.mostCurrent._viewphotos = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private SightingList As ListView";
sightings.mostCurrent._sightinglist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private AddPhoto As Button";
sightings.mostCurrent._addphoto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _gps1_locationchanged(RemoteObject _gpslocation) throws Exception{
try {
		Debug.PushSubsStack("GPS1_LocationChanged (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,159);
if (RapidSub.canDelegate("gps1_locationchanged")) return sightings.remoteMe.runUserSub(false, "sightings","gps1_locationchanged", _gpslocation);
Debug.locals.put("gpsLocation", _gpslocation);
 BA.debugLineNum = 159;BA.debugLine="Sub GPS1_LocationChanged (gpsLocation As Location)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(-2147483648);
sightings.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 161;BA.debugLine="Starter.L1=gpsLocation";
Debug.ShouldStop(1);
sightings.mostCurrent._starter._l1 = _gpslocation;
 BA.debugLineNum = 162;BA.debugLine="Starter.gps1.Stop";
Debug.ShouldStop(2);
sightings.mostCurrent._starter._gps1.runVoidMethod ("Stop");
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gpsready() throws Exception{
try {
		Debug.PushSubsStack("GPSReady (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,149);
if (RapidSub.canDelegate("gpsready")) return sightings.remoteMe.runUserSub(false, "sightings","gpsready");
 BA.debugLineNum = 149;BA.debugLine="Sub GPSReady";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="If Starter.GPS1.GPSEnabled= False Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 151;BA.debugLine="ToastMessageShow(\"Please enable your device's G";
Debug.ShouldStop(4194304);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please enable your device's GPS capabilities")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 152;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInten";
Debug.ShouldStop(8388608);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 }else {
 BA.debugLineNum = 154;BA.debugLine="Starter.gps1.Start(0,0)";
Debug.ShouldStop(33554432);
sightings.mostCurrent._starter._gps1.runVoidMethodAndSync ("Start",sightings.processBA,(Object)(BA.numberCast(long.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 155;BA.debugLine="ProgressDialogShow(\"Waiting for GPS location\")";
Debug.ShouldStop(67108864);
sightings.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",sightings.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Waiting for GPS location")));
 };
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _load_photos(RemoteObject _sightingid) throws Exception{
try {
		Debug.PushSubsStack("Load_Photos (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,228);
if (RapidSub.canDelegate("load_photos")) return sightings.remoteMe.runUserSub(false, "sightings","load_photos", _sightingid);
Debug.locals.put("SightingID", _sightingid);
 BA.debugLineNum = 228;BA.debugLine="Sub Load_Photos(SightingID As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="SightingPhotos.SightID = SightingID";
Debug.ShouldStop(16);
sightings.mostCurrent._sightingphotos._sightid = _sightingid;
 BA.debugLineNum = 230;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadattributes(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("LoadAttributes (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,232);
if (RapidSub.canDelegate("loadattributes")) return sightings.remoteMe.runUserSub(false, "sightings","loadattributes", _id);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("ID", _id);
 BA.debugLineNum = 232;BA.debugLine="Sub LoadAttributes(ID As Int)";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(256);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 234;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
Debug.ShouldStop(512);
_cursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM Sightings WHERE ID ="),_id))));
 BA.debugLineNum = 235;BA.debugLine="Cursor.Position = 0";
Debug.ShouldStop(1024);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 236;BA.debugLine="FlockSize.Text = Cursor.GetString(\"FlockSize\")";
Debug.ShouldStop(2048);
sightings.mostCurrent._flocksize.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("FlockSize")))));
 BA.debugLineNum = 237;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearan";
Debug.ShouldStop(4096);
sightings.mostCurrent._birdappearance.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Appearance")))));
 BA.debugLineNum = 238;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weath";
Debug.ShouldStop(8192);
sightings.mostCurrent._weatherconditions.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Weather")))));
 BA.debugLineNum = 239;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\"";
Debug.ShouldStop(16384);
sightings.mostCurrent._date.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
 BA.debugLineNum = 240;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\"";
Debug.ShouldStop(32768);
sightings.mostCurrent._time.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
 BA.debugLineNum = 241;BA.debugLine="End Sub";
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
public static RemoteObject  _opensightinginfo(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("OpenSightingInfo (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,220);
if (RapidSub.canDelegate("opensightinginfo")) return sightings.remoteMe.runUserSub(false, "sightings","opensightinginfo", _id);
Debug.locals.put("ID", _id);
 BA.debugLineNum = 220;BA.debugLine="Public Sub OpenSightingInfo(ID As Int)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 221;BA.debugLine="ID = ID + 1";
Debug.ShouldStop(268435456);
_id = RemoteObject.solve(new RemoteObject[] {_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ID", _id);
 BA.debugLineNum = 222;BA.debugLine="SpeciesList_ItemClick (ID,ID)";
Debug.ShouldStop(536870912);
_specieslist_itemclick(_id,(_id));
 BA.debugLineNum = 223;BA.debugLine="LoadAttributes(ID)";
Debug.ShouldStop(1073741824);
_loadattributes(_id);
 BA.debugLineNum = 225;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 BA.debugLineNum = 226;BA.debugLine="End Sub";
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
public static RemoteObject  _populate_list() throws Exception{
try {
		Debug.PushSubsStack("Populate_List (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,60);
if (RapidSub.canDelegate("populate_list")) return sightings.remoteMe.runUserSub(false, "sightings","populate_list");
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 60;BA.debugLine="Sub Populate_List";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 62;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(536870912);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 63;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(1073741824);
_speciescursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID, Name FROM Species ORDER BY Name ASC"))));
 BA.debugLineNum = 64;BA.debugLine="MapCheck.Visible = True";
Debug.ShouldStop(-2147483648);
sightings.mostCurrent._mapcheck.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 65;BA.debugLine="GetLocation.Visible = True";
Debug.ShouldStop(1);
sightings.mostCurrent._getlocation.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 66;BA.debugLine="AddNow.Visible = True";
Debug.ShouldStop(2);
sightings.mostCurrent._addnow.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 67;BA.debugLine="SpeciesList.clear";
Debug.ShouldStop(4);
sightings.mostCurrent._specieslist.runVoidMethod ("Clear");
 BA.debugLineNum = 68;BA.debugLine="If MapLookupFlag Then";
Debug.ShouldStop(8);
if (sightings._maplookupflag.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 69;BA.debugLine="OpenSightingInfo(Map.SelectedID)";
Debug.ShouldStop(16);
_opensightinginfo(sightings.mostCurrent._map._selectedid);
 BA.debugLineNum = 70;BA.debugLine="MapLookupFlag = False";
Debug.ShouldStop(32);
sightings._maplookupflag = sightings.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 71;BA.debugLine="GetLocation.Visible = False";
Debug.ShouldStop(64);
sightings.mostCurrent._getlocation.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="MapCheck.Visible = False";
Debug.ShouldStop(128);
sightings.mostCurrent._mapcheck.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="AddNow.Visible = False";
Debug.ShouldStop(256);
sightings.mostCurrent._addnow.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 75;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(1024);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 76;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(2048);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 77;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStr";
Debug.ShouldStop(4096);
sightings.mostCurrent._specieslist.runVoidMethod ("AddSingleLine2",(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))),(Object)((_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 85;BA.debugLine="End Sub";
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
public static RemoteObject  _populate_sightinglist() throws Exception{
try {
		Debug.PushSubsStack("Populate_SightingList (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,191);
if (RapidSub.canDelegate("populate_sightinglist")) return sightings.remoteMe.runUserSub(false, "sightings","populate_sightinglist");
RemoteObject _sightingcursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _sqlquery = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
 BA.debugLineNum = 191;BA.debugLine="Sub Populate_SightingList";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="Dim SightingCursor As Cursor";
Debug.ShouldStop(-2147483648);
_sightingcursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SightingCursor", _sightingcursor);
 BA.debugLineNum = 193;BA.debugLine="Dim SQLQuery As StringBuilder";
Debug.ShouldStop(1);
_sqlquery = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SQLQuery", _sqlquery);
 BA.debugLineNum = 194;BA.debugLine="SQLQuery.Initialize";
Debug.ShouldStop(2);
_sqlquery.runVoidMethod ("Initialize");
 BA.debugLineNum = 196;BA.debugLine="SQLQuery.Append(\"SELECT * FROM Sightings\").append";
Debug.ShouldStop(8);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT * FROM Sightings"))).runVoidMethod ("Append",(Object)(sightings.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 197;BA.debugLine="Log(SelectedSpeciesID)";
Debug.ShouldStop(16);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightings._selectedspeciesid)));
 BA.debugLineNum = 198;BA.debugLine="SQLQuery.Append(\"WHERE SpeciesID = ?\").append(CRL";
Debug.ShouldStop(32);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE SpeciesID = ?"))).runVoidMethod ("Append",(Object)(sightings.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 199;BA.debugLine="SightingCursor = Starter.Database.ExecQuery2(SQLQ";
Debug.ShouldStop(64);
_sightingcursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_sqlquery)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(sightings._selectedspeciesid)}))));
 BA.debugLineNum = 200;BA.debugLine="SightingList.clear 'Clears list";
Debug.ShouldStop(128);
sightings.mostCurrent._sightinglist.runVoidMethod ("Clear");
 BA.debugLineNum = 202;BA.debugLine="SightingList.AddSingleLine2(\"<Add Sighting>\", 0)";
Debug.ShouldStop(512);
sightings.mostCurrent._sightinglist.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToString("<Add Sighting>")),(Object)(RemoteObject.createImmutable((0))));
 BA.debugLineNum = 204;BA.debugLine="For i=0 To SightingCursor.RowCount-1 ' Loop to po";
Debug.ShouldStop(2048);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_sightingcursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10); _i = ((int)(0 + _i + step10)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 206;BA.debugLine="SightingCursor.Position = i";
Debug.ShouldStop(8192);
_sightingcursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 207;BA.debugLine="SightingList.AddSingleLine2(i + 1,SightingCursor";
Debug.ShouldStop(16384);
sightings.mostCurrent._sightinglist.runVoidMethod ("AddSingleLine2",(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1))),(Object)((_sightingcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 209;BA.debugLine="End Sub";
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
public static RemoteObject  _populatesightings(RemoteObject _sightingid) throws Exception{
try {
		Debug.PushSubsStack("PopulateSightings (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,286);
if (RapidSub.canDelegate("populatesightings")) return sightings.remoteMe.runUserSub(false, "sightings","populatesightings", _sightingid);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("sightingID", _sightingid);
 BA.debugLineNum = 286;BA.debugLine="Sub PopulateSightings(sightingID As Int)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 287;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(1073741824);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 288;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FRO";
Debug.ShouldStop(-2147483648);
_cursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM Sightings WHERE ID = "),_sightingid))));
 BA.debugLineNum = 289;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent.__c.runMethod(false,"LastException",sightings.mostCurrent.activityBA))));
 BA.debugLineNum = 290;BA.debugLine="Cursor.Position = 0";
Debug.ShouldStop(2);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 291;BA.debugLine="FlockSize.Text = Cursor.GetString(\"FlockSize\")";
Debug.ShouldStop(4);
sightings.mostCurrent._flocksize.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("FlockSize")))));
 BA.debugLineNum = 292;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearanc";
Debug.ShouldStop(8);
sightings.mostCurrent._birdappearance.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Appearance")))));
 BA.debugLineNum = 293;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weathe";
Debug.ShouldStop(16);
sightings.mostCurrent._weatherconditions.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Weather")))));
 BA.debugLineNum = 294;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\")";
Debug.ShouldStop(32);
sightings.mostCurrent._date.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
 BA.debugLineNum = 295;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\")";
Debug.ShouldStop(64);
sightings.mostCurrent._time.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
 BA.debugLineNum = 300;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
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
 //BA.debugLineNum = 9;BA.debugLine="Dim MapLookupFlag As Boolean = False";
sightings._maplookupflag = sightings.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 10;BA.debugLine="Dim SightingPhotoList As List";
sightings._sightingphotolist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sightinglist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SightingList_ItemClick (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,278);
if (RapidSub.canDelegate("sightinglist_itemclick")) return sightings.remoteMe.runUserSub(false, "sightings","sightinglist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 278;BA.debugLine="Sub SightingList_ItemClick (Position As Int, Value";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="If Position <> 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("!",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 280;BA.debugLine="PopulateSightings(Value)";
Debug.ShouldStop(8388608);
_populatesightings(BA.numberCast(int.class, _value));
 BA.debugLineNum = 281;BA.debugLine="SightingPhotos.SightID = Value";
Debug.ShouldStop(16777216);
sightings.mostCurrent._sightingphotos._sightid = BA.numberCast(int.class, _value);
 BA.debugLineNum = 282;BA.debugLine="SelectedSightingID = Value";
Debug.ShouldStop(33554432);
sightings._selectedsightingid = BA.numberCast(int.class, _value);
 };
 BA.debugLineNum = 284;BA.debugLine="End Sub";
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
public static RemoteObject  _specieslist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SpeciesList_ItemClick (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,174);
if (RapidSub.canDelegate("specieslist_itemclick")) return sightings.remoteMe.runUserSub(false, "sightings","specieslist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 174;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="SelectedSpeciesID = Value";
Debug.ShouldStop(16384);
sightings._selectedspeciesid = BA.numberCast(int.class, _value);
 BA.debugLineNum = 176;BA.debugLine="If Position = -1 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 177;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 179;BA.debugLine="If Value = -2 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable((-(double) (0 + 2))))) { 
 BA.debugLineNum = 180;BA.debugLine="AddNow.Width = 100dip";
Debug.ShouldStop(524288);
sightings.mostCurrent._addnow.runMethod(true,"setWidth",sightings.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));
 BA.debugLineNum = 181;BA.debugLine="AddNow.Visible = True";
Debug.ShouldStop(1048576);
sightings.mostCurrent._addnow.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 183;BA.debugLine="AddNow.Width = 200dip";
Debug.ShouldStop(4194304);
sightings.mostCurrent._addnow.runMethod(true,"setWidth",sightings.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))));
 BA.debugLineNum = 184;BA.debugLine="AddNow.Visible = True";
Debug.ShouldStop(8388608);
sightings.mostCurrent._addnow.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 186;BA.debugLine="Load_Photos(Value)";
Debug.ShouldStop(33554432);
_load_photos(BA.numberCast(int.class, _value));
 BA.debugLineNum = 188;BA.debugLine="Populate_SightingList";
Debug.ShouldStop(134217728);
_populate_sightinglist();
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _time_click() throws Exception{
try {
		Debug.PushSubsStack("Time_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,257);
if (RapidSub.canDelegate("time_click")) return sightings.remoteMe.runUserSub(false, "sightings","time_click");
RemoteObject _timedialog = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");
RemoteObject _dialogret = RemoteObject.createImmutable(0);
 BA.debugLineNum = 257;BA.debugLine="Sub Time_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 258;BA.debugLine="Dim TimeDialog As TimeDialog";
Debug.ShouldStop(2);
_timedialog = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");Debug.locals.put("TimeDialog", _timedialog);
 BA.debugLineNum = 259;BA.debugLine="Dim DialogRet As Int";
Debug.ShouldStop(4);
_dialogret = RemoteObject.createImmutable(0);Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 261;BA.debugLine="TimeDialog.TimeTicks = DateTime.Now";
Debug.ShouldStop(16);
_timedialog.runMethod(true,"setTimeTicks",sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 263;BA.debugLine="DialogRet = TimeDialog.Show(\"\",\"Select time\",\"Ok\"";
Debug.ShouldStop(64);
_dialogret = _timedialog.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Select time")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 265;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_dialogret,BA.numberCast(double.class, sightings.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 266;BA.debugLine="Time.Text = DateTime.Time(TimeDialog.TimeTicks)";
Debug.ShouldStop(512);
sightings.mostCurrent._time.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_timedialog.runMethod(true,"getTimeTicks")))));
 };
 BA.debugLineNum = 268;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _viewphotos_click() throws Exception{
try {
		Debug.PushSubsStack("ViewPhotos_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,271);
if (RapidSub.canDelegate("viewphotos_click")) return sightings.remoteMe.runUserSub(false, "sightings","viewphotos_click");
 BA.debugLineNum = 271;BA.debugLine="Sub ViewPhotos_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="Starter.list.Initialize";
Debug.ShouldStop(32768);
sightings.mostCurrent._starter._list.runVoidMethod ("Initialize");
 BA.debugLineNum = 273;BA.debugLine="Starter.list.Clear";
Debug.ShouldStop(65536);
sightings.mostCurrent._starter._list.runVoidMethod ("Clear");
 BA.debugLineNum = 274;BA.debugLine="Starter.list = SightingPhotoList";
Debug.ShouldStop(131072);
sightings.mostCurrent._starter._list = sightings._sightingphotolist;
 BA.debugLineNum = 275;BA.debugLine="StartActivity(SightingPhotos)";
Debug.ShouldStop(262144);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent._sightingphotos.getObject())));
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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