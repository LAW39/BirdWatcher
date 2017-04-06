
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "LAW.BirdWatcher.com.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _birdphotopath = RemoteObject.createImmutable("");
public static RemoteObject _reload_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _speciescursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static LAW.BirdWatcher.com.starter _starter = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightings _sightings = null;
public static LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public static LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public static LAW.BirdWatcher.com.map _map = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"BirdPhotoPath",main._birdphotopath,"CodeFunctions",Debug.moduleToString(LAW.BirdWatcher.com.codefunctions.class),"Map",Debug.moduleToString(LAW.BirdWatcher.com.map.class),"Reload_BTN",main.mostCurrent._reload_btn,"SightingPhotos",Debug.moduleToString(LAW.BirdWatcher.com.sightingphotos.class),"Sightings",Debug.moduleToString(LAW.BirdWatcher.com.sightings.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class),"SpeciesCursor",main.mostCurrent._speciescursor,"Starter",Debug.moduleToString(LAW.BirdWatcher.com.starter.class)};
}
}