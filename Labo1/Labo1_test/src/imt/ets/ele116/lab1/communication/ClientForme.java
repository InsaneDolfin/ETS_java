package src.imt.ets.ele116.lab1.communication;

import java.awt.Graphics;

public class ClientForme {
	
	private boolean flagEND;
	
	public void update(Graphics g) {
		
	}
	
	public void paint(Graphics g) {
		
	}
	
	public int getID(String str) {
		return Integer.parseInt(str.split(" ")[0]);
	}
	
	
	public static void main(String[] args) {
		CommForme com = new CommForme();
		com.connectionServeur();
		String t = com.recoieChaine();
		com.envoieGET();
		t = com.recoieChaine();
		System.out.println(t);
		
		
	}

}
