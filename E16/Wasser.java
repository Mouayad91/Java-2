
/**
 * Write a description of class Wasser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wasser extends AlkohlfreiesGetraenk
{
    private String quelle;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable quelle mit default_value erstellt wird.
     */
    public Wasser(){
        this.quelle = null;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable quelle mit dem eingegebenen String erstellt wird.
     * 
     * @param quelle, als Inhalt des Variables quelle
     */
    public Wasser(String quelle){
        setQuelle(quelle);
    }
    
    /**
     * Mit dieser Methode kann man eine neue Quelle setzen.
     * 
     * @param quelle Quelle des Wassers 
     */
    public void setQuelle(String quelle){
        if(quelle == null || quelle.trim().isEmpty()){ // trim to detect blanks
            throw new IllegalArgumentException("Quelle darf nicht leer sein!");
        }else{
            this.quelle = quelle;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man die Quelle zurück.
     * 
     * @return quelle des Wassers
     */
    public String getQuelle(){
        return quelle;
    }
    
    /**
     * Methode gibt die Quelle und den Hersteller des Wassers als String zurück.
     * 
     * @return quelle Quelle des Wassers als String
      * @return getHersteller() Hersteller des Wassers als String
     */
    public String toString(){
        return "Quelle: " + quelle + ", Hersteller: " + getHersteller();
    }
}
