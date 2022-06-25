
/**
 * Eine Top-Level-Klasse der Mathematische Funktion Fakultaet mit der implementierund der apply-Methode.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class FakultaetFunktion implements MyFunction { //Top level Class
     /**
     * Methode berechnet das Fakultaet der eingegebenen Wert und gibt das Ergebnis zurück.
     *
     *@param i eingegebene Wert
     *@return ergebnis das Ergebnis der Methode
     **/
     public int apply(int i){
         if(i <= 0){
             throw new IllegalArgumentException("Die Zahl muss größer als null sein!");
         }
         int ergebnis = 1;
         
         for(int j = 1; j <= i; j++){
              ergebnis *= j;
         }
         return ergebnis;
     }
     
     public static void main(String[] args) throws Aufgabe1Exception {
         FakultaetFunktion fakultaet = new FakultaetFunktion();
         MyFunction function = fakultaet::apply;
         Aufgabe1 berechnung = new Aufgabe1();
         berechnung.applyAndPrint(2,5,function);
     }
}
