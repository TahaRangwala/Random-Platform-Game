package com.taha.platform.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.taha.platform.framework.GameObject;
import com.taha.platform.framework.ObjectId;
import com.taha.platform.window.Handler;

public class Player extends GameObject{
	
	private float width = 48, height = 96;
	
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	
	private Handler handler;

	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
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
		
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block) {
				
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					velocityY = 0;
				}
				
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velocityY = 0;
					falling = false;
					jumping = false;
				}
				else
					falling = true;
				
				//RIGHT
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
				}
				//LEFT
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 32;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		//Collision Box Stuff
		/*Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());*/
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2) - ((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-(width/2/2)), (int)y, (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
	
}