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
 * Nom du fichier :    	labo2.arbre.Node
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package arbre;

import java.util.ArrayList;
import java.util.List;
import visitor.*;

// classe decrivant un noeud de l'arbre construit. Permet de set/get les attributs et d'agir sur le noeud, ou de visiter l'arbre.
public abstract class Node implements AcceptVisiteur{
	protected String content;
	protected List<Node> child;
	protected Node parent;
	protected String type;
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getParent() {
		return this.parent;
	}
	
	public void addChild (Node child) {
		this.child.add(child);
	}
	public Node getChild(int indice) {
		return this.child.get(indice);
	}
	
	public void setContent(String content ) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public int getSize() {
		return this.child.size();
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	
	public Node() {
		this.child = new ArrayList<Node>();
	}
	
	// Cette methode permet de visiter tous les enfants du noeuds courant et de recuperer les informations contenues dans ceux-ci. 
	// Elle est utilisee pour constituer le fichier HTML que nous affichons a lecran.
	public void accept(Visiteur visitor) {
		visitor.visit(this);
		for (Node n: this.child) {
			System.out.println("### Nouvel Enfant ###");
			System.out.println("Size: "+ n.getSize());
			if (n.getSize() == 0) {
				/*
				n.accept(visitor);
				System.out.println("In: "+this.getType());
				System.out.println("Enfant visite: "+n.getType());
				*/
				visitor.visit(n);
			}
			else {
				for (int i=0 ; i<n.getSize() ; i++) {
					System.out.println("Enfant n "+ i + " : " + n.getChild(i).getType());
					System.out.println("   Content: " + n.getChild(i).getContent());
					System.out.println("   Objet: "+n.getChild(i));
					System.out.println("   Type: "+n.getChild(i).getType());
					visitor.visit(n.getChild(i));
				}
			}
			
		}
		visitor.getHTML();
	}
	
	
}
	
	

