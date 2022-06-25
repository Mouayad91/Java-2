
/**
 * Write a description of class Wein here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wein extends AlkoholischesGetraenk
{
    private String weingut;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable weingut mit default_value erstellt wird.
     */
    public Wein(){
        this.weingut = null;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable weingut mit dem eingegebenen String erstellt wird.
     * 
     * @param weingut, als Inhalt des Variables weingut
     */
    public Wein(String weingut){
        setWeingut(weingut);
    }
    
    /**
     * Mit dieser Methode kann man einen neuen weingut setzen.
     * 
     * @param weingut Weingut des Weins 
     */
    public void setWeingut(String weingut){
        if(weingut == null || weingut.trim().isEmpty()){ // trim to detect blanks
            throw new IllegalArgumentException("Weingut darf nicht leer sein!");
        }else{
            this.weingut = weingut;
        }
    }
    
    /**
     * Mit dieser Methode bekommt man den Weingut zurück.
     * 
     * @return weingut Weingut des Weins
     */
    public String getWeingut(){
        return weingut;
    }
    
    /**
     * Methode gibt den Weingut und den Alkoholgehalt des Weins als String zurück.
     * 
     * @return weingut Weingut des Weins als String
     * @return getAlkoholgehalt() Alkoholgehalt des Weins als String
     */
    public String toString(){
        return "Weingut: " + weingut + ", Alkoholgehalt: " + getAlkoholgehalt();
    }
}
