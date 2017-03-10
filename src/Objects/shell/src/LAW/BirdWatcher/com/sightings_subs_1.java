package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sightings_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return sightings.remoteMe.runUserSub(false, "sightings","activity_create", _firsttime);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Log(Starter.GPS1)";
Debug.ShouldStop(1073741824);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._gps1)));
 BA.debugLineNum = 32;BA.debugLine="Log(Starter.L1)";
Debug.ShouldStop(-2147483648);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._l1)));
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"sightingadd\")";
Debug.ShouldStop(4);
sightings.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sightingadd")),sightings.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Activity.Title = \"Sightings\"";
Debug.ShouldStop(8);
sightings.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Sightings")));
 BA.debugLineNum = 37;BA.debugLine="DateTime.Dateformat = \"dd/MM/yyyy\"";
Debug.ShouldStop(16);
sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 38;BA.debugLine="DateTime.TimeFormat= \"HH:mm\"";
Debug.ShouldStop(32);
sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 39;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(64);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 40;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(128);
_speciescursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID, Name FROM Species ORDER BY Name ASC"))));
 BA.debugLineNum = 41;BA.debugLine="MapCheck.Visible = True";
Debug.ShouldStop(256);
sightings.mostCurrent._mapcheck.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 42;BA.debugLine="GetLocation.Visible = True";
Debug.ShouldStop(512);
sightings.mostCurrent._getlocation.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 43;BA.debugLine="SpeciesList.clear";
Debug.ShouldStop(1024);
sightings.mostCurrent._specieslist.runVoidMethod ("Clear");
 BA.debugLineNum = 44;BA.debugLine="If MapLookupFlag Then";
Debug.ShouldStop(2048);
if (sightings._maplookupflag.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="OpenSightingInfo(Map.SelectedID)";
Debug.ShouldStop(4096);
_opensightinginfo(sightings.mostCurrent._map._selectedid);
 BA.debugLineNum = 46;BA.debugLine="MapLookupFlag = False";
Debug.ShouldStop(8192);
sightings._maplookupflag = sightings.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 47;BA.debugLine="GetLocation.Visible = False";
Debug.ShouldStop(16384);
sightings.mostCurrent._getlocation.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 48;BA.debugLine="MapCheck.Visible = False";
Debug.ShouldStop(32768);
sightings.mostCurrent._mapcheck.runMethod(true,"setVisible",sightings.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 50;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(131072);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step18 > 0 && _i <= limit18) || (step18 < 0 && _i >= limit18); _i = ((int)(0 + _i + step18)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 51;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(262144);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 52;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStr";
Debug.ShouldStop(524288);
sightings.mostCurrent._specieslist.runVoidMethod ("AddSingleLine2",(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))),(Object)((_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 56;BA.debugLine="Location.Initialize";
Debug.ShouldStop(8388608);
sightings.mostCurrent._location.runVoidMethod ("Initialize");
 BA.debugLineNum = 57;BA.debugLine="Map.SelectedBird=False";
Debug.ShouldStop(16777216);
sightings.mostCurrent._map._selectedbird = sightings.mostCurrent.__c.getField(true,"False");
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,70);
if (RapidSub.canDelegate("activity_pause")) return sightings.remoteMe.runUserSub(false, "sightings","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,60);
if (RapidSub.canDelegate("activity_resume")) return sightings.remoteMe.runUserSub(false, "sightings","activity_resume");
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 64;BA.debugLine="If Starter.GPS1.GPSEnabled = False Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Please enable the GPS device.\",";
Debug.ShouldStop(1);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please enable the GPS device.")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 66;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsIntent";
Debug.ShouldStop(2);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
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
		Debug.PushSubsStack("AddNow_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,75);
if (RapidSub.canDelegate("addnow_click")) return sightings.remoteMe.runUserSub(false, "sightings","addnow_click");
RemoteObject _date_time = null;
 BA.debugLineNum = 75;BA.debugLine="Sub AddNow_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="If MapCheck.Checked = False Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._mapcheck.runMethod(true,"getChecked"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 78;BA.debugLine="Location.Latitude = Starter.L1.Latitude";
Debug.ShouldStop(8192);
sightings.mostCurrent._location.runMethod(true,"setLatitude",sightings.mostCurrent._starter._l1.runMethod(true,"getLatitude"));
 BA.debugLineNum = 79;BA.debugLine="Location.Longitude = Starter.L1.longitude";
Debug.ShouldStop(16384);
sightings.mostCurrent._location.runMethod(true,"setLongitude",sightings.mostCurrent._starter._l1.runMethod(true,"getLongitude"));
 }else {
 BA.debugLineNum = 81;BA.debugLine="Map.GetLocationFlag = True";
Debug.ShouldStop(65536);
sightings.mostCurrent._map._getlocationflag = sightings.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 82;BA.debugLine="Location.Latitude = Map.Location.Latitude";
Debug.ShouldStop(131072);
sightings.mostCurrent._location.runMethod(true,"setLatitude",sightings.mostCurrent._map._location.runMethod(true,"getLatitude"));
 BA.debugLineNum = 83;BA.debugLine="Location.Longitude = Map.Location.Longitude";
Debug.ShouldStop(262144);
sightings.mostCurrent._location.runMethod(true,"setLongitude",sightings.mostCurrent._map._location.runMethod(true,"getLongitude"));
 };
 BA.debugLineNum = 86;BA.debugLine="Dim Date_Time(2) As String";
Debug.ShouldStop(2097152);
_date_time = RemoteObject.createNewArray ("String", new int[] {2}, new Object[]{});Debug.locals.put("Date_Time", _date_time);
 BA.debugLineNum = 87;BA.debugLine="Date_Time(0) = Date.text";
Debug.ShouldStop(4194304);
_date_time.setArrayElement (sightings.mostCurrent._date.runMethod(true,"getText"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 88;BA.debugLine="Date_Time(1) = Time.Text";
Debug.ShouldStop(8388608);
_date_time.setArrayElement (sightings.mostCurrent._time.runMethod(true,"getText"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 90;BA.debugLine="If Date_Time(0) = \"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_date_time.getArrayElement(true,BA.numberCast(int.class, 0)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 91;BA.debugLine="Date_Time(0) = DateTime.GetDayOfMonth(DateTime.N";
Debug.ShouldStop(67108864);
_date_time.setArrayElement (RemoteObject.concat(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable("/"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable("/"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 94;BA.debugLine="If Date_Time(1) = \"\" Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_date_time.getArrayElement(true,BA.numberCast(int.class, 1)),BA.ObjectToString(""))) { 
 BA.debugLineNum = 95;BA.debugLine="Date_Time(1) = DateTime.GetHour(DateTime.Now) &";
Debug.ShouldStop(1073741824);
_date_time.setArrayElement (RemoteObject.concat(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(":"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(":"),sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetSecond",(Object)(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))),BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 98;BA.debugLine="Log(Starter.L1)";
Debug.ShouldStop(2);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(sightings.mostCurrent._starter._l1)));
 BA.debugLineNum = 99;BA.debugLine="DateTimeTicks = DateTime.DateTimeParse(Date_Time(";
Debug.ShouldStop(4);
sightings._datetimeticks = sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateTimeParse",(Object)(_date_time.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_date_time.getArrayElement(true,BA.numberCast(int.class, 1))));
 BA.debugLineNum = 100;BA.debugLine="Log(DateTimeTicks)";
Debug.ShouldStop(8);
sightings.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(sightings._datetimeticks)));
 BA.debugLineNum = 102;BA.debugLine="ExportData";
Debug.ShouldStop(32);
_exportdata();
 BA.debugLineNum = 104;BA.debugLine="End Sub";
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
public static RemoteObject  _date_click() throws Exception{
try {
		Debug.PushSubsStack("Date_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,192);
if (RapidSub.canDelegate("date_click")) return sightings.remoteMe.runUserSub(false, "sightings","date_click");
RemoteObject _datedialog = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");
RemoteObject _dialogret = RemoteObject.createImmutable(0);
 BA.debugLineNum = 192;BA.debugLine="Sub Date_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="Dim DateDialog As DateDialog";
Debug.ShouldStop(1);
_datedialog = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");Debug.locals.put("DateDialog", _datedialog);
 BA.debugLineNum = 194;BA.debugLine="Dim DialogRet As Int";
Debug.ShouldStop(2);
_dialogret = RemoteObject.createImmutable(0);Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 196;BA.debugLine="DateDialog.DateTicks = DateTime.Now";
Debug.ShouldStop(8);
_datedialog.runMethod(true,"setDateTicks",sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 198;BA.debugLine="DialogRet = DateDialog.Show(\"\",\"Select date\",\"Ok\"";
Debug.ShouldStop(32);
_dialogret = _datedialog.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Select date")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 200;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_dialogret,BA.numberCast(double.class, sightings.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 201;BA.debugLine="Date.Text = DateTime.Date(DateDialog.DateTicks)";
Debug.ShouldStop(256);
sightings.mostCurrent._date.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_datedialog.runMethod(true,"getDateTicks")))));
 };
 BA.debugLineNum = 203;BA.debugLine="End Sub";
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
public static RemoteObject  _exportdata() throws Exception{
try {
		Debug.PushSubsStack("ExportData (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,106);
if (RapidSub.canDelegate("exportdata")) return sightings.remoteMe.runUserSub(false, "sightings","exportdata");
RemoteObject _sightingsql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _insertdata = null;
 BA.debugLineNum = 106;BA.debugLine="Sub ExportData";
Debug.ShouldStop(512);
 BA.debugLineNum = 110;BA.debugLine="Dim SightingSQL As StringBuilder";
Debug.ShouldStop(8192);
_sightingsql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SightingSQL", _sightingsql);
 BA.debugLineNum = 111;BA.debugLine="Dim InsertData(7) As String";
Debug.ShouldStop(16384);
_insertdata = RemoteObject.createNewArray ("String", new int[] {7}, new Object[]{});Debug.locals.put("InsertData", _insertdata);
 BA.debugLineNum = 113;BA.debugLine="SightingSQL.Initialize";
Debug.ShouldStop(65536);
_sightingsql.runVoidMethod ("Initialize");
 BA.debugLineNum = 114;BA.debugLine="InsertData(0) = SelectedID";
Debug.ShouldStop(131072);
_insertdata.setArrayElement (BA.NumberToString(sightings._selectedid),BA.numberCast(int.class, 0));
 BA.debugLineNum = 115;BA.debugLine="InsertData(1) = FlockSize.Text";
Debug.ShouldStop(262144);
_insertdata.setArrayElement (sightings.mostCurrent._flocksize.runMethod(true,"getText"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 116;BA.debugLine="InsertData(2) = WeatherConditions.Text";
Debug.ShouldStop(524288);
_insertdata.setArrayElement (sightings.mostCurrent._weatherconditions.runMethod(true,"getText"),BA.numberCast(int.class, 2));
 BA.debugLineNum = 117;BA.debugLine="InsertData(3) =	 BirdAppearance.Text";
Debug.ShouldStop(1048576);
_insertdata.setArrayElement (sightings.mostCurrent._birdappearance.runMethod(true,"getText"),BA.numberCast(int.class, 3));
 BA.debugLineNum = 118;BA.debugLine="InsertData(4) = DateTimeTicks";
Debug.ShouldStop(2097152);
_insertdata.setArrayElement (BA.NumberToString(sightings._datetimeticks),BA.numberCast(int.class, 4));
 BA.debugLineNum = 119;BA.debugLine="InsertData(5) = Location.Latitude";
Debug.ShouldStop(4194304);
_insertdata.setArrayElement (BA.NumberToString(sightings.mostCurrent._location.runMethod(true,"getLatitude")),BA.numberCast(int.class, 5));
 BA.debugLineNum = 120;BA.debugLine="InsertData(6) = Location.Longitude";
Debug.ShouldStop(8388608);
_insertdata.setArrayElement (BA.NumberToString(sightings.mostCurrent._location.runMethod(true,"getLongitude")),BA.numberCast(int.class, 6));
 BA.debugLineNum = 123;BA.debugLine="SightingSQL.Append(\"INSERT INTO Sightings (Specie";
Debug.ShouldStop(67108864);
_sightingsql.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("INSERT INTO Sightings (SpeciesID,FlockSize,Weather,Appearance,Epoch,Lat,Lng) VALUES (?, ?, ?, ?, ?, ?, ?)")));
 BA.debugLineNum = 125;BA.debugLine="Starter.database.ExecNonQuery2(SightingSQL, Inser";
Debug.ShouldStop(268435456);
sightings.mostCurrent._starter._database.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString(_sightingsql)),(Object)(sightings.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_insertdata))));
 BA.debugLineNum = 127;BA.debugLine="End Sub";
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
public static RemoteObject  _getlocation_click() throws Exception{
try {
		Debug.PushSubsStack("GetLocation_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,145);
if (RapidSub.canDelegate("getlocation_click")) return sightings.remoteMe.runUserSub(false, "sightings","getlocation_click");
 BA.debugLineNum = 145;BA.debugLine="Sub GetLocation_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="If MapCheck.Checked = False Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._mapcheck.runMethod(true,"getChecked"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 147;BA.debugLine="GPSReady";
Debug.ShouldStop(262144);
_gpsready();
 }else {
 BA.debugLineNum = 149;BA.debugLine="Map.GetLocationFlag = True";
Debug.ShouldStop(1048576);
sightings.mostCurrent._map._getlocationflag = sightings.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 150;BA.debugLine="StartActivity(\"Map\")";
Debug.ShouldStop(2097152);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Map"))));
 };
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private SpeciesList As ListView";
sightings.mostCurrent._specieslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private AddNow As Button";
sightings.mostCurrent._addnow = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private FlockSize As EditText";
sightings.mostCurrent._flocksize = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private BirdAppearance As EditText";
sightings.mostCurrent._birdappearance = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private WeatherConditions As EditText";
sightings.mostCurrent._weatherconditions = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Time As Label";
sightings.mostCurrent._time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private BirdPhotoView As ImageView";
sightings.mostCurrent._birdphotoview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private SelectedID As Int = 0";
sightings._selectedid = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 23;BA.debugLine="Private Date As Label";
sightings.mostCurrent._date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private MapCheck As CheckBox";
sightings.mostCurrent._mapcheck = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Location As Location";
sightings.mostCurrent._location = RemoteObject.createNew ("anywheresoftware.b4a.gps.LocationWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private DateTimeTicks As Long";
sightings._datetimeticks = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 27;BA.debugLine="Private GetLocation As Button";
sightings.mostCurrent._getlocation = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _gps1_locationchanged(RemoteObject _gpslocation) throws Exception{
try {
		Debug.PushSubsStack("GPS1_LocationChanged (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,139);
if (RapidSub.canDelegate("gps1_locationchanged")) return sightings.remoteMe.runUserSub(false, "sightings","gps1_locationchanged", _gpslocation);
Debug.locals.put("gpsLocation", _gpslocation);
 BA.debugLineNum = 139;BA.debugLine="Sub GPS1_LocationChanged (gpsLocation As Location)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2048);
sightings.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 141;BA.debugLine="Starter.L1=gpsLocation";
Debug.ShouldStop(4096);
sightings.mostCurrent._starter._l1 = _gpslocation;
 BA.debugLineNum = 142;BA.debugLine="Starter.gps1.Stop";
Debug.ShouldStop(8192);
sightings.mostCurrent._starter._gps1.runVoidMethod ("Stop");
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("GPSReady (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,129);
if (RapidSub.canDelegate("gpsready")) return sightings.remoteMe.runUserSub(false, "sightings","gpsready");
 BA.debugLineNum = 129;BA.debugLine="Sub GPSReady";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="If Starter.GPS1.GPSEnabled= False Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",sightings.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"),sightings.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 131;BA.debugLine="ToastMessageShow(\"Please enable your device's G";
Debug.ShouldStop(4);
sightings.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please enable your device's GPS capabilities")),(Object)(sightings.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 132;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInten";
Debug.ShouldStop(8);
sightings.mostCurrent.__c.runVoidMethod ("StartActivity",sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 }else {
 BA.debugLineNum = 134;BA.debugLine="Starter.gps1.Start(0,0)";
Debug.ShouldStop(32);
sightings.mostCurrent._starter._gps1.runVoidMethodAndSync ("Start",sightings.processBA,(Object)(BA.numberCast(long.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 135;BA.debugLine="ProgressDialogShow(\"Waiting for GPS location\")";
Debug.ShouldStop(64);
sightings.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",sightings.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Waiting for GPS location")));
 };
 BA.debugLineNum = 137;BA.debugLine="End Sub";
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
public static RemoteObject  _loadattributes(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("LoadAttributes (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,180);
if (RapidSub.canDelegate("loadattributes")) return sightings.remoteMe.runUserSub(false, "sightings","loadattributes", _id);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("ID", _id);
 BA.debugLineNum = 180;BA.debugLine="Sub LoadAttributes(ID As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(1048576);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 182;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
Debug.ShouldStop(2097152);
_cursor.setObject(sightings.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM Sightings WHERE ID ="),_id))));
 BA.debugLineNum = 183;BA.debugLine="Cursor.Position = 0";
Debug.ShouldStop(4194304);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 184;BA.debugLine="FlockSize.Text = Cursor.GetString(\"FlockSize\")";
Debug.ShouldStop(8388608);
sightings.mostCurrent._flocksize.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("FlockSize")))));
 BA.debugLineNum = 185;BA.debugLine="BirdAppearance.Text = Cursor.GetString(\"Appearan";
Debug.ShouldStop(16777216);
sightings.mostCurrent._birdappearance.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Appearance")))));
 BA.debugLineNum = 186;BA.debugLine="WeatherConditions.Text = Cursor.GetString(\"Weath";
Debug.ShouldStop(33554432);
sightings.mostCurrent._weatherconditions.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Weather")))));
 BA.debugLineNum = 187;BA.debugLine="Date.Text = DateTime.Date(Cursor.GetLong(\"Epoch\"";
Debug.ShouldStop(67108864);
sightings.mostCurrent._date.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
 BA.debugLineNum = 188;BA.debugLine="Time.Text = DateTime.Time(Cursor.GetLong(\"Epoch\"";
Debug.ShouldStop(134217728);
sightings.mostCurrent._time.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_cursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("Epoch")))))));
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
public static RemoteObject  _loadbirdpic(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPic (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,163);
if (RapidSub.canDelegate("loadbirdpic")) return sightings.remoteMe.runUserSub(false, "sightings","loadbirdpic", _id);
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("ID", _id);
 BA.debugLineNum = 163;BA.debugLine="Sub LoadBirdPic(ID As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="ID = ID +1";
Debug.ShouldStop(8);
_id = RemoteObject.solve(new RemoteObject[] {_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ID", _id);
 BA.debugLineNum = 166;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(32);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 167;BA.debugLine="NewBird.InitializeSample(File.DirAssets, ID & \".j";
Debug.ShouldStop(64);
_newbird.runVoidMethod ("InitializeSample",(Object)(sightings.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(_id,RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 168;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
Debug.ShouldStop(128);
sightings.mostCurrent._birdphotoview.runMethod(false,"setBitmap",(_newbird.getObject()));
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("OpenSightingInfo (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,172);
if (RapidSub.canDelegate("opensightinginfo")) return sightings.remoteMe.runUserSub(false, "sightings","opensightinginfo", _id);
Debug.locals.put("ID", _id);
 BA.debugLineNum = 172;BA.debugLine="Public Sub OpenSightingInfo(ID As Int)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 173;BA.debugLine="ID = ID + 1";
Debug.ShouldStop(4096);
_id = RemoteObject.solve(new RemoteObject[] {_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ID", _id);
 BA.debugLineNum = 174;BA.debugLine="SpeciesList_ItemClick (ID,ID)";
Debug.ShouldStop(8192);
_specieslist_itemclick(_id,(_id));
 BA.debugLineNum = 175;BA.debugLine="LoadAttributes(ID)";
Debug.ShouldStop(16384);
_loadattributes(_id);
 BA.debugLineNum = 177;BA.debugLine="Return";
Debug.ShouldStop(65536);
if (true) return RemoteObject.createImmutable("");
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _specieslist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SpeciesList_ItemClick (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,154);
if (RapidSub.canDelegate("specieslist_itemclick")) return sightings.remoteMe.runUserSub(false, "sightings","specieslist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 154;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 155;BA.debugLine="SelectedID = Value -1";
Debug.ShouldStop(67108864);
sightings._selectedid = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _value),RemoteObject.createImmutable(1)}, "-",1, 0));
 BA.debugLineNum = 156;BA.debugLine="If Position = -1 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 157;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 159;BA.debugLine="LoadBirdPic(SelectedID)";
Debug.ShouldStop(1073741824);
_loadbirdpic(sightings._selectedid);
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Time_Click (sightings) ","sightings",3,sightings.mostCurrent.activityBA,sightings.mostCurrent,205);
if (RapidSub.canDelegate("time_click")) return sightings.remoteMe.runUserSub(false, "sightings","time_click");
RemoteObject _timedialog = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");
RemoteObject _dialogret = RemoteObject.createImmutable(0);
 BA.debugLineNum = 205;BA.debugLine="Sub Time_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="Dim TimeDialog As TimeDialog";
Debug.ShouldStop(8192);
_timedialog = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");Debug.locals.put("TimeDialog", _timedialog);
 BA.debugLineNum = 207;BA.debugLine="Dim DialogRet As Int";
Debug.ShouldStop(16384);
_dialogret = RemoteObject.createImmutable(0);Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 209;BA.debugLine="TimeDialog.TimeTicks = DateTime.Now";
Debug.ShouldStop(65536);
_timedialog.runMethod(true,"setTimeTicks",sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 211;BA.debugLine="DialogRet = TimeDialog.Show(\"\",\"Select time\",\"Ok\"";
Debug.ShouldStop(262144);
_dialogret = _timedialog.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Select time")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),sightings.mostCurrent.activityBA,(Object)((sightings.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("DialogRet", _dialogret);
 BA.debugLineNum = 213;BA.debugLine="If DialogRet = DialogResponse.POSITIVE Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_dialogret,BA.numberCast(double.class, sightings.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 214;BA.debugLine="Time.Text = DateTime.Time(TimeDialog.TimeTicks)";
Debug.ShouldStop(2097152);
sightings.mostCurrent._time.runMethod(true,"setText",(sightings.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_timedialog.runMethod(true,"getTimeTicks")))));
 };
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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