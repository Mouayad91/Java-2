import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
 * Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
 * moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
 * die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
 * 
 * <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
 * @author christopher
 *
 */
public class Ueb18Fassade {

    private Scanner input = new Scanner(System.in);
    
    /**
     * Loest die Aufgabe (c) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     *     <li>Unterkategorie (alphabetisch)</li>
     *     <li>Bestand</li>
     *     <li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_c_i(Lager lager) {
        System.out.println("Wie möchten Sie die Artikel sortieren...\n1. Nach Art (Alphabetisch) sortieren.\n2. Nach Bestand sortieren.\n3. Nach Preis sortieren.\n");
        int wahl = input.nextInt();
        if(wahl == 1){
            return lager.getSorted((a1,a2) -> {
            if(a1.getArt().compareTo(a2.getArt()) < 0){
                return true;
            }else{
                return false;
            }
        });
        }else if(wahl == 2){
            return lager.getSorted((a1,a2) -> a1.getBestand() < a2.getBestand());
        }else if(wahl == 3){
            return lager.getSorted((a1,a2) -> a1.getPreis() < a2.getPreis());
        }else{
            System.out.println("Funktion existiert nicht!");
        }
        return null;
    }
     
    /**
     * Loest die Aufgabe (c) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_c_ii(Lager lager) {
        lager.applyToArticles(a -> a.preisAendern(-10));
    }
    
    /**
     * Loest die Aufgabe (c) iii.
     * <br />
     * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
     * @param lager Das Lager mit den Artikeln, deren Bezeichnungen geaendert werden sollen.
     */    
    public void aufgabe_c_iii(Lager lager) {
        lager.applyToArticles(a -> a.setArt("Sonderangebot"));
    }
    
    /**
     * Loest die Aufgabe (c) iv.
     * <br />
     * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
     * um 10 % reduziert und alle Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
     * @param lager Das Lager mit den Artikeln, deren Preise und Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_c_iv(Lager lager) {
        lager.applyToArticles(a -> {a.setArt("Sonderangebot"); a.preisAendern(-10);});
    }
    
    /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) {
        lager.applyToSomeArticles(a -> a.preisAendern(10), a -> a instanceof CD);
    }
    
    /**
    * Loest die Aufgabe (h) ii.
    * <br />
    * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
    * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
    */
    public void aufgabe_h_ii(Lager lager) {
        lager.applyToSomeArticles((a) -> a.preisAendern(-5), (a) -> a.getBestand() == 10);
        lager.applyToSomeArticles((a) -> a.preisAendern(-10), (a) -> a.getBestand() != 10);
    }
    
    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) {
        lager.applyToSomeArticles((a) -> a.preisAendern(-5), (a) -> a instanceof Buch && ((Buch)a).getAutor().equals(gesuchterAutor));
    }
    
    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) {
        lager.applyToSomeArticles(a -> {a.preisAendern(10); a.preisAendern(-10);},  a -> a instanceof CD && a.getBestand() != 10);
    }
    
    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln. 
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren. 
     */
    public List aufgabe_h_v(Lager lager) {
        return lager.getArticles(a -> a instanceof Buch, (a1,a2) -> {
            if(((Buch)a1).getAutor().compareTo(((Buch)a2).getAutor()) < 0){
                return true;
            }else{
                return false;
            }
        });
    }
    
    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) {
        List<Predicate<Artikel>> predicates = new ArrayList<>();
        Predicate<Artikel> pTest = (a) -> a instanceof Buch;
        Predicate<Artikel> pTest2 = (a) -> ((Buch)a).getAutor().equals(gesuchterAutor);
        Predicate<Artikel> pTest3 = (a) -> a.getPreis() > minPreis && a.getPreis() < maxPreis;
        predicates.add(pTest);
        predicates.add(pTest2);
        predicates.add(pTest3);
        return lager.filterAll(predicates);
    }
}