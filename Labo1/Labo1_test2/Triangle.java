import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Triangle extends Forme {

	public Triangle(int x1, int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void dessine(Graphics2D g2) {
		Line2D.Double firstLine = new Line2D.Double(x1, y1, x2, y1);
		Line2D.Double secondLine = new Line2D.Double(x1, y1, (x1+x2)/2, y2);
		Line2D.Double thirdLine = new Line2D.Double((x1+x2)/2, y2, x2, y1);
		g2.fill(firstLine);
		g2.fill(secondLine);
		g2.fill(thirdLine);
		g2.setColor(Color.GREEN);
		g2.draw(firstLine);
		g2.draw(secondLine);
		g2.draw(thirdLine);
	}

}
