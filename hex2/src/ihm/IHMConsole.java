package ihm;

import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;
import hex.affich.AffichageInformationsDuTour;
import hex.affich.AffichagePlateau;
import hex.affich.DemanderProchainCoup;
import hex.ia.StrategieIA;

public class IHMConsole implements IHM {

	@Override
	public void actualiserPlateau(PlateauHex plateau) {
		System.out.println(AffichagePlateau.plateau2string(plateau));

	}

	@Override
	public void afficherInfos(PartieHex partie) {
		System.out.println(AffichageInformationsDuTour.getStringInfo(partie));

	}

	@Override
	public Coords demanderPlacement(PlateauHex plateau) {
		return DemanderProchainCoup.promptCase(plateau);
		
	}
	
	public StrategieIA demanderStrategieJoueur2() {
		List<String> choixDisponibles = new ArrayList<>();
	}

}
