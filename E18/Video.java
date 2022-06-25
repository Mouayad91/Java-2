import java.util.Scanner;
/**
 * Eine Klasse, die ein Video von typ Artikel beschreibt, und mit 7 Attribute (artikelNr, art, bestand, preis, titel, spieldauer un jahr)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Kabas Algharib
 * 
 * @version 1.0
 */
public class Video extends Artikel{
    private String titel;
    private int spieldauer;
    private int jahr;
    private Scanner input = new Scanner(System.in);
    
    /**
     * Hier werden die Attribute zum erstellen eines Videos vom Benutzer eingegeben und geprüft.
     * 
     * @param artikelNr, art, bestand, preis, titel, spieldauer und jahr eines Videos
     */
    public Video(int artikelNr, int
    bestand, double preis, String titel, int spieldauer, int jahr){
        super(artikelNr,"Medien", bestand, preis);
        
        if(titel == null || titel.strip().length() <= 0){
            throw new IllegalArgumentException("Titel muss nicht leer sein!");
        }else{
            this.titel=titel;
        }
        
        if(spieldauer <= 0){
            throw new IllegalArgumentException("Spieldauer muss größer Null sein!");
        }else{
            this.spieldauer=spieldauer;
        }
        
        if(jahr >= 1900 && jahr <= 2022){
            this.jahr=jahr;;
        }else{
            throw new IllegalArgumentException("Das Jahr muss zwischen 1900 und 2022 sein!");
        } 
        
    }
    
    /**
     * Ein neues Video wird hier angelegt und wird Werte für die Attribute eingegeben.
     * 
     * @return Video Ein neues Video
     */
    public static Artikel videoEinfuegen(){
            Scanner input = new Scanner(System.in);
            System.out.print( "Artikelnummer eingeben: ");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie den Bestand des Videos: ");
            int bestand = input.nextInt();
            System.out.println("Geben Sie den Preis des Videos: ");
            double preis = input.nextDouble();
            input.nextLine();
            System.out.println("Geben Sie den Titel des Videos: ");
            String titel = input.nextLine().trim();
            System.out.println("Geben Sie den Spieldauer des Videos: ");
            int spieldauer = input.nextInt();
            System.out.println("Geben Sie das Jahr des Videos: ");
            int jahr = input.nextInt();
            return new Video( artikelNr, bestand, preis, titel, spieldauer, jahr);
    }
    
    /**
     * Mit der Methode bekommt man dan Titel eines Videos.
     * 
     * @return titel eines Videos
     */
    public String getTitel(){
        return titel;
    }
    
    /**
     * Mit der Methode bekommt man das Spieldauer eines Videos.
     * 
     * @return spieldauer eines Videos
     */
    public int getSpieldauer(){
        return spieldauer;
    }
    
    /**
     * Mit der Methode bekommt man das Jahr eines Videos.
     * 
     * @return jahr des Videos
     */
    public int getJahr(){
        return jahr;
    }
    
    /**
     * Mit der Methode bekommt man die Beschreibung eines Videos.
     * 
     * @return title eines Artikels
     */
    public String getBeschreibung(){
        return getTitel() + "\t";
    }
    
}
