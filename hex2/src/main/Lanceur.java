/**
 * 
 */
package main;

import ctrl.Gestionnaire;

public class Lanceur {

	public static void main(String[] args) {
		
		Gestionnaire ctrl = Gestionnaire.getInstance();
		
		//AffichageJeton.setAffichageJeton(Joueur.JOUEUR1, "○");
		//AffichageJeton.setAffichageJeton(Joueur.JOUEUR2, "■");
		
		ctrl.nouvellePartie(6);
		
		ctrl.jouer();
	
	}
}
