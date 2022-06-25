import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Programm zum Reservieren und Bearbeiten von Räumen für die Mitarbeiter.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */

public class Dialog {

    private static final int MITARBEITER_ANMELDEN = 1;
    private static final int RAUM_RESERVIEREN = 2;
    private static final int RESERVIERTE_RAUEME_ANZEIGEN = 3;
    private static final int MITARBEITERLISTE = 4;
    private static final int FREIE_RAUEME = 5;
    private static final int ENDE = 0;
    private List<Raum> raeumeList = new ArrayList<>();
    private List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    private int raum_nummer;
    private int geb;
    private int etage;

    /**
     * Die Funktionen werden hier angezeigt.
     * 
     * @return Eingabe vom Benutzer als Ganzzahl.
     */
    private int einleseFunktion() {
        System.out.print(1 + ":Neue Mitarbeiter anmelden;\n" + 2 + ":Raum reservieren;\n" + 3 + ":Reservierte Termine im Raum anzeigen;\n"
                + 4 + ":Alle Mitarbeiter im Raum anzeigen;\n" + 0 + ":beenden -> ");
        return input.nextInt();
    }

    /**
     * Hier wird abhängig vom Benutzer eine Funktion ausgewählt und die richtige Methode ausgeführt.
     * 
     * @param Funktion Befehl des Benutzers
     */
    private void funktionAuswÃ¤hlen(int funktion) {
        switch (funktion) {
            case 1:
                System.out.println("Vorname: ");
                input.nextLine();
                String vorname = input.nextLine();
                System.out.println("Nachname: ");
                String nachname = input.nextLine();
                System.out.println("E-mail: ");
                String email = input.nextLine();
                mitarbeiter = new Mitarbeiter(vorname, nachname, email);
                mitarbeiterList.add(mitarbeiter);

                break;
            case 2:
                System.out.println("Gebaeude: ");
                geb = input.nextInt();
                System.out.println("Etage: ");
                etage = input.nextInt();
                System.out.println("Raum: ");
                raum_nummer = input.nextInt();
                if (getRaum(raum_nummer, geb, etage) != null) {
                    raum = getRaum(raum_nummer, geb, etage);
                }else {
                    raum = new Raum(geb, etage, raum_nummer);
                }
                System.out.println("Beginn-Stunde der Reservierung: ");
                int stunde = input.nextInt();
                System.out.println("Beginn-Minute der Reservierung: ");
                int minute = input.nextInt();
                Uhrzeit beginn = new Uhrzeit(stunde, minute);
                System.out.println("End-Stunde der Reservierung: ");
                int endStunde = input.nextInt();
                System.out.println("End-Minute der Reservierung: ");
                int endMinute = input.nextInt();
                Uhrzeit ende = new Uhrzeit(endStunde, endMinute);
                System.out.println("Bemerkung: ");
                input.nextLine();
                String bemerkung = input.nextLine();
                mitarbeiter.reserviere(raum, beginn, ende, bemerkung);
                addRaum(raum, raum_nummer, geb, etage);
                break;
            case 3:
                System.out.println("Gebaeude: ");
                geb = input.nextInt();
                System.out.println("Etage: ");
                etage = input.nextInt();
                System.out.println("Raum: ");
                raum_nummer = input.nextInt();
                System.out.println(getRaum(raum_nummer, geb, etage).toString());
                break;
            case 4:
                System.out.println("Gebaeude: ");
                geb = input.nextInt();
                System.out.println("Etage: ");
                etage = input.nextInt();
                System.out.println("Raum: ");
                raum_nummer = input.nextInt();
                System.out.println(getRaum(raum_nummer, geb, etage).getAllMitarbeiterImRaum());
                break;
            case 0:
                System.out.println("Programmende");
                System.exit(0);
                break;
            default:
                System.out.println("Falsche Funktion!");
                break;
        }
    }
    
    /**
     * Mit dieser Methode wird ein Raum in der List, die alle reservierte Räume enthält, hinzugefuegt.
     * 
     * @param raum, um ein Raum in der Liste hinzufuegen .
     * @param raum_nummer, geb, etage, um zu ueberpruefen, ob das Raum schon in der Liste existiert. 
     */
    public void addRaum(Raum raum, int raum_nummer, int geb, int etage) {
        boolean istRaumExistiert = false;
        for(Raum r: raeumeList) {
            if ((r.getRaumNummer() == raum_nummer) && (r.getGeb() == geb)&& (r.getEtage() == etage)) {
                istRaumExistiert = true;
            }
        }
        if (!(istRaumExistiert)) {
            raeumeList.add(raum);
        }

    }
    
    /**
     * Mit dieser Methode kann man ein Raum für einen Mitarbeiter reservieren.
     * 
     * @param raum_nummer, geb, etage, um ein bestimmtes Raum in der Liste zu finden. 
     */
    public Raum getRaum(int raum_nummer, int geb, int etage) {
        Raum gesuchte_raum = null;
        for(Raum raum: raeumeList) {
            if ((raum.getRaumNummer() == raum_nummer) && (raum.getGeb() == geb) && (raum.getEtage() == etage)) {
                gesuchte_raum = raum;
                break;
            }
        }
        return gesuchte_raum;
    }

    /**
     * Die Hauptschleife des Programms.
     */
    public void start() {
        int counter = 0;
        int eingabe;
        while (counter == 0) {
            try {
                eingabe = einleseFunktion();
                funktionAuswÃ¤hlen(eingabe);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e + " Falsche Eingabe!");
                input.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Mitarbeiter exestiert nicht! Bitte melden Sie zuerst einen Mitarbeiter an.");
            } catch (Exception e) {
                System.out.println(e + " Programm beendet");
            }
        }
    }
    
    /**
     * Die Main Methode der Klasse, um das Programm auszuführen.
     * 
     * @param args
     */
    public static void main(String[] args) {
            new Dialog().start();
       }
}