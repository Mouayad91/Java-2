import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 * Programm zum erstellen und bearbeiten von Getränkeautomat und Flaschen.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class FDialog
{
    private final String ERROR_FUNKTION = "Funktion existeirt nicht! Versuchen Sie bitte nochmal.";  
    private final String FLASCHE_TYP_ALKOHOLISCH = "\n1. Bier\n" + "2. Wein\n";  
    private final String FLASCHE_TYP_ALKOHLFREI = "\n1. Wasser" + "\n2. SoftDrink\n";
    private final String WEIN_TYP = "\n1. Wein" + "\n2. Weißwein" + "\n3. Rotwein\n";
    private final String FLASCHE_NOT_ALLOWED = "\nFlasche ist nicht erlaubt!";
    private final String GETRAENKEAUTOMAT_TYP = "1. Alle Getränketypen\n" + "2. Nur AlkoholischesGetränke\n" + "3. Nur AlkohlfreiesGetränke\n" + "4. Nur Wasser\n" + "5. Nur SoftDrinks\n" + "6. Nur Bier\n" + "7. Nur Wein\n" + "8. Nur Weißwein\n" + "9. Nur Rotwein\n";
    private int kap;
    private static Scanner input = new Scanner(System.in);
    
    private int wahl;
    
    /**
     * Die Main Methode der Dialog_Klasse.
     * 
     * @param args
     */
    public static void main(String[] args){
        FDialog fDialog = new FDialog();
        run(fDialog.chooseInstance());
    }
    
    /**
     * Eine Methode die abhängig vom Benutzer, eine Dialog_instanz mit einer von verschiedenen Generic_Typen zurückgebt, um das angeforderte Generic_Typ bei der Getränkeautomat einzusetzen.
     * 
     * @return d, eine Dialog_instanz mit bestimmten Generic_Typ.
     */
    public Dialog<?> chooseInstance(){
        
        while(true){
            System.out.println("\nFür welche Getränketypen möchten Sie das Gertänkeautomat:\n");
            System.out.println(GETRAENKEAUTOMAT_TYP);
            wahl = input.nextInt();
             if(wahl == 1){
                 Dialog<Getraenk> d = new Dialog<>();
                 return d;
             }else if(wahl == 2){   
                 Dialog<AlkoholischesGetraenk> d = new Dialog<>();
                 return d;
             }else if(wahl == 3){
                 Dialog<AlkohlfreiesGetraenk> d = new Dialog<>();
                 return d;
             }else if(wahl == 4){
                 Dialog<Wasser> d = new Dialog<>();
                 return d;
             }else if(wahl == 5){
                 Dialog<SoftDrink> d = new Dialog<>();
                 return d;
             }else if(wahl == 6){
                 Dialog<Bier> d = new Dialog<>();
                 return d;
             }else if(wahl == 7){
                 Dialog<Wein> d = new Dialog<>();
                 return d;
             }else if(wahl == 8){
                 Dialog<Weisswein> d = new Dialog<>();
                 return d;
             }else if(wahl == 9){
                 Dialog<Rotwein> d = new Dialog<>();
                 return d;
             }else{
                 System.out.println("\nFalsche Eingabe! Versuchen Sie bitte nochmal! \n");
                 continue;
            }
        }
    }
    
    /**
     * Eine Methode die uns, die Start_Methode des Dialog_instanzes ausführt.
     * 
     * @param o, die Dialog_instanz
     */
    public static void run(Dialog<?> o){
        o.start();
    }
    
    /**
     * Eine Innere_Generische_Dialog_Klasse, die mit dem, vom Benutzer ausgewählten Dialog_Generic_Typ ausgeführt wird. Dabei wird ein Getränkeautomat erstellt und bearbeitet.
     * 
     * @author Monzr Hajy Omar und Mouayad Haji Omar
     * 
     * @version 1.0
     */
    public class Dialog <T extends Getraenk> {

        private Getraenkeautomat<T> getraenke; 
           
        private boolean w = false;
        private boolean s = false;
        private boolean b = false;
        private boolean we = false;
        private boolean ww = false;
        private boolean rw = false;    
        
        /**
         * Die Funktionen werden hier angezeigt und abhängig vom Benutzer eine Funktion ausgewählt.
         * 
         * @return Eingabe vom Benutzer als Ganzzahl
         */
        public int einleseFunktion(){
            System.out.println(1 + ". Kapazität für den Getränkeautomat eingeben.\n" + 2 + ". Flaschen einlegen.\n" + 3 + ". Flasche ausgeben.\n" + 4 + ". Inhalt der Getränkeautomat anzeigen.\n" 
             + 5 + ". Anzahl der Flaschen im Getränkeautomat ausgeben.\n" + 0 + ". Programm beenden.\n");
            return input.nextInt();
        }
        
        /**
         * Die Hauptschleife des Programms.
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
                System.out.println("Getränkeautomat hat keine Kapazität! Bitte geben Sie zuerst die Kapazität ein!.");
              } catch (Exception e) {
                System.out.println(e + " Programm Error!");
              }
            }
        }
        
        /**
         * Hier wird vom Benutzer eine Funktion ausgewählt, die eine richtige Getraenkeautomat_methode ausführt.
         * 
         * @param funktion Auswahl des Benutzers
         */
        public void funktionAuswaehlen(int funktion){
            switch(funktion){
                case 1:
                    System.out.println("\nBitte geben Sie die Kapazität ein: ");
                    kap = input.nextInt();
                    getraenke = new Getraenkeautomat<>(kap);
                    break;
                case 2:
                    if(kap <= 0) {
                        throw new IllegalArgumentException("Getränkeautomat hat keine Kapazität! Bitte geben Sie zuerst die Kapazität ein!");
                    }
                    allowedTypes();
                    Flasche<T> flasche = null;
                    int wahl2;
                    int wahl3;
                    while(true){
                        System.out.println("\n1. Alkohlfreiesgetränke\n" + "2. AlkoholischesGetränke\n");
                        wahl2 = input.nextInt();
                        if(wahl2 == 1){
                            System.out.println(FLASCHE_TYP_ALKOHLFREI);
                            wahl3 = input.nextInt();
                            if(wahl3 == 1){
                                if(w == true){
                                    flasche = new Flasche<>();
                                    System.out.println("Quelle des Wassers: ");
                                    input.nextLine();
                                    Wasser wasser = new Wasser(input.nextLine());
                                    System.out.println("Hersteller des Wassers: ");
                                    wasser.setHersteller(input.nextLine());
                                    flasche.fuellen(wasser);
                                }else{
                                    System.out.println(FLASCHE_NOT_ALLOWED);
                                    continue;
                                }
                            }else if(wahl3 == 2){
                                if(s == true){
                                    flasche = new Flasche<>();
                                    System.out.println("Zuckergehalt des SoftDrinks: ");
                                    SoftDrink softDrink = new SoftDrink(input.nextFloat());
                                    System.out.println("Hersteller des SoftDrinks: ");
                                    input.nextLine();
                                    softDrink.setHersteller(input.nextLine());
                                    flasche.fuellen(softDrink);
                                }else{
                                    System.out.println(FLASCHE_NOT_ALLOWED);
                                    continue;
                                } 
                            }else{
                                System.out.println(ERROR_FUNKTION);
                                continue;
                            }
                        }else if(wahl2 == 2){
                            System.out.println(FLASCHE_TYP_ALKOHOLISCH);
                            wahl3 = input.nextInt();
                            if(wahl3 == 1){
                                if(b == true){
                                    flasche = new Flasche<>();
                                    System.out.println("Brauerei des Biers: ");
                                    input.nextLine();
                                    Bier bier = new Bier(input.nextLine());
                                    System.out.println("Alkoholgehalt des Biers: ");
                                    bier.setAlkoholgehalt(input.nextFloat());
                                    flasche.fuellen(bier);
                                }else{
                                    System.out.println(FLASCHE_NOT_ALLOWED);
                                    continue;
                                }                          
                            }else if(wahl3 == 2){
                                System.out.println(WEIN_TYP);  
                                wahl3 = input.nextInt();
                                if(wahl3 == 1){
                                    if(we == true){
                                        flasche = new Flasche<>();
                                        System.out.println("Weingut des Weins: ");
                                        input.nextLine();
                                        Wein wein = new Wein(input.nextLine());
                                        System.out.println("Alkoholgehalt des Weins: ");
                                        wein.setAlkoholgehalt(input.nextFloat());
                                        flasche.fuellen(wein);
                                    }else{
                                        System.out.println(FLASCHE_NOT_ALLOWED);
                                        continue;
                                    }                          
                                }else if(wahl3 == 2){
                                    if(ww == true){
                                        flasche = new Flasche<>();
                                        Weisswein weisswein = new Weisswein();
                                        System.out.println("Weingut des Weissweins: ");
                                        input.nextLine();
                                        weisswein.setWeingut(input.nextLine());
                                        System.out.println("Alkoholgehalt des Weissweins: ");
                                        weisswein.setAlkoholgehalt(input.nextFloat());
                                        flasche.fuellen(weisswein);
                                    }else{
                                        System.out.println(FLASCHE_NOT_ALLOWED);
                                        continue;
                                    }                         
                                }else if(wahl3 == 3){
                                    if(rw == true){
                                        flasche = new Flasche<>();
                                        Rotwein rotwein = new Rotwein();
                                        System.out.println("Weingut des Rotweins: ");
                                        input.nextLine();
                                        rotwein.setWeingut(input.nextLine());
                                        System.out.println("Alkoholgehalt des Rotweins: ");
                                        rotwein.setAlkoholgehalt(input.nextFloat());
                                        flasche.fuellen(rotwein);
                                    }else{
                                        System.out.println(FLASCHE_NOT_ALLOWED);
                                        continue;
                                     }                       
                                }else{
                                    System.out.println(ERROR_FUNKTION);
                                    continue;
                                }
                            }else{
                                System.out.println(ERROR_FUNKTION);
                                continue;
                            }  
                        }else{
                            System.out.println(ERROR_FUNKTION);
                            continue;
                        }
                        break;
                    }  
                    getraenke.flascheEinlegen(flasche);
                    break;
                case 3:
                            
                    if(getraenke.getAnzahlFlaschen() == 0) {
                         throw new IllegalArgumentException("Getränkeautomat ist leider leer!");
                    }
                    System.out.println(getraenke.toString());
                    System.out.println("\nWelche Flasche möchten Sie ausgeben: ");
                    int wahl = input.nextInt();
                    System.out.println(getraenke.getAnzahlFlaschen());
                    if(wahl > 0 && wahl <= getraenke.getAnzahlFlaschen()){
                        T t = getraenke.flascheAusgeben(wahl);
                        System.out.println("Flasche " + t.getClass().getName() + "; " + t + "\n");
                    }else{
                        System.out.println(ERROR_FUNKTION);
                    }
                    break;
                case 4:
                    if(getraenke.getAnzahlFlaschen() == 0) {
                         throw new IllegalArgumentException("Getränkeautomat ist leider leer!");
                    }
                    System.out.println(getraenke.toString());
                    break;
                case 5:    
                    System.out.println("Anzahl der Flaschen ist: " + getraenke.getAnzahlFlaschen());
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Falsche Funktion!");
                    break;
            }
        }
        
        /**
         * Methode zum Erlauben von der Richtigen Flaschen bei der Einlegung ins Getraenkeautomat. Abhängig vom Generischen_Typ des Getraenkeautomat.
         * Dabei wird die Liste, die von Getraenkeautomat nur bestimmte Flaschen akzeptieren.
         */
        public void allowedTypes(){
            if(wahl == 1){
                w = true;
                s = true;
                b = true;
                we = true;
                ww = true;
                rw = true;
            }else if(wahl == 2){
                b = true;
                we = true;
                ww = true;
                rw = true;
            }else if(wahl == 3){
                w = true;
                s = true;
            }else if(wahl == 4){
                w = true;
            }else if(wahl == 5){
                s = true;
            }else if(wahl == 6){
                b = true;
            }else if(wahl == 7){
                we = true;
                ww = true;
                rw = true;
            }else if(wahl == 8){
                ww = true;
            }else if(wahl == 9){
                rw = true;
            }
        }        
    }
}
