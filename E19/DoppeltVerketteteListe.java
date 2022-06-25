import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Eine Klasse, die mehrere Methoden des Interfaces List<E> implementiert.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */
public class DoppeltVerketteteListe<E> implements List<E>
{
    private Node<E> head;
    private Node<E> current;
    private Node<E> tail;
    private Iterator<E> iterator;
    
    /**
     * Konstruktor zum Erstellen der List<E> Object mit default Values.
     * 
     */
    public DoppeltVerketteteListe(){
        this.head = null;
        this.tail = null;
    }
    
    /**
     * Konstruktor zum Erstellen der List<E> Object mit head Node als eingabe und das tail Node wird mit null intialisiert.
     * @param head zum eingeben des heades node der Liste
     */
    public DoppeltVerketteteListe(Node<E> head){
        this.head = head;
        this.tail = null;
    }
    
    /**
     * Konstruktor zum Erstellen der List<E> Object mit head und tail Nodes als eingabe.
     * @param head zum eingeben des heades node der Liste
     * @param tail zum eingeben des tailes node der Liste
     */
    public DoppeltVerketteteListe(Node<E> head, Node<E> tail){
        this.head = head;
        this.tail = tail;
    }

    /**
     * Methode gibt die Größe der Liste zurück.
     * @return anzahl die Größe der Liste
     */
    @Override
    public int size() {
        int anzahl = 0;
        current = head;
        while (current != null) {
            anzahl++;
            current = current.getNext();
        }
        return anzahl;
    }

    /**
     * Methode überprüft, ob die Liste leer ist oder nicht.
     * @return true oder flase falls die Liste leer ist oder nicht
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Methode überprüft, ob ein Object in der Liste enthalten ist oder nicht.
     * @return true oder flase falls das Object in der Liste existiert oder nicht
     */
    @Override
    public boolean contains(Object o) {
        current = head;
        while (current != null) {
            if(current.getData().equals(o)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Methode gibt ein Iterator-Object zurück. Wobei das Iterator für mehrere ander Methoden notwendig ist.
     * @return new Iterarot<E> ein Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E data = node.getData();
                node = node.getNext();
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    /**
     * Methode umwandelt die Liste mit deren Inhalt auf ein Array und gibt das Array zurück.
     * @param a das Array als eingabe
     * @return a das Array nach dem ausfüllen mit dem Inhalt der Liste
     */
    @Override
    public <T> T[] toArray(T[] a) {
        int counter = 0;
        iterator = iterator();
        current = head;
        while(iterator.hasNext()) {
            a[counter] = (T) current.getData();
            current = current.getNext();
            counter++;
            iterator.next();
        }
        return a;
    }

    /**
     * Methode fügt einen Object in die Liste ein.
     * @param e das Objekt als Paramenter für die Einfügung
     * @return true oder false wenn es eingefügt wird oder nicht
     */
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<E>(e);
        current = head;

        if (head == null) {
            head = newNode;
            tail = null;
            return true;
        }

        while (current.getNext() != null) {
            current = current.getNext();
        }
        
        tail = newNode;
        current.setNext(tail);
        tail.setPrev(current);
        tail.setNext(null);

        return true;
    }

    /**
     * Methode löscht einen Object von der Liste.
     * @param o das Objekt als Paramenter für die Löschung
     * @return true oder false wenn es gelöscht wird oder nicht
     */
    @Override
    public boolean remove(Object o){

        if (head == null || o == null) {
            return false;
        }
        
        current = head;
        iterator = iterator();
        while (iterator.hasNext()) {
            if (current.getData().equals(o)) {
                break;
            }
            current = current.getNext();
            iterator.next();
        }

        if (current == null) {
            return false;
        }

        if (current == head) {
            head = current.getNext();
        }
        
        if(current == tail){
            tail = current.getPrev();
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    /**
     * Methode fügt meherere Werte in die Liste ein.
     * @param c ein Collection deren Inhalt jeweils eingefügt wird
     * @return true oder false wenn alle Werte eingefügt werden oder nicht
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        if (c.size() == 0) {
            return false;
        }else{
            for (E e : c) {
                add(e);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    /**
     * Methode löscht alle werte bzw. Objecte in der Liste.
     */
    @Override
    public void clear(){
        head = null;
        tail = null;
    }

    /**
     * Methode gibt ein Object zurück mit hilfe der Index-Stelle als eingabe für die Methode.
     * @param index die Stelle des Objectes
     * @return current das gesuchte Object
     */
    @Override
    public E get(int index){

        if(index < 0 || index >= size()){
            return null;
        }
        
        int counter = 0;
        current = head;
        iterator = iterator();

        while(iterator.hasNext()) {
            if (counter == index) {
                return current.getData();
            }
            counter++;
            current = current.getNext();
            iterator.next();
        }
        return null;
    }

    /**
     * Methode ersetzt den Inhalt eines Objectes in der Liste. Das Object wird mit Hilfe des indexes gesucht.
     * @param index die Stelle des Objectes
     * @param element das neue Object zum ersetzen
     * @return current das gesuchte Object
     */
    @Override
    public E set(int index, E element){
        if(index >= size() || index < 0) {
            throw new IllegalArgumentException("Index not available!");
        }
        
        int counter = 0;
        current = head;
        iterator = iterator();

        while(iterator.hasNext()) {
            if(counter == index) {
                E prev = current.getData();
                current.setData(element);
                return prev;
            }
            counter++;
            current = current.getNext();
            iterator.next();
        }

        return null;
    }

    /**
     * Methode fügt ein Object auf einem bestimmten Index-Stelle in die Liste ein.
     * @param index die Stelle zum Einfügen
     * @param element das neue Object zum Einfügen
     */
    @Override
    public void add(int index, E element){
        if(index >= size() || index < 0) {
            throw new IllegalArgumentException("Index not available!");
        }
        
        if(index == 0) {
            Node<E> newNode = new Node<E>(element);
            
            newNode.setNext(head);
            newNode.setPrev(null);

            if (head != null){
                head.setPrev(newNode);
            }
                
            head = newNode;
            return;
        }
        
        if(index == size()-1) {
            add(element);
            return;
        }
        
        int counter = 0;
        current = head;
        Node<E> newNode = new Node<E>(element);
        iterator = iterator();
        while(iterator.hasNext()) {
            if(counter == index) {
                newNode.setNext(current);
                newNode.setPrev(current.getPrev());
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
                return;
            }
            counter++;
            current = current.getNext();
            iterator.hasNext();
        }
    }

    /**
     * Methode löscht ein Object auf einem bestimmten Index-Stelle von der Liste.
     * @param index die Stelle des Objectes zum Löschen
     * @return current das gesuchte und gelöschte Objekt
     */
    @Override
    public E remove(int index){
        int size = size();
        if(index >= size || index < 0) {
            throw new IllegalArgumentException("Index not available");
        }
        
        int counter = 0;
        current = head;
        iterator = iterator();

        if(index == 0) {
            head = head.getNext();
            return current.getData();
        }else{
            while(iterator.hasNext()) {
                if(counter == index) {
                    current.getPrev().setNext(current.getNext());
                    if(current.getNext() != null) {
                        current.getNext().setPrev(current.getPrev());
                    }
                    current.setPrev(null); 
                    current.setNext(null); 
                    return current.getData();
                }
                 if(counter == size - 1) {
                    current.setPrev(null);
                    return current.getData();
                }
                counter++;
                current = current.getNext();
                iterator.next();
            }
        }
        
        return null;
    }

    /**
     * Methode gibt die Index-Stelle eines Objektes zurück.
     * @param o zum suchen des Objektes
     * @return counter die Index-Stelle des Objektes
     */
    @Override
    public int indexOf(Object o){
        int counter = 0;
        current = head;
        iterator = iterator();
        while (iterator.hasNext()) {
            if (current.getData().equals(o)) {
                return counter;
            }
            counter++;
            current = current.getNext();
            iterator.next();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }

    /**
     * Methode gibt ein listIterator<E>-Object zurück.
     * @return new Iterarot<E> ein ListIterator
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIterator<E>(){

            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E data = node.getData();
                node = node.getNext();
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return node.getPrev() != null;
            }

            @Override
            public E previous() {
                E data = node.getData();
                node = node.getPrev();
                return data;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {
                
            }

            @Override
            public void set(E e) {
                
            }

            @Override
            public void add(E e) {
                
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not Supported Operation!");
    }
    
    /**
     * Methode gibt alle Informationen der Nodes als Zeichenkette zurück.
     * 
     * @return s als Zeichenkette der Nodes mit deren Data-Inhalt
     */
    @Override
    public String toString() {
        String s = "";
        String empty = "null(head)<-->null(tail)";
        if(isEmpty()){
            return empty;
        }
    
        current = head;
        s += "null<----[ " + current.getData() + " ]" + "(head)" + "<---->";
        if(current.getNext() == null){
            s += "null(tail)<---->null";
            return s;
        }
        current = current.getNext();
        
        while(current.getNext() != null) {
            s += "[ " + current.getData() + " ]" + "<---->";
            current = current.getNext();
        }
        s += "[ " + current.getData() + " ]" + "(tail)<---->null";
        
        return s;
    }
}
