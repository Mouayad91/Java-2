import java.util.ArrayList;

/**
 * Eine Generische_Klasse, die eine Getraenke_instanz bzw. _Objekt erstellt und bearbeitet.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class Getraenkeautomat <T extends Getraenk>
{
    private ArrayList<T> flaschenlager;
    private int kapazitaet;
    
    /**
     * Konstruktor der Klasse Getraenkeautomat, in dem das Field_Variable kapazitaet und das ArrayList mit dem eingegebenen_generischen_Typ erstellt wird.
     * 
     * @param kapazitaet, als kapazitaet des ArrayLists bzw. des Getränkeautomats
     */
    public Getraenkeautomat(int kapazitaet){
        if(kapazitaet <= 0){
            throw new IllegalArgumentException("Die Lager Kapazität darf nicht kleiner als 1 sein!"); 
        }else{
            this.kapazitaet=kapazitaet;
        }
        flaschenlager = new ArrayList<T>();
    }
    
    /**
     * Methode fügt Flasche am ende des ArrayLists bzw. des Getraenkeautomat hin.
     *
     *@param f, die Objekt-Flasche hinzufügen.
     **/
    public void flascheEinlegen(Flasche<? extends T> f){
        if (flaschenlager.size() < getKapazitaet()) {
            if(f.getInhalt() == null){
                throw new IllegalArgumentException("Die eingegebene Flasche ist leider leer!");
            }
            flaschenlager.add(f.getInhalt());
            
        } else {
            throw new IllegalArgumentException("Getränkeautomat ist leider Voll! Sie dürfen keine weitere Getränke einlegen!");
        }
    }
    
    /**
     * Hier wird die angeforderte Flasche, abhängig von ihre index_Nummer zurückgegeben und dann von der ArrayList bzw. Getraenkeautomat gelöscht.
     * 
     * @param wahl Index der Flasche im ArrayList
     * @return flasche
     */
    public T flascheAusgeben(int wahl){
        if(flaschenlager.isEmpty()){
            throw new IllegalArgumentException("Die Getränkeautomat ist leider leer!");
        }else{
            for(int i = 0; i < flaschenlager.size(); i++){
                if(flaschenlager.get(wahl - 1) != null){
                    T flasche = flaschenlager.get(wahl - 1);
                    flaschenlager.remove(wahl - 1);
                    return flasche;
                }
            }
        }
        return null;
    }
    
    /**
     * Methode gibt die Anzahl der Flaschen im ArrayList bzw. Getraenkautomat zurück.
     *
     *@return anzahlFlaschen Anzahl der Flaschen im Automat
     **/
    public int getAnzahlFlaschen(){
        int anzahlFlaschen = 0;
        for(int i = 0; i < flaschenlager.size(); i++){
            anzahlFlaschen++;
        }
        return anzahlFlaschen;
    }
    
    /**
     * Mit der Methode bekommt man die Kapazitaet des ArrayLists.
     * 
     * @return kapazitaet
     */
    public int getKapazitaet() {
        return kapazitaet;
    }

    /**
     * Mit dieser Methode kann man eine neue Kapazität für den Getraenkeautomat setzen.
     * 
     * @param kapazitaet Kapazitaet des Getraenkeautomates
     */
    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }
    
    /**
     * Methode gibt alle enthaltenen Flaschen (mit Flaschen_Typ) im ArrayList bzw. im Getraenkeautomat als String zurück.
     * 
     * @return Zeichenkette von der enthaltenen Flaschen im ArrayList.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int index = 1;
        
        for(int i = 0; i < flaschenlager.size(); i++){
            T f = flaschenlager.get(i);
            sb.append(index + ". Flasche: " + f.getClass().getName() + "\n");
            index++;
        }
        return sb.toString();
    }
    
    /*public static void main(String[] args){
        Getraenkeautomat<Getraenk> w = new Getraenkeautomat<>(2);
        Flasche<Wasser> f = new Flasche<>();
        Wasser ww = new Wasser("Quelle");
        ww.setHersteller("Monzr");
        f.fuellen(ww);
        w.flascheEinlegen(f);
        System.out.println(w);
        
        Flasche<SoftDrink> s = new Flasche<>();
        SoftDrink ss = new SoftDrink(2.4f);
        ss.setHersteller("Mouayad");
        s.fuellen(ss);
        w.flascheEinlegen(s);
        System.out.println(w);
    }*/
 
}
