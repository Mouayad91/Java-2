
/**
 * Interface Klasse zum erbung der Methode und Konstanten.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public interface PersonIterator
{
    /**
     * Gibt true zurück, wenn der Iterator weitere Elemente enthält.
     *Ansonsten false.
     * @return true, wenn der Iterator weitere Elemente enthält.
     */
    public boolean hasNext();
    /**
     * Gibt das nächste Person-Objekt zurück
     * @return das nächste Person-Objekt.
     */
    public Person next();
}
