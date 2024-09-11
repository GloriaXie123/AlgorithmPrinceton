import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

//resizing array
public class RandomizedQueue<Item> implements Iterable<Item>{

    private int count = 0;
    private int maxSize = 1000;

    private static double random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed


    private Item[] array = (Item[]) new Object[maxSize];

    public int size(){return count;}

    public boolean isEmpty(){ return  size() == 0;}
    public void enqueue(Item item){

        if(item == null){
            throw new IllegalArgumentException("the item to be enqueued can't be null.");
        }
        if(count >= maxSize/2){
            maxSize = maxSize*2;
            resize();
        }
        array[count] = item;
        count++;
    }

    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("the Queue is empty.");
        }
        if(count <= maxSize/4){
            maxSize = maxSize/2;
           resize();
        }

        int k;
        k = uniform(count);

        Item temp = array[k];
        array[k] = array[count -1];
        array[count -1] = null;

       count--;
       return temp;
    }

    private static int uniformInt(int a, int b) {
        if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
        }
        return a + uniform(b - a);
    }

    private static int uniform(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive");
        }
        return StdRandom.uniformInt(n);
    }


    private void resize(){
        int size = array.length;
        Item[] copy = (Item[]) new Object[maxSize];
        for(int i = 0; i < count; i++){
            copy[i] = array[i];
        }
        array = copy;
    }

    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException("the Queue is empty.");
        }
        int k;
        k = uniform(count);
        return (Item)array[k];
    }

    //implement a shuffle method, using fisher-yates algorithm
    private void shuffle(){
        for(int i = 0; i < count; i++){
            for(int j = i; j < count; j++){
                int r = uniformInt(j,count);
                swap(i,r);
            }
        }
    }

    //implement a swap method
    private void swap(int i, int r){
        Item temp = array[i];
        array[i] = array[r];
        array[r] = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new randomizedQueueIterator();
    }

    private class randomizedQueueIterator<Item> implements Iterator<Item>{

        private int i;
        public randomizedQueueIterator(){
            shuffle();
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public Item next() {

            if(array[i] == null){
                throw new NoSuchElementException("the array is empty.");
            }
            Item it = (Item) array[i];
            i++;
            return it;
        }

        public void remove(){
            throw new UnsupportedOperationException("can't remove items while iterating");
        }
    }



    public static void main(String args[]){

        //read the strings from the commandline
        String ln = StdIn.readLine();

        String[] st = ln.trim().split(" ");

        RandomizedQueue<String> rq = new RandomizedQueue<>();

        for(int i = 0 ; i < st.length; i++){
            rq.enqueue(st[i]);
        }


        //test iterator

//        Iterator<String> itera = rq.iterator();
//
//        while(itera.hasNext()){
//            System.out.println(itera.next());
//        }
//        //test sample
//        int max = 30;
//        while(max > 0){
//            max--;
//            System.out.println(rq.sample());
//        }

        //test if it's independent iterator
        Iterator<String> rqit= rq.iterator();

        while(rqit.hasNext()){
            System.out.print(rqit.next()+" ");
        }
        System.out.println();

        Iterator<String> rqit2 = rq.iterator();
        while(rqit2.hasNext()){
            System.out.print(rqit2.next()+" ");
        }
//        //test shuffle
//        Iterator<String> it = rq.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        Iterator<String> it2 = rq.iterator();
//        while(it2.hasNext()){
//            System.out.println(it2.next());
//        }

//        int k = rq.size();
//        System.out.println(k);
//
//        while(k > 0){
//            System.out.println(rq.sample());
//            k--;
//        }
    }
}
