/**
 * An implementation of the interface WordMap using linked elements.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class LinkedWordMap implements WordMap {

    private static class Node{
        
        private String key;
        private int count;
        private Node next;
        private Node previous;

        private Node (String key, Node previous, Node next){
            this.key = key;
            this.next = next;
            this.previous = previous;
            count++;
        }
    }

    private Node head;

    public LinkedWordMap(){
        head = new Node(null,null,null);
        head.next = head;
        head.previous = head; 
    }
   

    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */
    
    public int size() {
        int size = 0;
        Node current = head;
        while (current.next != head){
            current = current.next;
            size ++;
        }
        return size; 
        
    }

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    public boolean contains(String key) {

        if (key == null){
            throw new NullPointerException("Not a valid key");
        }
 
        //Using while loop here instead of using size to reduce time, calling size will result in 2 loops or n*n time 
        Node current = head;
        while (current.next != head){
            current = current.next;
            if (key.equals(current.key)){
                return true; 
            }
        }
        return false;
        
    }
    
    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param key the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public int get(String key) {

        if (key == null){
            throw new NullPointerException();
        }   

        Node current = head;
        while(current.next != head){
            current = current.next;
            if (key.equals(current.key)){
                return current.count;
            }
        }
        return 0;     
    }
    
    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    public void update(String key) {
        if (key == null){
            throw new NullPointerException();
        }

        Node current = head;
        while(current.next != head){
            current = current.next;
            if (key.equals(current.key)){
                current.count += 1;
                return;
            }
            
        }
        if (head.next == head){
          Node p = new Node(key,head,head);
          head.next = p;
          head.previous =p;
          return;
        }

        current = head;
        while (current.next != head){
            current = current.next;
            if (current.key.compareTo(key)>= 1 ){
                Node p = new Node(key, current.previous, current);
                current.previous.next = p;
                current.previous = p;
                return;
            }
            if (current.next == head){
                Node p = new Node(key,current, head);
                current.next = p;
                head.previous = p;
                return;
          }
        }
        //if alphabetical will have to change this 
        Node newElem = new Node(key,current,head);
        //heads current previous points to last element and we connect that last element to new Node 
        current.next = newElem;
        head.previous = newElem;    
        
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys() {
        Node current = head;
        String[] keys = new String[size()];
        for (int i = 0; i < size(); i++){
            current = current.next;
            keys[i] = current.key;
        }
        return keys;
        
    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    public Integer[] counts() {
        
        Node current = head;
        Integer[] count = new Integer[size()];
        for (int i = 0; i < size(); i++){
            current = current.next;
            count[i] = new Integer(current.count);
        }
        return count;
        
    }
    
}
