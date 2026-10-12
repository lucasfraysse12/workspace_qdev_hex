package ctrl;

import hex.PartieHex;

public class Gestionnaire implements GestionnaireDePartie {

	@Override
	public void nouvellePartie(int taillePlateau) {
		PartieHex partie = new PartieHex(taillePlateau);

	}

	@Override
	public void jouer() {
		// TODO Auto-generated method stub

	}

}
