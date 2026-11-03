package it;

import java.util.Iterator;

import hex.Coords;

public class Grille implements Iterable<Coords> {

	private int taille;
	
	public Grille(int taille) {
		this.taille = taille;
	}

	@Override
	public Iterator<Coords> iterator() {
		// TODO Auto-generated method stub
		return new IterateurGrille(taille);
	}
	
	
}
