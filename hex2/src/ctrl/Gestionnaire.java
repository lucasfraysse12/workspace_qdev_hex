/**
 * 
 */
package ctrl;

import bot.StrategieIAObservable;
import hex.Coords;
import hex.Joueur;
import hex.MouvementImpossibleException;
import hex.PartieHex;
import ihm.IHM;
import ihm.IHMConsole;

public class Gestionnaire implements GestionnaireDePartie {
	
	
	private static Gestionnaire instance = new Gestionnaire();
	
	private Gestionnaire() {}
	
	public static Gestionnaire getInstance() {
		return Gestionnaire.instance;
	}
	
	
	
	
	
	
	
	/* Equivalent du modèle */
	private PartieHex partieActuelle;
	
	/* Equivalent de la vue */
	private IHM ihm = new IHMConsole();

	/* Stratégies des joueurs 1 et 2 */
	private StrategieIAObservable strat1;
	private StrategieIAObservable strat2;



	public void setStrat1(StrategieIAObservable strat1) {
		this.strat1 = strat1;
		if (this.strat1 != null) {
			this.strat1.ajouterObservateur(this.ihm);
		}
	}
	public void setStrat2(StrategieIAObservable strat2) {
		this.strat2 = strat2;
		if (this.strat2 != null) {
			this.strat2.ajouterObservateur(this.ihm);
		}
	}
	
	
	
	
	public void nouvellePartie(int taillePlateau) {
		this.partieActuelle = new PartieHex(taillePlateau);
		this.setStrat1(this.ihm.demanderStrategieJoueur1());
		this.setStrat2(this.ihm.demanderStrategieJoueur2());
	}
	

	public void jouer() {
		
		while (! this.partieActuelle.estFini()) {
			
			ihm.actualiserPlateau(this.partieActuelle.getPlateau());
			ihm.afficherInfos(this.partieActuelle);
			
			Coords c;
			
			/* Si c'est à J2 de jouer */
			if (this.partieActuelle.getAQuiDeJouer() == Joueur.JOUEUR2) {
				/* Si c'est un humain */
				if (this.strat2 == null) {
					c = ihm.demanderPlacement(this.partieActuelle.getPlateau());
				}
				/* Si c'est un bot */
				else {
					c = this.strat2.choisirCase(partieActuelle);
				}
			}
			/* Idem pour le joueur 1 */
			else {				
				if (this.strat1 == null) {
					c = ihm.demanderPlacement(this.partieActuelle.getPlateau());
				}
				else {
					c = this.strat1.choisirCase(partieActuelle);
				}
			}
			
			/* Placement effectif du jeton */
			try {
				this.partieActuelle.poserJeton(c);
			} catch (MouvementImpossibleException e) {
				e.printStackTrace();
			}	
			
			/* On attend 0.2 seconde pour l'affichage (lorsque deux bots jouent l'un contre l'autre */
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		ihm.actualiserPlateau(this.partieActuelle.getPlateau());
		ihm.afficherInfos(this.partieActuelle);
	}

	
	
	
	
	
	
	
	
	
	
	
}
