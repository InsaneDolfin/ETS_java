package src.imt.ets.ele116.lab1.formes;

import java.awt.Graphics2D;

public abstract class Forme {
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	public abstract void dessine(Graphics2D g2);
}
