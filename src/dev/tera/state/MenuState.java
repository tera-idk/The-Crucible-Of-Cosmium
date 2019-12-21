package dev.tera.state;

import java.awt.Color;
import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.gfx.Assets;
import dev.tera.input.ClickListener;
import dev.tera.ui.UIManager;
import dev.tera.ui.button.UITexturedButton;
import dev.tera.util.Util;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager();
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UITexturedButton(100.0f, 200.0f, 128, 64, new ClickListener() {
			@Override
			public void onClick() {
				game.currentState = new GameState(game);
			}
		}, Assets.uiPlayButton));
		uiManager.addObject(new UITexturedButton(100.0f, 300.0f, 128, 64, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(1);
			}
		}, Assets.uiQuitButton));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(159, 99, 39));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(new Color(159, 99, 39).darker());
		g.fillRect(25, 25, Game.WIDTH - 50, Game.HEIGHT - 50);
		g.drawImage(Assets.titleCosmium, 300, 75, Assets.SPRITE_WIDTH * 10, Assets.SPRITE_HEIGHT * 10, null);
		Util.drawString(g, "Crucible of Cosmium", 45, 100, false, Color.WHITE, Assets.titleFont);
		uiManager.render(g);
	}

}
