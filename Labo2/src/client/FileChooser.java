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
 * Nom du fichier :    	labo2.client.FileChooser
 * cr�e :         		2018-02-25
 * Date dern. modif.   	2018-03-11

 * *******************************************************/

package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

// Permet de choisir un fichier dans l'ordinateur, grace a une fenetre de dialogue.
public class FileChooser extends JPanel implements ActionListener {
	
	private JButton go;
	private JFileChooser chooser;
	private String chooserTitle;

	public File actionPerformed() {
		chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File(""));
	    chooser.setDialogTitle(chooserTitle);
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	   
	    chooser.setAcceptAllFileFilterUsed(false);
	 
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    	
	    		System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
	      	System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
	    }	    
	    else {
	    		System.out.println("No Selection ");
	    }
	    
	    return chooser.getSelectedFile();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
