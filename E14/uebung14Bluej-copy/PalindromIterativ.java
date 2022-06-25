/**
 * Programm, um das eingegebene Wort auf Palindrom Iterativ zu testen.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class PalindromIterativ extends Palindorm_Iterative_Rekursive{
    
  /**
  * Hier wird das Typ der Algorithmus für die Undersuchung gewählt.
  * 
  */  
  public PalindromIterativ() {
    super(1);
  }

  /**
  * Methode testet das Wort durch Iterative Algorithmus auf Palindrom.
  * 
  * @param wort, das wort zum Testen.
  */
  @Override
  public boolean istPalindrom(String wort) {
    String wort_rek = new StringBuilder(wort).reverse().toString();
    int zaehler = 0;

    for(int i = 0; i < wort.length(); i++) {
      char char_rek =  wort_rek.charAt(i);
      char wort_char = wort.charAt(i);
      int wort_ascii_sub = (int) char_rek -  (int) wort_char;
      if ((wort_char == char_rek || (wort_ascii_sub == 32) || (wort_ascii_sub == -32))) {
        zaehler++;
      }
    }
    if (zaehler == wort.length()) {
      return true;
    }
    
    return false;
  }
}
