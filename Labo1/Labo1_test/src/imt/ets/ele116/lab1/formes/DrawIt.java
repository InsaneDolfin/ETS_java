package src.imt.ets.ele116.lab1.formes;


/*
 * CODE ORIGINEL VIENT DE:
 * 
 * http://www.codejava.net/java-se/graphics/drawing-lines-examples-with-graphics2d
 */


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


 
/**
 * This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class DrawIt extends JFrame {
	
	
	
	
    public DrawIt() {
        super("Lines Drawing Demo");
 
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        /*
        g2d.drawLine(120, 50, 360, 50);
        g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
        g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
        */
        
        
        /*
        for (int i=0 ; i<10 ; i++) {
        	double c = Math.random();
        	if (c<0.5) {
        		Forme myRect = new Rectangle(10*i,10*i,10*i,10*i);
                myRect.dessine(g2d);
        	}
        	else {
        		Forme myEll = new Ellipse(30*i,30*i,10*i,25*i);
                myEll.dessine(g2d);
        	}
        }
        */
        /*
        g2d.drawLine(100, 150, 200, 150);
        g2d.drawLine(100, 150, 150, 50);
        g2d.drawLine(150, 50, 200,150);
        */
        
        Forme myPoly = new Triangle(100,200,150,150);
        myPoly.dessine(g2d);
        
        Forme myEll = new Ellipse(300,300,100,250);
        myEll.dessine(g2d);
        
        Forme myRect = new Rectangle(100,300,300,400);
        myRect.dessine(g2d);
        
        
        
        
        
 
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
 
    public static void main(String[] args) {
    	
    			
    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawIt().setVisible(true);
            }
        });
    }
}
