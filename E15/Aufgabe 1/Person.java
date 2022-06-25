
/**
 * Eine Klasse, die eine Person beschreibt, und mit 3 Attribute (vorname, nachname und beruf)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class Person {
    private String vorname;
    private String nachname;
    private String beruf;
    
    /**
     * Hier könner die Attribute vom Benutzer unter bestimmte bedingungen eingegeben.
     * 
     * @param vorname, nachname und beruf einer Person
     */
    public Person(String vorname, String nachname, String beruf){
        setVorname(vorname);
        setNachname(nachname);
        setBeruf(beruf);
    }
    
    /**
     * Mit der Methode kann man eine neuen Vornamen für eine Person setzen.
     * 
     * @param vorname Vorname der Person
     */
    public void setVorname(String vorname){
        if(vorname == null || vorname.strip().length() <= 0){
            throw new IllegalArgumentException("Vorname muss nicht leer sein!");
        }else{
            this.vorname=vorname;
        }
    }
    
    /**
     * Mit der Methode kann man einen neuen Nachname für eine Person setzen.
     * 
     * @param nachname Nachname der Person
     */
    public void setNachname(String nachname){
        if(nachname == null || nachname.strip().length() <= 0){
            throw new IllegalArgumentException("Nachname muss nicht leer sein!");
        }else{
            this.nachname=nachname;
        }
    }
    
    /**
     * Mit der Methode kann man einen neuen Beruf für eine Person setzen.
     * 
     * @param beruf Beruf der Person
     */
    public void setBeruf(String beruf){
        if(beruf == null || beruf.strip().length() <= 0){
            throw new IllegalArgumentException("Beruf der Person muss nicht leer sein!");
        }else{
            this.beruf=beruf;
        }
    }
    
    /**
     * Mit der Methode bekommt man den Vorname einer Person.
     * 
     * @return vorname der Person
     */
    public String getVorname(){
        return vorname;
    }
    
    /**
     * Mit der Methode bekommt man den Nachname einer Person.
     * 
     * @return nachname der Person
     */
    public String getNachname(){
        return nachname;
    }
    
    /**
     * Mit der Methode bekommt man den Beruf einer Person.
     * 
     * @return beruf der Person
     */
    public String getBeruf(){
        return beruf;
    }
    
    /**
     * Methode gibt Vorname, Nachname und Beruf der eingefügten Person zurück
     * 
     * @return Zeichenkette der Attribute vorname, nachname und beruf
     */
    public String toString(){
        return "Vorname: " + vorname + ", Nachname: " + nachname + ", Beruf: " + beruf;
    }
    
}
