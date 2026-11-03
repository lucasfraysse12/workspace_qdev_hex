package bot;

import hex.Coords;
import hex.PartieHex;
import hex.ia.StrategieIA;

public class FacadeStrategieIA extends AbstractStrategieIAObservable {
	
	private String nom;
	
	private StrategieIA strategie;
	
	public FacadeStrategieIA (String nom, StrategieIA strategie) {
		super(nom);
		this.strategie = strategie;
	}

	@Override
	public Coords choisirCase(PartieHex partie) {
		this.notifierObservateurs();
		return this.strategie.choisirCase(partie);
	}

}
