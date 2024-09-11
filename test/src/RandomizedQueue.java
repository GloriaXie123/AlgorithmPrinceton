import java.util.Iterator;

/**
 * a randomized queue is similar to a stack or queue
 * except that the item removed is chosen uniformly
 * at random from */
public class RandomizedQueue<Item> implements Iterable<Item>{

    //construct an empty randomized queue
    public RandomizedQueue()

    //is the randomized queue empty?
    public boolean isEmpty()

    //return the number of the items on the randomized queue
    public int size()

    //add items to the randomized queue
    public void enqueue(Item item){}

    //remove an item randomly and return
    public Item dequeue(){}

    //return an random item but don't remove it
    public Item Sample()

    //return an independent iterator of all the items in a random order
    public Iterator<Item> iterator(){}

    //unit testing(required)
    public static void main(String args[]){
    }

    iterator:
    each iterator must return the items in uniformly random order, the order of two or more iterators to the
            same randomized queue must be muturally independent.

        each iterator must mantain its own random order.
your main method must be able to call all the constructor and public method to make sure all the method work as
    prescribed(by printing results to standard output).









}
