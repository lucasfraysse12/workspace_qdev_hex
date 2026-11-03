package bot;

import hex.ia.StrategieIA;

public interface StrategieIAObservable extends StrategieIA {

	 public void ajouterObservateur(ObservateurStrategieIA obs);
	 
	 public void notifierObservateurs();
	 
	 public String getNom();
	 
}
