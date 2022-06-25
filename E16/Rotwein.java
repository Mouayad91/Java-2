
/**
 * Write a description of class Rotwein here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rotwein extends Wein
{
    /**
     * Standard_Konstruktor der Rotwein_Klasse.
     */
    public Rotwein(){
        
    }
    
    /**
     * Methode gibt den Weingut und den Alkoholgehalt des Rotweins als String zurück.
     * 
     * @return getWeingut() Rotweins des Rotweins als String
     * @return getAlkoholgehalt() Alkoholgehalt des Rotweins als String
     */
    public String toString(){
        return "Weingut: " + getWeingut() + ", Alkoholgehalt: " + getAlkoholgehalt();
    }
}
