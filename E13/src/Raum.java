import java.util.ArrayList;
import java.util.List;

/**
 * Eine Klasse, die einen Raum erstellt und in eine Arrayliste zuordnet, um das Raum für einen Mitarbeiter zu reservieren.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Raum {
    private int geb;
    private int etage;
    private int raum ;

    private List<Reservierung> list = new ArrayList<>();
    
    /**
     * Hier werden die Attribute (Merkmale der Raums) vom Benutzer eingegeben und gespeichert.
     * 
     * @param geb, etage und raum eines Raums
     */
    public Raum ( int geb, int etage, int raum){

        if ( (geb >= 0) && (etage >= 0) && ( raum >=0) ){
            this.geb = geb;
            this.etage = etage;
            this.raum = raum;

        }else {

            throw new IllegalArgumentException(" geb, etage, raum soll nur positive Nummer oder 0 enthalten");

        }

    }
    
    /**
     * Mit dieser Methode kann man eine neue Reservierung im Raum durchfuehren.
     * 
     * @param reservierung zum reservieren eines Raums
     */
    public void addReservierung(Reservierung reservierung) {
    	list.add(reservierung);
    }
    
    /**
     * Hier wird ein Raum mit Hilfe der Beginn und das Ende einer eingegebenen Reservierung überprüft, ob es möglich ist, eine neue Reservierung durchzufuehren.
     * 
     * @param reservierung, um zu ueberpreufen, ob die Reservierung möglich ist oder nicht.
     */
    public boolean verfeugbar(Reservierung reservierung){
        boolean nichtBesitzt = false;

        int beginn_neu_reservierung = reservierung.getBeginn().getZeit();
        int ende_neu_reservierung = reservierung.getEnd().getZeit();
        if (list.isEmpty()) {
            nichtBesitzt = true;
        } else {
            for (int i =0; i < list.size(); i++){

                int beginn_Uhrzeit= getReservierung(i).getBeginn().getZeit();
                int ende_Uhrzeit= getReservierung(i).getEnd().getZeit();
                if (beginn_neu_reservierung >= ende_Uhrzeit ){
                    if (beginn_Uhrzeit != getReservierung(list.size()-1).getBeginn().getZeit()) {
                        if (ende_neu_reservierung <= getReservierung(i+1).getBeginn().getZeit()) {
                            return true;
                        }
                    }else {
                        return true;
                    }
                } else {
                    if ((beginn_neu_reservierung < beginn_Uhrzeit) &&(ende_neu_reservierung <= beginn_Uhrzeit)) {
                        nichtBesitzt = true;
                    }
                    break;
                }
            }
        }
        return nichtBesitzt;
    }

    /**
     * Hier wird eine bestimmte Reservierung im Raum zureuckgegeben.
     * 
     * @return index, um eine bestimmte Reservierung im Raum zu finden.
     */
    public Reservierung getReservierung(int index) {
        return list.get(index);
    }

    /**
     * Mit der Methode bekommt man die Nummer des Gebeudes des Raums.
     * 
     * @return geb des Raums
     */
    public int getGeb() {
        return geb;
    }

    /**
     * Mit der Methode kann man ein neues Gebäude fuer das Raum setzen.
     * 
     * @param geb Gebäude des Raums
     */
    public void setGeb(int geb) {
        this.geb = geb;
    }

    /**
     * Mit der Methode bekommt man die Etage des Raums.
     * 
     * @return etage des Raums
     */
    public int getEtage() {
        return etage;
    }
    
    /**
     * Mit der Methode kann man eine neue Etage fuer das Raum setzen.
     * 
     * @param etage Etage des Raums
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * Mit der Methode bekommt man die Raumnummer des Raums.
     * 
     * @return raum des Raums
     */
    public int getRaumNummer() {
        return raum;
    }

    /**
     * Mit der Methode kann man eine neue Raumnummer fuer das Raum setzen.
     * 
     * @param raum Raumnummer des Raums
     */
    public void setRaum(int raum) {
        this.raum = raum;
    }
    
    /**
     * Mit der Methode bekommt man die angemeldete Mitarbeiter, die eine Resvierung im Raum durchgeführt haben.
     * 
     * @return mitarbeiter, die Mitarbeiter im Raum.
     */
    public String getAllMitarbeiterImRaum() {
        String mitarbeiter = "Die Mitarbeiter im Raum "+this.geb+"-"+this.etage+"."+this.raum+" sind: "+"\r\n";
        for(Reservierung reservierung: list) {
            mitarbeiter += reservierung.getMitarbeiter().toString()+"\r\n";
        }
        return  mitarbeiter;
    }

    /**
     * Methode gibt Raumnummer, Gebäude und Etage der Räume und alle Reservierungen von der Liste zurück.
     * 
     * @return Zeichenkette der Attribute geb, etage, raum und die Resrvierungen.
     */
    @Override
    public String toString() {
        String reservierungen = "Raum "+this.geb+"-"+this.etage+"."+this.raum+"\r\n";
        for(Reservierung reservierung: list) {
            reservierungen += reservierung.toString()+"\r\n";
        }
        return  reservierungen;
    }
}
