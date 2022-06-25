import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programm zum bearbeiten und testen der DoppeltVerketteteListe.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class Dialog
{
    private final String LIST_ERROR = "DoppletVerketteteListe existiert nicht! Bitte erstellen Sie zuerst eine DoppletVerketteteListe!.";   
    private final String FUNKTION_ERROR = "Falsche Funktion!";   
    private Scanner input = new Scanner(System.in);

    List liste;
    Type type;
    Object o;
    
    /**
    * Die Funktionen werden hier angezeigt und abhängig vom Benutzer eine Funktion ausgewählt.
    * 
    * @return Eingabe vom Benutzer als Ganzzahl
    */
    public int einleseFunktion(){
        System.out.println(1 + ". Doppeltverketteteliste erstellen.\n" + 2 + ". Anzahl der elemente (Size()).\n" + 3 + ". Prüfen, ob die liste leer ist oder nicht (isEmpty()).\n" + 4 + ". Prüfen ob ein Object in der liste existiert oder nicht (contains()).\n"
        + 5 + ". Die liste als Array umwandeln (toArray()).\n" + 6 + ". Element addieren (add()).\n" + 7 + ". Elements löschen (remove()).\n" + 8 + ". Mehrere elemente als collection addieren (addAll()).\n" + 9 + ". Liste leeren (clear()).\n" + 10 + ". Element mit index zurückbekommen (get()).\n" + 11  + ". Inhalt eines elementes ändern und mit index aufrufen (set()).\n" + 12 + ". Element mit index-stelle addieren (add()). \n"  + 13 + ". Element mit index-stelle löschen (remove()). \n" + 14 + ". Index einer element in der liste anzeigen (indexOf()).\n" + 15 + ". Inhalt der liste anzeigen. (toString())\n" + 0 + ". Programm beenden.\n");
        return input.nextInt();
    }
    
    /**
    * Hier wird vom Benutzer eine Funktion ausgewählt, die eine richtige DoppeltVerketteteListe-Methode ausführt/aufruft.
    * 
    * @param funktion Auswahl des Benutzers
    */
    public void funktionAuswaehlen(int funktion){
        switch(funktion){
            case 1:
                System.out.println("\nFür welche Datentyp möchten Sie die liste ersterllen....\n1. Strings.\n2. Integers.\n3. Floats.\n4. Doubles.\n5. Longs.\n6. Booleans.\n");
                int wahl = input.nextInt();
                if(wahl == 1){
                    liste = new DoppeltVerketteteListe<String>();
                    type = Type.STRING;
                }else if(wahl == 2){
                    liste = new DoppeltVerketteteListe<Integer>();
                    type = Type.INTEGER;
                }else if(wahl == 3){
                    liste = new DoppeltVerketteteListe<Float>();
                    type = Type.FLOAT;
                }else if(wahl == 4){
                    liste = new DoppeltVerketteteListe<Double>();
                    type = Type.DOUBLE;
                }else if(wahl == 5){
                    liste = new DoppeltVerketteteListe<Long>();
                    type = Type.LONG;
                }else if(wahl == 6){
                    liste = new DoppeltVerketteteListe<Boolean>();
                    type = Type.BOOLEAN;
                }else{
                    System.out.println(FUNKTION_ERROR);
                }
                break;
            case 2:
                check();
                System.out.println(liste.size());
                break;
            case 3:
                check();
                System.out.println(liste.isEmpty());
                break;
            case 4:
                check();
                System.out.println("Bitte geben Sie den gesuchten ELement ein: ");
                o = typeSafeInput();
                System.out.println(liste.contains(o));
                break;
            case 5:
                check();
                if(liste.isEmpty() == true){
                    throw new IllegalArgumentException("DoppeltVerketteteListe ist leider leer! Bitte fügen Sie zuerst elemente ein.");
                }
                Object[] array = null;
                if(type == Type.STRING){
                    array = new String[liste.size()];
                }else if(type == Type.INTEGER){
                    array = new Integer[liste.size()];
                }else if(type == Type.FLOAT){
                    array = new Float[liste.size()];
                }else if(type == Type.DOUBLE){
                    array = new Double[liste.size()];
                }else if(type == Type.LONG){
                    array = new Long[liste.size()];
                }else if(type == Type.BOOLEAN){
                    array = new Boolean[liste.size()];
                }
                System.out.println(Arrays.toString(liste.toArray(array)));
                break;
            case 6:
                check();
                System.out.println("Bitte geben Sie den element zum Addieren ein: ");     
                o = typeSafeInput();
                liste.add(o);
                break;
            case 7:
                check();
                System.out.println("Bitte geben Sie den element zum Löschen ein: ");     
                o = typeSafeInput();
                liste.remove(o);
                break;
            case 8:
                check();
                System.out.println("Bitte geben Sie die elemente zum einfügen ein: ");
                Collection newList = null;
                if(type == Type.STRING){
                    newList = new ArrayList<String>();
                }else if(type == Type.INTEGER){
                    newList = new ArrayList<Integer>();
                }else if(type == Type.FLOAT){
                    newList = new ArrayList<Float>();
                }else if(type == Type.DOUBLE){
                    newList = new ArrayList<Double>();
                }else if(type == Type.LONG){
                    newList = new ArrayList<Long>();
                }else if(type == Type.BOOLEAN){
                    newList = new ArrayList<Boolean>();
                }
                int index = 1;
                while(true){
                    System.out.println("Element " + index + ": ");
                    o = typeSafeInput();
                    newList.add(o);
                    index++;
                    System.out.println("\n1. Möchten Sie weitere Elemente einfügen.\n2. Keine weitere Elemente einfügen.");
                    wahl = input.nextInt();
                    if(wahl == 1){
                        continue;
                    }else if(wahl == 2){
                        break;
                    }else{
                        System.out.println(FUNKTION_ERROR);
                        break;
                    }
                }
                liste.addAll(newList);
                break;
            case 9:
                check();
                liste.clear();
                break;
            case 10:
                check();
                System.out.println("Bitte geben Sie die Index-Stelle des Elements ein: ");
                wahl = input.nextInt();
                if(wahl < 0 || wahl >= liste.size()){
                    throw new IllegalArgumentException("Invalid index!");
                }
                System.out.println("Inahlt: " + liste.get(wahl));
                break;
            case 11:
                check();
                System.out.println("An welche Index-Stelle möchten Sie den Element ändern: ");
                wahl = input.nextInt();
                System.out.println("Geben Sie den neuen ELement zum ersetzen ein: ");
                o = typeSafeInput();
                liste.set(wahl, o);
                break;
            case 12:
                check();
                System.out.println("An welche Index-Stelle möchten Sie den Element einfügen: ");
                wahl = input.nextInt();
                System.out.println("Geben Sie den neuen Element zum Einfügen ein: ");
                o = typeSafeInput();
                liste.add(wahl, o);
                break;
            case 13:
                check();
                System.out.println("An welcher Index-Stelle möchten Sie den Element löschen: ");
                wahl = input.nextInt();
                liste.remove(wahl);
                break;
            case 14:
                check();
                System.out.println("Bitte geben Sie den Element ein: ");
                o = typeSafeInput();
                System.out.println("Index: " + liste.indexOf(o));
                break;
            case 15:
                check();
                System.out.println(liste.toString());
                break;
            case 0:
                System.exit(1);
                break;
            default:
                System.out.println(FUNKTION_ERROR);
                break;      
        }
    }
    
    /**
     * Methode testet Typsicherheit für das Input des Benutzers.
     * @return Object 
     */
    private Object typeSafeInput() {
        Object o;
        if (type == Type.INTEGER) {
            o = input.nextInt();
        } else if (type == Type.DOUBLE) {
            o = input.nextDouble();
        } else if(type == Type.STRING){
            input.nextLine();
            o = input.nextLine();
        }else if(type == Type.FLOAT){
            o = input.nextFloat();
        }else if(type == Type.LONG){
            o = input.nextLong();
        }else if(type == Type.BOOLEAN){
            o = input.nextBoolean();
        }else{
            o = input.next();
        }
        return  o;
    }
    
    /**
     * Methode überprüft, ob die Liste erstellt wurde oder nicht.
     *
     */
    public void check(){
        if(liste == null){
            throw new IllegalArgumentException(LIST_ERROR);
        }
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
                System.out.println(LIST_ERROR);
            } catch (Exception e) {
                System.out.println(e + " Programm Error!");
            }
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
