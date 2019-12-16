package dev.tera.ui.button;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.tera.input.ClickListener;
import dev.tera.ui.UIObject;

public class UITexturedButton extends UIObject {

	private ClickListener clickListener;
	private BufferedImage texture;
	
	public UITexturedButton(float x, float y, int width, int height, ClickListener clickListener, BufferedImage texture) {
		super(x, y, width, height);
		this.clickListener = clickListener;
		this.texture = texture;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clickListener.onClick();
	}

}
