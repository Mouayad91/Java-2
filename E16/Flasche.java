
/**
 * Eine Generische_Klasse, die eine Flasche erstellt und bearbeitet.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class Flasche <T extends Getraenk>
{
    private T inhalt;
    
    /**
     * Standard_Konstruktor, in dem das Field_Variable inhalt mit default_value erstellt wird.
     * 
     */
    public Flasche(){
        this.inhalt = null;
    }
    
    /**
     * Konstruktor, in dem das Field_Variable inhalt mit dem eingegebenen_generischen_typ erstellt wird.
     * 
     * @param inhalt, als Inhalt des Variables inhalt
     */
    public Flasche(T inhalt){
        this.inhalt = inhalt;
    }
    
    /**
     * Mit dieser Methode kann man das Field_Variable mit einem eingegebenen Getraenk_Objekt füllen (als Inhalt der Objekt Flasche).
     * 
     * @param g, als Inhalt des Field_Variables
     */
    public void fuellen(Getraenk g){
        this.inhalt = (T) g;
    }
    
    /**
     * Mit dieser Methode kann man das Field_Variable mit null_Inhalt leeren (als Inhalt der Objekt Flasche).
     * 
     */
    public void leeren(){
        this.inhalt = null;
    }
    
    /**
     * Mit dieser Methode kann man einen neuen Inhalt für eine Flasche_Objekt setzen.
     * 
     * @param inhalt Inhalt der Flasche
     */
    public void setInhalt(T inhalt){
        this.inhalt = inhalt;
    }
      
    /**
     * Mit dieser Methode bekommt man den Inhalt der Flasche.
     * 
     * @return inhalt der Flasche
     */
    public T getInhalt(){
        return inhalt;
    }
    
    /**
     * Methode gibt den Ihalt der Flasche als String zurück.
     * 
     * @return inhalt Inhalt der Flasche als String
     */
    public String toString(){
        return "Flascheninhalt: " + inhalt;
    } 

}
