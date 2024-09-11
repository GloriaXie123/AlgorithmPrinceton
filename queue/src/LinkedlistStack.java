import java.util.Iterator;

//because it takes linear time to remove an item from the end of the linkedlist, so i will
//implement pop function in a different way.
public class LinkedlistStack<Item> implements Iterable<Item>{

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListStackIterator();
    }

    private class Node<Item>{
        Item item;
        Node<Item> next;
    }

    private Node first;

    private int N = 0;

//    public LinkedlistStack(){
//        current = first;
//    }

    public Item pop(){
        if(first != null){
            Node oldFirst = first;
            Item it = (Item) first.item;
            first = first.next;
            //avoid loitering
            oldFirst = null;
            N--;
            return it;
        }
        return null;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    private class LinkedListStackIterator implements Iterator<Item> {
        Node X = first;
        @Override
        public boolean hasNext() {
            return X!= null;
        }

        @Override
        public Item next() {
            Item it = (Item) X.item;
            X = X.next;
            return it;
        }


    }
}
