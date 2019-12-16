package dev.tera.ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {
	
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent me) {
		if (bounds.contains(new Point(me.getX(), me.getY())))
			hovering = true;
		else
			hovering = false;
	}
	
	public void onMouseRelease(MouseEvent me) {
		if (hovering)
			onClick();
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isHovering() {
		return hovering;
	}
	
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}

}
