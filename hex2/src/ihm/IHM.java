/**
 * 
 */
package ihm;

import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;
import hex.ia.StrategieIA;

public interface IHM {

	public void actualiserPlateau(PlateauHex plateau);
	public void afficherInfos(PartieHex partie);
	public Coords demanderPlacement(PlateauHex plateau);
	public StrategieIA demanderStrategieJoueur1();
	public StrategieIA demanderStrategieJoueur2();
}

