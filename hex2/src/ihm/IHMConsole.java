/**
 * 
 */
package ihm;

import java.util.ArrayList;
import java.util.List;

import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;
import hex.affich.AffichageInformationsDuTour;
import hex.affich.AffichagePlateau;
import hex.affich.DemanderProchainCoup;
import hex.affich.Menu;
import hex.ia.StrategieIA;
import hex.ia.StrategiePCC;
import hex.ia.StrategiePCCCritique;
import hex.ia.StrategiePCCInter;

public class IHMConsole implements IHM {

	@Override
	public void actualiserPlateau(PlateauHex plateau) {
		String str = AffichagePlateau.plateau2string(plateau);
		System.out.println(str);
	}

	@Override
	public void afficherInfos(PartieHex partie) {
		String str = AffichageInformationsDuTour.getStringInfo(partie);
		System.out.println(str);
	}

	@Override
	public Coords demanderPlacement(PlateauHex plateau) {
		return DemanderProchainCoup.promptCase(plateau);
	}

	@Override
	public StrategieIA demanderStrategieJoueur1() {
		return this.demanderStrategie(1);		
	}
	@Override
	public StrategieIA demanderStrategieJoueur2() {
		return this.demanderStrategie(2);
	}
	
	
	
	/**
	 * Affiche le menu et renvoie la stratégie correspnodante (même menu pour chaque joueur)
	 * @param numJoueur Numéro du joueur (pour l'affichage)
	 * @return Stratégie choisie
	 */
	private StrategieIA demanderStrategie (int numJoueur) {
		
		List<String> choixDisponibles = new ArrayList<>();
		choixDisponibles.add("Très facile");
		choixDisponibles.add("Facile");
		choixDisponibles.add("Moyen");
		choixDisponibles.add("Humain");
		
		int i = Menu.promptChoix("Choisir le joueur " + numJoueur + " :", choixDisponibles);
		StrategieIA strat;
		
		switch (i) {
		case 0:
			strat = new StrategiePCC();
			break;
		case 1:
			strat = new StrategiePCCCritique();
			break;
		case 2:
			strat = new StrategiePCCInter();
			break;
		default:
			strat = null;
			break;
		}
		
		return strat;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
