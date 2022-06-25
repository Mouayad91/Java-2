/**
 * Eine Klasse, die eine Person beschreibt, und mit 2 Attribute (vorname und nachname)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */

public class Person {
    private String vorname;
    private String nachname;
    
    /**
     * Hier werden die Attribute vom Benutzer eingegeben.
     * 
     * @param vorname und nachname einer Person
     */
    public Person (String vorname, String nachname){

        if((vorname == null || vorname.isEmpty()) ||  (nachname == null || nachname.isEmpty())) {
            throw new IllegalArgumentException(" Vorname bzw. Nachname muss angegeben werden");
        } else {
            this.vorname = vorname;
            this.nachname = nachname;
        }
    }

    /**
     * Mit der Methode bekommt man den Vorname des Mitarbeiters.
     * 
     * @return vorname
     */
    public String getVorname() {
        return vorname;
    }
    
    /**
     * Mit der Methode kann man einen neuen Vorname für der Person setzen.
     * 
     * @param vorname der Person
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    /**
     * Mit der Methode bekommt man den Nachname des Mitarbeiters.
     * 
     * @return nachname
     */
    public String getNachname() {
        return nachname;
    }
    
    /**
     * Mit der Methode kann man einen neuen Nachname für der Person setzen.
     * 
     * @param nachname der Person
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    /**
     * Methode gibt Vorname und Nachname der Person zurück.
     * 
     * @return Zeichenkette der Attribute vorname und nachname
     */
    @Override
    public String toString() {
        return  vorname + " " + nachname ;
    }
}
