/**
 * Programm, um das eingegebene Wort auf Palindrom Rekrsiv zu testen.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class PalindromRekursiv extends Palindorm_Iterative_Rekursive{
    
    /**
    * Hier wird das Typ der Algorithmus für die Undersuchung gewählt.
    * 
    */    
    public PalindromRekursiv() {
      super(2);
    }
  
    /**
     * Methode testet das Wort durch Rekursive Algorithmus auf Palindrom.
     * 
     * @param wort, das wort zum Testen.
     * @return ist_Palindorm, ob das Wort Palindrom ist oder nicht.
     */
     @Override
     public boolean istPalindrom(String wort) {
         boolean ist_Palindorm = false;
         char wort_rek =  wort.charAt(wort.length()-1);
         char wort_char = wort.charAt(0);
         int wort_ascii_sub = (int) wort_rek -  (int) wort_char;
         if ((wort_char == wort_rek) || (wort_ascii_sub ==32 ) || (wort_ascii_sub == -32)) {
           if((wort.length() == 2) || (wort.length() == 3)) {
             ist_Palindorm = true;
           } else {
             wort = wort.substring(1, wort.length()-1);
             ist_Palindorm = istPalindrom(wort);
           }
         }
         
         return ist_Palindorm;
     }
}
