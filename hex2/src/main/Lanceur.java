package main;

import ctrl.Gestionnaire;
import ctrl.GestionnaireDePartie;

public class Lanceur {
	public static void main (String[] args) {
		Gestionnaire g = Gestionnaire.getInstance();
		g.nouvellePartie(10);
		g.jouer();
	}
}
