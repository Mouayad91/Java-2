import java.util.Scanner;
/**
 * Eine Klasse, die ein CD von typ Artikel beschreibt, und mit 7 Attribute (artikelNr, art, bestand, preis, interpret, titel und anzahlTitel)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Kabas Algharib
 * 
 * @version 1.0
 */
public class CD extends Artikel{
    private String interpret;
    private String titel;
    private int anzahlTitel;
    private Scanner input = new Scanner(System.in);

    /**
     * Hier werden die Attribute zum erstellen eines CDs vom Benutzer eingegeben und geprüft.
     * 
     * @param artikelNr, art, bestand, preis, interpret, titel und anzahlTitel eines CDs
     */
    public CD(int artikelNr, int bestand,
        double preis, String interpret, String titel, int anzahlTitel){

        super(artikelNr,"Medien", bestand, preis);
        
        if(interpret == null || interpret.strip().length() <= 0){
            throw new IllegalArgumentException("Interpret muss nicht leer sein!");
        }else{
            this.interpret=interpret;
        }
        
        if(titel == null || titel.strip().length() <= 0){
            throw new IllegalArgumentException("Titel muss nicht leer sein!");
        }else{
            this.titel=titel;
        }
        
        if(anzahlTitel <= 0){
            throw new IllegalArgumentException("Anzahltitel muss größer Null sein!");
        }else{
            this.anzahlTitel=anzahlTitel;
        } 
        
    }
    
    /**
     * Ein neues CD wird hier angelegt und wird Werte für die Attribute eingegeben.
     * 
     * @return CD Ein neues CD
     */
    public static Artikel cdEinfuegen(){
        Scanner input = new Scanner(System.in);
        System.out.print( "Artikelnummer eingeben: ");
        int artikelNr = input.nextInt();
        System.out.println("Geben Sie den Bestand des CDs: ");
        int bestand = input.nextInt();
        System.out.println("Geben Sie den Preis des CDs: ");
        double preis = input.nextDouble();
        input.nextLine();
        System.out.println("Geben Sie den Interpret des CDs: ");
        String interpret = input.nextLine().trim();
        System.out.println("Geben Sie den Titel des CDs: ");
        String titel = input.nextLine().trim();
        System.out.println("Geben Sie den AnzahlTitel des CDs: ");
        int anzahlTitel = input.nextInt();
        return new CD( artikelNr, bestand, preis, interpret, titel, anzahlTitel);
    }
    
    /**
     * Mit der Methode bekommt man dan Interpret eines CDs.
     * 
     * @return interpret eines CDs
     */
    public String getInterpret(){
        return interpret;
    }
    
    /**
     * Mit der Methode bekommt man dan titel eines CDs.
     * 
     * @return titel eines CDs
     */
    public String getTitel(){
        return titel;
    }
    
    /**
     * Mit der Methode bekommt man dan Anzahltitel eines CDs.
     * 
     * @return anzahlTitel eines CDs
     */
    public int getAnzahlTitel(){
        return anzahlTitel;
    }
    
    /**
     * Mit der Methode bekommt man die Beschreibung eines CDs.
     * 
     * @return interpret, titel eines CDs
     */
    public String getBeschreibung(){
        return getInterpret()+ ": " + getTitel();
    }

}
