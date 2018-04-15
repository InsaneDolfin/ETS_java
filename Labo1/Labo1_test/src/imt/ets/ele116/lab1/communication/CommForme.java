package imt.ets.ele116.lab1.communication;

public class CommForme extends Comm {
	
	String chaine;

	public void envoieGET() {
		this.envoieChaine("GET");
		
	}
	
	public void envoieEND() {
		this.envoieChaine("END");
	}
}
