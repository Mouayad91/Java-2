import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programm zum erstellen und bearbeiten von Personen auf eine Warteschlange.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class QueueDialog {
    private Queue[] queue;
    private Scanner input = new Scanner(System.in);
    
    /**
     * Hier wird abhängig vom programmierer Methoden durch 
     * bestimmte Eingaben getestet und die richtige Methode ausgeführt.
     * 
     */
    public void start2() {
        queue = new Queue[4];
        System.out.println("Eine Warteschlaenge mit der große 2 wird erstellt!" );
        queue[0] = new PersonQueue(2);
        System.out.println("Einfügen eine neu Person: " );
        queue[0].addLast(new Person("Monzr", "Hajy Omar", "Student"));
        /*
        queue[1] = new PersonQueue(2);
        queue[2] = new PersonQueue();
        queue[3] = new PersonQueue();
        */
        System.out.println(queue[0].get(0));
        System.out.println("Ist die Warteschlange voll; "+ "ergebnis: " + queue[0].full());
        System.out.println("Ist die Warteschlange leer; " + "ergebnis: " + queue[0].empty());
        System.out.println("Anzahl der personen in Queue ist: " + queue[0].size());
        System.out.println("Einfügen eine neu Person: " );
        queue[0].addLast(new Person("Anna", "Müller", "Engenieer"));
        System.out.println(queue[0].get(1));
        System.out.println("Person an der ersten Stelle wird entfernt!\n" + queue[0].removeFirst());
        System.out.println("Einfügen eine neu Person: " );
        queue[0].addLast(new Person("Erik", "Emmerich", "Bauer"));
        print(queue[0]);
        
        System.out.println("Anzahl der personen in Queue ist: " + queue[0].size());
        
        /*for(int i = 0; i <queue[0].size(); i++) {
            Person person = (Person) queue[0].get(i);
            String beruf  = person.getBeruf();
            queue[1].addLast(beruf);
        }
        
        System.out.println("Anzahl der Personen mit Vorgegebenen Brufe sind: " + queue[1].size());
        System.out.println("Ist die Warteschlange voll; "+ "ergebnis: " + queue[1].full());
        System.out.println("Person an der ersten Stelle wird entfert! (also Anna Müller)\n" + queue[1].removeFirst());
        System.out.println("Person an der ersten Stelle wird entfert! (also Erik Emmerich)\n" + queue[1].removeFirst());
        System.out.println("Die Warteschlange ist leer; " + "ergebnis: " + queue[1].empty());
        */
        
    }
    
    /**
     * Die Main Methode der Klasse.
     * 
     * @param args
     */
    public static void main(String[] args) {
        QueueDialog queueDialog = new QueueDialog();
        queueDialog.start();
    }
    
    /**
     * Eine Methode die uns Details über die eingefügten Personen auf der Warteschlange als text ausgibt.
     * 
     * @param q Zugriff auf meine elemente in meiner Arrays
     */
    public void print(Queue q){
        for(int i = 0; i < q.size(); i++) {
            System.out.println(q.get(i));
        }
    }
    
    /**
     * Die Funktionen werden hier angezeigt.
     * 
     * @return Eingabe vom Benutzer als Ganzzahl
     */
    private int einleseFunktion() {
        System.out.println(
            1 + ": Neue Warteschlange erstellen;\n" + 2 + ": Personen in die Warteschlange nacheinander hinzufügen;\n" + 3 + ": Person an der ersten Stelle löschen;\n" + 4
                + ": Infos über bestimmte Person anzeigen;\n" + 5 + ": Ist die Warteschlange leer?.\n" + 6 + ": Ist die Warteschlange voll?.\n" + 7 + ": Anzahl der Personen auf der Warteschlange anzeigen.\n" + 0 + ": beenden -> ");
        return input.nextInt();
    }
    
    /**
     * Hier wird vom benutzer eine Funktion ausgewählt, die eine richtige artikel methode ausgeführt.
     * 
     * @param funktion Auswahl des benutzers
     */
    public void funktionAuswaehlen(int funktion){
        switch (funktion){
            case 1:
                queue = new Queue[4];
                System.out.println("Geben Sie die größe der Warteschlange ein: ");
                queue[0] = new PersonQueue(input.nextInt());
                break;
            case 2:
                System.out.println("Vorname: ");
                input.nextLine();
                String vorname = input.nextLine();
                System.out.println("Nachname: ");
                String nachname = input.nextLine();
                System.out.println("Beruf: ");
                String beruf = input.nextLine();
                Person p = new Person(vorname,nachname,beruf);
                queue[0].addLast(p);
                break;
            case 3:
                queue[0].removeFirst();  
                System.out.println("Person an der ersten Stelle wurde gelöscht!");
                break;
            case 4:
                System.out.println("Wählen Sie den Platz der Person zwischen 1 und " + queue[0].getArrLength() +": ");
                int platz = input.nextInt();
                if(platz > queue[0].getArrLength() || platz <= 0){
                    throw new IllegalArgumentException("Bitte beachten Sie die Größe der Warteschlange!");
                }else if(queue[0].get(platz - 1) == null){
                    System.out.println("Platz ist leer!");    
                }else{
                    System.out.println(queue[0].get(platz - 1));
                }
                break;
            case 5:
                if(queue[0].empty()){
                    System.out.println("Ja");
                }else{
                    System.out.println("Nein");
                }
                break;
            case 6:
                if(queue[0].full()){
                    System.out.println("Ja");
                }else{
                    System.out.println("Nein");
                }
                break;
            case 7:
                System.out.println("Die Anzahl der Personen auf der Warteschlange ist: " + queue[0].size());
                break;
            case 0:
                System.exit(1);
                break;
            default:
                System.out.println("Funktion existiert nicht!");
        }
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
            System.out.println("Warteschlange exestiert nicht! Bitte erstellen Sie zuerst eine Warteschlange.");
          } catch (Exception e) {
            System.out.println(e + " Programm beendet");
          }
        }
    }
}

