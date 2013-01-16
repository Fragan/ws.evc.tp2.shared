package j3d.abstraction.universe;

import j3d.interfaces.universe.ICamera;
import j3d.interfaces.universe.IObject;
import j3d.interfaces.universe.ISharedUniverse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ASharedUniverse implements ISharedUniverse {

	private Map<String, AObject> objects;
	private Map<String, ACamera> cameras;

	public ASharedUniverse() {
		objects = new HashMap<String, AObject>();
		cameras = new HashMap<String, ACamera>();
	}

	public Collection<AObject> getObjects() {
		return objects.values();
	}

	public Collection<ACamera> getCameras() {
		return cameras.values();
	}

	public boolean add(AObject object) {
		if (getObject(object.getName()) != null) {
			System.err.println("The object " + object.getName()
					+ " already included in the universe");
			return false;
		}
		objects.put(object.getName(), object);
		return true;
	}

	public void remove(AObject object) {
		objects.remove(object.getName());
	}

	public boolean add(ACamera camera) {
		if (getObject(camera.getOwnerName()) != null) {
			System.err.println("The camera " + camera.getOwnerName()
					+ " already included in the universe");
			return false;
		}
		cameras.put(camera.getOwnerName(), camera);
		return true;
	}

	public void remove(ACamera camera) {
		cameras.remove(camera.getOwnerName());
	}

	public AObject getObject(String name) {
		return objects.get(name);
	}

	public ACamera getCamera(String name) {
		return cameras.get(name);
	}

	public void update(ICamera camera) {
		ICamera ourCamera = cameras.get(camera.getOwnerName());
		if (ourCamera != null) {
			ourCamera.setOrientation(camera.getOrientation());
			ourCamera.setPosition(camera.getPosition());
		}
	}

	public void update(IObject object) {
		IObject ourObject = objects.get(object.getName());
		if (ourObject != null) {
			ourObject.setOrientation(object.getOrientation());
			ourObject.setPosition(object.getPosition());
		}

	}

}
