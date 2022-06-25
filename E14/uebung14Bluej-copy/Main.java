/**
 * Programm, um die Palindrom-Klassen zu testen.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Main {
  public static void main(String[] args) {
    PalindromRekursiv p1 = new PalindromRekursiv();
    PalindromIterativ p2 = new PalindromIterativ();
    boolean b1 = p1.istPalindrom("OTTO");
    boolean b2 = p1.istPalindrom("Otto");
    boolean b3 = p1.istPalindrom("ottO");
    boolean b4 = p1.istPalindrom("oTto");
    boolean b5 = p1.istPalindrom("otTo");

    boolean b6 = p1.istPalindrom("otoTo");
    boolean b7 = p1.istPalindrom("otoTo");
    boolean b8 = p1.istPalindrom("otoTo");
    boolean b9 = p1.istPalindrom("otoTo");
    System.out.println(b1);
    System.out.println(b2);
    System.out.println(b3);
    System.out.println(b4);
    System.out.println(b5);
    System.out.println(b6);
    System.out.println(b7);
    System.out.println(b8);
    System.out.println(b9);


    boolean e1 = p2.istPalindrom("OTTO");
    boolean e2 = p2.istPalindrom("Otto");
    boolean e3 = p2.istPalindrom("ottO");
    boolean e4 = p2.istPalindrom("oTto");
    boolean e5 = p2.istPalindrom("otTo");

    boolean e6 = p2.istPalindrom("otoTo");
    boolean e7 = p2.istPalindrom("otoTo");
    boolean e8 = p2.istPalindrom("otoTo");
    boolean e9 = p2.istPalindrom("otoTo");
    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e3);
    System.out.println(e4);
    System.out.println(e5);
    System.out.println(e6);
    System.out.println(e7);
    System.out.println(e8);
    System.out.println(e9);

  }
}
