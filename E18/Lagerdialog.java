import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.function.*;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.ArrayList;

 
/**
 * Programm zum erstellen und bearbeiten von Artikeln in einem Lager.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Lagerdialog {
    private final String FUNKTION_ERROR = "Funktion exestiert nicht!";
    private final String LAGER_ERROR = "Lager exestiert nicht! Bitte erstellen Sie zuerst ein Lager.";
    private final String FILTER_OPTIONEN = "\n1. Nach Art filtern.\n2. Nach Bestand filtern.\n3. Nach Preis filtern.\n";
    
    private Artikel artikel;
    private Lager lager;
    private int wahl;
    public static Scanner input = new Scanner(System.in);
    private Predicate<Artikel> predicate = null;
    private BiPredicate<Artikel,Artikel> biPredicate = null;
    private LagerInterface lagerInterface = null;
    
    /**
    * Die Funktionen werden hier angezeigt.
    * 
    * @return Eingabe vom Benutzer als Ganzzahl
    */
    private int einleseFunktion() {
        System.out.println(
                1 + ": Lager mit der maximum größe anlegen.\n" + 2 + ": Lager Größe eingeben.\n" + 3 + ": Artikel einfügen.\n" + 4 + ": Artikel entfernen.\n" + 5 + ": Artikel im lager ermitteln.\n" + 6 + ": Bestand des artikels erhöhen.\n" + 7
                + ": Bestand des Artikels verringern.\n" + 8 + ": Der Preis eines Artikels ändern.\n" + 9 + ": Der Preis alle Artikeln ändern.\n" + 10
                + ": Artikelinformationen erhalten.\n" + 11 + ": Anzahl der Artikeln im Lager.\n" + 12 + ": Verfügbare Plätze im Lager.\n" + 13 + ": Ausgabensbestandsliste. \n" + 14 + ": Lager nach Kriterien sortieren.\n" + 15 + ": Eine Funktion auf alle Artikel ausführen.\n" + 16 + ": Artikel im Lager filtern.\n" + 17 + ": Eine operation auf bestimmte Artikel ausführen.\n" + 18 + ": Artikel nach Kriterien suchen, sotieren und dann als List zurückgeben.\n" + 
                19 + ": Artikel im Lager nach mehrere Kriterien filtern.\n" + 0 + ": beenden -> ");
        return input.nextInt();
    }

    /**
     * Mit dieser Methode kann man eine Zahl/Wert von Datentyp Integer für Input eingeben.
     * 
     * @return input vom Benutzer als Ganzzahl
     */
    private int getInput() {
        return input.nextInt();
    }
    
    /**
     * Hier wird abhängig vom benutzer eine Funktion ausgewählt und die richtige Methode ausgeführt.
     * 
     * @param funktion Befehl des benutzer
     */
    private void funktionAuswählen(int funktion) {
        switch (funktion) {
            case 1:
                lager = new Lager();
                System.out.println("Die größe des Lagers ist 10!");
                break;
            case 2:
                System.out.println("Bitte geben Sie die größe des Lagers ein: ");
                int große = input.nextInt();
                lager = new Lager(große);
                break;
            case 3:
                /*
                if (lager.getLagerGroesse() == 0) {
                    throw new IllegalArgumentException("Alle Plätze im Lager sind belegt!");
                }
                */
               
                System.out.println(1 + ". Ein CD anlegen; \n" + 2 + ". Ein Video anlegen; \n" + 3 + ". Ein Buch anlegen; \n" + 4 + ". Sonstige Artikel anlegen;");
                int artWaehlen = input.nextInt();
                if(artWaehlen == 1){
                    artikel = CD.cdEinfuegen();
                    lager.legeAnArtikel(artikel);
                }else if(artWaehlen == 2){
                    artikel = Video.videoEinfuegen();
                    lager.legeAnArtikel(artikel);
                }else if(artWaehlen == 3){
                    artikel = Buch.buchEinfuegen();
                    lager.legeAnArtikel(artikel);
                }else if(artWaehlen == 4){
                    lager.legeAnArtikel(ArtikelDialog.artikelAnlegen());
                }else{
                    System.out.println("Die gewaehlte Funktion existiert nicht!");
                }
                break;   
            case 4:
                System.out.println("Bitte geben Sie die Artikelnummer des Artikels ein: ");
                int artNummer = input.nextInt();
                lager.entferneArtikel(artNummer);
                break;
            case 5:
                System.out.println("Bitte geben Sie eine Stelle im Lager zwischen " + "0-" + (lager.getArtikelAnzahl()-1) + " ein, um den Artikel an dieser Stelle zu ermitteln: ");
                int index = input.nextInt();
                if(index < lager.getArtikelAnzahl()){
                    artikel = lager.getArtikel(index);
                    System.out.println(artikel.toString());
                }else{
                    throw new IllegalArgumentException("An der eingegebene Stelle gibt es kein Artikel!");
                }
                break;    
            case 6:
                System.out.println("Bitte geben Sie die Artikelnummer des Artikels ein: ");
                artNummer = input.nextInt();
                System.out.println("Bitte geben Sie einen Wert ein, um den Bestand des ausgewählten Artikels zu erhöhen: ");
                int zugang = input.nextInt();
                lager.bucheZugang(artNummer,zugang);
                break;
            case 7:
                System.out.println("Bitte geben Sie die Artikelnummer des Artikels ein: ");
                artNummer = input.nextInt();
                System.out.println("Bitte geben Sie einen Wert ein, um den Bestand des ausgewählten Artikels zu verringern: ");
                int abgang = input.nextInt();
                lager.bucheAbgang(artNummer,abgang);
                break;
            case 8:
                System.out.println("Bitte geben Sie die Artikelnummer des Artikels ein: ");
                artNummer = input.nextInt();
                System.out.println("Bitte geben Sie einen Wert in Prozent ein, um den Preis des ausgewählten Artikels zu ändern: ");
                double prozent = input.nextDouble();
                lager.aenderePreisEinesArtikels(artNummer, prozent);
                break;
            case 9:
                System.out.println("Bitte geben Sie einen Wert in Prozent ein, um den Preis alle Artikeln zu ändern: ");
                prozent = input.nextDouble();
                lager.aenderePreisAllerArtikel(prozent);
                break;
            case 10:
                if (lager.getArtikelAnzahl() == 0) {
                    System.out.println("Das Lager ist leider leer :( ");
                }
                lager.toString();
                break;
            case 11:
                System.out.println("Das lager enthält " + lager.getArtikelAnzahl() + " Artikel." );
                break;
            case 12:
                System.out.println("Das lager hat " + lager.getAnzahlLeerePlaetzeImLager() + " freie Plätze." );
                break;
            case 13:
                if (lager.getArtikelAnzahl() == 0) {
                    System.out.println("Das Lager ist leider leer :( ");
                }
                System.out.println("ArtNr   " + "Beschreibung" + "\t" + "Preis" + "\t" + "Bestand" + "\t" + "Gesamt");
                StringBuilder sb = new StringBuilder(20);
                for(int n = 0; n < 10; ++n){
                    sb.append('-');
                    System.out.print(sb);
                }
                lager.ausgebenBestandsListe();
                break;
            case 14:
                check();
                check2();
                System.out.println("\n1. Nach Artikelnummer sortieren.\n2. Nach Artikel-art alphabetisch sortieren.\n3. Nach Artikel-Bestand sortieren.\n4. Nach Artikel-Preis sortieren.\n");
                wahl = input.nextInt();
                if(wahl == 1){
                    System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> a1.getArtikelNr() < a2.getArtikelNr())));
                }else if(wahl == 2){
                    System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> {
                        if(a1.getArt().compareTo(a2.getArt()) < 0){
                            return true;
                        }else{
                            return false;
                        }
                    })));
                }else if(wahl == 3){
                    System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> a1.getBestand() < a2.getBestand())));
                }else if(wahl == 4){
                    System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> a1.getPreis() < a2.getPreis())));
                }else{
                    System.out.println(FUNKTION_ERROR);
                }
                break;
            case 15: 
                check();
                check2();
                System.out.println("\n1. Art alle Artikel ändern.\n2. Bestand alle Artikel ändern.\n3. Preis alle Artikel ändern.\n");
                wahl = input.nextInt();
                if(wahl == 1){
                    System.out.println("Bitte geben Sie die Art ein: ");
                    input.nextLine();
                    String neuArt = input.nextLine();
                    lager.applyToArticles(a1 -> a1.setArt(neuArt));
                }else if(wahl == 2){
                    System.out.println("\n1. Bestand erhöhen.\n2. Bestand erniedrigen.\n");
                    wahl = input.nextInt();
                    if(wahl == 1){
                        System.out.println("Bitte geben Sie die Menge ein: ");
                        int neuBestand = input.nextInt();
                        lager.applyToArticles(a1 -> a1.bucheZugang(neuBestand));
                    }else if(wahl == 2){
                        System.out.println("Bitte geben Sie die Menge ein: ");
                        int neuBestand = input.nextInt();
                        lager.applyToArticles(a1 -> a1.bucheAbgang(neuBestand));
                    }else{
                        System.out.println(FUNKTION_ERROR);
                    }
                }else if(wahl == 3){
                    System.out.println("Bitte geben Sie in Prozent, wie viel Sie den Preis erhöhen bzw. erniedrigen wollen, ein: ");
                    double neuPreis = input.nextDouble();
                    lager.applyToArticles(a1 -> a1.preisAendern(neuPreis));
                }else{
                    System.out.println(FUNKTION_ERROR);
                }
                break;
            case 16: 
                check();
                check2();
                System.out.println(FILTER_OPTIONEN);
                wahl = input.nextInt();
                if(wahl == 1){
                    predicate = prediacteWaehlen(1);
                    System.out.println(lager.filter(predicate));
                }else if(wahl == 2){
                    predicate = prediacteWaehlen(2);
                    System.out.println(lager.filter(predicate));
                }else if(wahl == 3){
                    predicate = prediacteWaehlen(3);
                    System.out.println(lager.filter(predicate));
                }else{
                    System.out.println(FUNKTION_ERROR);
                }
                if(lager.filter(predicate).size() == 0){
                    throw new IllegalArgumentException("Es wurde leider kein Artikel mit den eingegebenen Kriterien gefunden!");
                }
                break;
            case 17:
                check();
                check2();
                System.out.println("\nWelche Bedingung soll das Artikel erfüllen;\n1. Bestimmte Art.\n2. Bestimmte Bestand.\n3. Bestimmte Preis.\n");
                wahl = input.nextInt();
                if(wahl == 1){
                    predicate = prediacteWaehlen(1); //Die Bedingung
                    lagerInterface = operation(); //Operation
                    lager.applyToSomeArticles(lagerInterface,predicate); 
                }else if(wahl == 2){
                    predicate = prediacteWaehlen(2); //Die Bedingung
                    lagerInterface = operation(); //Operation
                    lager.applyToSomeArticles(lagerInterface,predicate); 
                }else if(wahl == 3){
                    predicate = prediacteWaehlen(3); //Die Bedingung
                    lagerInterface = operation(); //Operation
                    lager.applyToSomeArticles(lagerInterface,predicate); 
                }else{
                    System.out.println(FUNKTION_ERROR);  
                }  
                break;
            case 18:   
                check();
                check2();
                System.out.println("\n1. Nach Art suchen.\n2. Nach Bestand suchen.\n3. Nach Preis suchen.\n"); 
                wahl = input.nextInt();                
                if(wahl == 1){
                    predicate = prediacteWaehlen(1); //Suchkriterium
                    biPredicate = sortKriterium(); //Sortkriterium
                    System.out.println(lager.getArticles(predicate, biPredicate));
                }else if(wahl == 2){
                    predicate = prediacteWaehlen(2); //Suchkriterium
                    biPredicate = sortKriterium(); //Sortkriterium
                    System.out.println(lager.getArticles(predicate, biPredicate));
                }else if(wahl == 3){
                    predicate = prediacteWaehlen(3); //Suchkriterium
                    biPredicate = sortKriterium(); //Sortkriterium
                    System.out.println(lager.getArticles(predicate, biPredicate));
                }else{
                    System.out.println(FUNKTION_ERROR); 
                }
                if(lager.getArticles(predicate, biPredicate).size() == 0){
                    throw new IllegalArgumentException("Es wurde leider kein Artikel mit den eingegebenen Kriterien gefunden!");
                }
                break;
            case 19:
                check();
                check2();
                List<Predicate<Artikel>> predicateList = new ArrayList<>();
                while(true){
                    System.out.println(FILTER_OPTIONEN);
                    wahl = input.nextInt();
                    if(wahl == 1){
                        predicateList.add(prediacteWaehlen(1));
                    }else if(wahl == 2){
                        predicateList.add(prediacteWaehlen(2));
                    }else if(wahl == 3){
                        predicateList.add(prediacteWaehlen(3));
                    }else {
                        System.out.println(FUNKTION_ERROR); 
                        continue;
                    }
                    System.out.println("Möchten Sie...\n1. Weitere Kriterien anlegen.\n2. Keine weitere Kriterien anlegen.\n");
                    wahl = input.nextInt();
                    if(wahl == 1){
                        continue;
                    }else if(wahl == 2){
                        break;
                    }else{
                        System.out.println(FUNKTION_ERROR); 
                        continue;
                    }
                }
                System.out.println(Arrays.toString(lager.filterAll(predicateList)));
                if(lager.filterAll(predicateList).length == 0){
                    throw new IllegalArgumentException("Es wurde leider kein Artikel mit den eingegebenen Kriterien gefunden!");
                }
                break;
            case 0:
                System.out.println("Programmende!");
                System.exit(0);
                break;    
            default:
                System.out.println("Falsche Funktion!");
                break;
        }
    }
    
    /**
     * Mit dieser Methode kann man eine die eine betimmte Kriterium als Lambda-Ausdruck zurückbekommen. Die Kriterium/Kriterien ist/sind mehrmals in der Dilog-Klasse verwendet, dadurch ist diese Methode hier notwendig.
     * 
     * @return BiPredicate<Artikel,Artikel> ein Lambda-Ausdruck des Interfaces BiPredicate.
     */
    public BiPredicate<Artikel,Artikel> sortKriterium(){
        System.out.println("\n1. Nach Art sortieren.\n2. Nach Bestand sortieren.\n3. Nach Preis sortieren.\n"); 
        int wahl = input.nextInt();
        while(true){
            if(wahl == 1){
                    return (a1,a2) -> {
                        if(a1.getArt().compareTo(a2.getArt()) < 0){
                            return true;
                        }else{
                            return false;
                        }
                    };
            }else if(wahl == 2){
                 return (a1,a2) -> a1.getBestand() < a2.getBestand();  
            }else if(wahl == 3){
                 return (a1,a2) -> a1.getPreis() < a2.getPreis();
            }else{
                 System.out.println(FUNKTION_ERROR); 
                 continue;
            }
        }
    }
    
    /**
     * Mit dieser Methode kann man eine die eine betimmte Bedingung als Lambda-Ausdruck zurückbekommen. Ist notwendig für die Dialog-Klasse, denn es mehrere Funktionen gibt, die mit solche Lambda-Ausdrücke arbeiten.
     * 
     * @param wahl, um ein lambda Ausdruck auszuwählen.
     * @return Predicate<Artikel> ein Lambda-Ausdruck des Interfaces Predicate.
     */
    public Predicate<Artikel> prediacteWaehlen(int wahl){
         if(wahl == 1){
                System.out.println("Art eingeben: ");
                input.nextLine();
                String artFilter = input.nextLine();
                return (a1) -> a1.getArt().equals(artFilter);
         }else if(wahl == 2){
                System.out.println("Bestand eingeben: ");
                int bestandFilter = input.nextInt();
                return (a1) -> a1.getBestand() == bestandFilter;
         }else if(wahl == 3){
                System.out.println("Preis eingeben: ");
                double preisFilter = input.nextDouble();
                return (a1) -> a1.getPreis() == preisFilter;
         }
         return null;
    }
    
    /**
     * Mit dieser Methode kann man eine die eine betimmte Operation als Lambda-Ausdruck zurückbekommen. Ist notwendig für die Dialog-Klasse, denn es mehrere Funktionen gibt, die mit solche Lambda-Ausdrücke arbeiten.
     * 
     * @return LagerInterface ein Lambda-Ausdruck.
     */
    public LagerInterface operation(){
        LagerInterface operation = null;
        while(true){
            System.out.println("\n1. Art des Artikels ändern.\n2. Bestand des Artikels ändern.\n3. Preis des Artikels ändern.\n");
            int wahl = input.nextInt();
                if(wahl == 1){
                System.out.println("Art eingeben: ");
                input.nextLine();
                String newArt = input.nextLine();
                return operation = (a1) -> a1.setArt(newArt);
            }else if(wahl == 2){
                System.out.println("\n1. Bestand erhöhen.\n2. Bestand erniedrigen.\n");
                wahl = input.nextInt();
                if(wahl == 1){
                     System.out.println("Bitte geben Sie die Menge ein: ");
                     int newBestand = input.nextInt();
                     return operation = (a1) -> a1.bucheZugang(newBestand);
                }else if(wahl == 2){
                    System.out.println("Bitte geben Sie die Menge ein: ");
                    int newBestand = input.nextInt();
                    return operation = (a1) -> a1.bucheAbgang(newBestand);
                }else{
                    System.out.println(FUNKTION_ERROR);
                }
                break;
            }else if(wahl == 3){
                System.out.println("Preis eingeben: ");
                double newPreis = input.nextDouble();
                return operation = (a1) -> a1.preisAendern(newPreis);
            }else{
                System.out.println(FUNKTION_ERROR);
                continue;
            }
        }
        return null;
    }
    
    /**
     * Mit dieser Methode wird eine Exception getestet und mehrmals in der Dialod-Klasse verwendet.
     */
    public void check(){
        if(lager == null){
                throw new IllegalArgumentException(LAGER_ERROR);
        }    
    }
    
    /**
     * Mit dieser Methode wird eine Exception getestet und mehrmals in der Dialod-Klasse verwendet.
     */
    public void check2(){
        if(lager.isEmpty()){
                throw new IllegalArgumentException("Lager ist leider Leer!\n");
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
                System.out.println(LAGER_ERROR);
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
        new Lagerdialog().start();
    }
}

