package src.imt.ets.ele116.lab1.formes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ellipse extends Forme{

	public Ellipse(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void dessine(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.drawOval(x1, y1, x2, y2);
		g2.fillOval(x1, y1, x2, y2);
	}

}
