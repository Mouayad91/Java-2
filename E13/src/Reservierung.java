
/**
 * Eine Klasse, die einen Raum f�r einen Mitarbeiter f�r bestimmte Zeit reserviert .
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
          throw new IllegalArgumentException("Ende der reservierte Zeit soll groeßer als Beginn sein");
      }
    }

    /**
     *Set-Methode, um eine neue Bemerkung f�r die Reservierung zu setzen.
     * 
     * @return bemerkung
     */
    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man die Bemerkung zur�ck.
     * 
     * @return bemerkung
     */
    public String getBemerkung() {
        return this.bemerkung;
    }

    /**
     * Mit dieser Get-Methode bekommt man die Beginnzeit der Reservierung zur�ck.
     * 
     * @return beginn
     */
    public Uhrzeit getBeginn() {
        return beginn;
    }
    
    /**
     *Set-Methode, um neue Beginnzeit f�r die Reservierung zu setzen.
     * 
     * @return beginn
     */
    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man die Endezeit der Reservierung zur�ck.
     * 
     * @return ende
     */
    public Uhrzeit getEnd() {
        return ende;
    }
    
    /**
     *Set-Methode, um neue Endezeit f�r die Reservierung zu setzen.
     * 
     * @return end
     */
    public void setEnd(Uhrzeit end) {
        this.ende = end;
    }
    
    /**
     *Set-Methode, um neuen Mitarbeiter f�r die Reservierung zu setzen.
     * 
     * @return mitarbeiter
     */
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
    
    /**
     * Mit dieser Get-Methode bekommt man den Mitarbeiter, der das Raum reserviert hat, zur�ck.
     * 
     * @return mitarbeiter
     */
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    
    /**
     *Set-Methode, um ein neues Raum f�r die Reservierung zu setzen.
     * 
     * @return raum
     */
    public void setRaum(Raum raum) {
        this.raum = raum;
    }
     
    /**
     * Methode gibt Mitarbeiter-Name, Beginnzeit und Endezeit seine Reservierung zur�ck
     * 
     * @return Zeichenkette der Attribute beginn, ende und bemerkung
     */
    @Override
    public String toString() {
        return "gebucht von "+this.getMitarbeiter().toString()+ " von "+this.beginn.toString()+" bis "+this.ende.toString()+" für "+this.bemerkung;
    }
}
