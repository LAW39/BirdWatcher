
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

public class codefunctions implements IRemote{
	public static codefunctions mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public codefunctions() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, codefunctions.class);
    static {
		mostCurrent = new codefunctions();
        remoteMe = RemoteObject.declareNull("LAW.BirdWatcher.com.codefunctions");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("codefunctions"), "LAW.BirdWatcher.com.codefunctions");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("LAW.BirdWatcher.com.codefunctions"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static LAW.BirdWatcher.com.main _main = null;
public static LAW.BirdWatcher.com.starter _starter = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightings _sightings = null;
public static LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public static LAW.BirdWatcher.com.map _map = null;
  public Object[] GetGlobals() {
		return new Object[] {"Main",Debug.moduleToString(LAW.BirdWatcher.com.main.class),"Map",Debug.moduleToString(LAW.BirdWatcher.com.map.class),"SightingPhotos",Debug.moduleToString(LAW.BirdWatcher.com.sightingphotos.class),"Sightings",Debug.moduleToString(LAW.BirdWatcher.com.sightings.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class),"Starter",Debug.moduleToString(LAW.BirdWatcher.com.starter.class)};
}
}