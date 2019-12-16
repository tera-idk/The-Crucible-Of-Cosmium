package dev.tera.state;

import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Game game) {
		super(game);
		world = new World(game, "res/wrl/world1.wld");
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
