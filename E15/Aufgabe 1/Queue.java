
/**
* Interface Klasse zum erbung der Methode und Konstanten.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public interface Queue {
    public void addLast(Object o); //Objekt hinten anfuegen
    public Object removeFirst();   //entferne das erste Element und gibt eine Referenz darauf zurueck
    public Object get(int i);      //Das i-te Element zurueckgeben
    public boolean empty();        //Testen, ob schon Elemente eingefuegt wurden
    public boolean full();         //Testen, ob noch Elemente einfuegbar sind
    public int size();             //Anzahl eingefuegter Elemente
    public int getArrLength();     // Größe des erstellten Arrays
}
