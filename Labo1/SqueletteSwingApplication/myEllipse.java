import java.awt.geom.Ellipse2D;

public class myEllipse {
	
	private Ellipse2D.Double oneEllipse;

	public myEllipse(int CANEVAS_LARGEUR, int CANEVAS_HAUTEUR, int FORME_MAX_LARGEUR, int FORME_MAX_HAUTEUR) {
		this.oneEllipse = new Ellipse2D.Double(
				Math.random() * CANEVAS_LARGEUR,
				Math.random() * CANEVAS_HAUTEUR,
				Math.random() * FORME_MAX_LARGEUR,
				Math.random() * FORME_MAX_HAUTEUR);
	}
	
	public Ellipse2D.Double getIt() {
		return oneEllipse;
	}

}
