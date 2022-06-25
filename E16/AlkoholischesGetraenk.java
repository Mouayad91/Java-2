
/**
 * Abstakte-Klasse zum erstellen und bearbeiten von Alkoholischesgetränke.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public abstract class AlkoholischesGetraenk extends Getraenk
{
    private float alkoholgehalt;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable alkoholgehalt mit default_value erstellt wird.
     * 
     */
    public AlkoholischesGetraenk(){
        this.alkoholgehalt = 0;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable alkoholgehalt mit dem eingegebenen Float erstellt wird.
     * 
     * @param alkoholgehalt, als Inhalt des Variables alkoholgehalt
     */
    public AlkoholischesGetraenk(float alkoholgehalt){
        setAlkoholgehalt(alkoholgehalt);
    }
    
    /**
     * Mit dieser Methode kann man einen neuen Alkoholgehalt setzen.
     * 
     * @param alkoholgehalt 
     */
    public void setAlkoholgehalt(float alkoholgehalt){
        if(alkoholgehalt < 0 ){
            throw new IllegalArgumentException("Alkoholgehalt darf nicht kleiner als 0 sein!");
        }else{
            this.alkoholgehalt = alkoholgehalt;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man den Alkoholgehalt des Alkoholischesgetraenkes.
     * 
     * @return alkoholgehalt des Getraenkes
     */
    public float getAlkoholgehalt(){
        return alkoholgehalt;
    }
    
    /**
     * Methode gibt den Alkoholgehalt des Alkoholischesgetraenkes als String zurück.
     * 
     * @return alkoholgehalt Alkoholgehalt des Getraenkes als String
     */
    public String toString(){
        return "Alkoholgehalt: " + alkoholgehalt;
    }
}
