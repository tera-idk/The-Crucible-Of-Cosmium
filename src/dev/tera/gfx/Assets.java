package dev.tera.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import dev.tera.util.FontLoader;
import dev.tera.util.ImageLoader;

public class Assets {
	
	public static final int SPRITE_WIDTH = 32, SPRITE_HEIGHT = 32;

	public static Font titleFont, mainFont, inputFont;
	
	public static BufferedImage grassTile, dirtTile, stoneTile, titleCosmium;
	public static BufferedImage uiPlayButton, uiQuitButton;
	
	public static void init() {
		// Font
		titleFont = FontLoader.loadFont("res/fnt/m3x6.ttf", 123);
		mainFont = FontLoader.loadFont("res/fnt/m3x6.ttf", 63);
		inputFont = FontLoader.loadFont("res/fnt/m3x6.ttf", 53);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("./res/img/sheet.png"));
		SpriteSheet uiSheet = new SpriteSheet(ImageLoader.loadImage("./res/img/ui.png"));
		
		// Tiles
		grassTile = sheet.crop(SPRITE_WIDTH, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		dirtTile = sheet.crop(SPRITE_WIDTH * 2, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		stoneTile = sheet.crop(SPRITE_WIDTH * 3, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		titleCosmium = sheet.crop(0, SPRITE_HEIGHT, SPRITE_WIDTH * 2, SPRITE_HEIGHT * 2);
		
		// UI
		uiPlayButton = uiSheet.crop(0, 0, SPRITE_WIDTH * 2, SPRITE_HEIGHT);
		uiQuitButton = uiSheet.crop(SPRITE_WIDTH * 2, 0, SPRITE_WIDTH * 2, SPRITE_HEIGHT);
	}

}
