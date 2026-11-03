/**
 * 
 */
package ihm;

import java.util.ArrayList;
import java.util.List;

import bot.FacadeStrategieIA;
//import bot.StrategieHasard;
import bot.StrategieIAObservable;
import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;
import hex.affich.AffichageInformationsDuTour;
import hex.affich.AffichagePlateau;
import hex.affich.DemanderProchainCoup;
import hex.affich.Menu;
import hex.ia.StrategiePCC;
import hex.ia.StrategiePCCCritique;
import hex.ia.StrategiePCCInter;

public class IHMConsole implements IHM {

	@Override
	public void actualiserPlateau(PlateauHex plateau) {
		String str = AffichagePlateau.plateau2string(plateau);
		System.out.println(str);
		System.out.flush();
	}

	@Override
	public void afficherInfos(PartieHex partie) {
		System.out.println("");
		String str = AffichageInformationsDuTour.getStringInfo(partie);
		System.out.println(str);
	}

	@Override
	public Coords demanderPlacement(PlateauHex plateau) {
		return DemanderProchainCoup.promptCase(plateau);
	}

	@Override
	public StrategieIAObservable demanderStrategieJoueur1() {
		return this.demanderStrategie(1);		
	}
	@Override
	public StrategieIAObservable demanderStrategieJoueur2() {
		return this.demanderStrategie(2);
	}
	
	
	
	/**
	 * Affiche le menu et renvoie la stratégie correspnodante (même menu pour chaque joueur)
	 * @param numJoueur Numéro du joueur (pour l'affichage)
	 * @return Stratégie choisie
	 */
	private StrategieIAObservable demanderStrategie (int numJoueur) {
			
		List<String> choixDisponibles = new ArrayList<>();
		choixDisponibles.add("Extrêmement facile");
		choixDisponibles.add("Très facile");
		choixDisponibles.add("Facile");
		choixDisponibles.add("Moyen");
		choixDisponibles.add("Humain");
		
		int i = Menu.promptChoix("Choisir le joueur " + numJoueur + " :", choixDisponibles);
		
		StrategieIAObservable strat;
		
		switch (i) {
		
		case 1:
			strat = new FacadeStrategieIA("Très facile", new StrategiePCC());
			break;
		case 2:
			strat = new FacadeStrategieIA("Facile", new StrategiePCCCritique());
			break;
		case 3:
			strat = new FacadeStrategieIA("Moyen", new StrategiePCCInter());
			break;
		default:
			strat = null;
			break;
		}
		
		return strat;
		
	}

	@Override
	public void notifier(StrategieIAObservable notificateur) {
		System.out.println("La stratégie '" + notificateur.getNom() + "' s'est activée.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
