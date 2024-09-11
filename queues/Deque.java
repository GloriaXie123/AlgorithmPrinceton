import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node{
        Item item;
        Node previous;
        Node next;

        public Node(Item item){
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

    private Node first;

    private Node last;

    private int size;

    public Deque(){
        this.first = null;
        this.last = null;
        size = 0;
    }


    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node index = first;

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException("No more elements to iterate.");
            }

            Item it = index.item;
            index = index.next;
            return it;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException("item needs to be provided");
        }
        Node newNode = new Node(item);
        if(size == 0){
            first = newNode;
            last = newNode;
        }else{
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
        size++;
    }

    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException("item needs to be provided");
        }

        Node newNode = new Node(item);

        if(size == 0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("the deque is empty!");
        }
        Item it = first.item;
        if(size == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            first.previous = null;
        }
        size--;
        return it;
    }

    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException("the deque is empty!");
        }

        Item it = last.item;
        if(size == 1){

            first = null;
            last = null;
        }else{
            last = last.previous;
            last.next = null;
        }
        size--;

        return it;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public static void main(String[] args){

//        //read the strings from the commandline
//        String ln = StdIn.readLine();
//
//        String[] st = ln.trim().split(" ");
//
//        Deque<String> dq = new Deque<String>();
//
//        for(int i = 0 ; i < st.length; i++){
//            dq.addLast(st[i]);
//        }
//
//        Iterator<String> itera = dq.iterator();
//
//        while(itera.hasNext()){
//            System.out.println(itera.next());
//        }

        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.isEmpty();     //==> false
        deque.addFirst(7);//7->5->4->3->2->1
        deque.removeLast();    // ==> 1  7->5->4->3->2
        deque.removeLast();  //2  7->5->4->3

    }
}
