/**
 * 
 */
package ihm;

import bot.ObservateurStrategieIA;
import bot.StrategieIAObservable;
import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;

public interface IHM extends ObservateurStrategieIA {

	public void actualiserPlateau(PlateauHex plateau);
	public void afficherInfos(PartieHex partie);
	public Coords demanderPlacement(PlateauHex plateau);
	
	public StrategieIAObservable demanderStrategieJoueur1();
	public StrategieIAObservable demanderStrategieJoueur2();
}

