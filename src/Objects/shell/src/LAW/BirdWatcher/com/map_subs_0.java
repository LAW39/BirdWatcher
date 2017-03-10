package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class map_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) return map.remoteMe.runUserSub(false, "map","activity_create", _firsttime);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
Debug.ShouldStop(2);
map.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainScreen")),map.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Activity.Title = \"Map\"";
Debug.ShouldStop(4);
map.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Map")));
 BA.debugLineNum = 37;BA.debugLine="If MainMap.IsGooglePlayServicesAvailable = False";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",map.mostCurrent._mainmap.runMethod(true,"IsGooglePlayServicesAvailable",map.mostCurrent.activityBA),map.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 38;BA.debugLine="ToastMessageShow(\"Please install Google Play";
Debug.ShouldStop(32);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please install Google Play Services.")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 42;BA.debugLine="Location.Initialize(0,0)";
Debug.ShouldStop(512);
map._location.runVoidMethod ("Initialize",(Object)(BA.numberCast(double.class, 0)),(Object)(BA.numberCast(double.class, 0)));
 BA.debugLineNum = 45;BA.debugLine="MapSetupCompleted = False";
Debug.ShouldStop(4096);
map._mapsetupcompleted = map.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 46;BA.debugLine="MapTimer.Initialize(\"LootTimer\",1000)";
Debug.ShouldStop(8192);
map._maptimer.runVoidMethod ("Initialize",map.processBA,(Object)(BA.ObjectToString("LootTimer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 48;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(32768);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 49;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(65536);
_speciescursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID, Name FROM Species ORDER BY ID ASC"))));
 BA.debugLineNum = 50;BA.debugLine="SpeciesList.clear";
Debug.ShouldStop(131072);
map.mostCurrent._specieslist.runVoidMethod ("Clear");
 BA.debugLineNum = 52;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(524288);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(1048576);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 54;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStri";
Debug.ShouldStop(2097152);
map.mostCurrent._specieslist.runVoidMethod ("AddSingleLine2",(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))),(Object)((_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 56;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,72);
if (RapidSub.canDelegate("activity_pause")) return map.remoteMe.runUserSub(false, "map","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="MapTimer.Enabled = False";
Debug.ShouldStop(256);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,64);
if (RapidSub.canDelegate("activity_resume")) return map.remoteMe.runUserSub(false, "map","activity_resume");
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="If (MapSetupCompleted = False) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",map._mapsetupcompleted,map.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 67;BA.debugLine="MapTimer.Enabled = True";
Debug.ShouldStop(4);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 70;BA.debugLine="End Sub";
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
public static RemoteObject  _getlocation() throws Exception{
try {
		Debug.PushSubsStack("GetLocation (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,58);
if (RapidSub.canDelegate("getlocation")) return map.remoteMe.runUserSub(false, "map","getlocation");
 BA.debugLineNum = 58;BA.debugLine="Public Sub GetLocation";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 61;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
Debug.ShouldStop(268435456);
map.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainScreen")),map.mostCurrent.activityBA);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private gmap As GoogleMap";
map.mostCurrent._gmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private MapSetupCompleted As Boolean";
map._mapsetupcompleted = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Private MainMap As MapFragment";
map.mostCurrent._mainmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private SpeciesList As ListView";
map.mostCurrent._specieslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private BirdImage As ImageView";
map.mostCurrent._birdimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private MoreInfo As Button";
map.mostCurrent._moreinfo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private DateTime1 As EditText";
map.mostCurrent._datetime1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Name As EditText";
map.mostCurrent._name = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loadbird(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("LoadBird (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,167);
if (RapidSub.canDelegate("loadbird")) return map.remoteMe.runUserSub(false, "map","loadbird", _id);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _mapsql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _errorflag = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _sightingmarker = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper");
Debug.locals.put("ID", _id);
 BA.debugLineNum = 167;BA.debugLine="Sub LoadBird(ID As Int)";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="ID = ID +1";
Debug.ShouldStop(128);
_id = RemoteObject.solve(new RemoteObject[] {_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ID", _id);
 BA.debugLineNum = 170;BA.debugLine="gmap.Clear";
Debug.ShouldStop(512);
map.mostCurrent._gmap.runVoidMethod ("Clear");
 BA.debugLineNum = 172;BA.debugLine="Name.Text = \"\"";
Debug.ShouldStop(2048);
map.mostCurrent._name.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 173;BA.debugLine="DateTime1.Text = \"\"";
Debug.ShouldStop(4096);
map.mostCurrent._datetime1.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 175;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(16384);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 176;BA.debugLine="Dim MapSQL As StringBuilder";
Debug.ShouldStop(32768);
_mapsql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 177;BA.debugLine="Dim ErrorFlag As Boolean = False";
Debug.ShouldStop(65536);
_errorflag = map.mostCurrent.__c.getField(true,"False");Debug.locals.put("ErrorFlag", _errorflag);Debug.locals.put("ErrorFlag", _errorflag);
 BA.debugLineNum = 178;BA.debugLine="MapSQL.Initialize";
Debug.ShouldStop(131072);
_mapsql.runVoidMethod ("Initialize");
 BA.debugLineNum = 180;BA.debugLine="MapSQL.Append(\"SELECT * FROM Sightings\").Append(C";
Debug.ShouldStop(524288);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT * FROM Sightings"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 181;BA.debugLine="MapSQL.Append(\"WHERE ID = ?\").Append(CRLF)";
Debug.ShouldStop(1048576);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE ID = ?"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 182;BA.debugLine="MapSQL.Append(\"ORDER BY ID Asc\").Append(CRLF)";
Debug.ShouldStop(2097152);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("ORDER BY ID Asc"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 183;BA.debugLine="ErrorFlag= False";
Debug.ShouldStop(4194304);
_errorflag = map.mostCurrent.__c.getField(true,"False");Debug.locals.put("ErrorFlag", _errorflag);
 BA.debugLineNum = 184;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(MapSQ";
Debug.ShouldStop(8388608);
_speciescursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_mapsql)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)}))));
 BA.debugLineNum = 187;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(67108864);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 189;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(268435456);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 191;BA.debugLine="Dim SightingMarker As Marker";
Debug.ShouldStop(1073741824);
_sightingmarker = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper");Debug.locals.put("SightingMarker", _sightingmarker);
 BA.debugLineNum = 195;BA.debugLine="Log(\"LAT: \" & SpeciesCursor.GetDouble(\"Lat\"))";
Debug.ShouldStop(4);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("LAT: "),_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat"))))));
 BA.debugLineNum = 196;BA.debugLine="Log(\"LNG: \" & SpeciesCursor.GetDouble(\"Lng\"))";
Debug.ShouldStop(8);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("LNG: "),_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng"))))));
 BA.debugLineNum = 200;BA.debugLine="If SpeciesCursor.GetDouble(\"Lat\") = \"0\" Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat"))),BA.numberCast(double.class, "0"))) { 
 BA.debugLineNum = 201;BA.debugLine="If SpeciesCursor.GetDouble(\"Lng\") = \"0\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng"))),BA.numberCast(double.class, "0"))) { 
 BA.debugLineNum = 202;BA.debugLine="ErrorFlag = True";
Debug.ShouldStop(512);
_errorflag = map.mostCurrent.__c.getField(true,"True");Debug.locals.put("ErrorFlag", _errorflag);
 };
 };
 BA.debugLineNum = 207;BA.debugLine="If ErrorFlag = False Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_errorflag,map.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 208;BA.debugLine="SightingMarker = gmap.AddMarker2(SpeciesCursor.";
Debug.ShouldStop(32768);
_sightingmarker = map.mostCurrent._gmap.runMethod(false,"AddMarker2",(Object)(_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat")))),(Object)(_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng")))),(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("SpeciesID")))),(Object)(map.mostCurrent._gmap.getField(true,"HUE_RED")));Debug.locals.put("SightingMarker", _sightingmarker);
 BA.debugLineNum = 210;BA.debugLine="SightingMarker.Draggable = False";
Debug.ShouldStop(131072);
_sightingmarker.runMethod(true,"setDraggable",map.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 211;BA.debugLine="SightingMarker.Snippet = SpeciesCursor.GetInt(\"";
Debug.ShouldStop(262144);
_sightingmarker.runMethod(true,"setSnippet",BA.NumberToString(_speciescursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("ID")))));
 BA.debugLineNum = 212;BA.debugLine="SightingMarker.Visible = True";
Debug.ShouldStop(524288);
_sightingmarker.runMethod(true,"setVisible",map.mostCurrent.__c.getField(true,"True"));
 };
 }
}Debug.locals.put("i", _i);
;
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
public static RemoteObject  _loadbirdpic(RemoteObject _birdid) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPic (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,158);
if (RapidSub.canDelegate("loadbirdpic")) return map.remoteMe.runUserSub(false, "map","loadbirdpic", _birdid);
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("BirdID", _birdid);
 BA.debugLineNum = 158;BA.debugLine="Sub LoadBirdPic(BirdID As Int)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 159;BA.debugLine="BirdID = BirdID +1";
Debug.ShouldStop(1073741824);
_birdid = RemoteObject.solve(new RemoteObject[] {_birdid,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("BirdID", _birdid);
 BA.debugLineNum = 161;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(1);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 162;BA.debugLine="NewBird.InitializeSample(File.DirAssets,BirdID  &";
Debug.ShouldStop(2);
_newbird.runVoidMethod ("InitializeSample",(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(_birdid,RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 163;BA.debugLine="BirdImage.Bitmap = NewBird";
Debug.ShouldStop(4);
map.mostCurrent._birdimage.runMethod(false,"setBitmap",(_newbird.getObject()));
 BA.debugLineNum = 165;BA.debugLine="End Sub";
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
public static RemoteObject  _loottimer_tick() throws Exception{
try {
		Debug.PushSubsStack("LootTimer_Tick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,76);
if (RapidSub.canDelegate("loottimer_tick")) return map.remoteMe.runUserSub(false, "map","loottimer_tick");
 BA.debugLineNum = 76;BA.debugLine="Sub LootTimer_Tick";
Debug.ShouldStop(2048);
 BA.debugLineNum = 80;BA.debugLine="If ((gmap.IsInitialized) And (gmap.MyLocation.IsI";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean(".",(map.mostCurrent._gmap.runMethod(true,"IsInitialized"))) && RemoteObject.solveBoolean(".",(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"IsInitialized"))))) { 
 BA.debugLineNum = 81;BA.debugLine="MapSetupCompleted = True";
Debug.ShouldStop(65536);
map._mapsetupcompleted = map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 82;BA.debugLine="MapTimer.Enabled = False";
Debug.ShouldStop(131072);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _mainmap_longclick(RemoteObject _point) throws Exception{
try {
		Debug.PushSubsStack("MainMap_LongClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,237);
if (RapidSub.canDelegate("mainmap_longclick")) return map.remoteMe.runUserSub(false, "map","mainmap_longclick", _point);
Debug.locals.put("Point", _point);
 BA.debugLineNum = 237;BA.debugLine="Sub MainMap_LongClick (Point As LatLng)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="If GetLocationFlag = True Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",map._getlocationflag,map.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 239;BA.debugLine="Location = Point";
Debug.ShouldStop(16384);
map._location = _point;
 BA.debugLineNum = 240;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32768);
map.mostCurrent._activity.runVoidMethod ("Finish");
 };
 BA.debugLineNum = 242;BA.debugLine="End Sub";
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
public static RemoteObject  _mainmap_markerclick(RemoteObject _selectedmarker) throws Exception{
try {
		Debug.PushSubsStack("MainMap_MarkerClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,131);
if (RapidSub.canDelegate("mainmap_markerclick")) return map.remoteMe.runUserSub(false, "map","mainmap_markerclick", _selectedmarker);
RemoteObject _birdcursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _mapsql = RemoteObject.createImmutable("");
Debug.locals.put("SelectedMarker", _selectedmarker);
 BA.debugLineNum = 131;BA.debugLine="Sub MainMap_MarkerClick (SelectedMarker As Marker)";
Debug.ShouldStop(4);
 BA.debugLineNum = 133;BA.debugLine="Dim BirdCursor As Cursor";
Debug.ShouldStop(16);
_birdcursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("BirdCursor", _birdcursor);
 BA.debugLineNum = 134;BA.debugLine="Dim MapSQL As String";
Debug.ShouldStop(32);
_mapsql = RemoteObject.createImmutable("");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 137;BA.debugLine="If (SelectedMarker.Snippet = \"0\") Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",_selectedmarker.runMethod(true,"getSnippet"),RemoteObject.createImmutable("0")))) { 
 BA.debugLineNum = 138;BA.debugLine="ToastMessageShow(\"Location new loot to be added";
Debug.ShouldStop(512);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Location new loot to be added at")),(Object)(map.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 139;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return map.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 144;BA.debugLine="MapSQL = \"SELECT * FROM Sightings WHERE ID = ?\"";
Debug.ShouldStop(32768);
_mapsql = BA.ObjectToString("SELECT * FROM Sightings WHERE ID = ?");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 146;BA.debugLine="BirdCursor = Starter.Database.ExecQuery2(MapSQL,";
Debug.ShouldStop(131072);
_birdcursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(_mapsql),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_selectedmarker.runMethod(true,"getSnippet")}))));
 BA.debugLineNum = 147;BA.debugLine="BirdCursor.Position = 0";
Debug.ShouldStop(262144);
_birdcursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 150;BA.debugLine="Name.Text = BirdCursor.GetString(\"Weather\")";
Debug.ShouldStop(2097152);
map.mostCurrent._name.runMethodAndSync(true,"setText",(_birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Weather")))));
 BA.debugLineNum = 151;BA.debugLine="DateTime1.Text = DateTime.Date(BirdCursor.GetStri";
Debug.ShouldStop(4194304);
map.mostCurrent._datetime1.runMethodAndSync(true,"setText",(RemoteObject.concat(map.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Epoch")))))),RemoteObject.createImmutable(" "),map.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(BA.numberCast(long.class, _birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Epoch")))))))));
 BA.debugLineNum = 153;BA.debugLine="SelectedBird = True";
Debug.ShouldStop(16777216);
map._selectedbird = map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 155;BA.debugLine="Return True 'stop the pop up text box from being";
Debug.ShouldStop(67108864);
if (true) return map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mainmap_ready() throws Exception{
try {
		Debug.PushSubsStack("MainMap_Ready (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,93);
if (RapidSub.canDelegate("mainmap_ready")) return map.remoteMe.runUserSub(false, "map","mainmap_ready");
 BA.debugLineNum = 93;BA.debugLine="Sub MainMap_Ready";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="gmap = MainMap.GetMap";
Debug.ShouldStop(536870912);
map.mostCurrent._gmap = map.mostCurrent._mainmap.runMethod(false,"GetMap");
 BA.debugLineNum = 96;BA.debugLine="Log(\"Mylocation:\" & gmap.MyLocationEnabled)";
Debug.ShouldStop(-2147483648);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Mylocation:"),map.mostCurrent._gmap.runMethod(true,"getMyLocationEnabled"))));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
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
public static RemoteObject  _mainscreen_click() throws Exception{
try {
		Debug.PushSubsStack("MainScreen_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,89);
if (RapidSub.canDelegate("mainscreen_click")) return map.remoteMe.runUserSub(false, "map","mainscreen_click");
 BA.debugLineNum = 89;BA.debugLine="Sub MainScreen_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(33554432);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._main.getObject())));
 BA.debugLineNum = 91;BA.debugLine="End Sub";
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
public static RemoteObject  _maptestbutton_click() throws Exception{
try {
		Debug.PushSubsStack("MapTestButton_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,125);
if (RapidSub.canDelegate("maptestbutton_click")) return map.remoteMe.runUserSub(false, "map","maptestbutton_click");
 BA.debugLineNum = 125;BA.debugLine="Sub MapTestButton_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 127;BA.debugLine="SetupMapLocation";
Debug.ShouldStop(1073741824);
_setupmaplocation();
 BA.debugLineNum = 129;BA.debugLine="End Sub";
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
public static RemoteObject  _moreinfo_click() throws Exception{
try {
		Debug.PushSubsStack("MoreInfo_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,228);
if (RapidSub.canDelegate("moreinfo_click")) return map.remoteMe.runUserSub(false, "map","moreinfo_click");
 BA.debugLineNum = 228;BA.debugLine="Sub MoreInfo_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="If SelectedBird = True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",map._selectedbird,map.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 230;BA.debugLine="Sightings.MapLookupFlag = True";
Debug.ShouldStop(32);
map.mostCurrent._sightings._maplookupflag = map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 231;BA.debugLine="StartActivity(Sightings)";
Debug.ShouldStop(64);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._sightings.getObject())));
 }else {
 BA.debugLineNum = 233;BA.debugLine="Msgbox(\"Please select a sighting using the map a";
Debug.ShouldStop(256);
map.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Please select a sighting using the map above first")),(Object)(RemoteObject.createImmutable("Error")),map.mostCurrent.activityBA);
 };
 BA.debugLineNum = 235;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public MapTimer As Timer";
map._maptimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="Public SelectedID As Int";
map._selectedid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 11;BA.debugLine="Public GetLocationFlag As Boolean = False";
map._getlocationflag = map.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 12;BA.debugLine="Public Location As LatLng";
map._location = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Public SelectedBird As Boolean";
map._selectedbird = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setupmaplocation() throws Exception{
try {
		Debug.PushSubsStack("SetupMapLocation (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,100);
if (RapidSub.canDelegate("setupmaplocation")) return map.remoteMe.runUserSub(false, "map","setupmaplocation");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _newmapposition = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper");
 BA.debugLineNum = 100;BA.debugLine="Sub SetupMapLocation";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(32);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 106;BA.debugLine="If ((Starter.GPS1.GPSEnabled) And (p.IsAirplaneMo";
Debug.ShouldStop(512);
if ((RemoteObject.solveBoolean(".",(map.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"))) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_p.runMethod(true,"IsAirplaneModeOn"),map.mostCurrent.__c.getField(true,"False"))))))) { 
 BA.debugLineNum = 108;BA.debugLine="Dim NewMapPosition As CameraPosition";
Debug.ShouldStop(2048);
_newmapposition = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper");Debug.locals.put("NewMapPosition", _newmapposition);
 BA.debugLineNum = 109;BA.debugLine="NewMapPosition.Initialize(gmap.MyLocation.Latitu";
Debug.ShouldStop(4096);
_newmapposition.runVoidMethod ("Initialize",(Object)(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"getLatitude")),(Object)(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"getLongitude")),(Object)(BA.numberCast(float.class, 12)));
 BA.debugLineNum = 110;BA.debugLine="gmap.MoveCamera(NewMapPosition)";
Debug.ShouldStop(8192);
map.mostCurrent._gmap.runVoidMethod ("MoveCamera",(Object)((_newmapposition.getObject())));
 }else {
 BA.debugLineNum = 112;BA.debugLine="If (p.IsAirplaneModeOn) Then";
Debug.ShouldStop(32768);
if ((_p.runMethod(true,"IsAirplaneModeOn")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Airplane mode is enabled. Int";
Debug.ShouldStop(65536);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Airplane mode is enabled. Internet connection needed for maps")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Device GPS is disabled. Pleas";
Debug.ShouldStop(1048576);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Device GPS is disabled. Please enable now")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 118;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInte";
Debug.ShouldStop(2097152);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 };
 };
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
public static RemoteObject  _specieslist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SpeciesList_ItemClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,218);
if (RapidSub.canDelegate("specieslist_itemclick")) return map.remoteMe.runUserSub(false, "map","specieslist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 218;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="SelectedID = Value -1";
Debug.ShouldStop(67108864);
map._selectedid = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _value),RemoteObject.createImmutable(1)}, "-",1, 0));
 BA.debugLineNum = 220;BA.debugLine="If Position = -1 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 221;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 223;BA.debugLine="LoadBirdPic(SelectedID)";
Debug.ShouldStop(1073741824);
_loadbirdpic(map._selectedid);
 BA.debugLineNum = 224;BA.debugLine="LoadBird(SelectedID)";
Debug.ShouldStop(-2147483648);
_loadbird(map._selectedid);
 BA.debugLineNum = 225;BA.debugLine="End Sub";
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
}