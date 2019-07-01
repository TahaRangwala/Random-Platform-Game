package com.taha.platform.framework;

import java.awt.Graphics;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y;
	protected ObjectId id;
	protected float velocityX = 0, velocityY = 0;
	
	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	
	public abstract float getX();
	public abstract float getY();
	public abstract void setX(float x);
	public abstract void setY(float y);
	
	public abstract float getVelocityX();
	public abstract float getVelocityY();
	public abstract void setVelocityX(float velocityX);
	public abstract void setVelocityY(float velocityY);
	
	public abstract ObjectId getId();
	
}
