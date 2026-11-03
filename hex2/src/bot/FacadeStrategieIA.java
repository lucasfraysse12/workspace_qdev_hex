/**
 * 
 */
package bot;

import hex.Coords;
import hex.PartieHex;
import hex.ia.StrategieIA;

/**
 * FacadeStrategieIA
 *
 *
 * @author Pierre PC (IUT de Rodez)
 * @version 1.0
 * @since 3 nov. 2026
 */
public class FacadeStrategieIA extends AbstractStrategieIAObservable {
	
	private StrategieIA strategie;

	public FacadeStrategieIA(String nom, StrategieIA strategie) {
		super(nom);
		this.strategie = strategie;
	}
	
	@Override
	public Coords choisirCase(PartieHex partie) {
		this.notifierObservateurs();
		return this.strategie.choisirCase(partie);
	}

}
