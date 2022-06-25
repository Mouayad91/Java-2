/**
 * Klasse zum erstellen und bearbeiten von Uhrzeiten für die Reservierung.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */

public class Uhrzeit {
    private int stunde;
    private int minute;

    /**
     * Hier werden die Attribute der Uhrzeit eingegeben.
     * 
     * @param stunde minute der Uhrzeit
     */
    public Uhrzeit( int stunde, int minute){

        if ( (stunde < 0) || (stunde > 23)){
            throw new IllegalArgumentException(" Stunde muss zwischen 0 und 23 sein");
        }
        else{
            this.stunde = stunde;
        }
        if ( (minute < 0) || (minute > 59)){
            throw new IllegalArgumentException(" Minute muss zwischen 0 und 59 sein");
        }
        else {
        this.minute = minute;
        }
    }
    
    /**
     * Mit der Methode bekommt man die Zeit für die Reservierung.
     * 
     * @return zeit
     */
    public int getZeit() {
        String zeit = new String();
        if (this.minute < 10) {
             zeit = String.valueOf(this.stunde)+String.valueOf("0")+String.valueOf(this.minute);
        } else {
            zeit = String.valueOf(this.stunde)+String.valueOf(this.minute);
        }
        return  Integer.parseInt(zeit);
    }

    /**
     * Mit der Methode bekommt man die vorher eingegebene Stunde.
     * 
     * @return stunde
     */
    public int getStunde() {
        return stunde;
    }
    
    /**
     *Set-Methode, um eine neue Stunde für die Reservierung zu setzen.
     * 
     * @return stunde
     */
    public void setStunde(int stunde) {
        this.stunde = stunde;
    }

    /**
     * Mit dieser Get-Methode bekommt man die vorher eingegebene minute.
     * 
     * @return minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     *Set-Methode, um neue minute für die Reservierung zu setzen.
     * 
     * @return minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    /**
     * Methode gibt die Erstellete Uhrzeit für die Reservierung zurück.
     * 
     * @return Zeichenkette der Attribute Stunde und Minute
     */
    public String toString(){
        String str = new String();

        if(stunde < 10 ){
            if(minute < 10){
                str = "0" + stunde + ":" + "0" + minute + " Uhr";

            }else {
                str = "0" + stunde + ":" + minute + " Uhr";
            }
        }
        else{
            if(minute < 10){
                str =   stunde + ":" + "0" + minute + " Uhr";
            }else{
                str =   stunde + ":" + minute + " Uhr";
            }
        }
        return str;
    }
}
