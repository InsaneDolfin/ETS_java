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
 * Nom du fichier :    	labo2.client.Client
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package client;



import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;

import javax.swing.AbstractButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import analyseur.Parser;
import arbre.Node;
import visitor.VisiteurContenu;
import visitor.VisiteurTDM;

// Classe principale de notre programme. Permet d'ouvrir un fichier et d'appeler les bonnes methodes pour afficher la table de matiere ou le contenu du fichier XML
public class Client implements ActionListener {
	
	private JFrame myFrame;
	private static JEditorPane myPane;
	//private JFileChooser chooser;
	//private String title;
	private static File fichier;
	private Node myLivre;
	
	
	// Setup de la fenetre d'affichage
	public Client() {
		myFrame = new JFrame("XML Reader");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPane = new JEditorPane();
		myPane.setContentType("text/html");
		myPane.setEditable(false);
		myPane.setText("Bienvenu !!!");
		
		JMenuBar myBar = new JMenuBar();
		JMenu myMenu = getFileMenu();
		myBar.add(myMenu);
		
		JScrollPane myScroll = new JScrollPane(myPane);
		
		myFrame.getContentPane().add(myScroll);
		myFrame.pack();
		myFrame.setSize(800, 800);
		myFrame.setJMenuBar(myBar);
		myFrame.setVisible(true);
	}
	
	
	
	// Setup du Menu de la fenetre
	private JMenu getFileMenu() {
		JMenu myMenu = new JMenu("Fichier");
		JMenuItem myItem = new JMenuItem("Ouvrir un fichier");
		myItem.addActionListener(this);
	    myMenu.add(myItem); 
	           
	    JMenuItem tableMatiere = new JMenuItem("Table de matiere");
		tableMatiere.addActionListener(this);
		myMenu.add(tableMatiere);
		   
		JMenuItem fullBook = new JMenuItem("Livre au complet");
		fullBook.addActionListener(this);
		myMenu.add(fullBook);
	     
		JMenuItem Close = new JMenuItem("Ferme");
		Close.addActionListener(this);
		myMenu.add(Close);
		   
		return myMenu;
	}




	
	// Permet de realiser des actions en fonction de l'action realisee.
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = ((AbstractButton) e.getSource()).getText();
	      
	    try {
	    if (cmd.equals("Ouvrir un fichier")) {
	        
	        	
	    FileChooser panel = new FileChooser();
	    fichier =  panel.actionPerformed();
	    System.out.println("Ouvert");
				     	 
	     } 
	    
	    // Pour lire le fichier XML, on commence par le Parser (creation de l'arbre), puis on cree un visiteur et on visit chacun des enfants du noeud racine.
	    else if (cmd.equals("Table de matiere")) {
	        	 if (fichier != null) {
	        		 	        		 
	        		 Parser myParser = new Parser();
	        		 XMLReader reader = XMLReaderFactory.createXMLReader();
	        		 reader.setContentHandler(myParser);
	        		 reader.parse(fichier.getName());
	        		 myLivre = myParser.getRoot();
	        		 
		        	 VisiteurTDM lireTDM = new VisiteurTDM();
		        	 		        	 
		        	 myLivre.accept(lireTDM);
		        	 String TableMatiereString = lireTDM.getHTML();
		        	 System.out.println(TableMatiereString);
		        	 myPane.setText("");
		        	 myPane.setText(TableMatiereString);
	        	 }
	        	 else { System.out.println("fichier null"); }
	        	 
	     } 
	    
	     else if (cmd.equals("Livre au complet")) {
	        	 if (fichier != null) {
	        		 Parser myParser = new Parser();
	        		 XMLReader reader = XMLReaderFactory.createXMLReader();
	        		 reader.setContentHandler(myParser);
	        		 reader.parse(fichier.getName());
	        		 myLivre = myParser.getRoot();
	        		 
		        	 VisiteurContenu lireLivre = new VisiteurContenu();
		        	 myLivre.accept(lireLivre);
		        	 String LivreString = lireLivre.getHTML();
		        	 System.out.println(LivreString);
		        	 myPane.setText("");
		        	 myPane.setText(LivreString);
		        	 
	        	 }
	        	 else { System.out.println("fichier null"); }
	     }
	       
	     else if (cmd.equals("Ferme")) {
	        	 System.exit(0);
	     }
	         
	     } catch (Exception f) {
	      	 f.printStackTrace();
	     }
		
	}
	
public static void main(String[] args) throws ParserConfigurationException, SAXException {
		
		
	Client client = new Client();
	fichier = null;
	
	do {}
	while (fichier == null);
	
	
        
        
        
        
        
	}

}
