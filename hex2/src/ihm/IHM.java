package ihm;

import hex.Coords;
import hex.PartieHex;
import hex.PlateauHex;

public interface IHM {
	public void actualiserPlateau(PlateauHex plateau);
	public void afficherInfos(PartieHex partie);
	public Coords demanderPlacement(PlateauHex plateau);
}