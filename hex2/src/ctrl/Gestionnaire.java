package ctrl;

import hex.Coords;
import hex.Joueur;
import hex.MouvementImpossibleException;
import hex.PartieHex;
import hex.ia.StrategieIA;
import hex.ia.StrategiePCC;
import ihm.IHMConsole;

public class Gestionnaire implements GestionnaireDePartie {

	private static Gestionnaire instance = new Gestionnaire();
	private IHMConsole ihm;
	private PartieHex partie;
	private StrategieIA strat2 = new StrategiePCC();
	 
	private Gestionnaire() {
		this.ihm = new IHMConsole();
	}
	
	public static Gestionnaire getInstance() {
			
		return instance;
	}
	
	
	
	
	
	@Override
	public void nouvellePartie(int taillePlateau) {
		this.partie = new PartieHex(taillePlateau);

	}
	
	public void setStrat2(StrategieIA strat2) {
		this.strat2 = strat2;
	}

	@Override
	public void jouer() {

		while (!this.partie.estFini()) {
			ihm.actualiserPlateau(this.partie.getPlateau());
			ihm.afficherInfos(this.partie);
			Coords c;
			if (this.partie.getAQuiDeJouer() == Joueur.JOUEUR2) {
				if (this.strat2!=null) {
					c = ihm.demanderPlacement(this.partie.getPlateau());
				} else {
					c = this.strat2.choisirCase(partie);
				}
				
				
			} else {
				c = ihm.demanderPlacement(this.partie.getPlateau());
			}
			try {
				this.partie.poserJeton(c);
			} catch (MouvementImpossibleException e) {
				System.err.println("Placement impossible");
			}
			
		}
		ihm.actualiserPlateau(this.partie.getPlateau());
		ihm.afficherInfos(this.partie);

	}

}
