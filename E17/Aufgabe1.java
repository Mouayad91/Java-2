import java.util.function.*;

/**
 * Eine Klasse, die verschiedene Mathematische Funktionen implementiert.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class Aufgabe1
{
    private static final String FALSCHR_WERT = "Flasche Eingabe! Die eingegebene Werte müssen größer als 0 sein!";
    //private static FInterface f;
    
    /**
     * Methode gibt ein Lambda-Ausdruck zurück. Hier wird abhängig von der Eingabe ein Lambda-Ausdruck, das nur gerade oder ungerade Zahlen erlaubt zurück.
     *
     *@param wahl die Eingabe
     *@return odd Lambda-Ausdruck erlaubt nur ungerade Zahlen
     *@return even Lambda-Ausdruck erlaubt nur gerade Zahlen
     **/
    public static IntPredicate condition(int wahl){
        IntPredicate odd = new IntPredicate(){
            @Override
            public boolean test(int number){
                return number % 2 != 0;
            }
        };
        
        IntPredicate even = (number) -> number % 2 == 0;
        
        if(wahl == 1){
            return odd;
        }else if(wahl == 2){
            return even;
        }
        return null;
    }
    
    /**
     *In dieser Methode werden mehrere Lambda-Ausdrücke erstellt. Hier wird abhängig von der Eingabe und zwei natürliche Zahlen ein Lambda-Ausdruck erstellt, dann die Methode-applyAndPrint mit einem lambda-Ausdruck und zwei natuerliche Zahlen als argumente aufruft und eine bestimme Mathematische Funktion bearbeitet.
     *
     *@param wahl die Eingabe um das lambda-Ausdruck auszuwaehlen
     *@param x die erste natuerliche Zahl
     *@param y die zweite natuerliche Zahl
     **/
    public void lambdas(int wahl,int x, int y) throws Aufgabe1Exception {
        MyFunction quadrat1 = (i) -> {
            try
            {
                check(i > 0 ,FALSCHR_WERT);
            }
            catch (Aufgabe1Exception ae)
            {
                ae.printStackTrace();
            }
            return i*i;
        };
        
        MyFunction fakultaet1 = (i) -> {
            try
            {
                check(i > 0 ,FALSCHR_WERT);
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
        };
        
        MyFunction exponentialFunktion1 = (i) -> {
            try
            {
                check(i > 0 ,FALSCHR_WERT);
            }
            catch (Aufgabe1Exception ae)
            {
                ae.printStackTrace();
            }
            int ergebnis = 1;
            for(int exponent = i + 1; exponent != 0; exponent--){
                ergebnis *= i;
            }
            return ergebnis;
        };
        
        MyFunction fibonacci1 = (i) -> {
            try
            {
                check(i > 0 ,FALSCHR_WERT);
            }
            catch (Aufgabe1Exception ae)
            {
                ae.printStackTrace();
            }
            int fib = 1;
            for(int fib1 = 1, fib2 = 1, j = 3; j <= i; j++){
                fib = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib;
            }
            return fib;
        };
        
        if(wahl == 1){
            applyAndPrint(x,y,quadrat1);
        }else if(wahl == 2){
            applyAndPrint(x,y,fakultaet1);
        }else if(wahl == 3){
            applyAndPrint(x,y,exponentialFunktion1);
        }else if(wahl == 4){
            applyAndPrint(x,y,fibonacci1); 
        }        
    }
    
    /**
     *Methode gibt ein Lambda-Ausdruck zurück, das als Anonyme-Klasse implementiert wird. Hier wird abhängig von der Eingabe eine bestimmte Lambda-Ausdruck zurückgegeben.
     *
     *@param wahl die Eingabe um das angeforderte Lambda-Ausdruck zurückzugeben.
     *@return quadrat2 Lambda-Ausdruck berechnet die quadratische Werte der Zahlen.
     *@return fakultaet2 Lambda-Ausdruck berechnet die Fakultaet Werte der Zahlen.
     *return exponentialFunktion2 Lambda-Ausdruck berechnet eine exponential Funktion.
     *return fibonacci2 Lambda-Ausdruck berechnet die fibonacci Werte der Zahlen.
     **/
    public MyFunction anonymeKlassen(int wahl){
        MyFunction quadrat2 = new MyFunction(){
            public int apply(int i){
                try
                {
                    check(i > 0 ,FALSCHR_WERT);
                }
                catch (Aufgabe1Exception ae)
                {
                    ae.printStackTrace();
                }
                return i*i;
            }
        };
        
        MyFunction fakultaet2 = new MyFunction(){
            public int apply(int i){
                try
                {
                    check(i > 0 ,FALSCHR_WERT);
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
        };
        
        MyFunction exponentialFunktion2 = new MyFunction(){
            public int apply(int i){
                try
                {
                    check(i > 0 ,FALSCHR_WERT);
                }
                catch (Aufgabe1Exception ae)
                {
                    ae.printStackTrace();
                }
                int ergebnis = 1;
                for(int exponent = i + 1; exponent != 0; exponent--){
                    ergebnis *= i;
                }
                return ergebnis;
            }
        };
        
        MyFunction fibonacci2 = new MyFunction(){
            public int apply(int i){
                try
                {
                    check(i > 0 ,FALSCHR_WERT);
                }
                catch (Aufgabe1Exception ae)
                {
                    ae.printStackTrace();
                }
                int fib = 1;
                for(int fib1 = 1, fib2 = 1, j = 3; j <= i; j++){
                    fib = fib1 + fib2;
                    fib1 = fib2;
                    fib2 = fib;
                }
                return fib;
            }
        };
        
        if(wahl == 1){
            return quadrat2;
        }else if(wahl == 2){
            return fakultaet2;
        }else if(wahl == 3){
            return exponentialFunktion2;
        }else if(wahl == 4){
            return fibonacci2;
        }
        return null;
    }
    
    /**
     * Eine Static-Nested-Innere-Klasse, die die apply-Methode des Inerfaces MyFunction implementiert.
     */
    public static class NestedFakultaetFunktion implements MyFunction{ // Static nested Class            
           public int apply(int i){
                if(i <= 0){ //check-method cannot be called here, because its not a static context as this static class is.
                     throw new IllegalArgumentException(getErrorMsg());
                }
                int ergebnis = 1;
                for(int j = 1; j <= i; j++){
                    ergebnis *= j;
                }
                return ergebnis;
           }
    }
    
    /**
     *Eine Methode, die zwei natürliche Zahlen i und j sowie ein Lambda-Ausdruck nimmt. Die Methode wendet sich an die Zahlen zwischen i und j und berechnet für diese die eingegebene Mathematische Funktion im Lambda-Ausdruck, und gibt das Ergebnis aus.
     *
     *@param i die erste natuerliche Zahl
     *@param j die zweite natuerliche Zahl
     *@param funktion als Lambda-Ausdruck
     **/
    public void applyAndPrint(int i, int j, MyFunction funktion) throws Aufgabe1Exception {
        check(i > 0 && j > 0, FALSCHR_WERT);
        System.out.print("Ergebnis: " + "[" );
        for(int x = i; x <= j; x++){
            System.out.print(funktion.apply(x));
            if(x == j){
                continue;
            }
            System.out.print(",");
        }
        System.out.println("]");
    }
    
    /**
     *Methode testet die eingegebene Werte für bestimmte Bedingung.
     *
     *@param b
     *@param msg Error-Nachricht als Ausgabe
     **/
    public void check(boolean b, String msg) throws Aufgabe1Exception {
        if(!b){
            throw new Aufgabe1Exception(msg);
        }
    }
    
    /**
     * Mit der Methode bekommt man das String-Error-Nachricht zurück.
     * 
     * @return FALSCHR_WERT
     */
    public static String getErrorMsg(){
        return FALSCHR_WERT;
    }
    
    /**
     *Main-Methode der Klasse, hier wird das Programm getestet, wobei man die odd oder even Zahlen in bestimmte Lamdba-Ausdrücke verwendet und dann mit der applyAndPrint-Methode das Ergebnis ausgeben.
     * 
     * @param args
     */
    public static void main(String[] args) throws Aufgabe1Exception {
        Aufgabe1 obj = new Aufgabe1();
        int x = 2;
        int y = 4;
        obj.applyAndPrint(x, y, (i) -> {
            if(condition(2).test(i) == true){
                return i*i;
            }else{
                return 0;
            }
        });
        //obj.applyAndPrint(x, y, f.conditionateInput(condition(2)));
        //obj.applyAndPrint(x, y, f.conditionateOutput(condition(2)));
        
        obj.applyAndPrint(x, y, (i) -> {
                int ergebnis = 1;
                for(int j = 1; j <= i; j++){
                    ergebnis *= j;
                }
                if(condition(1).test(ergebnis) == true){
                    return ergebnis;
                }else{
                    return 0;
                }
        });
    }
}
