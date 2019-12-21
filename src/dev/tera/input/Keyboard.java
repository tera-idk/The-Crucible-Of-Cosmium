package dev.tera.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public StringBuilder cmdBuilder;
	public boolean[] keys;
	public boolean up, down, left, right, enter, backspace, clear, escape;
	
	public Keyboard() {
		keys = new boolean[256];
		cmdBuilder = new StringBuilder();
	}

	public void tick() {
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		enter = keys[KeyEvent.VK_ENTER];
		backspace = keys[KeyEvent.VK_BACK_SPACE];
		clear = keys[KeyEvent.VK_CONTROL];
		escape = keys[KeyEvent.VK_ESCAPE];
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		keys[ke.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		keys[ke.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (Character.isAlphabetic(ke.getKeyChar()) || Character.isSpaceChar(ke.getKeyChar()) || Character.isDigit(ke.getKeyChar()) || ke.getKeyChar() == ',') {
			cmdBuilder.append(ke.getKeyChar());
		}
	}

}
