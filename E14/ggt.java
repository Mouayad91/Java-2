import java.util.Scanner;

/**
 * Write a description of class ggt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ggt{
    private static final String FEHLER = "x und y müssen größer oder gleich 0 sein!";
    
    public int ggtBerechnen(int a, int b) throws ggtException {
        check(a >= 0 && b >= 0, FEHLER);
        int ergebnis = 0;
        if(b == 0){
            ergebnis = a;
        }else if (a == 0){
            ergebnis = b;
        }else{    
            ergebnis = ggtBerechnen(b, a % b);
        }
        System.out.println(ergebnis);
        return ergebnis;
    }
    
    public int ggT(int a, int b){
        int rest;
        while(b != 0){
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
    
    public void check(boolean bedingung, String msg) throws ggtException {
        if(!bedingung){
            throw new ggtException(msg);
        }
    }
    
    public static void main(String[] args) throws ggtException {
        ggt ggt = new ggt();
        Scanner input = new Scanner(System.in);
        System.out.println("Zahl1 = ");
        int zahl1 = input.nextInt();
        System.out.println("Zahl2 = ");
        int zahl2 = input.nextInt();
        ggt.ggtBerechnen(zahl1, zahl2);
    }
}
