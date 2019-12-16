package dev.tera.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile stoneTile = new StoneTile(2);
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	protected final int id;
	protected BufferedImage texture;
	
	public Tile(BufferedImage texture, final int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public abstract boolean isSolid();
	public int getTileID() {
		return id;
	}
	
}
