/**
 * 
 */
package main;

import ctrl.Gestionnaire;

public class MainTestGestionnaire {

	public static void main(String[] args) {

		Gestionnaire ctrl = Gestionnaire.getInstance();
		Gestionnaire ctrl2 = Gestionnaire.getInstance();
		
		System.out.println(ctrl == ctrl2);

	}

}
