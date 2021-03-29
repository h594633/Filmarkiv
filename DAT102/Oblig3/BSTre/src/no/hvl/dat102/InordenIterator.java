package no.hvl.dat102;

import java.util.Iterator;
import java.util.Stack;

/**
 * Klassen implementerer en InordenIterator
 *
 */

public class InordenIterator<T> implements Iterator<T>{
 private Stack<BinaerTreNode<T>> s = null;
 private BinaerTreNode<T> aktuell = null;

 // gå helt til venstre
 // stable på venstrebarn

 private BinaerTreNode<T> gaaTilVenstre(BinaerTreNode<T> p){
  if (p == null)
   return null;
  while (p.getVenstre() != null){
   s.push(p);
   p = p.getVenstre();
  }
  return p;
 }

 /**
  * Oppretter en InordenIterator<T>, gaar helt til venstre
  * i bs-treet.
  */
 public InordenIterator(BinaerTreNode<T> rot){
  s = new Stack<BinaerTreNode<T>>();
  aktuell = gaaTilVenstre(rot);
 }

    /**
     * Returnerer sann hvis iterasjonen har flere elementer.
     *
     */
  public boolean hasNext(){
   return (aktuell != null);
  }

    /**
     * Returnerer det neste elementet i iterasjonen hvis det fins.
     *
     */
 public T next() {
  T resultat = null;  
  
  if(hasNext()){  
  resultat = aktuell.getElement();

  if (aktuell.getHoyre() != null) // har et høyre undertre
   // stable på node for venstre undertre
    aktuell = gaaTilVenstre(aktuell.getHoyre());
  else if (!s.isEmpty())
   // ingen høyre undertre
      aktuell = (BinaerTreNode<T>)s.pop();
  else
   aktuell = null;   // slutt på treet  
  }
  return resultat;
 }
 
 
 public void remove() {
  // Ikke implementert
  
 }
 
 
}//
 
