
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

public class sightings implements IRemote{
	public static sightings mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public sightings() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("sightings"), "LAW.BirdWatcher.com.sightings");
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
		pcBA = new PCBA(this, sightings.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _maplookupflag = RemoteObject.createImmutable(false);
public static RemoteObject _sightingphotolist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _specieslist = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _addnow = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _flocksize = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _birdappearance = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _weatherconditions = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _time = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _selectedspeciesid = RemoteObject.createImmutable(0);
public static RemoteObject _selectedsightingid = RemoteObject.createImmutable(0);
public static RemoteObject _date = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _mapcheck = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _location = RemoteObject.declareNull("anywheresoftware.b4a.gps.LocationWrapper");
public static RemoteObject _datetimeticks = RemoteObject.createImmutable(0L);
public static RemoteObject _getlocation = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _viewphotos = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sightinglist = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _addphoto = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static LAW.BirdWatcher.com.main _main = null;
public static LAW.BirdWatcher.com.starter _starter = null;
public static LAW.BirdWatcher.com.species _species = null;
public static LAW.BirdWatcher.com.sightingphotos _sightingphotos = null;
public static LAW.BirdWatcher.com.codefunctions _codefunctions = null;
public static LAW.BirdWatcher.com.map _map = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",sightings.mostCurrent._activity,"AddNow",sightings.mostCurrent._addnow,"AddPhoto",sightings.mostCurrent._addphoto,"BirdAppearance",sightings.mostCurrent._birdappearance,"CodeFunctions",Debug.moduleToString(LAW.BirdWatcher.com.codefunctions.class),"Date",sightings.mostCurrent._date,"DateTimeTicks",sightings._datetimeticks,"FlockSize",sightings.mostCurrent._flocksize,"GetLocation",sightings.mostCurrent._getlocation,"Location",sightings.mostCurrent._location,"Main",Debug.moduleToString(LAW.BirdWatcher.com.main.class),"Map",Debug.moduleToString(LAW.BirdWatcher.com.map.class),"MapCheck",sightings.mostCurrent._mapcheck,"MapLookupFlag",sightings._maplookupflag,"SelectedSightingID",sightings._selectedsightingid,"SelectedSpeciesID",sightings._selectedspeciesid,"SightingList",sightings.mostCurrent._sightinglist,"SightingPhotoList",sightings._sightingphotolist,"SightingPhotos",Debug.moduleToString(LAW.BirdWatcher.com.sightingphotos.class),"Species",Debug.moduleToString(LAW.BirdWatcher.com.species.class),"SpeciesList",sightings.mostCurrent._specieslist,"Starter",Debug.moduleToString(LAW.BirdWatcher.com.starter.class),"Time",sightings.mostCurrent._time,"ViewPhotos",sightings.mostCurrent._viewphotos,"WeatherConditions",sightings.mostCurrent._weatherconditions};
}
}