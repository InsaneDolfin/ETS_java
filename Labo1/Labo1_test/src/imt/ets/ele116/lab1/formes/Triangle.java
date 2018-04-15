package src.imt.ets.ele116.lab1.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends Forme {

	public Triangle(int x1, int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void dessine(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		int[] px = {x1,x2,Math.round((x2-x1)/2)+x1};
		int[] py = {y1,y2,Math.round((x2-x1)/2)};
		Polygon myPoly = new Polygon(px,py,3);
        g2.fill(myPoly);
        g2.draw(myPoly);
	}

}
