import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Programm, um Palindrom worter zu prüfen und finden und die Rekursive und Iterative Geschwindigkeit zu rechnen.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */
public abstract class IPalindrom implements Palindrom {

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static List<String> strings = new ArrayList<>();
    
    /**
     * Hier wird die L und Existenz der Datei getestet und dann die Datei lesen und an andere Methode weiterleiten.
     * 
     * @param filename der Datei
     */
    public static void start(File filename) throws IOException {
        File file = filename;

        if (!file.exists() || !file.canRead()) {
            throw new IOException("Die TextDatei " + filename + " ist nicht lesbar oder existiert nicht!");
        }

        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            dateiLesen(file);
        } catch (IOException e) {
            System.out.println("Fehler!" + e);
        } finally {
            bufferedReader.close();
        }
    }
    
    /**
     * In dieser Methode wird die Datei gelesen und die enthaltene Strings geändert und dann an die dateiSchreiben-methode weitergeleitet
     * nachdem alle Wörter als Strings in einer Liste gespeichert werden.
     * 
     * @param file, um die Inhalte der Datei zu lesen.
     */
    public static void dateiLesen(File file) throws IOException {
        String eingabe = "";
      
        try (BufferedReader bufferedReader  = new BufferedReader(
                new FileReader(file))){

            while ((eingabe = bufferedReader.readLine()) != null) {
                eingabe += " ";
                eingabe.replaceAll("\\s+", " ");
                String[] woerter = eingabe.split(" ");
                for (int i = 0; i < woerter.length; i++){
                    String wort = woerter[i];
                    if (wort.length() > 1) {
                         strings.add(wort);
                    }
                }
            }
            dateiSchreiben();
        }catch(Exception e) {
            System.out.println("Falscher Wert: " + eingabe);
        }

    }
    
    /**
     * Methode berechnet die Geschwindigkeit der beiden Algorithmen Rekursiv und Iterativ für die Palindromuntersuchung und gibt das Ergbnis als String zurück.
     * 
     * @param wort, um die Geschwindigkeit der gespeicherte Wörter in der Liste zu testen.
     * @return Zeichenkette der Attribute wort, rekErgebnis, iterErgebnis und wort.length() als String
     */
    private static String geschwindigkeitsmessung(String wort) {
            long iterBeginn = System.nanoTime();
            boolean iterativ = new PalindromIterativ().istPalindrom(wort);
            long iterErgebnis = System.nanoTime() - iterBeginn;
            long rekBeginn = System.nanoTime();
            boolean rekursiv= new PalindromRekursiv().istPalindrom(wort);
            long rekErgebnis = System.nanoTime() - rekBeginn;
            
            return "Wort: " + wort + ", Wortlänge: " + wort.length() + ", Rekursiv: " + rekursiv + ", Rekursiv Dauerzeit: " + rekErgebnis  + ", Iterativ:" + iterativ +  ", Iterativ Dauerzeit: " + iterErgebnis + "\n";
    }
    
    /**
     * Methode schreibt das Endergebnis der Testungen von Wörter in eine neue erstellte Text-Datei.
     * 
     */
    public static void dateiSchreiben() throws IOException {
        String ergebnis = "ErgebnisDatei";
        File ergebnisFile = new File(ergebnis);
        bufferedWriter = new BufferedWriter(new FileWriter(ergebnis));

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
            String s = geschwindigkeitsmessung(strings.get(i));
            System.out.println(s);
            bufferedWriter.write(s);
        }
        bufferedWriter.close();
    }

    @Override
    public abstract boolean istPalindrom(String wort);
    
    /**
     * Die Main Methode der Klasse, um das Programm auszuführen.
     * Abhängig vom Benutzer zu wählen, ob die Eingabe als Text-Datei oder Aguments zu geben.
     * @param args
     */
    public static void main(String[] args) {
        try {
            if (args[0].endsWith("txt")) {
               start(new File(args[0])); 
            } else {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].length() > 1) {
                        strings.add(args[i]);
                    }
                }
                dateiSchreiben();
        
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



