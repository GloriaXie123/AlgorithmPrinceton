import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    public class Node<Item>{
        Item item;
        Node<Item> previous;
        Node<Item> next;

        public Node(Item item){
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

    public Node<Item> first;

    public Node<Item> last;


    public DequeIterator<Item> iterator(){
        return new DequeIterator<Item>();
    }

    public class DequeIterator<Item> implements Iterator<Item>{
        Node index = first;
        @Override
        public boolean hasNext() {
            return index!= null;
        }

        @Override
        public Item next() throws NoSuchElementException {
            Item it = (Item) index.item;
            index = index.next;
            return it;
        }
    }

    public int size(){
        int count = 0;
        Node it = first;
        while (it != null){
            it = it.next;
            count++;
        }
        return count;
    }

    public void addFirst(Item item){
        Node newNode = new Node(item);
        Node temp = first;
        newNode.next = temp;
        first.next = newNode;
    }

    public void addLast(Item item){
        Node newNode = new Node(item);
        last.next = newNode;
    }

    public Item removeFirst(){
        Node temp;
        temp = first;
        Item it = (Item) temp.item;
        first = first.next;
        temp = null;
        return it;
    }

    public Item removeLast(){
        Node temp;
        temp = last;
        Item it = (Item) temp.item;
        temp = null;
        last = last.previous;
        return it;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
