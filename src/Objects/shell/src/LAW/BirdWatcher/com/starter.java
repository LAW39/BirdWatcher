
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

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "LAW.BirdWatcher.com.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("LAW.BirdWatcher.com.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _database = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _gps1 = RemoteObject.declareNull("anywheresoftware.b4a.gps.GPS");
public static RemoteObject _cc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _l1 = RemoteObject.declareNull("anywheresoftware.b4a.gps.LocationWrapper");
public static RemoteObject _list = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static LAW.BirdWatcher.com.main _main = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightings _sightings = null;
public static LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public static LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public static LAW.BirdWatcher.com.map _map = null;
  public Object[] GetGlobals() {
		return new Object[] {"CC",starter._cc,"CodeFunctions",Debug.moduleToString(LAW.BirdWatcher.com.codefunctions.class),"database",starter._database,"GPS1",starter._gps1,"L1",starter._l1,"list",starter._list,"Main",Debug.moduleToString(LAW.BirdWatcher.com.main.class),"Map",Debug.moduleToString(LAW.BirdWatcher.com.map.class),"Service",starter.mostCurrent._service,"SightingPhotos",Debug.moduleToString(LAW.BirdWatcher.com.sightingphotos.class),"Sightings",Debug.moduleToString(LAW.BirdWatcher.com.sightings.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class)};
}
}