import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item>{

//    private class Node<Item>{
//
//        Item item;
//        Node<Item> next;
//        public Node(Item item){
//            this.item = item;
//            this.next = null;
//        }
//    }
    Deque dq = new Deque();


    public Deque RandomizedQueue(){
        return dq;
    }

    public boolean isEmpty(){
        return dq.isEmpty();
    }

    public int size(){
        return dq.size();
    }

    //add to the end,first in first out
    public void enqueue(Item item){
        dq.addFirst(item);
    }

    //remove from the beginning, first in first out.
    public Item dequeue(){
        return (Item) dq.removeFirst();
    }

    //return a random item(but do not remove it)
    //get the random index from the Queue
    public Item sample(){
        int max = size();
        int randomIdx = getRandomInt(1,max);
        Deque.Node current = dq.first;
        Item it = (Item) current.item;
        while(randomIdx > 1){
            current = current.next;
            it = (Item) current.item;
            randomIdx --;
        }
        return it;
    }

    public static int getRandomInt(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(){}


    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
