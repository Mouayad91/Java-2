import java.sql.SQLSyntaxErrorException;

/**
 * Eine Klasse, die die Methoden von Queue Klasse implemintiert.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
public class PersonQueue implements Queue {   
    
    private final Person[] personenArray;
    private final int WARTE_SCHLANGE_GROSSE;
    
    /**
     * Hier wird die größe der Warteschlange eingegeben.
     * 
     * @param WARTE_SCHLANGE_GROSSE Anzahl der möglichen freien Plätze auf der Warteschlange
     */
    public PersonQueue(int WARTE_SCHLANGE_GROSSE){


        if(WARTE_SCHLANGE_GROSSE <= 0){
            throw new IllegalArgumentException("Warteschalngegrosse muss großer als 0 sein!");
        }else{
            this.WARTE_SCHLANGE_GROSSE = WARTE_SCHLANGE_GROSSE;
        }
        
        personenArray = new Person[WARTE_SCHLANGE_GROSSE];
    }
    
    /**
     * Eine Klasse, die die Methoden von PersonIterator Klasse implemintiert.
     *
     ** @author Monzr Hajy Omar und Mouayad Haji Omar
     * 
     * @version 1.0
     **/
    public class Piterator implements PersonIterator {
        private Person[] arr;
        private int len;
        private int iter;
        
        /**
         * Hier wird die größe des Arrays arr eingegeben.
         * 
         * @param arr Array, um Objekte zu speichern.
         */
        public Piterator(Person[] arr) {
            if(arr.length > 0) {
                this.arr = arr;
                this.len = arr.length;
                this.iter = 0;
            }else {
                throw new IllegalArgumentException("Array muss nicht leer sein!");
            }
        }
        
        /**
         * Mit dieser Methode wird überprüft, ob es eine nächste Person auf der Warteschlange gibt oder nicht.
         *
         *@return hasNext falls es eine nächste Person gibt oder nicht.
         **/
        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            if ( this.iter < this.len) {
                hasNext = true;
            }
            return hasNext;
        }
        
        /**
         * Mit dieser Methode wird die nächste Person auf der Warteschlange zurückgegeben.
         *
         *@return person die nächste Person
         **/
        @Override
        public Person next() {
            Person person = this.arr[iter];
            iter += 1;
            return person;
        }
    }
    
    /**
    * Methode fügt eine Person am ende der Warteschlange hin.
    *
    *@param o, die Objekt-Person hinzufügen.
    **/
    @Override
    public void addLast(Object o){
        // if ( o instanceof Person )
        /*   if(o instanceof Person){
            o = new Object();
            Person person = (Person) o;
            anzahlPerson++;
           personQueue[anzahlPerson] = person;
        }*/
        if (this.full() == true) {
            throw new IllegalArgumentException("Warteschalngegrosse muss nicht voll sein!");
        }

        int element = 0;

        while (element < personenArray.length) {
            if (personenArray[element] == null) {
                personenArray[element] = (Person) o;
                element = personenArray.length;
            }
            else {
                element++;
            }
        }
    }
    
    /**
     * Hier wird die erste Person auf der Warteschlange entfernt.
     * 
     * @return personen die neue Reihe von personen nach der Entfernung
     */
    @Override
    public Object removeFirst(){
        
        if (this.empty() == true) {
            throw new IllegalArgumentException("Warteschalngegrosse muss nicht leer sein");

        }
        int index = 0;
        String personen = "";  // Person person = personenArray[0]
        
        for (int i = 0; i < personenArray.length; i++) {
            if ( i == personenArray.length-1) {
                personenArray[i] = null;
            } else {
                 personenArray[i] = personenArray[i+1];
            }
        }
        
        for (Person element: personenArray) {
            if (element != null) {
                personen += "Person Platz" + index + " : \n"+ element.toString() + "\n";
                index++;
            }
        }
        
        return personen;  // return person;
    }
    
    /**
     * Hier werden die Personen auf der Warteschlange ermittelt.
     * 
     * @param i um die Personen zu ermitteln
     */
    @Override
    public Object get(int i){
        return personenArray[i]; // OutOfBopundsException
    }
    
    /**
     * Hier wird geprüft, ob meine Warteschlange leer ist oder nicht.
     *
     */
    @Override
    public boolean empty(){
        
        boolean personenEingefuegt = false;
        if (personenArray[0] == null) {
            personenEingefuegt = true;
        } 
        return personenEingefuegt;

    } 
     
    /**
     * Hier wird geprüft, ob meine Warteschlange voll ist oder nicht.
     *
     */
    @Override
    public boolean full(){
        
        boolean personenEinfugbar= false;
        if (personenArray[personenArray.length-1] != null) {
            personenEinfugbar = true;
        } 
        
        return personenEinfugbar;
    }
    
    /**
    * Methode gibt alle Personen auf der Warteschlange zurück.
    *
    **/
    public void print(){
        if(personenArray.length > 0) {
            Piterator piterator = new Piterator(personenArray);
            while(piterator.hasNext()) {
                Person person = piterator.next();
                if (person != null) {
                    System.out.println(person);
                }
            }
        } else {
            throw new IllegalArgumentException("PersonenArray muss nicht leer sein!");
        }

    }
    
    /**
    * Methode gibt die Vorname von der Person, die mit dem Kurzesten Vorname zurück.
    *
    * @param vorname, Kurzester Vorname.
    **/
    public String smallest(){
        Piterator piterator = new Piterator(personenArray);
        String vorname = new String();
        if((personenArray.length == 1) && (piterator.next() != null)) {
            vorname = piterator.next().getVorname();
        } else {
            int comp = 0;
            Person p1 = piterator.next(); // iter == 0  arr[iter]
            Person p2 = piterator.next();  // iter == 1 arr[iter]
            while (piterator.hasNext()) {
                comp = p1.getVorname().compareTo(p2.getVorname());
                if (comp < 0 || comp == 0) {
                    if (!piterator.hasNext()){
                        return p1.getVorname();
                    }
                    p2 = piterator.next();
                }
                if (comp > 0) {
                    p1 = p2;
                    p2 = piterator.next();
                }
                vorname = p1.getVorname();
                if (p2 == piterator.arr[piterator.arr.length-1]) {
                    break;
                }
            }
        }
        return vorname;
    }
    
    /**
    * Methode gibt zurück, wie viele hinzugefügte Personen auf der Warteschlange so weit gibt.
    *
    *@return anzahlDerPersonen, die Anzahl der Personen.
    **/
    @Override
    public int size(){
        int anzahlDerPersonen = 0;
        for (Person element: personenArray) {
            if (element != null) {
                anzahlDerPersonen++;
            }
            /*
             * else { break; } damit wir weniger iterationen haben sobald ein null-element gefunden werden
             */
        }
        return anzahlDerPersonen;
    }
    
    /**
    * Methode gibt zurück, die Größe des Arrays.
    *
    *@return personenArray.length, Größe des Arrays.
    **/
    @Override
    public int getArrLength(){
        return personenArray.length;
    }
    
    /**
     * Die Main Methode der Klasse, um das Programm zu testen.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Person p1 = new Person("aaa", "b", "c");
        Person p2 = new Person("aab", "bb", "cc");
        Person p3 = new Person("ghi", "bbb", "ccc");
        PersonQueue personQueue = new PersonQueue(4);
        personQueue.addLast(p1);
        personQueue.addLast(p2);
        personQueue.addLast(p3);
        personQueue.print();
        System.out.println(personQueue.smallest());
    }
}
