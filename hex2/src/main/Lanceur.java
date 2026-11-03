/**
 * 
 */
package main;

import ctrl.Gestionnaire;

public class Lanceur {

	public static void main(String[] args) {
		
		Gestionnaire ctrl = Gestionnaire.getInstance();
		
		ctrl.nouvellePartie(10);
		
	
		ctrl.jouer();
	
	}
}
