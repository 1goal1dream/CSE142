// Thomas You
// CSE142
// 4/11/17
// Create the infamous cafe wall illusion

import java.awt.Color;
import java.awt.Graphics;

public class CafeWall {
	public static final int MORTAR = 2;

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(650, 400);
		panel.setBackground(Color.GRAY);
		Graphics g = panel.getGraphics();
		row(g, 0, 0, 4, 20);
		row(g, 50, 70, 5, 30);
		grid(g, 10, 150, 4, 25, 0);
		grid(g, 400, 20, 2, 35, 35);
		grid(g, 250, 200, 3, 25, 10);
		grid(g, 425, 180, 5, 20, 10);
	}

	// creates a row of alternating black and white boxes.
	public static void row(Graphics g, int x, int y, int pairs, int size) {
		for (int i = 0; i < pairs; i++) {
			int shift = size * 2 * i;
			g.fillRect(x + shift, y, size, size);
			g.setColor(Color.BLUE);
			g.drawLine(x + shift, y, x + size + shift, y + size);
			g.drawLine(x + shift, y + size, x + size + shift, y);
			g.setColor(Color.WHITE);
			g.fillRect(x + size + shift, y, size, size);
			g.setColor(Color.BLACK);
		}
	}

	// uses row method to create a grid with an alternating pattern.
	public static void grid(Graphics g, int x, int y, int pairs, int size, int change) {
		for (int i = 0; i < pairs * 2; i++) {
			row(g, x + (i % 2 * change), y + size * i, pairs, size);
			y = y + MORTAR;
		}
	}
}
