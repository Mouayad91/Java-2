/**
 * Eine Klasse, die einen Mitarbeiter anmeldet und ihm ein Raum reserviert.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */

public class Mitarbeiter extends Person {
    private String email;

    /**
     * Hier werder die Vorname, Nachname und E-mail eines Mitarbeiters eingegeben.
     * Die Attribute vorname und nachname werden von Klasse Person geerbt.
     * @param vorname, nachname und email des Mitarbeiters
     */
    public Mitarbeiter( String vorname, String nachname, String email){
    	
        super(vorname, nachname);
        
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email muss angegeben werden");
        }else {
            this.email = email;
        }
    }
    
    /**
     * Mit dieser Methode kann man ein Raum für einen Mitarbeiter reservieren.
     * 
     * @param raum, beginn, ende und bemerkung zum Reservieren eines Raums.
     */
    public void reserviere(Raum raum, Uhrzeit  beginn, Uhrzeit  ende,  String bemerkung) {
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setMitarbeiter(this);
        if(raum.verfeugbar(reservierung)) {
            raum.addReservierung(reservierung);
        } else {
        	throw new IllegalArgumentException("Die Reservierung ist nicht moeglich");
        }
    }
    
    /**
     * Mit der Methode bekommt man die Email-Adresse des Mitarbeiters.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Mit der Methode kann man eine neue Email-Adresse für einen Mitarbeiter setzen.
     * 
     * @param email des Mitarbeiters
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Methode gibt Vorname, Nachname und Email-Adresse des Mitarbeiters zurück
     * 
     * @return Zeichenkette der Attribute vorname, nachname und email
     */
    @Override
    public String toString() {
        return this.getVorname()+" "+this.getNachname()+ " ("+ email+")";
    }
}
