import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum erstellen und bearbeiten von Artikeln.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class ArtikelDialog {
    
    private Artikel artikel;
    public static Scanner input = new Scanner(System.in);

     /**
     * Die Funktionen werden hier angezeigt.
     * 
     * @return Eingabe vom Benutzer als Ganzzahl
     */
    private int einleseFunktion() {
        System.out.println(
                 1 + ": Artikel anlegen.\n" + 2 + ": Bestand des artikels erhöhen.\n" + 3
                + ": Bestand des Artikels verringern.\n" + 4 + ": Artikelart neu setzen.\n" + 5 + ": Preis des Artikels ändern.\n" 
                + 6 + ": Artikelinformationen erhalten.\n" + 0 + ": beenden -> ");
        return input.nextInt();
    }
    
    /**
     * Ein neues Artikel wird hier angelegt.
     * 
     * @return Ein neues Artikel
     */ 
    public static Artikel artikelAnlegen() {
        System.out.print("Artikelnummer eingeben: ");
        int artikelNr = input.nextInt();
        input.nextLine();
        System.out.print("Artikelart eingeben: ");
        String art = input.nextLine().trim();
        System.out.print("Bestand eingeben: ");
        int bestand = input.nextInt();
        System.out.print("Preis eingeben: ");
        double preis = input.nextDouble();
        return new Artikel(artikelNr, art, bestand, preis);
    }

    /**
     * Hier wird man einen Wert eingeben um den Bestand zu erhöhen oder verringern oder für die Attribute Werte eingeben.
     * 
     * @return Eingabe vom Benutzer als Ganzzahl
     */
    private int getInput() {
        return input.nextInt();
    }

    /**
     * Hier wird vom benutzer eine Funktion ausgewählt, die eine richtige artikel methode ausgeführt.
     * 
     * @param funktion Auswahl des benutzers
     */
    private void funktionAuswählen(int zahlDerFunktion) {
        if (zahlDerFunktion >= 0 && zahlDerFunktion <= 6) {
        
            if (zahlDerFunktion == 1) {
                artikel = artikelAnlegen();
                artikel.toString();
            }
        
            if (zahlDerFunktion == 2) {
                System.out.print("Erhöhen Sie den Wert des Bestandes: ");
                int eingabe = getInput();
                artikel.bucheZugang(eingabe);
            }
        
            if (zahlDerFunktion == 3) {
                System.out.print("Verringeren Sie den Wert des Bestandes: ");
                int eingabe = getInput();
                artikel.bucheAbgang(eingabe);
            }
        
            if (zahlDerFunktion == 4) {
                input.nextLine();
                System.out.println("Artikelart: ");
                String eingabe = input.nextLine();
                artikel.setArt(eingabe);
            }
            
            if (zahlDerFunktion == 5) {
                System.out.print("Ändern Sie den Wert des Preises: ");
                double prozent = input.nextDouble();
                artikel.preisAendern(prozent);
            }
        
            if (zahlDerFunktion == 6) {
                System.out.println(artikel.toString());
            }
        
            if (zahlDerFunktion == 0) {
                System.out.println("Programmende!");
                System.exit(0);
            }
        } else {
            System.out.println("Funktion existiert nicht!");
        }
    }

    /**
     * Die Hauptschleife des Programms.
     */
    public void start() {
        artikel = null;
        int counter = 0;
        int eingabe;
        while (counter == 0) {
            try {
                eingabe = einleseFunktion();
                funktionAuswählen(eingabe);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e + " Falsche Eingabe!");
                input.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Artikel exestiert nicht! Bitte erstellen Sie zuerst ein Artikel.");
            } catch (Exception e) {
                System.out.println(e + " Programm beendet");
            }
        }
    }

    /**
     * Die Main Methode der Klasse.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new ArtikelDialog().start();
    }
}
