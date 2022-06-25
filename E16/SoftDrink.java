
/**
 * Write a description of class SoftDrink here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SoftDrink extends AlkohlfreiesGetraenk
{
    private float zuckergehalt;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable zuckergehalt mit default_value erstellt wird.
     */
    public SoftDrink(){
        this.zuckergehalt = 0;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable zuckergehalt mit dem eingegebenen Float erstellt wird.
     * 
     * @param zuckergehalt, als Inhalt des Variables zuckergehalt
     */
    public SoftDrink(float zuckergehalt){
        setZuckergehalt(zuckergehalt);
    }
    
    /**
     * Mit dieser Methode kann man einen neuen Zuckergehalt setzen.
     * 
     * @param zuckergehalt Zuckergehalt des Softdrinks 
     */
    public void setZuckergehalt(float zuckergehalt){
        if(zuckergehalt <= 0){ // trim to detect blanks
            throw new IllegalArgumentException("Zuckergehalt darf nicht leer sein!");
        }else{
            this.zuckergehalt = zuckergehalt;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man den Zuckergehalt zurück.
     * 
     * @return zuckergehalt Zuckergehalt des Softdrinks
     */
    public float getZuckergehalt(){
        return zuckergehalt;
    }
    
    /**
     * Methode gibt den Zuckergehalt und den Hersteller des Softdrinks als String zurück.
     * 
     * @return zuckergehalt Zuckergehalt des Softdrinks als String
     * @return getHersteller() Hersteller des Softdrinks als String
     */
    public String toString(){
        return "Zuckergehalt: " + zuckergehalt + ", Hersteller: " + getHersteller();
    }
}
