package dev.tera.state;

import java.awt.Color;
import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.input.Keyboard;
import dev.tera.ui.UIInputField;
import dev.tera.ui.UIManager;
import dev.tera.worlds.World;

public class GameState extends State {

	private World world;
	private UIManager uiManager;
	
	public GameState(Game game) {
		super(game);
		world = new World(game, "res/wrl/world1.wld");
		uiManager = new UIManager();
		uiManager.addObject(new UIInputField(game, game.getKeyManager().cmdBuilder.toString(), new Color(154, 57, 0), Color.WHITE, 480, 370, 200, 50));
	}
	
	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
		detectKeyChanges(game.getKeyManager());
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		uiManager.render(g);
	}
	
	public void detectKeyChanges(Keyboard keyboard) {
		UIInputField inputField = (UIInputField) uiManager.getObjects().get(0);
		if (inputField != null)
			inputField.detectInputChanges(keyboard);
		else
			System.out.println("Input field is null.\n");
	}

}
