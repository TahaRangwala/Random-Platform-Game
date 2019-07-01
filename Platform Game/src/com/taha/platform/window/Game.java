package com.taha.platform.window;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
	
	private boolean running = false;
	private Thread thread;
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		System.out.println("Thread has begun");
	}
	
	public static void main (String [] args) {
		new Window(800, 600, "Taha's Platform Game", new Game());
	}
	
}
