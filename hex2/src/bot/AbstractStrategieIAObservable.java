package bot;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStrategieIAObservable implements StrategieIAObservable {
	
	private String nom;
	
	List<ObservateurStrategieIA> observateurs = new ArrayList<>();
	
	public AbstractStrategieIAObservable(String nom) {
		this.nom = nom;
	}
	
	public void ajouterObservateur(ObservateurStrategieIA obs) {
		this.observateurs.add(obs);
	}
	
	public void notifierObservateurs() {
		for (ObservateurStrategieIA obs : this.observateurs) {
			obs.notifier(this);
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
}
