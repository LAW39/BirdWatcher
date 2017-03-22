
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

public class sightingphotos implements IRemote{
	public static sightingphotos mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public sightingphotos() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("sightingphotos"), "LAW.BirdWatcher.com.sightingphotos");
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
		pcBA = new PCBA(this, sightingphotos.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sightingphotolist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _sightid = RemoteObject.createImmutable(0);
public static RemoteObject _phototab = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabStripViewPager");
public static RemoteObject _sightingphoto = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _removebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static LAW.BirdWatcher.com.main _main = null;
public static LAW.BirdWatcher.com.starter _starter = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightings _sightings = null;
public static LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public static LAW.BirdWatcher.com.map _map = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",sightingphotos.mostCurrent._activity,"CodeFunctions",Debug.moduleToString(LAW.BirdWatcher.com.codefunctions.class),"Main",Debug.moduleToString(LAW.BirdWatcher.com.main.class),"Map",Debug.moduleToString(LAW.BirdWatcher.com.map.class),"Phototab",sightingphotos.mostCurrent._phototab,"RemoveBtn",sightingphotos.mostCurrent._removebtn,"SightID",sightingphotos._sightid,"SightingPhoto",sightingphotos.mostCurrent._sightingphoto,"SightingPhotoList",sightingphotos._sightingphotolist,"Sightings",Debug.moduleToString(LAW.BirdWatcher.com.sightings.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class),"Starter",Debug.moduleToString(LAW.BirdWatcher.com.starter.class)};
}
}