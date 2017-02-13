package LAW.BirdWatcher.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class species_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) return species.remoteMe.runUserSub(false, "species","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"speciesadd\")";
Debug.ShouldStop(1);
species.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("speciesadd")),species.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="Activity.Title = \"Species\"";
Debug.ShouldStop(2);
species.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Species")));
 BA.debugLineNum = 37;BA.debugLine="PopulateList ' Subroutine to populate list from D";
Debug.ShouldStop(16);
_populatelist();
 BA.debugLineNum = 38;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) return species.remoteMe.runUserSub(false, "species","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) return species.remoteMe.runUserSub(false, "species","activity_resume");
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="PopulateList";
Debug.ShouldStop(8388608);
_populatelist();
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbtn_click() throws Exception{
try {
		Debug.PushSubsStack("AddBtn_Click (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,65);
if (RapidSub.canDelegate("addbtn_click")) return species.remoteMe.runUserSub(false, "species","addbtn_click");
RemoteObject _speciessql = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _insertdata = null;
 BA.debugLineNum = 65;BA.debugLine="Sub AddBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="Dim SpeciesSQL As StringBuilder";
Debug.ShouldStop(4);
_speciessql = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("SpeciesSQL", _speciessql);
 BA.debugLineNum = 68;BA.debugLine="Dim InsertData(5) As String";
Debug.ShouldStop(8);
_insertdata = RemoteObject.createNewArray ("String", new int[] {5}, new Object[]{});Debug.locals.put("InsertData", _insertdata);
 BA.debugLineNum = 70;BA.debugLine="SpeciesSQL.Initialize";
Debug.ShouldStop(32);
_speciessql.runVoidMethod ("Initialize");
 BA.debugLineNum = 71;BA.debugLine="InsertData(0) = SpeciesName.Text";
Debug.ShouldStop(64);
_insertdata.setArrayElement (species.mostCurrent._speciesname.runMethod(true,"getText"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 72;BA.debugLine="InsertData(1) = SpeciesHabitat.Text";
Debug.ShouldStop(128);
_insertdata.setArrayElement (species.mostCurrent._specieshabitat.runMethod(true,"getText"),BA.numberCast(int.class, 1));
 BA.debugLineNum = 73;BA.debugLine="InsertData(2) = SpeciesColour.Text";
Debug.ShouldStop(256);
_insertdata.setArrayElement (species.mostCurrent._speciescolour.runMethod(true,"getText"),BA.numberCast(int.class, 2));
 BA.debugLineNum = 75;BA.debugLine="InsertData(4) = ImageTime";
Debug.ShouldStop(1024);
_insertdata.setArrayElement (BA.NumberToString(species._imagetime),BA.numberCast(int.class, 4));
 BA.debugLineNum = 76;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = -1 Th";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",species.mostCurrent._specieslistview.runMethod(false,"GetItem",(Object)(species._selectedindex)),RemoteObject.createImmutable((-(double) (0 + 1))))) { 
 BA.debugLineNum = 77;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 80;BA.debugLine="If SpeciesListView.GetItem(SelectedIndex) = 0 The";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",species.mostCurrent._specieslistview.runMethod(false,"GetItem",(Object)(species._selectedindex)),RemoteObject.createImmutable((0)))) { 
 BA.debugLineNum = 81;BA.debugLine="SpeciesSQL.Append(\"INSERT INTO Species (Name,Hab";
Debug.ShouldStop(65536);
_speciessql.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("INSERT INTO Species (Name,Habitat,Colour,Appearance,ImagePath) VALUES (?, ?, ?, ?,?)")));
 }else {
 BA.debugLineNum = 83;BA.debugLine="SpeciesSQL.Append(\"UPDATE Species\").Append(CRLF)";
Debug.ShouldStop(262144);
_speciessql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("UPDATE Species"))).runVoidMethod ("Append",(Object)(species.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 84;BA.debugLine="SpeciesSQL.Append(\"SET Name = ?, Habitat = ?, Co";
Debug.ShouldStop(524288);
_speciessql.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("SET Name = ?, Habitat = ?, Colour = ?, Appearance = ?, ImagePath = ?"))).runVoidMethod ("Append",(Object)(species.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 85;BA.debugLine="SpeciesSQL.Append(\"WHERE ID =\" & (ID + 1)).Appen";
Debug.ShouldStop(1048576);
_speciessql.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("WHERE ID ="),(RemoteObject.solve(new RemoteObject[] {species._id,RemoteObject.createImmutable(1)}, "+",1, 1))))).runVoidMethod ("Append",(Object)(species.mostCurrent.__c.getField(true,"CRLF")));
 };
 BA.debugLineNum = 88;BA.debugLine="Starter.database.ExecNonQuery2(SpeciesSQL, Insert";
Debug.ShouldStop(8388608);
species.mostCurrent._starter._database.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString(_speciessql)),(Object)(species.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_insertdata))));
 BA.debugLineNum = 89;BA.debugLine="PopulateList";
Debug.ShouldStop(16777216);
_populatelist();
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
public static RemoteObject  _addphotobtn_click() throws Exception{
try {
		Debug.PushSubsStack("AddPhotoBtn_Click (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,151);
if (RapidSub.canDelegate("addphotobtn_click")) return species.remoteMe.runUserSub(false, "species","addphotobtn_click");
 BA.debugLineNum = 151;BA.debugLine="Sub AddPhotoBtn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="Starter.CC.Show(\"image/*\",\"Choose image\")";
Debug.ShouldStop(8388608);
species.mostCurrent._starter._cc.runVoidMethod ("Show",species.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Choose image")));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("CC_Result (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,155);
if (RapidSub.canDelegate("cc_result")) return species.remoteMe.runUserSub(false, "species","cc_result", _success, _dir, _filename);
RemoteObject _contentpathfile = RemoteObject.createImmutable("");
RemoteObject _filenameindex = RemoteObject.createImmutable(0);
RemoteObject _imgfilename = RemoteObject.createImmutable("");
RemoteObject _imgfolderpath = RemoteObject.createImmutable("");
RemoteObject _sf = RemoteObject.declareNull("adr.stringfunctions.stringfunctions");
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 155;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="If (Success) Then";
Debug.ShouldStop(268435456);
if ((_success).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 159;BA.debugLine="Msgbox(\"Dir: \" & Dir & \" File: \" & FileName, \"Se";
Debug.ShouldStop(1073741824);
species.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dir: "),_dir,RemoteObject.createImmutable(" File: "),_filename)),(Object)(RemoteObject.createImmutable("Selected File - DEFAULT")),species.mostCurrent.activityBA);
 BA.debugLineNum = 161;BA.debugLine="Dim ContentPathFile As String";
Debug.ShouldStop(1);
_contentpathfile = RemoteObject.createImmutable("");Debug.locals.put("ContentPathFile", _contentpathfile);
 BA.debugLineNum = 162;BA.debugLine="Dim FileNameIndex As Int";
Debug.ShouldStop(2);
_filenameindex = RemoteObject.createImmutable(0);Debug.locals.put("FileNameIndex", _filenameindex);
 BA.debugLineNum = 163;BA.debugLine="Dim ImgFileName As String";
Debug.ShouldStop(4);
_imgfilename = RemoteObject.createImmutable("");Debug.locals.put("ImgFileName", _imgfilename);
 BA.debugLineNum = 165;BA.debugLine="Dim ImgFolderPath As String";
Debug.ShouldStop(16);
_imgfolderpath = RemoteObject.createImmutable("");Debug.locals.put("ImgFolderPath", _imgfolderpath);
 BA.debugLineNum = 166;BA.debugLine="Dim sf As StringFunctions";
Debug.ShouldStop(32);
_sf = RemoteObject.createNew ("adr.stringfunctions.stringfunctions");Debug.locals.put("sf", _sf);
 BA.debugLineNum = 167;BA.debugLine="sf.Initialize";
Debug.ShouldStop(64);
_sf.runVoidMethod ("_initialize",species.processBA);
 BA.debugLineNum = 169;BA.debugLine="ContentPathFile = CodeFunctions.GetPathFromConte";
Debug.ShouldStop(256);
_contentpathfile = species.mostCurrent._codefunctions.runMethod(true,"_getpathfromcontentresult",species.mostCurrent.activityBA,(Object)(_filename));Debug.locals.put("ContentPathFile", _contentpathfile);
 BA.debugLineNum = 170;BA.debugLine="ImageTime = DateTime.now";
Debug.ShouldStop(512);
species._imagetime = species.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 171;BA.debugLine="If ContentPathFile = Null Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("n",_contentpathfile)) { 
 BA.debugLineNum = 172;BA.debugLine="Msgbox( \"Please select photo from the photos ap";
Debug.ShouldStop(2048);
species.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Please select photo from the photos app by selecting from drawer on left")),(Object)(RemoteObject.createImmutable("Error")),species.mostCurrent.activityBA);
 BA.debugLineNum = 173;BA.debugLine="AddPhotoBtn_Click";
Debug.ShouldStop(4096);
_addphotobtn_click();
 BA.debugLineNum = 174;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 177;BA.debugLine="FileNameIndex = ContentPathFile.LastIndexOf(\"/\")";
Debug.ShouldStop(65536);
_filenameindex = _contentpathfile.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/")));Debug.locals.put("FileNameIndex", _filenameindex);
 BA.debugLineNum = 178;BA.debugLine="ImgFileName = ContentPathFile.SubString(FileName";
Debug.ShouldStop(131072);
_imgfilename = _contentpathfile.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_filenameindex,RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("ImgFileName", _imgfilename);
 BA.debugLineNum = 179;BA.debugLine="ImgFolderPath = ContentPathFile.SubString2(1,Fil";
Debug.ShouldStop(262144);
_imgfolderpath = _contentpathfile.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(_filenameindex));Debug.locals.put("ImgFolderPath", _imgfolderpath);
 BA.debugLineNum = 181;BA.debugLine="File.Copy(ImgFolderPath,ImgFileName,Main.BirdPho";
Debug.ShouldStop(1048576);
species.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(_imgfolderpath),(Object)(_imgfilename),(Object)(species.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(species._imagetime,RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 183;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(4194304);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 184;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Imag";
Debug.ShouldStop(8388608);
_newbird.runVoidMethod ("InitializeSample",(Object)(species.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(species._imagetime,RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 185;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
Debug.ShouldStop(16777216);
species.mostCurrent._birdphotoview.runMethod(false,"setBitmap",(_newbird.getObject()));
 };
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private SpeciesName As EditText			'<Defining elem";
species.mostCurrent._speciesname = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private SpeciesHabitat As EditText";
species.mostCurrent._specieshabitat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private SpeciesColour As EditText";
species.mostCurrent._speciescolour = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private AddBtn As Button";
species.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private SpeciesListView As ListView";
species.mostCurrent._specieslistview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private ID As Int = 0";
species._id = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 22;BA.debugLine="Private RemoveBtn As Button";
species.mostCurrent._removebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private AddPhotoBtn As Button";
species.mostCurrent._addphotobtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private BirdPhotoView As ImageView 		'</Defining";
species.mostCurrent._birdphotoview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private SelectedIndex As Int = -1";
species._selectedindex = BA.numberCast(int.class, -(double) (0 + 1));
 //BA.debugLineNum = 28;BA.debugLine="Dim ImageTime As Long";
species._imagetime = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loadbirdpick(RemoteObject _birdid) throws Exception{
try {
		Debug.PushSubsStack("LoadBirdPick (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,191);
if (RapidSub.canDelegate("loadbirdpick")) return species.remoteMe.runUserSub(false, "species","loadbirdpick", _birdid);
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _newbird = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("BirdID", _birdid);
 BA.debugLineNum = 191;BA.debugLine="Sub LoadBirdPick(BirdID As Int)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 193;BA.debugLine="Log(BirdID)";
Debug.ShouldStop(1);
species.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_birdid)));
 BA.debugLineNum = 194;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(2);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 195;BA.debugLine="Dim NewBird As Bitmap";
Debug.ShouldStop(4);
_newbird = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("NewBird", _newbird);
 BA.debugLineNum = 196;BA.debugLine="ToastMessageShow(BirdID,True)";
Debug.ShouldStop(8);
species.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.NumberToString(_birdid)),(Object)(species.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 197;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(16);
_speciescursor.setObject(species.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT ID,ImagePath FROM Species WHERE ID = "),_birdid))));
 BA.debugLineNum = 198;BA.debugLine="SpeciesCursor.Position = 0";
Debug.ShouldStop(32);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 199;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 200;BA.debugLine="Log(Main.BirdPhotoPath & SpeciesCursor.GetLong(\"";
Debug.ShouldStop(128);
species.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(species.mostCurrent._main._birdphotopath,_speciescursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("ImagePath"))))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e10) {
			BA.rdebugUtils.runVoidMethod("setLastException",species.processBA, e10.toString()); BA.debugLineNum = 202;BA.debugLine="Log(\"Add new Species\")";
Debug.ShouldStop(512);
species.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Add new Species")));
 };
 BA.debugLineNum = 204;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 205;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,Spec";
Debug.ShouldStop(4096);
_newbird.runVoidMethod ("InitializeSample",(Object)(species.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_speciescursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("ImagePath"))),RemoteObject.createImmutable(".jpg"))),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e15) {
			BA.rdebugUtils.runVoidMethod("setLastException",species.processBA, e15.toString()); BA.debugLineNum = 207;BA.debugLine="NewBird.InitializeSample(Main.BirdPhotoPath,\"0.j";
Debug.ShouldStop(16384);
_newbird.runVoidMethod ("InitializeSample",(Object)(species.mostCurrent._main._birdphotopath),(Object)(BA.ObjectToString("0.jpg")),(Object)(BA.numberCast(int.class, 240)),(Object)(BA.numberCast(int.class, 240)));
 BA.debugLineNum = 208;BA.debugLine="Log(\"Image not Found \" & BirdID)";
Debug.ShouldStop(32768);
species.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Image not Found "),_birdid)));
 BA.debugLineNum = 209;BA.debugLine="ToastMessageShow(\"Image not found\", True)";
Debug.ShouldStop(65536);
species.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Image not found")),(Object)(species.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 212;BA.debugLine="BirdPhotoView.Bitmap = NewBird";
Debug.ShouldStop(524288);
species.mostCurrent._birdphotoview.runMethod(false,"setBitmap",(_newbird.getObject()));
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
public static RemoteObject  _populatelist() throws Exception{
try {
		Debug.PushSubsStack("PopulateList (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,40);
if (RapidSub.canDelegate("populatelist")) return species.remoteMe.runUserSub(false, "species","populatelist");
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 40;BA.debugLine="Sub PopulateList";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(256);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 42;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELEC";
Debug.ShouldStop(512);
_speciescursor.setObject(species.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT ID, Name FROM Species ORDER BY Name ASC"))));
 BA.debugLineNum = 43;BA.debugLine="SpeciesListView.clear 'Clears list";
Debug.ShouldStop(1024);
species.mostCurrent._specieslistview.runVoidMethod ("Clear");
 BA.debugLineNum = 45;BA.debugLine="SpeciesListView.AddSingleLine2(\"<Add Species>\", 0";
Debug.ShouldStop(4096);
species.mostCurrent._specieslistview.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToString("<Add Species>")),(Object)(RemoteObject.createImmutable((0))));
 BA.debugLineNum = 47;BA.debugLine="For i=0 To SpeciesCursor.RowCount-1 ' Loop to pop";
Debug.ShouldStop(16384);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_speciescursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 49;BA.debugLine="SpeciesCursor.Position = i";
Debug.ShouldStop(65536);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 50;BA.debugLine="SpeciesListView.AddSingleLine2(SpeciesCursor.Get";
Debug.ShouldStop(131072);
species.mostCurrent._specieslistview.runVoidMethod ("AddSingleLine2",(Object)(_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))),(Object)((_speciescursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("ID"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 52;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _removebtn_click() throws Exception{
try {
		Debug.PushSubsStack("RemoveBtn_Click (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,129);
if (RapidSub.canDelegate("removebtn_click")) return species.remoteMe.runUserSub(false, "species","removebtn_click");
RemoteObject _deletesqlquery = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 BA.debugLineNum = 129;BA.debugLine="Sub RemoveBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="Dim DeleteSQLQuery As StringBuilder";
Debug.ShouldStop(2);
_deletesqlquery = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("DeleteSQLQuery", _deletesqlquery);
 BA.debugLineNum = 131;BA.debugLine="DeleteSQLQuery.Initialize";
Debug.ShouldStop(4);
_deletesqlquery.runVoidMethod ("Initialize");
 BA.debugLineNum = 132;BA.debugLine="Dim SpeciesCursor As Cursor";
Debug.ShouldStop(8);
_speciescursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("SpeciesCursor", _speciescursor);
 BA.debugLineNum = 134;BA.debugLine="If ID = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",species._id,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 135;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 138;BA.debugLine="DeleteSQLQuery.Append(\"DELETE FROM Species\").Appe";
Debug.ShouldStop(512);
_deletesqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("DELETE FROM Species"))).runVoidMethod ("Append",(Object)(species.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 139;BA.debugLine="DeleteSQLQuery.Append(\"WHERE [ID] = ?\").Append(CR";
Debug.ShouldStop(1024);
_deletesqlquery.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("WHERE [ID] = ?"))).runVoidMethod ("Append",(Object)(species.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 140;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 141;BA.debugLine="SpeciesCursor = Starter.Database.ExecQuery(\"SELE";
Debug.ShouldStop(4096);
_speciescursor.setObject(species.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT ImagePath FROM Species WHERE ID = "),species._id))));
 BA.debugLineNum = 142;BA.debugLine="SpeciesCursor.Position = 0";
Debug.ShouldStop(8192);
_speciescursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 143;BA.debugLine="File.Delete(Main.BirdPhotoPath, SpeciesCursor.Ge";
Debug.ShouldStop(16384);
species.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(species.mostCurrent._main._birdphotopath),(Object)(RemoteObject.concat(_speciescursor.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("ImagePath"))),RemoteObject.createImmutable(".jpg"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e14) {
			BA.rdebugUtils.runVoidMethod("setLastException",species.processBA, e14.toString()); BA.debugLineNum = 145;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(65536);
species.mostCurrent.__c.runVoidMethod ("Log",(Object)(species.mostCurrent.__c.runMethod(false,"LastException",species.mostCurrent.activityBA).runMethod(true,"getMessage")));
 };
 BA.debugLineNum = 147;BA.debugLine="Starter.database.ExecNonQuery2(DeleteSQLQuery,Arr";
Debug.ShouldStop(262144);
species.mostCurrent._starter._database.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString(_deletesqlquery)),(Object)(species.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(species._id)})))));
 BA.debugLineNum = 148;BA.debugLine="StartActivity(\"Species\")";
Debug.ShouldStop(524288);
species.mostCurrent.__c.runVoidMethod ("StartActivity",species.mostCurrent.activityBA,(Object)((RemoteObject.createImmutable("Species"))));
 BA.debugLineNum = 149;BA.debugLine="End Sub";
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
public static RemoteObject  _specieslistview_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SpeciesListView_ItemClick (species) ","species",2,species.mostCurrent.activityBA,species.mostCurrent,92);
if (RapidSub.canDelegate("specieslistview_itemclick")) return species.remoteMe.runUserSub(false, "species","specieslistview_itemclick", _position, _value);
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 92;BA.debugLine="Sub SpeciesListView_ItemClick (Position As Int, Va";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="ID = Value";
Debug.ShouldStop(268435456);
species._id = BA.numberCast(int.class, _value);
 BA.debugLineNum = 94;BA.debugLine="If Position = -1 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 95;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 97;BA.debugLine="SelectedIndex = Position";
Debug.ShouldStop(1);
species._selectedindex = _position;
 BA.debugLineNum = 98;BA.debugLine="If Value <> 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("!",_value,RemoteObject.createImmutable((0)))) { 
 BA.debugLineNum = 99;BA.debugLine="AddBtn.Text = \"Save\"";
Debug.ShouldStop(4);
species.mostCurrent._addbtn.runMethod(true,"setText",RemoteObject.createImmutable(("Save")));
 BA.debugLineNum = 100;BA.debugLine="AddBtn.Width = 200dip";
Debug.ShouldStop(8);
species.mostCurrent._addbtn.runMethod(true,"setWidth",species.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))));
 BA.debugLineNum = 101;BA.debugLine="RemoveBtn.Visible = True";
Debug.ShouldStop(16);
species.mostCurrent._removebtn.runMethod(true,"setVisible",species.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 103;BA.debugLine="AddBtn.Text = \"Add\"";
Debug.ShouldStop(64);
species.mostCurrent._addbtn.runMethod(true,"setText",RemoteObject.createImmutable(("Add")));
 BA.debugLineNum = 104;BA.debugLine="AddBtn.Width = 430dip";
Debug.ShouldStop(128);
species.mostCurrent._addbtn.runMethod(true,"setWidth",species.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 430))));
 BA.debugLineNum = 105;BA.debugLine="RemoveBtn.Visible = False";
Debug.ShouldStop(256);
species.mostCurrent._removebtn.runMethod(true,"setVisible",species.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 107;BA.debugLine="AddBtn.Visible = True";
Debug.ShouldStop(1024);
species.mostCurrent._addbtn.runMethod(true,"setVisible",species.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 109;BA.debugLine="If Position <> 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("!",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 110;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(8192);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 111;BA.debugLine="Cursor = Starter.database.ExecQuery(\"SELECT * FR";
Debug.ShouldStop(16384);
_cursor.setObject(species.mostCurrent._starter._database.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM Species WHERE ID = "),species._id))));
 BA.debugLineNum = 112;BA.debugLine="Cursor.Position = 0";
Debug.ShouldStop(32768);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 113;BA.debugLine="SpeciesName.Text = Cursor.GetString(\"Name\")";
Debug.ShouldStop(65536);
species.mostCurrent._speciesname.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Name")))));
 BA.debugLineNum = 114;BA.debugLine="SpeciesHabitat.Text = Cursor.GetString(\"Habitat\"";
Debug.ShouldStop(131072);
species.mostCurrent._specieshabitat.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Habitat")))));
 BA.debugLineNum = 115;BA.debugLine="SpeciesColour.Text = Cursor.GetString(\"Colour\")";
Debug.ShouldStop(262144);
species.mostCurrent._speciescolour.runMethodAndSync(true,"setText",(_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Colour")))));
 BA.debugLineNum = 117;BA.debugLine="LoadBirdPick(ID)";
Debug.ShouldStop(1048576);
_loadbirdpick(species._id);
 }else {
 BA.debugLineNum = 119;BA.debugLine="SpeciesName.Text = \"\"";
Debug.ShouldStop(4194304);
species.mostCurrent._speciesname.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 120;BA.debugLine="SpeciesHabitat.Text = \"\"";
Debug.ShouldStop(8388608);
species.mostCurrent._specieshabitat.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 121;BA.debugLine="SpeciesColour.Text = \"\"";
Debug.ShouldStop(16777216);
species.mostCurrent._speciescolour.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 123;BA.debugLine="LoadBirdPick(ID)";
Debug.ShouldStop(67108864);
_loadbirdpick(species._id);
 };
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
}