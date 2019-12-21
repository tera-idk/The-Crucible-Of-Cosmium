package dev.tera;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.tera.display.Display;
import dev.tera.gfx.Assets;
import dev.tera.input.Keyboard;
import dev.tera.input.MouseManager;
import dev.tera.state.MenuState;
import dev.tera.state.State;

public class Game implements Runnable {
	
	public static final int WIDTH = 680;
	public static final int HEIGHT = 420;
	private static final String TITLE = "The Crucible of Cosmium - V0.1";
	
	private Display display;
	private Keyboard keyManager;
	private MouseManager mouseManager;
	
	public static State currentState;
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		display = new Display(TITLE, WIDTH, HEIGHT);
		keyManager = new Keyboard();
		display.accessWindow().addKeyListener(keyManager);
		mouseManager = new MouseManager();
		display.accessWindow().addMouseListener(mouseManager);
		display.accessWindow().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
	}
	
	private void init() {
		System.out.println("Game started...\n");
		Assets.init();
		currentState = new MenuState(this);
	}

	private void tick() {
		/***
		 * Update/Physics code goes here.
		 * Called every frame, 60 times/sec, @ 60FPS.
		 */
		keyManager.tick();
		if (currentState != null) currentState.tick();
	}
	
	private void render() {
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		/***
		 * Rendering code goes here.
		 * Called every frame, 60 times/sec, @ 60FPS.
		 */
		if (currentState != null) currentState.render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
//			if (timer >= 1000000000) {
//				System.out.println("Ticks and Frames: " + ticks);
//				ticks = 0;
//				timer = 0;
//			}
		}
		stop();
	}
	
	public Keyboard getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
