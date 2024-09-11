import java.util.Iterator;

/**
 * write a generic data type for a deque and a randomized queue
 */
public class Deque<Item> implements Iterable<Item>{

    //construct an empty deque
    public Deque();

    //is the deque empty?
    public boolean isEmpty(){

    }

    //return the number of items in the deque
    public int size()

    //add the item to the front
    public void addFirst(Item item)

    //add the item to the rear
    public void addLast(Item item)

    //remove the item from the front and return the value
    public Item removeFirst()

    //remove the item from the rear and return the value
    public Item removeLast()

    //return an iterator over the items in an order from front to the back
    public Iterator<Item> iterator()

    //unit testing
    public static void main(String args[]){}

}
