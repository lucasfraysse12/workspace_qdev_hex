package it;

import java.util.Iterator;

import hex.Coords;

public class IterateurGrille  implements Iterator<Coords>{
	private int taille;
	private int curseurLig = 0;
	private int curseurCol = 0;
	
	public IterateurGrille(int taille) {
		this.taille = taille;
	}
	
	public boolean hasNext() {
		return curseurLig < taille;
	}
	
	public Coords next() {
		Coords c = new Coords(curseurLig, curseurCol);
		curseurCol ++;
		if (curseurCol == taille) {
			curseurCol = 0;
			curseurLig++;
		}
		return c;
	}
}
