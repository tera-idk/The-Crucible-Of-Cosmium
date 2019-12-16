package dev.tera.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import dev.tera.util.FontLoader;
import dev.tera.util.ImageLoader;

public class Assets {
	
	private static final int SPRITE_WIDTH = 32, SPRITE_HEIGHT = 32;

	public static Font mainFont;
	
	public static BufferedImage grassTile, dirtTile, stoneTile;
	public static BufferedImage uiPlayButton;
	
	public static void init() {
		// Font
		mainFont = FontLoader.loadFont("res/fnt/m3x6.ttf", 63);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("./res/img/sheet.png"));
		SpriteSheet uiSheet = new SpriteSheet(ImageLoader.loadImage("./res/img/ui.png"));
		
		// Tiles
		grassTile = sheet.crop(SPRITE_WIDTH, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		dirtTile = sheet.crop(SPRITE_WIDTH * 2, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		stoneTile = sheet.crop(SPRITE_WIDTH * 3, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		
		// UI
		uiPlayButton = uiSheet.crop(0, 0, SPRITE_WIDTH * 2, SPRITE_HEIGHT);
	}

}
