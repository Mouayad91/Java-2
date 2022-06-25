
/**
 * Eine Top-Level-Klasse der Mathematische Funktion Fakultaet mit der implementierund der apply-Methode.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class FakultaetFunktion extends Aufgabe1 implements MyFunction { //Top level Class
     /**
     * Methode berechnet das Fakultaet der eingegebenen Wert und gibt das Ergebnis zurück.
     *
     *@param i eingegebene Wert
     *@return ergebnis das Ergebnis der Methode
     **/
     public int apply(int i){
         try
         {
             check(i > 0 ,getErrorMsg());
         }
         catch (Aufgabe1Exception ae)
         {
              ae.printStackTrace();
         }
         int ergebnis = 1;
         
         for(int j = 1; j <= i; j++){
              ergebnis *= j;
         }
         return ergebnis;
     }
}
