package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sightingphotos_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_create", _firsttime);
int _i = 0;
RemoteObject _photoint = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 26;BA.debugLine="Log(SightID)";
Debug.ShouldStop(33554432);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightingphotos._sightid)));
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"SightingPhotos\")";
Debug.ShouldStop(67108864);
sightingphotos.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("SightingPhotos")),sightingphotos.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",\"Species Picture\")";
Debug.ShouldStop(134217728);
sightingphotos.mostCurrent._phototab.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("PhotoTab")),(Object)((RemoteObject.createImmutable("Species Picture"))));
 BA.debugLineNum = 29;BA.debugLine="Load_Photos(SightID)";
Debug.ShouldStop(268435456);
_load_photos(sightingphotos._sightid);
 BA.debugLineNum = 30;BA.debugLine="Activity.Title = (\"Photos\")";
Debug.ShouldStop(536870912);
sightingphotos.mostCurrent._activity.runMethod(false,"setTitle",((RemoteObject.createImmutable("Photos"))));
 BA.debugLineNum = 31;BA.debugLine="Log(SightingPhotoList.Size)";
Debug.ShouldStop(1073741824);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightingphotos._sightingphotolist.runMethod(true,"getSize"))));
 BA.debugLineNum = 32;BA.debugLine="For i = 0 To SightingPhotoList.Size-1";
Debug.ShouldStop(-2147483648);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {sightingphotos._sightingphotolist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 34;BA.debugLine="Dim PhotoInt As String = i+1";
Debug.ShouldStop(2);
_photoint = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1));Debug.locals.put("PhotoInt", _photoint);Debug.locals.put("PhotoInt", _photoint);
 BA.debugLineNum = 35;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",PhotoInt)";
Debug.ShouldStop(4);
sightingphotos.mostCurrent._phototab.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("PhotoTab")),(Object)((_photoint)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 38;BA.debugLine="Phototab_PageSelected (0)";
Debug.ShouldStop(32);
_phototab_pageselected(BA.numberCast(int.class, 0));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Pause (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,73);
if (RapidSub.canDelegate("activity_pause")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_Resume (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,69);
if (RapidSub.canDelegate("activity_resume")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_resume");
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 18;BA.debugLine="Private Phototab As TabStrip";
sightingphotos.mostCurrent._phototab = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabStripViewPager");
 //BA.debugLineNum = 19;BA.debugLine="Private SightingPhoto As ImageView";
sightingphotos.mostCurrent._sightingphoto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private RemoveBtn As Button";
sightingphotos.mostCurrent._removebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _load_photos(RemoteObject _sightingid) throws Exception{
try {
		Debug.PushSubsStack("Load_Photos (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,42);
if (RapidSub.canDelegate("load_photos")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","load_photos", _sightingid);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _sqlquery = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _sightingpicture = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _birdphotofile = RemoteObject.createImmutable(0);
int _counter = 0;
Debug.locals.put("SightingID", _sightingid);
 BA.debugLineNum = 42;BA.debugLine="Sub Load_Photos(SightingID As Int)";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="SightingPhotoList.Initialize";
Debug.ShouldStop(1024);
sightingphotos._sightingphotolist.runVoidMethod ("Initialize");
 BA.debugLineNum = 44;BA.debugLine="Log(SightingID)";
Debug.ShouldStop(2048);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_sightingid)));
 BA.debugLineNum = 45;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(4096);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 46;BA.debugLine="Dim SQLQuery As StringBuilder";
Debug.ShouldStop(8192);
_sqlquery = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SQLQuery", _sqlquery);
 BA.debugLineNum = 47;BA.debugLine="Dim SightingPicture As Bitmap";
Debug.ShouldStop(16384);
_sightingpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("SightingPicture", _sightingpicture);
 BA.debugLineNum = 48;BA.debugLine="Dim BirdPhotoFile As Double";
Debug.ShouldStop(32768);
_birdphotofile = RemoteObject.createImmutable(0);Debug.locals.put("BirdPhotoFile", _birdphotofile);
 BA.debugLineNum = 49;BA.debugLine="SQLQuery.Initialize";
Debug.ShouldStop(65536);
_sqlquery.runVoidMethod ("Initialize");
 BA.debugLineNum = 50;BA.debugLine="SQLQuery.Append(\"SELECT PhotoDir\").Append(CRLF)";
Debug.ShouldStop(131072);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT PhotoDir"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 51;BA.debugLine="SQLQuery.Append(\"FROM SightingPhoto\").Append(CRLF";
Debug.ShouldStop(262144);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("FROM SightingPhoto"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 52;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
Debug.ShouldStop(524288);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("LEFT JOIN Sightings ON Sightings.ID = SightingPhoto.SightingID"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 53;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
Debug.ShouldStop(1048576);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE Sightings.ID = ?"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 55;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
Debug.ShouldStop(4194304);
_speciescursor.setObject(sightingphotos.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_sqlquery)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_sightingid)}))));
 BA.debugLineNum = 56;BA.debugLine="SpeciesCursor.Position = 0";
Debug.ShouldStop(8388608);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 57;BA.debugLine="Log(SpeciesCursor.RowCount & \"Test\")";
Debug.ShouldStop(16777216);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable("Test"))));
 BA.debugLineNum = 59;BA.debugLine="For counter = 0 To SpeciesCursor.RowCount";
Debug.ShouldStop(67108864);
{
final int step15 = 1;
final int limit15 = _speciescursor.runMethod(true,"getRowCount").<Integer>get().intValue();
for (_counter = 0 ; (step15 > 0 && _counter <= limit15) || (step15 < 0 && _counter >= limit15); _counter = ((int)(0 + _counter + step15)) ) {
Debug.locals.put("counter", _counter);
 BA.debugLineNum = 60;BA.debugLine="BirdPhotoFile = SpeciesCursor.GetInt(\"PhotoDir\"";
Debug.ShouldStop(134217728);
_birdphotofile = BA.numberCast(double.class, _speciescursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("PhotoDir"))));Debug.locals.put("BirdPhotoFile", _birdphotofile);
 BA.debugLineNum = 61;BA.debugLine="SightingPicture.Initialize(Main.BirdPhotoPath,B";
Debug.ShouldStop(268435456);
_sightingpicture.runVoidMethod ("Initialize",(Object)(sightingphotos.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_birdphotofile,RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 62;BA.debugLine="SightingPhotoList.Add(SightingPicture)";
Debug.ShouldStop(536870912);
sightingphotos._sightingphotolist.runVoidMethod ("Add",(Object)((_sightingpicture.getObject())));
 }
}Debug.locals.put("counter", _counter);
;
 BA.debugLineNum = 67;BA.debugLine="End Sub";
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
public static RemoteObject  _loadbirdpic(RemoteObject _sightingid) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPic (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,77);
if (RapidSub.canDelegate("loadbirdpic")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","loadbirdpic", _sightingid);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _sqlquery = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("SightingID", _sightingid);
 BA.debugLineNum = 77;BA.debugLine="Sub LoadBirdPic(SightingID As Int) As Object";
Debug.ShouldStop(4096);
 BA.debugLineNum = 79;BA.debugLine="Log(SightingID)";
Debug.ShouldStop(16384);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_sightingid)));
 BA.debugLineNum = 80;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(32768);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 81;BA.debugLine="Dim SQLQuery As StringBuilder";
Debug.ShouldStop(65536);
_sqlquery = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SQLQuery", _sqlquery);
 BA.debugLineNum = 82;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(131072);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 83;BA.debugLine="SQLQuery.Initialize";
Debug.ShouldStop(262144);
_sqlquery.runVoidMethod ("Initialize");
 BA.debugLineNum = 84;BA.debugLine="ToastMessageShow(SightingID,True)";
Debug.ShouldStop(524288);
sightingphotos.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.NumberToString(_sightingid)),(Object)(sightingphotos.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 85;BA.debugLine="SQLQuery.Append(\"SELECT ImagePath\").Append(CRLF)";
Debug.ShouldStop(1048576);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT ImagePath"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 86;BA.debugLine="SQLQuery.append(\"FROM Species\").Append(CRLF)";
Debug.ShouldStop(2097152);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("FROM Species"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 87;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
Debug.ShouldStop(4194304);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("LEFT JOIN Sightings ON Sightings.SpeciesID = Species.ID"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 88;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
Debug.ShouldStop(8388608);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE Sightings.ID = ?"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 89;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
Debug.ShouldStop(16777216);
_speciescursor.setObject(sightingphotos.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_sqlquery)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_sightingid)}))));
 BA.debugLineNum = 90;BA.debugLine="SpeciesCursor.Position = 0";
Debug.ShouldStop(33554432);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 92;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
Debug.ShouldStop(134217728);
_newbird.runVoidMethod ("InitializeSample",(Object)(sightingphotos.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_speciescursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("ImagePath"))),RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 620)),(Object)(BA.numberCast(int.class, 480)));
 BA.debugLineNum = 99;BA.debugLine="Return(NewBird)";
Debug.ShouldStop(4);
if (true) return ((_newbird).getObject());
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _phototab_pageselected(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("Phototab_PageSelected (sightingphotos) ","sightingphotos",4,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,102);
if (RapidSub.canDelegate("phototab_pageselected")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","phototab_pageselected", _position);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 102;BA.debugLine="Sub Phototab_PageSelected (Position As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Log(Position)";
Debug.ShouldStop(64);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_position)));
 BA.debugLineNum = 104;BA.debugLine="Log(\"Code Run\")";
Debug.ShouldStop(128);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Code Run")));
 BA.debugLineNum = 105;BA.debugLine="If Position = 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 106;BA.debugLine="SightingPhoto.bitmap = LoadBirdPic(SightID)";
Debug.ShouldStop(512);
sightingphotos.mostCurrent._sightingphoto.runMethod(false,"setBitmap",(_loadbirdpic(sightingphotos._sightid)));
 BA.debugLineNum = 107;BA.debugLine="RemoveBtn.Visible = False";
Debug.ShouldStop(1024);
sightingphotos.mostCurrent._removebtn.runMethod(true,"setVisible",sightingphotos.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="Return";
Debug.ShouldStop(2048);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 111;BA.debugLine="Position = Position - 1";
Debug.ShouldStop(16384);
_position = RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("Position", _position);
 BA.debugLineNum = 112;BA.debugLine="RemoveBtn.Visible = True";
Debug.ShouldStop(32768);
sightingphotos.mostCurrent._removebtn.runMethod(true,"setVisible",sightingphotos.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 114;BA.debugLine="SightingPhoto.bitmap =  SightingPhotoList.Get(Pos";
Debug.ShouldStop(131072);
sightingphotos.mostCurrent._sightingphoto.runMethod(false,"setBitmap",(sightingphotos._sightingphotolist.runMethod(false,"Get",(Object)(_position))));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim SightingPhotoList As List";
sightingphotos._sightingphotolist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 10;BA.debugLine="Dim SightID As Int";
sightingphotos._sightid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}