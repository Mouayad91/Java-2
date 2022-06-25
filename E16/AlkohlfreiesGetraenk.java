
/**
 * Abstakte-Klasse zum erstellen und bearbeiten von Alkohlfreiesgetränke.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public abstract class AlkohlfreiesGetraenk extends Getraenk
{
    private String hersteller;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable hersteller mit default_value erstellt wird.
     *
     */
    public AlkohlfreiesGetraenk(){
        this.hersteller = null;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable hersteller mit dem eingegebenen String erstellt wird.
     * 
     * @param hersteller, als Inhalt des Variables hersteller
     */
    public AlkohlfreiesGetraenk(String hersteller){
        setHersteller(hersteller);
    }
    
    /**
     * Mit dieser Methode kann man einen neuen Hersteller setzen.
     * 
     * @param hersteller 
     */
    public void setHersteller(String hersteller){
        if(hersteller == null || hersteller.trim().isEmpty()){ // trim detects also blanks
            throw new IllegalArgumentException("Hersteller_Name darf nicht leer sein!");
        }else{
            this.hersteller = hersteller;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man den Hersteller des Alkohlfreiesgetraenkes.
     * 
     * @return hersteller des Getraenkes
     */
    public String getHersteller(){
        return hersteller;
    }
    
    /**
     * Methode gibt den hersteller des Alkohlfreiesgetraenkes als String zurück.
     * 
     * @return hersteller Hersteller des Getraenkes als String
     */
    public String toString(){
        return "Hersteller: " + hersteller;
    }
}
