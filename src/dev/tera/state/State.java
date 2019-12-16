package dev.tera.state;

import java.awt.Graphics;

import dev.tera.Game;

public abstract class State {
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
