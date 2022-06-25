import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Programm zum bearbeiten von Mathematische Funktionen mit verschiedene Varianten.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Dialog
{
    private final String FALSCHE_FUNKTION = "Falsche Funktion!";
    private final String FUNCTION_SELECTION = "Wollen Sie die Funktionen als...\n1. Lambda-Ausdruck aufrufen.\n2. AnonymeKlasse aufrufen.";
    private final String FUNCTION_SELECTION2 = "Wollen Sie die Funktionen als...\n1. Lambda-Ausdruck aufrufen.\n2. AnonymeKlasse aufrufen.\n3. Top-Level-Klasse.\n4. Static nested Class.";
    
    private Scanner input = new Scanner(System.in);
    private Aufgabe1 func = new Aufgabe1();
    
    /**
    * Die Funktionen werden hier angezeigt und abhängig vom Benutzer eine Funktion ausgewählt.
    * 
    * @return Eingabe vom Benutzer als Ganzzahl
    */
    public int einleseFunktion(){
        System.out.println("\n" + 1 + ". Quadratische Funktion berechnen.\n" + 2 + ". Fakultät berechnen.\n" + 3 + ". Exponential Funktion berechnen.\n" 
        + 4 + ". Fibonacci-Folge berechnen.\n" + 0 + ". Programm beenden.\n");
        return input.nextInt();
    }
    
    /**
    * Die Hauptschleife des Programms. Hier werden die benötigte Mthoden nacheinander ausgeführt.
    */
    public void start() {
         int eingabe;
         while (true) {
             try {
                 eingabe = einleseFunktion();
                 funktionAuswaehlen(eingabe);
             } catch (IllegalArgumentException e) {
                 System.out.println(e);
             } catch (InputMismatchException e) {
                 System.out.println(e + " Falsche Eingabe!");
                 input.nextLine();
             } catch (NullPointerException e) {
                 System.out.println("Bitte Wählen Sie zuerst eine Funktion aus!");
             } catch (Exception e) {
                 System.out.println(e + " Programm Error!");
             }
         }
    }
    
    /**
    * Hier wird vom Benutzer eine Funktion ausgewählt, die eine richtige Aufgabe1_Methode ausführt.
    * 
    * @param funktion Auswahl des Benutzers
    */
    public void funktionAuswaehlen(int funktion) throws Aufgabe1Exception {
        int x, y, wahl;
        switch(funktion){
            case 1:
                System.out.println(FUNCTION_SELECTION);
                wahl = input.nextInt();
                if(wahl < 1 || wahl > 2){
                    throw new IllegalArgumentException(FALSCHE_FUNKTION);
                }
                System.out.println("Bitte geben Sie die Zahlen ein;\nX: ");
                x = input.nextInt();
                System.out.println("Y: ");
                y = input.nextInt();
                if(wahl == 1){
                    func.lambdas(1,x,y);
                }else if(wahl == 2){
                    func.applyAndPrint(x,y,func.anonymeKlassen(1));
                }
                break;
            case 2:
                System.out.println(FUNCTION_SELECTION2);
                wahl = input.nextInt();
                if(wahl < 1 || wahl > 4){
                    throw new IllegalArgumentException(FALSCHE_FUNKTION);
                } 
                System.out.println("Bitte geben Sie die Zahlen ein;\nX: ");
                x = input.nextInt();
                System.out.println("Y: ");
                y = input.nextInt();
                if(wahl == 1){
                    func.lambdas(2,x,y);
                }else if(wahl == 2){
                    func.applyAndPrint(x,y,func.anonymeKlassen(2));
                }else if(wahl == 3){
                    FakultaetFunktion fakultaet = new FakultaetFunktion();
                    func.applyAndPrint(x,y,fakultaet);
                }else if(wahl == 4){
                    Aufgabe1.NestedFakultaetFunktion obj = new Aufgabe1.NestedFakultaetFunktion();
                    func.applyAndPrint(x,y,obj);
                }
                break;
            case 3:
                System.out.println(FUNCTION_SELECTION);
                wahl = input.nextInt();
                if(wahl < 0 || wahl > 2){
                    throw new IllegalArgumentException(FALSCHE_FUNKTION);
                }
                System.out.println("Bitte geben Sie die Zahlen ein;\nX: ");
                x = input.nextInt();
                System.out.println("Y: ");
                y = input.nextInt();
                if(wahl == 1){
                    func.lambdas(3,x,y);
                }else if(wahl == 2){
                    func.applyAndPrint(x,y,func.anonymeKlassen(3));
                }
                break;
            case 4:
                System.out.println(FUNCTION_SELECTION);
                wahl = input.nextInt();
                if(wahl < 0 || wahl > 2){
                    throw new IllegalArgumentException(FALSCHE_FUNKTION);
                }
                System.out.println("Bitte geben Sie die Zahlen ein;\nX: ");
                x = input.nextInt();
                System.out.println("Y: ");
                y = input.nextInt();
                if(wahl == 1){
                    func.lambdas(4,x,y);
                }else if(wahl == 2){
                    func.applyAndPrint(x,y,func.anonymeKlassen(4));
                }
                break;
            case 0:
                System.exit(1);
                break;
            default:
                System.out.println("Funktion exestiert nicht!");
                break;
        }
    }
    
    /**
     * Die Main Methode der Dialog_Klasse.
     * 
     * @param args
     */
    public static void main(String[] args){
        Dialog dialog = new Dialog();
        dialog.start();
    }
}
