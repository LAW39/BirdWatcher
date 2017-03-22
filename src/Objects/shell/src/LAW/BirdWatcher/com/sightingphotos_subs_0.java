package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sightingphotos_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sightingphotos) ","sightingphotos",5,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_create", _firsttime);
int _i = 0;
RemoteObject _photoint = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"SightingPhotos\")";
Debug.ShouldStop(33554432);
sightingphotos.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("SightingPhotos")),sightingphotos.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",\"Species Picture\")";
Debug.ShouldStop(67108864);
sightingphotos.mostCurrent._phototab.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("PhotoTab")),(Object)((RemoteObject.createImmutable("Species Picture"))));
 BA.debugLineNum = 28;BA.debugLine="SightingPhotoList.Initialize";
Debug.ShouldStop(134217728);
sightingphotos._sightingphotolist.runVoidMethod ("Initialize");
 BA.debugLineNum = 29;BA.debugLine="SightingPhotoList = Starter.list";
Debug.ShouldStop(268435456);
sightingphotos._sightingphotolist = sightingphotos.mostCurrent._starter._list;
 BA.debugLineNum = 30;BA.debugLine="Log(SightingPhotoList.Size)";
Debug.ShouldStop(536870912);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightingphotos._sightingphotolist.runMethod(true,"getSize"))));
 BA.debugLineNum = 31;BA.debugLine="For i = 0 To SightingPhotoList.Size-1";
Debug.ShouldStop(1073741824);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {sightingphotos._sightingphotolist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 33;BA.debugLine="Dim PhotoInt As String = i+1";
Debug.ShouldStop(1);
_photoint = BA.NumberToString(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1));Debug.locals.put("PhotoInt", _photoint);Debug.locals.put("PhotoInt", _photoint);
 BA.debugLineNum = 34;BA.debugLine="Phototab.LoadLayout(\"PhotoTab\",PhotoInt)";
Debug.ShouldStop(2);
sightingphotos.mostCurrent._phototab.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("PhotoTab")),(Object)((_photoint)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (sightingphotos) ","sightingphotos",5,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,43);
if (RapidSub.canDelegate("activity_pause")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (sightingphotos) ","sightingphotos",5,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,39);
if (RapidSub.canDelegate("activity_resume")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","activity_resume");
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 17;BA.debugLine="Activity.Title = (\"Photos\")";
sightingphotos.mostCurrent._activity.runMethod(false,"setTitle",((RemoteObject.createImmutable("Photos"))));
 //BA.debugLineNum = 18;BA.debugLine="Private Phototab As TabStrip";
sightingphotos.mostCurrent._phototab = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabStripViewPager");
 //BA.debugLineNum = 19;BA.debugLine="Private SightingPhoto As ImageView";
sightingphotos.mostCurrent._sightingphoto = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private RemoveBtn As Button";
sightingphotos.mostCurrent._removebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loadbirdpic(RemoteObject _sightingid) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPic (sightingphotos) ","sightingphotos",5,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,47);
if (RapidSub.canDelegate("loadbirdpic")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","loadbirdpic", _sightingid);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _sqlquery = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("SightingID", _sightingid);
 BA.debugLineNum = 47;BA.debugLine="Sub LoadBirdPic(SightingID As Int) As Object";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="Log(SightingID)";
Debug.ShouldStop(65536);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_sightingid)));
 BA.debugLineNum = 50;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(131072);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 51;BA.debugLine="Dim SQLQuery As StringBuilder";
Debug.ShouldStop(262144);
_sqlquery = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SQLQuery", _sqlquery);
 BA.debugLineNum = 52;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(524288);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 53;BA.debugLine="SQLQuery.Initialize";
Debug.ShouldStop(1048576);
_sqlquery.runVoidMethod ("Initialize");
 BA.debugLineNum = 54;BA.debugLine="ToastMessageShow(SightingID,True)";
Debug.ShouldStop(2097152);
sightingphotos.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.NumberToString(_sightingid)),(Object)(sightingphotos.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 55;BA.debugLine="SQLQuery.Append(\"SELECT ImagePath\").Append(CRLF)";
Debug.ShouldStop(4194304);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT ImagePath"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 56;BA.debugLine="SQLQuery.append(\"FROM Species\").Append(CRLF)";
Debug.ShouldStop(8388608);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("FROM Species"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 57;BA.debugLine="SQLQuery.Append(\"LEFT JOIN Sightings ON Sightings";
Debug.ShouldStop(16777216);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("LEFT JOIN Sightings ON Sightings.SpeciesID = Species.ID"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 58;BA.debugLine="SQLQuery.Append(\"WHERE Sightings.ID = ?\").Append(";
Debug.ShouldStop(33554432);
_sqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE Sightings.ID = ?"))).runVoidMethod ("Append",(Object)(sightingphotos.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 59;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(SQLQu";
Debug.ShouldStop(67108864);
_speciescursor.setObject(sightingphotos.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_sqlquery)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_sightingid)}))));
 BA.debugLineNum = 60;BA.debugLine="SpeciesCursor.Position = 0";
Debug.ShouldStop(134217728);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 61;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 62;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
Debug.ShouldStop(536870912);
_newbird.runVoidMethod ("InitializeSample",(Object)(sightingphotos.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_speciescursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("ImagePath"))),RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e16) {
			BA.rdebugUtils.runVoidMethod("setLastException",sightingphotos.processBA, e16.toString()); BA.debugLineNum = 64;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,\"0.j";
Debug.ShouldStop(-2147483648);
_newbird.runVoidMethod ("InitializeSample",(Object)(sightingphotos.mostCurrent._main._birdphotopath),(Object)(BA.ObjectToString("0.jpg")),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 65;BA.debugLine="Log(\"Image not Found \" & SightingID)";
Debug.ShouldStop(1);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Image not Found "),_sightingid)));
 BA.debugLineNum = 66;BA.debugLine="ToastMessageShow(\"Image not found\", True)";
Debug.ShouldStop(2);
sightingphotos.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Image not found")),(Object)(sightingphotos.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 69;BA.debugLine="Return(NewBird)";
Debug.ShouldStop(16);
if (true) return ((_newbird).getObject());
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Phototab_PageSelected (sightingphotos) ","sightingphotos",5,sightingphotos.mostCurrent.activityBA,sightingphotos.mostCurrent,72);
if (RapidSub.canDelegate("phototab_pageselected")) return sightingphotos.remoteMe.runUserSub(false, "sightingphotos","phototab_pageselected", _position);
RemoteObject _photo = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Position", _position);
 BA.debugLineNum = 72;BA.debugLine="Sub Phototab_PageSelected (Position As Int)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Log(Position)";
Debug.ShouldStop(256);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_position)));
 BA.debugLineNum = 75;BA.debugLine="If Position = 1 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 76;BA.debugLine="SightingPhoto.bitmap = LoadBirdPic(Position)";
Debug.ShouldStop(2048);
sightingphotos.mostCurrent._sightingphoto.runMethod(false,"setBitmap",(_loadbirdpic(_position)));
 BA.debugLineNum = 77;BA.debugLine="RemoveBtn.Visible = False";
Debug.ShouldStop(4096);
sightingphotos.mostCurrent._removebtn.runMethod(true,"setVisible",sightingphotos.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 81;BA.debugLine="Position = Position - 1";
Debug.ShouldStop(65536);
_position = RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("Position", _position);
 BA.debugLineNum = 82;BA.debugLine="RemoveBtn.Visible = True";
Debug.ShouldStop(131072);
sightingphotos.mostCurrent._removebtn.runMethod(true,"setVisible",sightingphotos.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 83;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 84;BA.debugLine="SightingPhoto.bitmap =  SightingPhotoList.Get(Po";
Debug.ShouldStop(524288);
sightingphotos.mostCurrent._sightingphoto.runMethod(false,"setBitmap",(sightingphotos._sightingphotolist.runMethod(false,"Get",(Object)(_position))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",sightingphotos.processBA, e12.toString()); BA.debugLineNum = 86;BA.debugLine="Dim Photo As Bitmap";
Debug.ShouldStop(2097152);
_photo = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Photo", _photo);
 BA.debugLineNum = 87;BA.debugLine="Photo.InitializeSample(Main.BirdPhotoPath,\"0.jpg";
Debug.ShouldStop(4194304);
_photo.runVoidMethod ("InitializeSample",(Object)(sightingphotos.mostCurrent._main._birdphotopath),(Object)(BA.ObjectToString("0.jpg")),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 88;BA.debugLine="SightingPhoto.bitmap = Photo";
Debug.ShouldStop(8388608);
sightingphotos.mostCurrent._sightingphoto.runMethod(false,"setBitmap",(_photo.getObject()));
 BA.debugLineNum = 89;BA.debugLine="Log(\"Image not Found \" & Position)";
Debug.ShouldStop(16777216);
sightingphotos.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Image not Found "),_position)));
 BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"Image not found\", True)";
Debug.ShouldStop(33554432);
sightingphotos.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Image not found")),(Object)(sightingphotos.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 93;BA.debugLine="End Sub";
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