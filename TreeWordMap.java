/**
 * A Binary Search Tree implementation of the interface WordMap.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TreeWordMap implements WordMap {

    private static class Elem {

        private String key;
        private int count;
        private Elem left, right;

        private Elem(String key) {
            this.key = key;
            count = 1;
        }

    }

    private Elem root;
    private int size;
    
    private String[] keys;
    private Integer[] counts;
    private int count;
    private int count2 = 0;

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param word the specified word
     * @return true if and only if this WordMap contains the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public boolean contains(String key) {
        boolean found = false;
        Elem current = root;
        while (! found && current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }
    
    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param word the specified word
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public void update(String key) {
                
                boolean done = false;

            if(key == null) {
                throw new NullPointerException();
            }
            

            if(root == null) {
                root = new Elem(key);
                size++;
                done = true;
            }
            
            
            Elem current = root;
            while(!done) {
                int test = current.key.compareTo(key);
                if(test == 0) {
                if(key.equals(current.key)) {
                    current.count++;
                    break;
                }
                    done = true;
                }
                else if(test<0) {
                    if(current.right == null) {
                        current.right = new Elem(key);
                        done = true;
                        size++;
                    }
                    else {
                        if(key.equals(current.right.key)) {
                            current.right.count++;
                        break;
                    }
                        else {
                            current = current.right;
                            done = false;
                        }
                    }
                }
                else {
                    if(current.left == null) {
                        current.left = new Elem(key);
                        done = true;
                        size++;
                    }
                    else {
                        if(key.equals(current.left.key)) {
                            current.left.count++;
                        break;
                    }
                        else {
                            current = current.left;
                            done = false;
                        }
                    }   
                }
                
            }
            
            
    }
    
    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param word the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public int get(String key) {
        boolean found = false;
        Elem current = root;
        while (current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                return current.count;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return 0;
    }
    
    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */
    
    public int size() {
        return size;
    }
    
    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */
    
    public String[] keys() {
        
        Elem current = root;
        keys = new String[size()];
        inOrder(root);
        return keys;
        
    }

    private void visit(Elem current){
        keys[count] = current.key;
        count++;
    }

    private void inOrder(Elem current){
        if (current != null){
            inOrder(current.left);
            visit(current);
            inOrder(current.right);
        }
    }
    
    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */
    
    public Integer[] counts() {
        
        Elem current = root;
            counts = new Integer[size()];
            inOrder2(root);
        return counts;
        
    }
    
    private void visit2(Elem current){
            counts[count2] = current.count;
            count2++;
    }

    private void inOrder2(Elem current){
        if (current != null){
            inOrder2(current.left);
            visit2(current);
            inOrder2(current.right);
        }
    }

}
