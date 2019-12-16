package dev.tera.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line + "\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
	
	public static void drawString(Graphics g, String text, int x, int y, boolean center, Color c, Font font) {
		g.setColor(c);
		g.setFont(font);
		int xP = x;
		int yP = y;
		if (center) {
			FontMetrics fm = g.getFontMetrics(font);
			xP = x - fm.stringWidth(text) / 2;
			yP = (y - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, xP, yP);
	}
	
}
