import java.util.Arrays;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Main-Methode der Klasse, hier werden mehrere Methoden des Programms getestet. Jeder aufgabe ist geteilt durch ein "----." String.
     * 
     * @param args
     */
    public static void main(String[] args){
        Lager lager = new Lager();
        Artikel a1 = new Artikel(1234, "ajc", 10, 50);
        Artikel a2 = new Artikel(3425, "abz", 5, 200);
        Artikel a3 = new Artikel(2674, "vas", 200, 25);
        Artikel a4 = new Artikel(7632, "kwa", 70, 60);
        lager.legeAnArtikel(a1);
        lager.legeAnArtikel(a2);
        lager.legeAnArtikel(a3);
        lager.legeAnArtikel(a4);
        Ueb18Fassade test = new Ueb18Fassade();
        String aufgabenGrenze = "\n----------------------------------------------------------------------\n";
        System.out.println(Arrays.toString(test.aufgabe_c_i(lager)));
        System.out.println(aufgabenGrenze);
        
        test.aufgabe_c_ii(lager);
        lager.toString();
        System.out.println(aufgabenGrenze);
        
        test.aufgabe_c_iii(lager);
        lager.toString();
        System.out.println(aufgabenGrenze);
        
        test.aufgabe_c_iv(lager);
        lager.toString();
        System.out.println(aufgabenGrenze);
        
        Lager lager2 = new Lager();
        Artikel arr1 = new CD(3451, 10, 10, "Videospiel", "Overwatch", 4);
        Artikel arr2 = new Artikel(5632, "Tisch", 5, 200);
        Artikel arr3 = new Artikel(7563, "Laptop", 200, 25);
        Artikel arr4 = new CD(4512, 60, 20, "Videospiel2", "Valorant", 4);
        Artikel arr5 = new Artikel(2352, "Stuhl", 70, 60);
        lager2.legeAnArtikel(arr1);
        lager2.legeAnArtikel(arr2);
        lager2.legeAnArtikel(arr3);
        lager2.legeAnArtikel(arr4);
        lager2.legeAnArtikel(arr5);
        
        test.aufgabe_h_i(lager2);
        lager2.toString();
        System.out.println(aufgabenGrenze);
        
        test.aufgabe_h_ii(lager2);
        lager2.toString();
        System.out.println(aufgabenGrenze);
        
        
        Lager lager3 = new Lager();
        Artikel arrt1 = new CD(5475, 10, 10, "Videospiel", "Overwatch", 4);
        Buch arrt2 = new Buch(8632, 15, 40, "Stephan King", "The Shining", "Das Monstrum");
        Artikel arrt3 = new Artikel(1656, "Laptop", 200, 25);
        Artikel arrt4 = new Buch(8563, 60, 20, "Stephan King", "The Green Mile", "Das Monstrum");
        Artikel arrt5 = new Buch(9657, 87, 120, "Waris Dirie", "Wüstenblume", "Blabla");
        Artikel arrt6 = new Buch(7842, 6, 250, "Stephan King", "Misery", "Das Monstrum");
        lager3.legeAnArtikel(arrt1);
        lager3.legeAnArtikel(arrt2);
        lager3.legeAnArtikel(arrt3);
        lager3.legeAnArtikel(arrt4);
        lager3.legeAnArtikel(arrt5);
        lager3.legeAnArtikel(arrt6);
        test.aufgabe_h_iii(lager3, "Stephan King");
        lager3.toString();
        System.out.println(aufgabenGrenze);
        
        test.aufgabe_h_iv(lager3);
        lager3.toString();
        System.out.println(aufgabenGrenze);
        
        System.out.println(test.aufgabe_h_v(lager3));
        System.out.println(aufgabenGrenze);
        
        System.out.println(Arrays.toString(test.aufgabe_h_vi(lager3, "Stephan King", 10, 50)));
        System.out.println(aufgabenGrenze);
        
    }
}
