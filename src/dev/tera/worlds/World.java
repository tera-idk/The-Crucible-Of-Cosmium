package dev.tera.worlds;

import java.awt.Color;
import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.tile.Tile;
import dev.tera.util.Util;

public class World {

	private Game game;
	private String path;
	
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Game game, String path) {
		this.game = game;
		this.path = path;
		loadWorld(path);
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(205, 133, 63));
		g.fillRect(0, 0, 680, 420);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTileAt(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}
	
	public Tile getTileAt(int x, int y) {
		Tile t =  Tile.tiles[tiles[x][y]];
		if (t == null) return Tile.dirtTile;
		return t;
	}
	
	public void loadWorld(String path) {
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
}
