package com.taha.platform.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.taha.platform.framework.GameObject;
import com.taha.platform.framework.ObjectId;
import com.taha.platform.objects.Block;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createLevel() {
		for(int xx = 0; xx < Game.WIDTH*2; xx += 32)
			addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
		
		//for(int yy = 0; yy < Game.WIDTH+32; yy += 32)
			//addObject(new Block(Game.HEIGHT+170, yy, ObjectId.Block));
		
		for(int zz = 0; zz < Game.WIDTH+32; zz += 32)
			addObject(new Block(Game.HEIGHT-612, zz, ObjectId.Block));
		
		for(int jj = 190; jj < 600; jj += 32)
			addObject(new Block(jj, Game.HEIGHT-200, ObjectId.Block));
	}
	
}
