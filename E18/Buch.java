import java.util.Scanner;
/**
 * Eine Klasse, die einen Buch von typ Artikel beschreibt, und mit 7 Attribute (artikelNr, art, bestand, preis, autor, titel und verlag)
 * erstellt wird.
 * 
 * @author Monzr Hajy Omar und Kabas Algharib
 * 
 * @version 1.0
 */
public class Buch extends Artikel{
    private String titel;
    private String autor;
    private String verlag;
    private Scanner input = new Scanner(System.in);
    
    /**
     * Hier werden die Attribute zum erstellen eines Buchs vom Benutzer eingegeben und geprüft.
     * 
     * @param artikelNr, art, bestand, preis, autor, titel und verlag eines Buchs
     */
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag){
        super(artikelNr,"Medien", bestand, preis);
        
        if(titel == null || titel.strip().length() <= 0){
            throw new IllegalArgumentException("Titel muss nicht leer sein!");
        }else{
            this.autor=autor;
        }
        
        if(autor == null || autor.strip().length() <= 0){
            throw new IllegalArgumentException("Autor muss nicht leer sein!");
        }else{
            this.titel=titel;
        }
        
        if(verlag == null || verlag.strip().length() <= 0){
            throw new IllegalArgumentException("Verlag muss größer Null sein!");
        }else{
            this.verlag=verlag;
        } 
        
    }
    
    /**
     * Ein neues Buch wird hier angelegt und wird Werte für die Attribute eingegeben.
     * 
     * @return CD Ein neues Buch
     */
    public static Artikel buchEinfuegen(){
            Scanner input = new Scanner(System.in);
            System.out.print( "Artikelnummer eingeben: ");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie den Bestand des Buches: ");
            int bestand = input.nextInt();
            System.out.println("Geben Sie den Preis des Buches: ");
            double preis = input.nextDouble();
            input.nextLine();
            System.out.println("Geben Sie den Titel des Buches: ");
            String autor = input.nextLine().trim();
            System.out.println("Geben Sie den Autor des Buches: ");
            String titel = input.nextLine().trim();
            System.out.println("Geben Sie das verlag des Buches: ");
            String verlag = input.nextLine().trim();
            return new Buch( artikelNr, bestand, preis, autor, titel, verlag);
    }
    
    /**
     * Mit der Methode bekommt man dan Titel eines Buchs.
     * 
     * @return titel eines Buchs
     */
    public String getTitel(){
        return titel;
    }
    
    /**
     * Mit der Methode bekommt man dan Autor eines Buchs.
     * 
     * @return autor eines Buchs
     */
    public String getAutor(){
        return autor;
    }
    
    /**
     * Mit der Methode bekommt man dan Verlag eines Buchs.
     * 
     * @return verlag eines Buchs
     */
    public String getVerlag(){
        return verlag;
    }
    
    /**
     * Mit der Methode bekommt man die Beschreibung eines Buchs.
     * 
     * @return titel, autor eines Buchs
     */
    public String getBeschreibung(){
        return getTitel() + ": " + getAutor();
    }
}
