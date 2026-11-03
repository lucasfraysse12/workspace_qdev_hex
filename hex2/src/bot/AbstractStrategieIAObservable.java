/**
 * 
 */
package bot;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractStrategieIAObservable
 *
 *
 * @author Pierre PC (IUT de Rodez)
 * @version 1.0
 * @since 3 nov. 2026
 */
public abstract class AbstractStrategieIAObservable implements StrategieIAObservable {

	private List<ObservateurStrategieIA> observateurs = new ArrayList<>();
	private String nom;
	
	public AbstractStrategieIAObservable(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void ajouterObservateur(ObservateurStrategieIA obs) {
		this.observateurs.add(obs);
	}

	@Override
	public void notifierObservateurs() {
		for (ObservateurStrategieIA obs : this.observateurs ) {
			obs.notifier(this);
		}
	}

	@Override
	public String getNom() {
		return this.nom;
	}

}
