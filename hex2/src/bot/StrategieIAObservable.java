/**
 * 
 */
package bot;

import hex.ia.StrategieIA;

/**
 * StrategieIAObservable
 *
 *
 * @author Pierre PC (IUT de Rodez)
 * @version 1.0
 * @since 3 nov. 2026
 */
public interface StrategieIAObservable extends StrategieIA {

	public void ajouterObservateur(ObservateurStrategieIA obs);
	public void notifierObservateurs();
	
	public String getNom();
	
}
