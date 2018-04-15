import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Forme {
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	public abstract Rectangle2D.Double dessine(Graphics2D g2);
}
