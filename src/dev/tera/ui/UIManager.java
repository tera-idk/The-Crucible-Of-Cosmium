package dev.tera.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

	private ArrayList<UIObject> objects;
	
	public UIManager() {
		objects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for (UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g) {
		for (UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent me) {
		for (UIObject o : objects)
			o.onMouseMove(me);
	}
	
	public void onMouseRelease(MouseEvent me){
		for(UIObject o : objects)
			o.onMouseRelease(me);
	}
	
	public void addObject(UIObject o){
		objects.add(o);
	}
	
	public void removeObject(UIObject o){
		objects.remove(o);
	}
	
	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
	
}
