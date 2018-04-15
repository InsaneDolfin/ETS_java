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
 * Nom du fichier :    	labo2.analyseur.Parser
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/


package analyseur;


import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import arbre.*;

/*
 * Classe permettant de Parser le fichier XML et de constuire un arbre lui correspondant.
 * 
 */
public class Parser implements ContentHandler {
	
	
	private Node livre;
	private Node auteur;
	private Node titreLivre;
	private Node chapitre;
	private Node titreChapitre;
	private Node paragraphe;
	
	private boolean isLivre = false;
	private boolean isAuteur = false;
	private boolean isTitreLivre = false;
	private boolean isChapitre = false;
	private boolean isTitreChapitre = false;
	private boolean isParagraphe = false;
	
	
	
	//Detecter debut d'une balise
	public void startElement (String namespaceURI, String lname, String qname, Attributes attrs) {
		
		isLivre = false;
		isAuteur = false;
		isTitreLivre = false;
		isChapitre = false;
		isTitreChapitre = false;
		isParagraphe = false;
		
		
		
		
		
		if (qname.equals("livre")) {
			livre = new Livre();
			isLivre = true;
		}
		else if (qname.equals("titre_livre")) {
			titreLivre = new TitreLivre();
			titreLivre.setParent(livre);
			isTitreLivre = true;
		}
		else if (qname.equals("auteur")) {
			auteur = new Auteur();
			auteur.setParent(livre);
			isAuteur = true;
		}
		else if (qname.equals("chapitre")) {
			chapitre = new Chapitre();
			chapitre.setParent(livre);
			isChapitre = true;
		}
		else if (qname.equals("titre_chapitre")) {
			titreChapitre = new TitreChapitre();
			titreChapitre.setParent(chapitre);
			isTitreChapitre = true;
		}
		else if (qname.equals("paragraphe")) {
			paragraphe = new Paragraphe();
			paragraphe.setParent(chapitre);
			isParagraphe = true;
		}
	}

	// detecter fin d'une balise
	public void endElement(String uri, String localName, String qName) {
	      		
		if(qName.equals("livre")){
			isLivre = false;
		}
		else if(qName.equals("auteur")){			
	    	  	livre.addChild(auteur);
	    	  	isAuteur = false;
		}
		else if(qName.equals("titre_livre")){
	    	  	livre.addChild(titreLivre);
	    	  	isTitreLivre = false;
		}
		else if(qName.equals("chapitre")){
			livre.addChild(chapitre);
			isChapitre = false;
		}
		else if(qName.equals("titre_chapitre")){
			chapitre.addChild(titreChapitre);
			isTitreChapitre = false;
		}
		else if(qName.equals("paragraphe")){
			chapitre.addChild(paragraphe);
			isParagraphe = false;
		} 
	}

	  
	// On recupere ce qu'il y a entre les balises
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String myContent = new String(ch, start, length);
		
		if (isLivre) {
			livre.setContent(myContent);
			livre.setType("Livre");
		}
		if (isTitreLivre) {
			titreLivre.setContent(myContent);
			titreLivre.setType("TitreLivre");
		}
		if (isAuteur) {
			auteur.setContent(myContent);
			auteur.setType("Auteur");
		}
		if(isChapitre) {
			chapitre.setContent(myContent);
			chapitre.setType("Chapitre");
		}
		if (isTitreChapitre) {
			titreChapitre.setContent(myContent);
			titreChapitre.setType("TitreChapitre");
		}
		if (isParagraphe) {
			paragraphe.setContent(myContent);
			paragraphe.setType("Paragraphe");
		}
		
	}

	
	// permet de recuperer la racine de l'arbre construit pour pouvoir manipuler l'arbre.
	public Node getRoot() {
		return this.livre;
	}
	
	

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	

	

}
