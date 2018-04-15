import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Forme{

	public Ellipse(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void dessine(Graphics2D g2) {
		Ellipse2D.Double myEllipse = new Ellipse2D.Double(x1, y1, x2-x1, y2-y1);
		g2.fill(myEllipse);
		g2.setColor(Color.BLUE);
		g2.draw(myEllipse);
	}

}
