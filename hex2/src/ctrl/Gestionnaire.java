package ctrl;

import hex.Coords;
import hex.MouvementImpossibleException;
import hex.PartieHex;
import ihm.IHMConsole;

public class Gestionnaire implements GestionnaireDePartie {

	private static Gestionnaire instance = new Gestionnaire();
	private IHMConsole ihm;
	private PartieHex partie;
	 
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
	
	

	@Override
	public void jouer() {

		while (!this.partie.estFini()) {
			ihm.actualiserPlateau(this.partie.getPlateau());
			ihm.afficherInfos(this.partie);
			Coords c = ihm.demanderPlacement(this.partie.getPlateau());
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
