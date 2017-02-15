package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class map_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return map.remoteMe.runUserSub(false, "map","activity_create", _firsttime);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
Debug.ShouldStop(-2147483648);
map.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainScreen")),map.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="Activity.Title = \"Map\"";
Debug.ShouldStop(1);
map.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Map")));
 BA.debugLineNum = 35;BA.debugLine="If MainMap.IsGooglePlayServicesAvailable = False";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",map.mostCurrent._mainmap.runMethod(true,"IsGooglePlayServicesAvailable",map.mostCurrent.activityBA),map.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 36;BA.debugLine="ToastMessageShow(\"Please install Google Play";
Debug.ShouldStop(8);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Please install Google Play Services.")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 39;BA.debugLine="Location.Initialize(0,0)";
Debug.ShouldStop(64);
map._location.runVoidMethod ("Initialize",(Object)(BA.numberCast(double.class, 0)),(Object)(BA.numberCast(double.class, 0)));
 BA.debugLineNum = 42;BA.debugLine="MapSetupCompleted = False";
Debug.ShouldStop(512);
map._mapsetupcompleted = map.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 43;BA.debugLine="MapTimer.Initialize(\"LootTimer\",1000)";
Debug.ShouldStop(1024);
map._maptimer.runVoidMethod ("Initialize",map.processBA,(Object)(BA.ObjectToString("LootTimer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 45;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(4096);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 46;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(8192);
_speciescursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID, Name FROM Species ORDER BY ID ASC"))));
 BA.debugLineNum = 47;BA.debugLine="SpeciesList.clear";
Debug.ShouldStop(16384);
map.mostCurrent._specieslist.runVoidMethod ("Clear");
 BA.debugLineNum = 49;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(65536);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 50;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(131072);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 51;BA.debugLine="SpeciesList.AddSingleLine2(SpeciesCursor.GetStri";
Debug.ShouldStop(262144);
map.mostCurrent._specieslist.runVoidMethod ("AddSingleLine2",(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))),(Object)((_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 53;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,69);
if (RapidSub.canDelegate("activity_pause")) return map.remoteMe.runUserSub(false, "map","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="MapTimer.Enabled = False";
Debug.ShouldStop(32);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,61);
if (RapidSub.canDelegate("activity_resume")) return map.remoteMe.runUserSub(false, "map","activity_resume");
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="If (MapSetupCompleted = False) Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",map._mapsetupcompleted,map.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 64;BA.debugLine="MapTimer.Enabled = True";
Debug.ShouldStop(-2147483648);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"True"));
 };
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
public static RemoteObject  _getlocation() throws Exception{
try {
		Debug.PushSubsStack("GetLocation (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,55);
if (RapidSub.canDelegate("getlocation")) return map.remoteMe.runUserSub(false, "map","getlocation");
 BA.debugLineNum = 55;BA.debugLine="Public Sub GetLocation";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"MainScreen\")";
Debug.ShouldStop(33554432);
map.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainScreen")),map.mostCurrent.activityBA);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private gmap As GoogleMap";
map.mostCurrent._gmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private MapSetupCompleted As Boolean";
map._mapsetupcompleted = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Private MainMap As MapFragment";
map.mostCurrent._mainmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private SpeciesList As ListView";
map.mostCurrent._specieslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private BirdImage As ImageView";
map.mostCurrent._birdimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private MoreInfo As Button";
map.mostCurrent._moreinfo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private DateTime1 As EditText";
map.mostCurrent._datetime1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Name As EditText";
map.mostCurrent._name = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loadbird(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("LoadBird (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,164);
if (RapidSub.canDelegate("loadbird")) return map.remoteMe.runUserSub(false, "map","loadbird", _id);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _mapsql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _errorflag = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _sightingmarker = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper");
Debug.locals.put("ID", _id);
 BA.debugLineNum = 164;BA.debugLine="Sub LoadBird(ID As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="ID = ID +1";
Debug.ShouldStop(16);
_id = RemoteObject.solve(new RemoteObject[] {_id,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ID", _id);
 BA.debugLineNum = 167;BA.debugLine="gmap.Clear";
Debug.ShouldStop(64);
map.mostCurrent._gmap.runVoidMethod ("Clear");
 BA.debugLineNum = 169;BA.debugLine="Name.Text = \"\"";
Debug.ShouldStop(256);
map.mostCurrent._name.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 170;BA.debugLine="DateTime1.Text = \"\"";
Debug.ShouldStop(512);
map.mostCurrent._datetime1.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 172;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(2048);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 173;BA.debugLine="Dim MapSQL As StringBuilder";
Debug.ShouldStop(4096);
_mapsql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 174;BA.debugLine="Dim ErrorFlag As Boolean = False";
Debug.ShouldStop(8192);
_errorflag = map.mostCurrent.__c.getField(true,"False");Debug.locals.put("ErrorFlag", _errorflag);Debug.locals.put("ErrorFlag", _errorflag);
 BA.debugLineNum = 175;BA.debugLine="MapSQL.Initialize";
Debug.ShouldStop(16384);
_mapsql.runVoidMethod ("Initialize");
 BA.debugLineNum = 177;BA.debugLine="MapSQL.Append(\"SELECT * FROM Sightings\").Append(C";
Debug.ShouldStop(65536);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SELECT * FROM Sightings"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 178;BA.debugLine="MapSQL.Append(\"WHERE ID = ?\").Append(CRLF)";
Debug.ShouldStop(131072);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE ID = ?"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 179;BA.debugLine="MapSQL.Append(\"ORDER BY ID Asc\").Append(CRLF)";
Debug.ShouldStop(262144);
_mapsql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("ORDER BY ID Asc"))).runVoidMethod ("Append",(Object)(map.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 180;BA.debugLine="ErrorFlag= False";
Debug.ShouldStop(524288);
_errorflag = map.mostCurrent.__c.getField(true,"False");Debug.locals.put("ErrorFlag", _errorflag);
 BA.debugLineNum = 181;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery2(MapSQ";
Debug.ShouldStop(1048576);
_speciescursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString(_mapsql)),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)}))));
 BA.debugLineNum = 184;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1";
Debug.ShouldStop(8388608);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 186;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(33554432);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 188;BA.debugLine="Dim SightingMarker As Marker";
Debug.ShouldStop(134217728);
_sightingmarker = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.MarkerWrapper");Debug.locals.put("SightingMarker", _sightingmarker);
 BA.debugLineNum = 192;BA.debugLine="Log(\"LAT: \" & SpeciesCursor.GetDouble(\"Lat\"))";
Debug.ShouldStop(-2147483648);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("LAT: "),_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat"))))));
 BA.debugLineNum = 193;BA.debugLine="Log(\"LNG: \" & SpeciesCursor.GetDouble(\"Lng\"))";
Debug.ShouldStop(1);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("LNG: "),_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng"))))));
 BA.debugLineNum = 197;BA.debugLine="If SpeciesCursor.GetDouble(\"Lat\") = \"0\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat"))),BA.numberCast(double.class, "0"))) { 
 BA.debugLineNum = 198;BA.debugLine="If SpeciesCursor.GetDouble(\"Lng\") = \"0\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng"))),BA.numberCast(double.class, "0"))) { 
 BA.debugLineNum = 199;BA.debugLine="ErrorFlag = True";
Debug.ShouldStop(64);
_errorflag = map.mostCurrent.__c.getField(true,"True");Debug.locals.put("ErrorFlag", _errorflag);
 };
 };
 BA.debugLineNum = 204;BA.debugLine="If ErrorFlag = False Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_errorflag,map.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 205;BA.debugLine="SightingMarker = gmap.AddMarker2(SpeciesCursor.";
Debug.ShouldStop(4096);
_sightingmarker = map.mostCurrent._gmap.runMethod(false,"AddMarker2",(Object)(_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lat")))),(Object)(_speciescursor.runMethod(true,"GetDouble",(Object)(RemoteObject.createImmutable("Lng")))),(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("SpeciesID")))),(Object)(map.mostCurrent._gmap.getField(true,"HUE_RED")));Debug.locals.put("SightingMarker", _sightingmarker);
 BA.debugLineNum = 207;BA.debugLine="SightingMarker.Draggable = False";
Debug.ShouldStop(16384);
_sightingmarker.runMethod(true,"setDraggable",map.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 208;BA.debugLine="SightingMarker.Snippet = SpeciesCursor.GetInt(\"";
Debug.ShouldStop(32768);
_sightingmarker.runMethod(true,"setSnippet",BA.NumberToString(_speciescursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("ID")))));
 BA.debugLineNum = 209;BA.debugLine="SightingMarker.Visible = True";
Debug.ShouldStop(65536);
_sightingmarker.runMethod(true,"setVisible",map.mostCurrent.__c.getField(true,"True"));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 213;BA.debugLine="End Sub";
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
public static RemoteObject  _loadbirdpic(RemoteObject _birdid) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPic (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,155);
if (RapidSub.canDelegate("loadbirdpic")) return map.remoteMe.runUserSub(false, "map","loadbirdpic", _birdid);
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("BirdID", _birdid);
 BA.debugLineNum = 155;BA.debugLine="Sub LoadBirdPic(BirdID As Int)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 156;BA.debugLine="BirdID = BirdID +1";
Debug.ShouldStop(134217728);
_birdid = RemoteObject.solve(new RemoteObject[] {_birdid,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("BirdID", _birdid);
 BA.debugLineNum = 158;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(536870912);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 159;BA.debugLine="NewBird.InitializeSample(File.DirAssets,BirdID  &";
Debug.ShouldStop(1073741824);
_newbird.runVoidMethod ("InitializeSample",(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.concat(_birdid,RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 160;BA.debugLine="BirdImage.Bitmap = NewBird";
Debug.ShouldStop(-2147483648);
map.mostCurrent._birdimage.runMethod(false,"setBitmap",(_newbird.getObject()));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
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
public static RemoteObject  _loottimer_tick() throws Exception{
try {
		Debug.PushSubsStack("LootTimer_Tick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,73);
if (RapidSub.canDelegate("loottimer_tick")) return map.remoteMe.runUserSub(false, "map","loottimer_tick");
 BA.debugLineNum = 73;BA.debugLine="Sub LootTimer_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 77;BA.debugLine="If ((gmap.IsInitialized) And (gmap.MyLocation.IsI";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean(".",(map.mostCurrent._gmap.runMethod(true,"IsInitialized"))) && RemoteObject.solveBoolean(".",(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"IsInitialized"))))) { 
 BA.debugLineNum = 78;BA.debugLine="MapSetupCompleted = True";
Debug.ShouldStop(8192);
map._mapsetupcompleted = map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 79;BA.debugLine="MapTimer.Enabled = False";
Debug.ShouldStop(16384);
map._maptimer.runMethod(true,"setEnabled",map.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 82;BA.debugLine="End Sub";
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
public static RemoteObject  _mainmap_longclick(RemoteObject _point) throws Exception{
try {
		Debug.PushSubsStack("MainMap_LongClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,230);
if (RapidSub.canDelegate("mainmap_longclick")) return map.remoteMe.runUserSub(false, "map","mainmap_longclick", _point);
Debug.locals.put("Point", _point);
 BA.debugLineNum = 230;BA.debugLine="Sub MainMap_LongClick (Point As LatLng)";
Debug.ShouldStop(32);
 BA.debugLineNum = 231;BA.debugLine="If GetLocationFlag = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",map._getlocationflag,map.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 232;BA.debugLine="Location = Point";
Debug.ShouldStop(128);
map._location = _point;
 BA.debugLineNum = 233;BA.debugLine="Activity.Finish";
Debug.ShouldStop(256);
map.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _mainmap_markerclick(RemoteObject _selectedmarker) throws Exception{
try {
		Debug.PushSubsStack("MainMap_MarkerClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,128);
if (RapidSub.canDelegate("mainmap_markerclick")) return map.remoteMe.runUserSub(false, "map","mainmap_markerclick", _selectedmarker);
RemoteObject _birdcursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _mapsql = RemoteObject.createImmutable("");
Debug.locals.put("SelectedMarker", _selectedmarker);
 BA.debugLineNum = 128;BA.debugLine="Sub MainMap_MarkerClick (SelectedMarker As Marker)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="Dim BirdCursor As Cursor";
Debug.ShouldStop(2);
_birdcursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("BirdCursor", _birdcursor);
 BA.debugLineNum = 131;BA.debugLine="Dim MapSQL As String";
Debug.ShouldStop(4);
_mapsql = RemoteObject.createImmutable("");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 134;BA.debugLine="If (SelectedMarker.Snippet = \"0\") Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",_selectedmarker.runMethod(true,"getSnippet"),RemoteObject.createImmutable("0")))) { 
 BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"Location new loot to be added";
Debug.ShouldStop(64);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Location new loot to be added at")),(Object)(map.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 136;BA.debugLine="Return True";
Debug.ShouldStop(128);
if (true) return map.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 141;BA.debugLine="MapSQL = \"SELECT * FROM Sightings WHERE ID = ?\"";
Debug.ShouldStop(4096);
_mapsql = BA.ObjectToString("SELECT * FROM Sightings WHERE ID = ?");Debug.locals.put("MapSQL", _mapsql);
 BA.debugLineNum = 143;BA.debugLine="BirdCursor = Starter.Database.ExecQuery2(MapSQL,";
Debug.ShouldStop(16384);
_birdcursor.setObject(map.mostCurrent._starter._database.runMethod(false,"ExecQuery2",(Object)(_mapsql),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_selectedmarker.runMethod(true,"getSnippet")}))));
 BA.debugLineNum = 144;BA.debugLine="BirdCursor.Position = 0";
Debug.ShouldStop(32768);
_birdcursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 147;BA.debugLine="Name.Text = BirdCursor.GetString(\"Weather\")";
Debug.ShouldStop(262144);
map.mostCurrent._name.runMethodAndSync(true,"setText",(_birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Weather")))));
 BA.debugLineNum = 148;BA.debugLine="DateTime1.Text = DateTime.Date(BirdCursor.GetStri";
Debug.ShouldStop(524288);
map.mostCurrent._datetime1.runMethodAndSync(true,"setText",(RemoteObject.concat(map.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(BA.numberCast(long.class, _birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Epoch")))))),RemoteObject.createImmutable(" "),map.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(BA.numberCast(long.class, _birdcursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Epoch")))))))));
 BA.debugLineNum = 152;BA.debugLine="Return True 'stop the little pop up text box from";
Debug.ShouldStop(8388608);
if (true) return map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("MainMap_Ready (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,90);
if (RapidSub.canDelegate("mainmap_ready")) return map.remoteMe.runUserSub(false, "map","mainmap_ready");
 BA.debugLineNum = 90;BA.debugLine="Sub MainMap_Ready";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="gmap = MainMap.GetMap";
Debug.ShouldStop(67108864);
map.mostCurrent._gmap = map.mostCurrent._mainmap.runMethod(false,"GetMap");
 BA.debugLineNum = 93;BA.debugLine="Log(\"Mylocation:\" & gmap.MyLocationEnabled)";
Debug.ShouldStop(268435456);
map.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Mylocation:"),map.mostCurrent._gmap.runMethod(true,"getMyLocationEnabled"))));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
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
public static RemoteObject  _mainscreen_click() throws Exception{
try {
		Debug.PushSubsStack("MainScreen_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,86);
if (RapidSub.canDelegate("mainscreen_click")) return map.remoteMe.runUserSub(false, "map","mainscreen_click");
 BA.debugLineNum = 86;BA.debugLine="Sub MainScreen_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(4194304);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._main.getObject())));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
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
public static RemoteObject  _maptestbutton_click() throws Exception{
try {
		Debug.PushSubsStack("MapTestButton_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,122);
if (RapidSub.canDelegate("maptestbutton_click")) return map.remoteMe.runUserSub(false, "map","maptestbutton_click");
 BA.debugLineNum = 122;BA.debugLine="Sub MapTestButton_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 124;BA.debugLine="SetupMapLocation";
Debug.ShouldStop(134217728);
_setupmaplocation();
 BA.debugLineNum = 126;BA.debugLine="End Sub";
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
public static RemoteObject  _moreinfo_click() throws Exception{
try {
		Debug.PushSubsStack("MoreInfo_Click (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,225);
if (RapidSub.canDelegate("moreinfo_click")) return map.remoteMe.runUserSub(false, "map","moreinfo_click");
 BA.debugLineNum = 225;BA.debugLine="Sub MoreInfo_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="Sightings.MapLookupFlag = True";
Debug.ShouldStop(2);
map.mostCurrent._sightings._maplookupflag = map.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 227;BA.debugLine="StartActivity(Sightings)";
Debug.ShouldStop(4);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._sightings.getObject())));
 BA.debugLineNum = 228;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setupmaplocation() throws Exception{
try {
		Debug.PushSubsStack("SetupMapLocation (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,97);
if (RapidSub.canDelegate("setupmaplocation")) return map.remoteMe.runUserSub(false, "map","setupmaplocation");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _newmapposition = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper");
 BA.debugLineNum = 97;BA.debugLine="Sub SetupMapLocation";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(4);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 103;BA.debugLine="If ((Starter.GPS1.GPSEnabled) And (p.IsAirplaneMo";
Debug.ShouldStop(64);
if ((RemoteObject.solveBoolean(".",(map.mostCurrent._starter._gps1.runMethod(true,"getGPSEnabled"))) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_p.runMethod(true,"IsAirplaneModeOn"),map.mostCurrent.__c.getField(true,"False"))))))) { 
 BA.debugLineNum = 105;BA.debugLine="Dim NewMapPosition As CameraPosition";
Debug.ShouldStop(256);
_newmapposition = RemoteObject.createNew ("anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper");Debug.locals.put("NewMapPosition", _newmapposition);
 BA.debugLineNum = 106;BA.debugLine="NewMapPosition.Initialize(gmap.MyLocation.Latitu";
Debug.ShouldStop(512);
_newmapposition.runVoidMethod ("Initialize",(Object)(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"getLatitude")),(Object)(map.mostCurrent._gmap.runMethod(false,"getMyLocation").runMethod(true,"getLongitude")),(Object)(BA.numberCast(float.class, 12)));
 BA.debugLineNum = 107;BA.debugLine="gmap.MoveCamera(NewMapPosition)";
Debug.ShouldStop(1024);
map.mostCurrent._gmap.runVoidMethod ("MoveCamera",(Object)((_newmapposition.getObject())));
 }else {
 BA.debugLineNum = 109;BA.debugLine="If (p.IsAirplaneModeOn) Then";
Debug.ShouldStop(4096);
if ((_p.runMethod(true,"IsAirplaneModeOn")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"Airplane mode is enabled. Int";
Debug.ShouldStop(8192);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Airplane mode is enabled. Internet connection needed for maps")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 114;BA.debugLine="ToastMessageShow(\"Device GPS is disabled. Pleas";
Debug.ShouldStop(131072);
map.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Device GPS is disabled. Please enable now")),(Object)(map.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 115;BA.debugLine="StartActivity(Starter.GPS1.LocationSettingsInte";
Debug.ShouldStop(262144);
map.mostCurrent.__c.runVoidMethod ("StartActivity",map.mostCurrent.activityBA,(Object)((map.mostCurrent._starter._gps1.runMethod(false,"getLocationSettingsIntent"))));
 };
 };
 BA.debugLineNum = 120;BA.debugLine="End Sub";
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
public static RemoteObject  _specieslist_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SpeciesList_ItemClick (map) ","map",4,map.mostCurrent.activityBA,map.mostCurrent,215);
if (RapidSub.canDelegate("specieslist_itemclick")) return map.remoteMe.runUserSub(false, "map","specieslist_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 215;BA.debugLine="Sub SpeciesList_ItemClick (Position As Int, Value";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="SelectedID = Value -1";
Debug.ShouldStop(8388608);
map._selectedid = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _value),RemoteObject.createImmutable(1)}, "-",1, 0));
 BA.debugLineNum = 217;BA.debugLine="If Position = -1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 218;BA.debugLine="Return";
Debug.ShouldStop(33554432);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 220;BA.debugLine="LoadBirdPic(SelectedID)";
Debug.ShouldStop(134217728);
_loadbirdpic(map._selectedid);
 BA.debugLineNum = 221;BA.debugLine="LoadBird(SelectedID)";
Debug.ShouldStop(268435456);
_loadbird(map._selectedid);
 BA.debugLineNum = 222;BA.debugLine="End Sub";
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
}