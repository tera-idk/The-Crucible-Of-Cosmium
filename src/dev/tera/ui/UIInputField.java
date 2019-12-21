package dev.tera.ui;

import java.awt.Color;
import java.awt.Graphics;

import dev.tera.Game;
import dev.tera.gfx.Assets;
import dev.tera.input.Keyboard;

public class UIInputField extends UIObject {

	private String inputString;
	private float inputX, inputY;
	
	private Color bgCol, textCol;
	private int blinkInterval = 0;
	
	public UIInputField(Game game, String inputString, Color bgCol, Color textCol, float x, float y, int width, int height) {
		super(x, y, width, height);
		inputX = x + 20;
		inputY = y + 35;
		this.inputString = inputString;
		this.bgCol = bgCol;
		this.textCol = textCol;
	}

	@Override
	public void tick() {
		blinkInterval += 5;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(bgCol);
		g.fillRect((int) x, (int) y, width, height);
		g.setFont(Assets.inputFont);
		g.setColor(textCol);
		g.drawString(inputString, (int) inputX, (int) inputY);
		g.setColor(bgCol.darker());
		g.fillRect((int) x, (int) y, 10, height);
		g.setColor(textCol);
		if (blinkInterval >= 120) {
			g.fillRect((int) ((inputX + (inputString.length() * 2.3) * 5.1)), (int) y + 10, 3, height - 20);
			blinkInterval = -5;
		}
	}

	@Override
	public void onClick() {
	}
	
	public void detectInputChanges(Keyboard keyboard) {
		inputString = keyboard.cmdBuilder.toString();
		if (keyboard.backspace && inputString.length() != 0) {
			keyboard.cmdBuilder.deleteCharAt(inputString.length() - 1);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
