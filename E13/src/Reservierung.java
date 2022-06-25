
/**
 * Eine Klasse, die einen Raum für einen Mitarbeiter für bestimmte Zeit reserviert .
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */

public class Reservierung {
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    
    /**
     * Hier werden die Attribute (Merkmale der Uhrzeit) vom Benutzer eingegeben und gespeichert.
     * 
     * @param beginn und ende der Reservierung
     */
    public Reservierung(  Uhrzeit beginn, Uhrzeit ende ){

      this.beginn = beginn;

      if(ende.getZeit() > beginn.getZeit()){
          this.ende = ende;
      }else {
          throw new IllegalArgumentException("Ende der reservierte Zeit soll groeÃŸer als Beginn sein");
      }
    }

    /**
     *Set-Methode, um eine neue Bemerkung für die Reservierung zu setzen.
     * 
     * @return bemerkung
     */
    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man die Bemerkung zurück.
     * 
     * @return bemerkung
     */
    public String getBemerkung() {
        return this.bemerkung;
    }

    /**
     * Mit dieser Get-Methode bekommt man die Beginnzeit der Reservierung zurück.
     * 
     * @return beginn
     */
    public Uhrzeit getBeginn() {
        return beginn;
    }
    
    /**
     *Set-Methode, um neue Beginnzeit für die Reservierung zu setzen.
     * 
     * @return beginn
     */
    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man die Endezeit der Reservierung zurück.
     * 
     * @return ende
     */
    public Uhrzeit getEnd() {
        return ende;
    }
    
    /**
     *Set-Methode, um neue Endezeit für die Reservierung zu setzen.
     * 
     * @return end
     */
    public void setEnd(Uhrzeit end) {
        this.ende = end;
    }
    
    /**
     *Set-Methode, um neuen Mitarbeiter für die Reservierung zu setzen.
     * 
     * @return mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man den Mitarbeiter, der das Raum reserviert hat, zurück.
     * 
     * @return mitarbeiter
     */
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    
    /**
     *Set-Methode, um ein neues Raum für die Reservierung zu setzen.
     * 
     * @return raum
     */
    public void setRaum(Raum raum) {
        this.raum = raum;
    }
     
    /**
     * Methode gibt Mitarbeiter-Name, Beginnzeit und Endezeit seine Reservierung zurück
     * 
     * @return Zeichenkette der Attribute beginn, ende und bemerkung
     */
    @Override
    public String toString() {
        return "gebucht von "+this.getMitarbeiter().toString()+ " von "+this.beginn.toString()+" bis "+this.ende.toString()+" fÃ¼r "+this.bemerkung;
    }
}
