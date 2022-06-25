import java.util.Arrays;
import java.util.function.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Eine Klasse, die ein Lager und Artikeln erstellt, und mit mehrere Methoden bearbeitet
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class Lager{
    private static final int STANDARD_GROSSE = 10;
    private static final int MINIMAL_LAGERGROESSE = 1;
    private static final String ERROR_LAGER_NICHT_GROESSER_0 = 
        "Die größe des Lagers muss größer als 0 sein!";
    private static final String ERROR_LAGER_IST_VOLL = 
        "Alle Plätze im Lager sind belegt!";

    private int lagergroesse;
    private Artikel[] artikelArray;
    private int index;
     
    /**
     * Hier wird die größe des Lagers eingegeben.
     * 
     * @param lagergroesse Anzahl der möglichen freien Plätze im Lager
     */
    public Lager(int lagergroesse) {
        if(lagergroesse < MINIMAL_LAGERGROESSE) {
            throw new IllegalArgumentException(ERROR_LAGER_NICHT_GROESSER_0);
        }else{
            this.lagergroesse = lagergroesse;
        }
        index = 0;
        artikelArray = new Artikel[lagergroesse];
    }
    
    /**
     * Hier wird die größe des Lagers mit den Maximalen Wert 10 eingegeben.
     */
    public Lager() {
        artikelArray = new Artikel[STANDARD_GROSSE];
    }
    
    /**
     * Mit dieser Methode kann man ein neuen Arikel ins Lagen anlegen.
     * 
     * @param artikel zum erstellen eines Artikels
     */
    public void legeAnArtikel(Artikel artikel) {
        
        if (isFull()) {
            throw new IllegalArgumentException(ERROR_LAGER_IST_VOLL);
        }else{
            for (Artikel element : artikelArray) {
                if(getArtikelAnzahl() == 0){
                    break;
                }
                if (element != null) {
                    if (element.getArtikelNr() == artikel.getArtikelNr()){
                        throw new IllegalArgumentException("Die Artikelnummer " + artikel.getArtikelNr() + " ist bereits  belegt!");
                    }
                }
            }
        }
        
        artikelArray[index] = artikel;
        index++;
    }
    
    /**
     * Mit dieser Methode kann man überprüfen, ob das Lager voll ist oder nicht.
     */
    public boolean isFull(){
        for(int i = 0; i < artikelArray.length; i++){
            if(artikelArray[i] == null){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Mit dieser Methode kann man überprüfen, ob das Lager leer ist oder nicht.
     */
    public boolean isEmpty(){
        if(artikelArray[0] == null){
            return true;
        }
        return false;
    }
    
    /**
     * Mit dieser Methode kann man einen Arikel im Lagen entfernen.
     * 
     * @param artikelNr um einen Artikel zu suchen
     */
    public void entferneArtikel(int artikelNr) {
        int length = artikelArray.length;
        if (length == 0 || matchAndFind(artikelNr, artikelArray) == null) {
            throw new IllegalArgumentException("Es existiert keinen Artikel zu entfernen!");
        }      
        Artikel artikel = matchAndFind(artikelNr, artikelArray);
        
        for (int i = 0; i < length; i++) {
            //finde der gewünschte Artikel 
            if (artikelArray[i] == artikel) {
                if(artikelArray[i+1] == artikelArray[length - 1]){
                    artikelArray[i] = null;
                }else if(artikelArray[i+1] != null) {
                    artikelArray[i] = artikelArray[i+1];
                    artikelArray[i+1] = null;
                }
                break;
            }
        }
    }
    
    /**
     * Mit dieser Methode kann man den Bestand eines ausgewähltes Artikels erhöhen.
     * 
     * @param artikelNr, zugang um einen Artikel zu suchen und den Bestand zu erhöhen
     */
    public void bucheZugang(int artikelNr, int zugang) {
        Artikel artikel = matchAndFind(artikelNr, artikelArray);
        artikel.bucheZugang(zugang);
    }
    
    /**
     * Mit dieser Methode kann man den Bestand eines ausgewähltes Artikels verringern.
     * 
     * @param artikelNr, abgang um einen Artikel zu suchen und den Bestand zu verringern
     */
    public void bucheAbgang(int artikelNr, int abgang) {
        Artikel artikel = matchAndFind(artikelNr, artikelArray);
        artikel.bucheAbgang(abgang);
    }
    
    /**
     * Mit dieser Methode kann man den Preis eines ausgewähltes Artikels ändern.
     * 
     * @param artikelNr, prozent um einen Artikel zu suchen und den Preis zu ändern
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        Artikel artikel = matchAndFind(artikelNr, artikelArray); 
        artikel.preisAendern(prozent);
        System.out.println("Der Preis hat sich um " + prozent + "% geändert");
        System.out.println("Der neue Preis des Artikels mit der AtrikelNummer "+ artikel.getArtikelNr() + " beträgt " + artikel.getPreis());
    }
    
    /**
     * Mit dieser Methode kann man den Preis aller Artikeln ändern.
     * 
     * @param prozent um den Preis alle Artikel zu ändern
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (Artikel element: artikelArray) {
            if(element != null) {
                aenderePreisEinesArtikels(element.getArtikelNr(), prozent);
            }
        }
    }
    
    /**
     * Hier wird einen Artikel mit Hilfe der eingegebene Artikelnummer gefunden.
     * 
     * @param artikelNr, array um einen Artikel zu finden
     */
    public Artikel matchAndFind(int artikelNr, Artikel[] array) {
       Artikel artikel = null;
       for (Artikel element: array) {
            if (element != null) {
                if (element.getArtikelNr() == artikelNr) {
                    artikel = element;
                    break;
                }
            }
       }
       if (artikel == null) {
            throw new IllegalArgumentException("Es wurde keinen Artikel mit der eingegebene AtrikelNummer gefunden :( ! ");
       } 
       return artikel;
    }
    
    /**
     * Hier wird einen Artikel im Lager ermittelt.
     * 
     * @param index um den Artikel im Lager zu finden
     */
    public Artikel getArtikel(int index) {
       return artikelArray[index];  
    }
    
    /**
     * Hier wird die Anzahl der angelegte Artikel gegeben.
     * 
     * @return counter um die Anzahl der angelegte Artikel zu rechnen
     */
    public int getArtikelAnzahl() {
        int counter = 0;
        for (Artikel element: artikelArray) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Methode gibt Artikelnummer, Artikelart, Bestand und Preis eines/alle Artikels zurück.
     * 
     * @return lager der Attribute artikelnr, art, bestand und preis von aller angelegte Artikeln
     */
    public String toString() {
        String lager = "";
        int index = 0;
        for (Artikel element: artikelArray) {
            if (element != null) {
                lager += "Artikel Platz" + index + " : \n"+ element.toString() + "\n";
                index++;
            }
        }
        System.out.println(lager);
        return lager;
    }
    
    /**
     * Hier wird die Anzahl der verfügbare freie Plätze im Lager gegeben.
     * 
     * @return Anzahl der freie Plätze im Lager
     */
    public int getAnzahlLeerePlaetzeImLager() {
        return artikelArray.length - getArtikelAnzahl();
    }
    
    /**
     * Hier wird die größe des Lagers gegeben.
     * 
     * @return die größe des Lagers
     */
    public int getLagerGroesse() {
        return artikelArray.length;
    }
    
    /**
     * Methode gibt alle Informationen von den angelegten Artikeln als String Text zurück.
     * 
     * @return lager als Text aus den Attribute artikelNr, art/Beschreibung , bestand, preis und gesamt von aller angelegten Artikeln
     */
    public String ausgebenBestandsListe(){ 
         double gesamt = 0;
         String lager = "";
         int gesamtsumme = 0;
         
         for (int i = 0; i < getArtikelAnzahl(); i++) {      
             gesamt = artikelArray[i].getPreis()*artikelArray[i].getBestand();
             lager = "\n" + artikelArray[i].getArtikelNr() +"\t"+ artikelArray[i].getBeschreibung() +"\t"+ artikelArray[i].getPreis() + "\t" + artikelArray[i].getBestand() +
             "\t" + artikelArray[i].getBestand()*artikelArray[i].getPreis();
             gesamt = gesamt;
             System.out.println(lager+"\n");
             gesamtsumme += gesamt;    
         }
         
         System.out.println("Gesamtwert " + "\t"+ "\t"+ "\t" + "\t" + gesamtsumme);
         return lager;
    }
    
    /**
     * Mit dieser Methode kann man die Artikel im Lager nach bestimmte Kriterium sortieren und ausgeben.
     * 
     * @param predicate, um die Kriterium einzugeben
     * @return sortArray das sortierte Array von Artikel
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> predicate){
        Artikel[] sortArray = new Artikel[getArtikelAnzahl()];
        /*for(int i = 0; i < artikelArray.length; i++){
            if(artikelArray[i] != null){
                sortArray[i] = artikelArray[i];
            }
        }*/
        for(int i = 0; i < artikelArray.length; i++){ //um die null werte in dem Array zu vermeiden.
            if(artikelArray[i] != null){
                sortArray[i] = artikelArray[i];
            }else{
                break;
            }
        }
        
        Artikel tmp;
        for(int i = 0; i < sortArray.length; i++){
            for(int j = i + 1; j < sortArray.length; j++){
                 if(sortArray[j] != null){
                    if(predicate.test(sortArray[i],sortArray[j])){
                        continue;
                    }else{
                        tmp = sortArray[i];
                        sortArray[i] = sortArray[j];
                        sortArray[j] = tmp;
                    }
                }else{
                    break;
                }
            } 
        }
        return sortArray;
    }
    
    /**
     * Hier wird eine eingegebene Funktion auf alle Artikel ausgeführt.
     * 
     * @param function eine Funktion
     */
    public void applyToArticles(Consumer<Artikel> function){
        for(int i = 0; i < getArtikelAnzahl(); i++){ //i < getArtikelAnzahl(), um die null Werte zu vermeiden.
            function.accept(artikelArray[i]); 
        }
    }
    
    /**
     * Mit dieser Methode kann man die Artikel im Lager nach bestimmte Bedingung filtern und ausgeben.
     * 
     * @param predicate, um die Bedingung einzugeben
     * @return artikelList eine Liste von gefilterte Artikel, hier kein Array als return damit wir kein null werte zurückbekommen.
     */
    public List filter(Predicate<Artikel> predicate){
        List<Artikel> artikelList = new ArrayList<>();
        for(Artikel element: artikelArray){
            if(element != null){
                if(predicate.test(element)){
                    artikelList.add(element);
                }
            } 
        }
        return artikelList;
    }
    
    /**
     * Mit dieser Methode kann man eine Bestimmte Operation auf bestimmte Artikel im Lager ausführen.
     * 
     * @param predicate, um die Bedingung einzugeben
     * @param operation hier ein Lambda-Ausdrück einzugeben
     */
    public void applyToSomeArticles(LagerInterface operation, Predicate<Artikel> predicate){
        for(int i = 0; i < artikelArray.length; i++){
            if(artikelArray[i] != null){
                if(predicate.test(artikelArray[i])){
                    operation.apply(artikelArray[i]);
                }
            }
        }
    }
    
    /**
     * Mit dieser Methode kann man den Art eines Artikels neusetzen. Dieser implementierung ist notwendig für das FunctionalInterface des Lager und für die Methode applyToSomeArticles.
     * 
     * @param artikel 
     * @param art Art des Artikels
     */
    public void setArtikelArt(Artikel artikel, String art){
        artikel.setArt(art);
    }
    
    /**
     * Mit dieser Methode kann man eine Liste von bestimmte Artikeln, die eine betimmte Bedingung erfüllen und sortiert in der Liste nach bestimmte Kriterium.
     * 
     * @param predicate, um die Bedingung einzugeben
     * @param biPredicate Sortkriterium in der Liste
     * @return artikelList eine Sortiertierte und gefilterte Liste
     */
    public List getArticles(Predicate<Artikel> predicate, BiPredicate<Artikel, Artikel> biPredicate){
        List<Artikel> artikelList = filter(predicate);
        Artikel tmp;
        for(int i = 0; i < artikelList.size(); i++){
            for(int j = i + 1; j < artikelList.size(); j++){
                 if(artikelList.get(i) != null){
                    if(biPredicate.test(artikelList.get(i),artikelList.get(j))){
                        continue;
                    }else{
                        tmp = artikelList.get(i);
                        artikelList.set(i, artikelList.get(j));
                        artikelList.set(j, tmp);
                    }
                }else{
                    break;
                }
            } 
        }
        return artikelList;
    }
    
    /**
     * Mit dieser Methode kann man eine Liste von bestimmte Artikeln, die eine oder mehrere Bedingungen bzw. Kriterien erfüllen. Maximum 3 Kriterien können eingegeben.
     * @param parameterliste, um die Kriterien als List einzugeben
     * @return artikelList eine gefilterte Liste nach verschiedene Kriterien
     */
    public Artikel[] filterAll(List<Predicate<Artikel>> parameterliste){
        List<Artikel> artikelList = new ArrayList<>();
        for(int j = 0; j < getArtikelAnzahl(); j++){
             if(parameterliste.size() == 1){
                if(parameterliste.get(0).test(artikelArray[j])){
                     artikelList.add(artikelArray[j]);
                }
            }else if(parameterliste.size() == 2){
                if(parameterliste.get(0).test(artikelArray[j]) && parameterliste.get(1).test(artikelArray[j])){
                       artikelList.add(artikelArray[j]);
                }
            }else{
                 if(parameterliste.get(0).test(artikelArray[j]) && parameterliste.get(1).test(artikelArray[j]) && parameterliste.get(2).test(artikelArray[j])){
                     artikelList.add(artikelArray[j]);
                 }
            }
        }
        Artikel[] newArtikelArray = new Artikel[artikelList.size()];
        for(int i = 0; i < newArtikelArray.length; i++){
            newArtikelArray[i] = artikelList.get(i);
        }
        return newArtikelArray;
    }
    
    /**
     * Main-Methode der Klasse, hier werden mehrere Methoden des Programms getestet. Jeder aufgabe ist geteilt durch ein "----." String.
     * 
     * @param args
     */
    public static void main(String[] args){
        Lager lager = new Lager(5);
        Artikel ar1 = new Artikel(1234, "abc", 2, 100);
        Artikel ar2 = new Artikel(2345, "def", 4, 10);
        Artikel ar3 = new Artikel(1233, "abd", 3, 50);
        lager.legeAnArtikel(ar1);
        lager.legeAnArtikel(ar2);
        lager.legeAnArtikel(ar3);
        String aufgabeGrenze = "\n--------------------------------------------------------------------------\n";
        System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> {
            if(a1.getArt().compareTo(a2.getArt()) < 0){
                return true;
            }else{
                return false;
            }
        })));
        
        System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> a1.getBestand() < a2.getBestand())));
        System.out.println(Arrays.toString(lager.getSorted((a1,a2) -> a1.getPreis() < a2.getPreis())));
        System.out.println(aufgabeGrenze);
        
        lager.applyToArticles(a1 -> a1.preisAendern(-10)); //accept-method des  Interfaces as a method argument
        lager.toString();
        System.out.println(aufgabeGrenze);
        
        lager.applyToArticles(a1 -> a1.setArt("Sonderangebot"));
        lager.toString();
        System.out.println(aufgabeGrenze);
        
        //Verknüpfung der ii und iii
        lager.applyToArticles(a1 -> {a1.setArt("Sonderangebot"); a1.preisAendern(-10);});
        lager.toString();
        System.out.println(aufgabeGrenze);
        
        Lager lager2 = new Lager(10);
        Artikel arr1 = new Artikel(1543, "Tisch", 10, 25);
        Artikel arr2 = new Artikel(6545, "Laptop", 10, 30);
        Artikel arr3 = new Artikel(3242, "Taschenrechner", 20, 35);
        Artikel arr4 = new Artikel(1234, "CD", 2, 100);
        Artikel arr5 = new Artikel(2345, "CD", 4, 10);
        Artikel arr6 = new Artikel(1233, "CD", 3, 50);
        Artikel arr7 = new Artikel(3762, "Stephen King", 75, 200);
        Artikel arr8 = new Artikel(8487, "Stephen King", 80, 150);
        Artikel arr9 = new Artikel(8787, "Stephen King", 90, 55);
        lager2.legeAnArtikel(arr1);
        lager2.legeAnArtikel(arr2);
        lager2.legeAnArtikel(arr3);
        lager2.legeAnArtikel(arr4);
        lager2.legeAnArtikel(arr5);
        lager2.legeAnArtikel(arr6);
        lager2.legeAnArtikel(arr7);
        lager2.legeAnArtikel(arr8);
        lager2.legeAnArtikel(arr9);
        
        lager2.applyToSomeArticles((a1) -> a1.preisAendern(10), (a1) -> a1.getArt().equals("CD")); //(Operation, Bedingung)
        lager2.toString();
        System.out.println(aufgabeGrenze);
        
        lager2.applyToSomeArticles((a1) -> a1.preisAendern(-5), (a1) -> a1.getBestand() == 10);
        lager2.applyToSomeArticles((a1) -> a1.preisAendern(-10), (a1) -> a1.getBestand() != 10);
        lager2.toString();
        System.out.println(aufgabeGrenze);
        
        lager2.applyToSomeArticles((a1) -> a1.preisAendern(-5), (a1) -> a1.getArt().equals("Stephen King"));
        lager2.toString();
        System.out.println(aufgabeGrenze);
        
        lager2.applyToSomeArticles(a1 -> {a1.preisAendern(10); a1.preisAendern(-10);}, a1 -> {a1.getArt().equals("CD"); return a1.getBestand() != 10;});
        lager2.toString();
        System.out.println(aufgabeGrenze);
        
        System.out.println(lager2.getArticles(a1 -> a1.getArt().equals("Stephen King"), (a1,a2) -> a1.getPreis() < a2.getPreis()));
        System.out.println(aufgabeGrenze);
        
        List<Predicate<Artikel>> predicates = new ArrayList<>();
        Predicate<Artikel> pTest = (a1) -> a1.getArt().equals("Stephen King");
        Predicate<Artikel> pTest2 = (a1) -> a1.getPreis() > 100 && a1.getPreis() < 200;
        predicates.add(pTest);
        predicates.add(pTest2);
        System.out.println(Arrays.toString(lager2.filterAll(predicates)));
        
    }
}
