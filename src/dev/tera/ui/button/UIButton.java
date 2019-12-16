package dev.tera.ui.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.tera.input.ClickListener;
import dev.tera.ui.UIObject;
import dev.tera.util.Util;

public class UIButton extends UIObject {
	
	private ClickListener clickListener;
	
	private String text;
	private Color foregroundCol, backgroundCol, textColour;
	private Font font;
	
	public UIButton(float x, float y, int width, int height, String text, ClickListener clickListener, Color foregroundCol, Color backgroundCol, Font font, Color textColour) {
		super(x, y, width, height);
		this.clickListener = clickListener;
		this.foregroundCol = foregroundCol;
		this.backgroundCol = backgroundCol;
		this.text = text;
		this.font = font;
		this.textColour = textColour;
	}

	@Override
	public void tick() {
		if (text.equals("") || text == null) text = "NoT";
	}

	@Override
	public void render(Graphics g) {
		g.setColor(backgroundCol);
		g.fillRect((int) x - 10, (int) y - 10, width + 20, height + 20);
		g.setColor(foregroundCol);
		g.fillRect((int) x, (int) y, width, height);
		Util.drawString(g, text, (int) x + 50, (int) y + 18, true, textColour, font);
	}

	@Override
	public void onClick() {
		clickListener.onClick();
	}

}
