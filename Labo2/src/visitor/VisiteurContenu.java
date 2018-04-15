/****************************************************** 
 * 
 * Cours:				ELE116 
 * Session : 			Hiver
 * ann�e:				2018
 * Groupe:				N/A
 * Projet :            	Laboratoire 2
 * �tudiants:    		Justin Guirautane // Jeffrey Tabet
 * Codes perm. :		GUIJ21099504	//	TABJ01079007
 * Professeur :        	Kim Khoa Nguyen
 * Nom du fichier :    	labo2.visitor.VisiteurContenu
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package visitor;

import arbre.Node;

// Classe qui herite de l'interface Visiteur, utilisee si on choisit d'afficher le livre au complet
public class VisiteurContenu implements Visiteur {
	
	private String texteHTML = "";
	
	// methode permettant de construire le fichier HTML en fonction du type du noeud que l'on visite.
	@Override
	public void visit(Node node) {
		
		if (node.getType().equals("Livre")) {
			System.out.println("Livre Lu");
		}
		
		else if (node.getType().equals("TitreLivre")) {
			this.texteHTML += ("<h1><font size=16>" + node.getContent() + "</font></h1><");
			System.out.println("Titre Livre Lu");
		}
		
		else if (node.getType().equals("Auteur")) {
			this.texteHTML += ("<p><font size=12>" + "Auteur: " + node.getContent() + "</font></p>");
			System.out.println("Auteur Lu");
		}
		
		else if (node.getType().equals("Chapitre")) {
			System.out.println("Chapitre Lu");
		}
		
		else if (node.getType().equals("TitreChapitre")) {
			this.texteHTML += ("<h3><font size=14>" + node.getContent() + "</font></h3>");
			System.out.println("Titre Chapitre Lu");
		}
		
		else if (node.getType().equals("Paragraphe")) {
			this.texteHTML += ("<p><font size=12>" + node.getContent() + "</font></p>");
			System.out.println("Paragraphe Lu");
		}
		
	}
	
	public String getHTML() {
		return this.texteHTML;
	}

}
