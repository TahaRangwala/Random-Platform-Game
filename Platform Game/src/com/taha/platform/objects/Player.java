package com.taha.platform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.taha.platform.framework.GameObject;
import com.taha.platform.framework.ObjectId;

public class Player extends GameObject{
	
	private float width = 32, height = 64;
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;

	public Player(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		x += velocityX;
		y += velocityY;
		
		if(falling || jumping) {
			velocityY += gravity;
			if(velocityY > MAX_SPEED) {
				velocityY = MAX_SPEED;
			}
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
}