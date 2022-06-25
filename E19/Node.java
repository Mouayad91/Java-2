
/**
 * Eine Klasse, die ein Node mit generischen Typ erstellt und bearbeitet.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar 
 * 
 * @version 1.0
 */

public class Node<T> {
    
    private T data;
    private Node<T> next;
    private Node<T> prev;

    /**
     * Konstruktor .Hier können die Informationen des Nodes eingegeben.
     * 
     * @param data die Inhalt des Nodes
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Konstruktor .Hier können die Informationen des Nodes und die voher-und nächste nodes davon eingegeben.
     * 
     * @param data die Inhalt des Nodes
     * @param prev das vorheriges Node
     * @param next das nächste Node
     */
    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Mit der Methode bekommt man die Data des Nodes zurück.
     * 
     * @return data Inhalt des Nodes
     */
    public T getData() {
        return data;
    }
    
    /**
     * Mit der Methode kann man data des Nodes neu ersetzen.
     * 
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Mit der Methode bekommt man das nächste Node zurück.
     * 
     * @return next 
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Mit der Methode kann man das nächste Node des Nodes neu ersetzen.
     * 
     * @param next zu Ersetzen.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Mit der Methode bekommt man das vorherige Node zurück.
     * 
     * @return prev 
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Mit der Methode kann man das vorherige Node des Nodes neu ersetzen.
     * 
     * @param prev zu Ersetzen.
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    /**
     * Methode den Inahlt des Nodes als Zeichenkette bzw. als String zurück.
     * 
     * @return getData() Inhalt des Nodes
     */
    @Override
    public String toString() {
        return "Data: " + getData().toString();
    }
}