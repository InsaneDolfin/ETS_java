import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Rectangle extends Forme{

	public Rectangle(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public Rectangle2D.Double dessine(Graphics2D g2) {
		Rectangle2D.Double myRectangle = new Rectangle2D.Double(x1, y1, x2-x1, y2-y1);
		//g2.fill(myRectangle);
		//g2.setColor(Color.RED);
		//g2.draw(myRectangle);
		return myRectangle;
	}

}
