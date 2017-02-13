
package LAW.BirdWatcher.com;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class map implements IRemote{
	public static map mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public map() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("map"), "LAW.BirdWatcher.com.map");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, map.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _maptimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _selectedid = RemoteObject.createImmutable(0);
public static RemoteObject _getlocationflag = RemoteObject.createImmutable(false);
public static RemoteObject _location = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.LatLngWrapper");
public static RemoteObject _gmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper");
public static RemoteObject _mapsetupcompleted = RemoteObject.createImmutable(false);
public static RemoteObject _mainmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.MapFragmentWrapper");
public static RemoteObject _specieslist = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _birdimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _moreinfo = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _datetime1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _name = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static LAW.BirdWatcher.com.main _main = null;
public static LAW.BirdWatcher.com.starter _starter = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightings _sightings = null;
public static LAW.BirdWatcher.com.codefunctions _codefunctions = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",map.mostCurrent._activity,"BirdImage",map.mostCurrent._birdimage,"CodeFunctions",Debug.moduleToString(LAW.BirdWatcher.com.codefunctions.class),"DateTime1",map.mostCurrent._datetime1,"GetLocationFlag",map._getlocationflag,"gmap",map.mostCurrent._gmap,"Location",map._location,"Main",Debug.moduleToString(LAW.BirdWatcher.com.main.class),"MainMap",map.mostCurrent._mainmap,"MapSetupCompleted",map._mapsetupcompleted,"MapTimer",map._maptimer,"MoreInfo",map.mostCurrent._moreinfo,"Name",map.mostCurrent._name,"SelectedID",map._selectedid,"Sightings",Debug.moduleToString(LAW.BirdWatcher.com.sightings.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class),"SpeciesList",map.mostCurrent._specieslist,"Starter",Debug.moduleToString(LAW.BirdWatcher.com.starter.class)};
}
}