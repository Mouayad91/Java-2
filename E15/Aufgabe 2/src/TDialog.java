import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * Programm zum erstellen und bearbeiten von Numbercruncher mit Hilfe von verschiedene Mathematische Funktionen.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */
public class TDialog {

  private Scanner input = new Scanner (System.in);
  private float[] arr;
  private NumberCruncher numberCruncher;
  private String[] operationen;

  /**
   * Die Main Methode der Klasse, um das Programm auszuführen.
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    new TDialog().start();
  }

  /**
   * Die Hauptschleife des Programms.
   */
  private void start() {
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
        System.out.println("Numbercrunch exestiert nicht! Bitte erstellen Sie zuerst ein Numbercrunch.");
      } catch (Exception e) {
        System.out.println(e + " Programm beendet");
      }
    }
  }

  /**
   * Die Funktionen werden hier angezeigt.
   *
   * @return Eingabe vom Benutzer als Ganzzahl
   */
  private int einleseFunktion() {
    System.out.println(
        1 + ": Numbercrunch formen;\n" + 2 + ": Float-Array zeigen;\n" + 3 + ": Mathmatische Operationen auswählen;\n" + 4
            + ": Operationen-Liste anzeigen;\n" + 5 + ": Mathmatische Operationen ausführen.\n" + 0 + ": beenden -> ");
    return input.nextInt();
  }

  /**
   * Mit dieser Methode wird abhängig vom Benutzer ein Numbercruncher selbst oder mit zufälligen Zahlen erstellt und dann mit der selbst ausgewählte Klasse bearbeitet.
   *
   * @return numCruncher das vom Benutzer erstellte Numbercruncher
   */
  private NumberCruncher numberCruncherErstellen(float[] arr) {
    System.out.println("Wollen Sie die Zahlen für die Liste eingeben oder zufällige Zahlen hinzügen:\n" +
        "1: Zahlen selbst hinzufügen.\n"+
        "2: Zufällige Zahlen hinzufühgen.");
    int in = input.nextInt();

    if(!((in == 1) || (in == 2))) {
      boolean term = true;
      while (term) {
        System.out.println("Bitte geben sie\n"+
            "1: Zahlen selbst hinzufügen.\n"+
            "2: Zufällige Zahlen hinzufühgen.");
        in = input.nextInt();
        if((in == 1) || (in == 2)) {
          term = false;
        }
      }
    }

    if (in == 1) {
      System.out.println("Geben Sie bitte "+arr.length+" Zahlen ein");
      int index = 0;
      while (index != arr.length) {
        arr[index] = input.nextFloat();
        index++;
      }
    } else if (in == 2) {
      Random random = new Random();
      System.out.println(arr.length);
      for (int i = 0; i < arr.length; i++) {
        arr[i] = new Random().nextFloat() * 100;
      }
    }
    System.out.print("Wählen Sie bitte welche Art von NumberCruncher \n"+
        "Geben Sie bitte 1 für NumberCruncherAnonym oder 2 für NumberCruncherTopLevel ein:\n");
    //input.nextLine();
    int wahl = input.nextInt();
    if(!((wahl == 1) || (wahl == 2))) {
      boolean term = true;
      while (term) {
        System.out.println("Geben Sie bitte 1 für NumberCruncherAnonym oder 2 für NumberCruncherTopLevel ein !");
        wahl = input.nextInt();
        if((wahl == 1) || (wahl == 2)) {
          term = false;
        }
      }
    }
    NumberCruncher numCruncher = null;
    if( wahl == 1) {
      numCruncher = new NumberCruncherAnonym(arr);
    }
    if (wahl == 2) {
      numCruncher = new NumberCruncherTopLevel(arr);
    }

    return numCruncher;
  }
  /**
   * Hier wird abhängig vom benutzer eine Funktion ausgewählt und die richtige Methode ausgeführt.
   *
   * @param funktion Befehl des benutzer
   */
  private void funktionAuswaehlen(int funktion){
    switch(funktion){
      case 1: {
        System.out.println("Geben Sie bitte die Anzahl der Zahlen ein");
        int anzahl = input.nextInt();
        while (anzahl <= 1) {
          System.out.println("Geben Sie bitte eine Zahl, die größer gleich eins, ein");
          anzahl = input.nextInt();
        }
        arr = new float[anzahl];
        numberCruncher = numberCruncherErstellen(arr);
      }
        break;

      case 2: {
        if(numberCruncher != null) {
          arr = numberCruncher.getNumbers();
          System.out.println("Array:\n"+ Arrays.toString(arr));
        } else {
          System.out.println("Erstellen Sie bitte einen NumberCruncher");
        }
      }
        break;

      case 3: {
        System.out.println("Geben Sie bitte die Operationen, die Sie brauchen.\n"  +
            "Mögliche Operationen sind: sum swirl divide subtract average");
        input.nextLine();
        String op = input.nextLine().trim();
        boolean term = true;
        String msg = "Wollen Sie noch eine Operation eingeben, wenn ja geben Sie bitte 1 ein, wenn nein geben Sie bitte irgendwelche andere Zahl ein!";
        System.out.println(msg);
        int wahl = input.nextInt();
        while (wahl == 1) {
          op += ",";
          System.out.println("Mögliche Operationen sind: sum swirl divide subtract average");
          input.nextLine();
          op += input.nextLine().trim();
          System.out.println(msg);
          wahl = input.nextInt();
        }
        operationen = op.split(",");
      }
        break;

      case 4:{
        if (operationen.length > 0) {
          System.out.println(Arrays.toString(operationen));
        } else {
          System.out.println("Erstellen Sie bitte Operationen wie sum, divide, ....");
        }
      }
        break;

      case 5:{
        if (numberCruncher != null) {
            numberCruncher.crunch(operationen);
        } else {
          System.out.println("Erstellen Sie bitte Operationen wie sum, divide, ....");
        }
      }
      break;

      case 0: System.exit(1);
        break;

      default:
        System.out.println("Funktion existiert nicht!");
    }

  }

}
