/**
 * Eine Klasse, die das GGT von zwei Zahlen berechnet und die Ausführung Rekursiv durchzuführen.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class GGT {
    
  /**
  * Main-Methode unser Programm, um das Programm auszuführen und paar Teste durchzuführen. 
  * 
  * @param args
  */ 
  public static void main(String[] args) {
     GGT GGT = new GGT();
     int ggt1 = GGT.ggt(133,91);
     int ggt2 = GGT.ggt(84,66);
     int ggt3 = GGT.ggt(0,0);
     int ggt4 = GGT.ggt(45, 0);
     int ggt5 = GGT.ggt(0, 65);
     System.out.println(ggt1);
     System.out.println(ggt2);
     System.out.println(ggt3);
     System.out.println(ggt4);
     System.out.println(ggt5);

     //System.out.println(ggt(133,91));
     //System.out.println(ggt(91,133));
     //System.out.println(ggt(84,66));
  }
    
  /**
   * Mit dieser Methode wird das GGT von zwei Zahlen Rekursiv berechnet.
   * 
   * @param a, erste Zahl
   * @param b, zweite Zahl
   * @return ggt_zwei_zahlen, das ergebnis
   */
  public int ggt(int a, int b) {
     int ggt_zwei_zahlen = 0;
     if ((a < 0) && (b < 0)) {
       throw new IllegalArgumentException("Geben Sie bitte positive Zahlen ein!");
     }
     if (a < b) {
       int tmp = a;
       a = b;
       b = tmp;
     }
     if (b == 0) {
       return a;
     }
     if ( a % b == 0) {
       ggt_zwei_zahlen = b;
     } else {
       int tmp = a;
       a = b;
       b = tmp % b;
       ggt_zwei_zahlen = ggt(a,b);
     }

     return ggt_zwei_zahlen;
  }
}
