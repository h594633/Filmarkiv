package no.hvl.dat102;

import no.hvl.dat102.adt.BSTreADT;

import java.util.Iterator;

//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>,Iterable<T> {

	private int antall;
	/**
	 * @return the rot
	 */
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}
	
	
	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {

		if (p == null){
			return new BinaerTreNode<>(element);
		}if(p.getElement().compareTo(element) > 0){
			p.setVenstre(leggTilRek(p.getVenstre(), element));
		} else if(p.getElement().compareTo(element) <= 0){
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		}

		return p;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		// 
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	@Override
	public T fjernMin() {

		return fjernMinRek(rot);

	}//
	private T fjernMinRek(BinaerTreNode<T> p) {
		BinaerTreNode<T> pvenstre = p.getVenstre();
		T element;
		if(p != null){
			if(pvenstre != null) {
				if(pvenstre.getVenstre() != null){
					return fjernMinRek(pvenstre);
				} else {
					if(pvenstre.getHoyre() == null){
						element = pvenstre.getElement();
						p.setVenstre(null);
						return element;
					} else {
						element = pvenstre.getElement();
						p.setVenstre(pvenstre.getHoyre());
						return element;
					}
				}
			}else{
				element = p.getElement();
				rot = rot.getHoyre();
				return element;
			}
			}

		return null;
	}

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	@Override
	public T fjernMaks() {

		return fjernMaksRek(rot);
	}//
	private T fjernMaksRek(BinaerTreNode<T> p){
		BinaerTreNode<T> phoyre = p.getHoyre();
		T element;
		if(p != null){
			if(phoyre != null) {
				if(phoyre.getHoyre() != null){
					return fjernMaksRek(phoyre);
				} else {
					if(phoyre.getVenstre() == null){
						element = phoyre.getElement();
						p.setHoyre(null);
						return element;
					} else {
						element = phoyre.getElement();
						p.setHoyre(phoyre.getVenstre());
						return element;
					}
				}
			}else{
				element = p.getElement();
				rot = rot.getVenstre();
				return element;
			}
		}

		return null;


	}
	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMin() {

		return (finnMinRek(this.rot));
	}//

	private T finnMinRek(BinaerTreNode<T> p){
		if (p == null){
			return null;
		}
		if(p.getVenstre() == null){
			return p.getElement();
		}
		return finnMinRek(p.getVenstre());

	}
	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	@Override
	public T finnMaks() {

		return finnMaksRek(this.rot);
	}//
	private T finnMaksRek(BinaerTreNode<T> p){
		if(p.getHoyre() == null){
			return p.getElement();
		}
		return finnMaksRek(p.getHoyre());
	}
	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode

		 return finnRek(element, rot);

	}


	public T finnRek(T element, BinaerTreNode<T> a){
		if(a == null){
			return null;
		}
		if (a.getElement().compareTo(element) == 0){
			return a.getElement();
		}
		if(a.getElement().compareTo(element) > 0){
			return finnRek(element, a.getVenstre());
		} else {
			return finnRek(element, a.getHoyre());
		}
	}
	// Den rekursive hjelpemetoden for søking
	


	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO

		BinaerTreNode<T> aktuell = rot;
		while (true) {
			if (aktuell != null) {
				if (aktuell.getElement().compareTo(element) < 0) {
					aktuell = aktuell.getVenstre();
				} else if (aktuell.getElement().compareTo(element) > 0) {
					aktuell = aktuell.getHoyre();
				} else {
					return aktuell.getElement();
				}
			} else {
				System.out.println(element + " finnes ikke i treet!");
				return null;
			}

		}
	}
	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}  
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
		
	}
	public int hoydeRek(BinaerTreNode<T> t){
		if(t == null){
			return -1;
		}
		int vensteHoyde = hoydeRek(t.getVenstre());
		int hoyreHoyde = hoydeRek(t.getHoyre());
		int maxHoyde = Math.max(vensteHoyde, hoyreHoyde);
		return maxHoyde;
	}
}// class
