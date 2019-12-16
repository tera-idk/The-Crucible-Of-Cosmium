package dev.tera.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private int width, height;
	
	@SuppressWarnings("unused")
	private String title;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		frame = new JFrame(title);
		canvas = new Canvas();
		createDisplay();
	}
	
	private void createDisplay() {
		Dimension size = new Dimension(width, height);
		frame.setSize(size);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		canvas.setPreferredSize(size);
		canvas.setMaximumSize(size);
		canvas.setMinimumSize(size);
		
		frame.add(canvas);
		frame.setVisible(true);
		frame.pack();
	}
	
	public JFrame accessWindow() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
