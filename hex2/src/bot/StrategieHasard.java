/**
 * 
 */
package bot;

import java.util.ArrayList;
import java.util.List;

import hex.Coords;
import hex.Joueur;
import hex.PartieHex;
import hex.PlateauHex;
import hex.ia.StrategieIA;
import util.Pick;

/**
 * Stratégie choisissant une case libre au hasard.
 * 
 * L'algorithme considéré construit la liste des cases disponibles puis en choisit une aléatoirement, donc linéaire en le nombre de cases.
 *
 *
 * @author Pierre PC (IUT de Rodez)
 * @version 1.0
 * @since 3 nov. 2026
 */
public class StrategieHasard implements StrategieIA {

	@Override
	public Coords choisirCase(PartieHex partie) {
		PlateauHex plateau = partie.getPlateau();
		int taillePlateau = plateau.getTaillePlateau();
		
		/* On construit la liste des cases disponibles */
		List<Coords> casesDisponibles = new ArrayList<>();

		for (int i = 0 ; i < taillePlateau ; i++) {
			for (int j = 0 ; j < taillePlateau ; j++) {
				Coords c = new Coords(i,j);
				if (plateau.getCase(c) == Joueur.PERSONNE) {
					casesDisponibles.add(c);
				}
			}
		}

		/* On renvoit l'une des cases disponibles au hasard */
		return Pick.random(casesDisponibles);
	}

}
