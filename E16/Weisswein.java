
/**
 * Write a description of class Weisswein here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weisswein extends Wein
{
    /**
     * Standard_Konstruktor der Weisswein_Klasse.
     */
    public Weisswein(){
        
    }
    
    /**
     * Methode gibt den Weingut und den Alkoholgehalt des Weißweins als String zurück.
     * 
     * @return getWeingut() Weingut des Weißweins als String
     * @return getAlkoholgehalt() Alkoholgehalt des Weißweins als String
     */
    public String toString(){
        return "Weingut: " + getWeingut() + ", Alkoholgehalt: " + getAlkoholgehalt();
    }
}
