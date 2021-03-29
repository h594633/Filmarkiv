package no.hvl.dat102;

//  BinærTreNode.java               
//
//  Representerer en node i et binært tre.
//*******************************************************************

public class BinaerTreNode<T> {
	private T element;
	private BinaerTreNode<T> venstre;
	private BinaerTreNode<T> hoyre;

	/*****************************************************************
	 * Oppretter et nytt tre med spesifisert data.
	 *****************************************************************/
	public BinaerTreNode(T el) {
		element = el;
		venstre = null;
		hoyre = null;
	}

	public BinaerTreNode(T element, BinaerTreNode<T> venstre, BinaerTreNode<T> hoyre) {
		this.element = element;
		this.venstre = venstre;
		this.hoyre = hoyre;
	}

	/******************************************************************/
	/*
	 * Hent- og settmetoder /
	 ******************************************************************/

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return hoyre;
	}

	public void setVenstre(BinaerTreNode<T> ny) {
		venstre = ny;
	}

	public void setHoyre(BinaerTreNode<T> ny) {
		hoyre = ny;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T el) {
		element = el;
	}
}
