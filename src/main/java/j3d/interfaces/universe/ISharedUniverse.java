package j3d.interfaces.universe;

import j3d.abstraction.universe.ACamera;
import j3d.abstraction.universe.AObject;

import java.util.Collection;

public interface ISharedUniverse {
	
	public Collection<AObject> getObjects();
	
	public Collection<ACamera> getCameras();	
	
	public boolean add(AObject object);
	
	public void remove(AObject object);
	
	public boolean add(ACamera camera);
	
	public void remove(ACamera camera);
	
	public AObject getObject(String name);

	public ACamera getCamera(String name);
	
	public void update(ICamera camera);
	
	public void update(IObject object);

}
