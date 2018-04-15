import java.awt.geom.Rectangle2D;

public class MyRectangle {
	
	private Rectangle2D.Double oneRectangle;
	
	public MyRectangle(int CANEVAS_LARGEUR, int CANEVAS_HAUTEUR, int FORME_MAX_LARGEUR, int FORME_MAX_HAUTEUR) {
		this.oneRectangle = new Rectangle2D.Double(
				Math.random() * CANEVAS_LARGEUR,
				Math.random() * CANEVAS_HAUTEUR,
				Math.random() * FORME_MAX_LARGEUR,
				Math.random() * FORME_MAX_HAUTEUR);
	}
	
	public Rectangle2D.Double getIt() {
		return oneRectangle;
	}

}
