package dev.tera.state;

import java.awt.Color;
import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.gfx.Assets;
import dev.tera.input.ClickListener;
import dev.tera.ui.UIManager;
import dev.tera.ui.button.UIButton;
import dev.tera.ui.button.UITexturedButton;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager();
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIButton(100.0f, 100.0f, 100, 50, "Play", new ClickListener() {
			@Override
			public void onClick() {
				Game.currentState = new GameState(game);
			}
		}, Color.WHITE, Color.BLACK, Assets.mainFont, Color.BLACK));
		uiManager.addObject(new UIButton(400.0f, 100.0f, 100, 50, "Quit", new ClickListener() {
			@Override
			public void onClick() {
				System.exit(0);
			}
		}, Color.WHITE, Color.BLACK, Assets.mainFont, Color.BLACK));
		uiManager.addObject(new UITexturedButton(100.0f, 250.0f, 128, 64, new ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Clicked textured button.\n");
			}
		}, Assets.uiPlayButton));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(159, 99, 39));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		uiManager.render(g);
	}

}
