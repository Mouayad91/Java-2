/**
 * Eine Klasse, die einen Artikel beschreibt, und mit 4 Attribute (artikelNr, art, bestand, preis)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Artikel {
    
    private int artikelNr;
    private String art;
    private int bestand;
    private double preis;
    
    /**
     * Hier werden die Attribute vom Benutzer eingegeben.
     * 
     * @param artikelNr, art, bestand und preis eines Artikels
     */
    public Artikel(int artikelNr, String art, int bestand, double preis) {
       if (artikelNr >= 1000 && artikelNr <= 9999) {
            this.artikelNr = artikelNr;
       } else {
            throw new IllegalArgumentException("ArtikelNr soll vierstellige Nummer sein!");
       }
    
       setArt(art);
       setBestand(bestand);
       setPreis(preis);       
    }

    /**
     * Mit der Methode bekommt man die Artikelnummer.
     * 
     * @return artikelNr
     */
    public int getArtikelNr() {
        return artikelNr;
    }

    /**
     * Mit der Methode bekommt man die Art eines Artikel.
     * 
     * @return Art des art
     */
    public String getArt() {
        return art;
    }

    /**
     * Mit der Methode kann man eine neue Art für den Artikel setzen.
     * 
     * @param art Art des Artikels
     */
    public void setArt(String art) {
        if (art == null || art.strip().length() <= 0) {
            throw new IllegalArgumentException("Artikelart soll nicht leer sein!");
       } else {
            this.art = art;
       }
    }

    /**
     * Mit der Methode bekommt man den Bestand des Artikels.
     * 
     * @return bestand des artikels
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * Mit dieser Methode kann man ein neuen Bestand setzen.
     * 
     * @param bestand Bestand des Artikels
     */
    public void setBestand(int bestand) {
        if (bestand >= 1) {
            this.bestand = bestand;
       } else {
            throw new IllegalArgumentException("Bestand soll größer/gleich als 1 sein!");
       }
    }
    
    /**
     * Mit der Methode bekommt man den Preis des Artikels.
     * 
     * @return preis des artikels
     */
    public double getPreis() {
        return preis;
    }
    
    /**
     * Mit dieser Methode kann man ein neuen Preis setzen.
     * 
     * @param preis Preis des Artikels
     */
    public void setPreis(double preis) {
        if (preis >= 0) {
           this.preis = preis;
       } else {
           throw new IllegalArgumentException("Preis muss größer gleich null!");
       }
    }

    /**
     * Mit der Methode wird dr Bestand um eine bestimmte Menge erhöht
     * 
     * @param menge Die menge die dazu addiert wird
     */
    public void bucheZugang(int menge) {
        if (menge >= 1) {
            this.bestand = bestand + menge;
        }
    }

    /**
     * Mit der Methode wird der Bestand um eine bestimmte Menge vermindert
     * 
     * @param menge Die menge die den Bestand vermindert
     */
    public void bucheAbgang(int menge) {
        if (menge <= -1) {
            this.bestand = bestand + menge;
        }else if (menge > 1) {
            this.bestand = bestand - menge;
        }
        if (bestand < 0) {
                bestand = 0;
            }
    }
    
    /**
     * Mit der Methode wird der Preis eines Artikels geändert
     * 
     * @param prozent Der Preis eines Artikels um einen bestimmten Wert in Prozent ändern
     */
    public void preisAendern(double prozent) {
        double teil_preis = (preis * prozent) / 100;
        this.preis = preis + teil_preis;
        if (this.preis < 0) {
            this.preis = 0;
        }
    }
    
    /**
     * Mit der Methode bekommt man die Beschreibung eines Artikel.
     * 
     * @return art des Artikels
     */
    public String getBeschreibung(){
        return getArt() + "\t";
    }
    
    /**
     * Dieser Methode vergleicht das equality/Gleichstimmung von den aktuellen objekt mit den objekt vom selben Typ.
    ´*/
    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 29;
        result = prime * result + ((art == null) ? 0 : art.hashCode());
        result = prime * result + artikelNr;
        return result;
    }
    
    /**
     * Dieser Methode vergleicht das equality/Gleichstimmung von den aktuellen objekt mit den objekt vom selben Typ.
    ´*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artikel other = (Artikel) obj;
        if (art == null) {
            if (other.art != null)
                return false;
        } else if (!art.equals(other.art))
            return false;
        if (artikelNr != other.artikelNr)
            return false;
        if (artikelNr == 0) {
            if (other.artikelNr != 0)
                return false;
        } else if (artikelNr!=other.artikelNr)
            return false;
        return true;
    }

    /**
     * Methode gibt Artikelnummer, Artikelart, Bestand und Preis des Artikels zurück
     * 
     * @return Zeichenkette der Attribute artikelnr, art, bestand und preis
     */
    public String toString() {
        return "Artikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand + ", Preis: " + preis + "; ";
    }
}
