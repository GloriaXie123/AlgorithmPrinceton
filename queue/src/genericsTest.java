import java.util.*;

//the code expose ingredients we need to implement in any iterable collection.
//the collection must implement an iterator method that returns an iterator object.
//the iterator object must implement two methods, next() and hasNext(), the next() method
//returns a generic item from the collection, the hasNext() method will return a boolean value.
//in Java, we use the interface mechanism to express the idea that a class implements a specific
//method. For iterable collections, the necessary interfaces are already defined for us in Java.
//to make a class iterable, the first step is to add implements iterable<Item> to its declaration,
//matching the interface.
public class genericsTest {

    public static void main(String[] args) {
        Queue<String> lnk = new Queue<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(String s) {
                return false;
            }

            @Override
            public String remove() {
                return null;
            }

            @Override
            public String poll() {
                return null;
            }

            @Override
            public String element() {
                return null;
            }

            @Override
            public String peek() {
                return null;
            }
        };

        lnk.add("today");
//        lnk.addFirst("is");

        // Iterable
        for(String str : lnk){
            System.out.println(str);
        }

        Stack<String> collection = new Stack<String>();

        for(String s : collection){
            System.out.println(s);
        }

        Iterator<String> itera = collection.iterator();

        while(itera.hasNext()){
            String s = itera.next();
            System.out.println(s);
        }
    }
}
