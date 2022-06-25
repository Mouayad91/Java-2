
/**
 * Write a description of class Bier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bier extends AlkoholischesGetraenk
{
    private String brauerei;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable brauerei mit default_value erstellt wird.
     */
    public Bier(){
        this.brauerei = null;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable brauerei mit dem eingegebenen String erstellt wird.
     * 
     * @param brauerei, als Inhalt des Variables brauerei
     */
    public Bier(String brauerei){
        setBrauerei(brauerei);
    }
    
    /**
     * Mit dieser Methode kann man eine neue brauerei setzen.
     * 
     * @param brauerei Brauerei des Biers 
     */
    public void setBrauerei(String brauerei){
        if(brauerei == null || brauerei.trim().isEmpty()){ // trim to detect blanks
            throw new IllegalArgumentException("Brauerei darf nicht leer sein!");
        }else{
            this.brauerei = brauerei;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man die Brauerei zurück.
     * 
     * @return brauerei Brauerei des Biers
     */
    public String getBrauerei(){
        return brauerei;
    }
    
    /**
     * Methode gibt die Brauerei und den Alkoholgehalt des Biers als String zurück.
     * 
     * @return brauerei Brauerei des Biers als String
     * @return getAlkoholgehalt() Alkoholgehalt des Biers als String
     */
    public String toString(){
        return "Brauerei: " + brauerei + ", Alkoholgehalt: " + getAlkoholgehalt();
    }
}
