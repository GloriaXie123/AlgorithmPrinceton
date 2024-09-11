import java.util.Iterator;

//we gonna implement a stack for any types of data, this stack is
//capable of resizing to avoid waste of space.
//apply generalized and consistent implementations for all the method!
public class ResizedArrayStack<Item> implements Iterable<Item> {
    Item[] arr;
    int maxSize;
    int N;

    public ResizedArrayStack(int cap) {
        maxSize = cap;
        arr = (Item[])new Object[maxSize];
    }
    @Override
    public Iterator<Item> iterator() {
        return new ResizedArrayStackIterator<Item>();
    }

    public class ResizedArrayStackIterator<Item> implements Iterator<Item>{

        int idx = 0;

        @Override
        public boolean hasNext() {
            return idx >= 0 && idx < N;
        }

        @Override
        public Item next() {
            idx ++;
            Item next = (Item)arr[idx];
            return next;
        }
    }

    public void resize(){
        int size = maxSize;
        Item[] temp = (Item[])new Object[size];
        for(int i = 0; i < N; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N <= 0;
    }

    public void push(Item item){
        if(N == maxSize){
            maxSize = 2 * maxSize;
            resize();
            N++;
            arr[N] = item;
        }
    }

    public Item pop(){
        if(N > 0 && N < maxSize){
            Item item = arr[N];
            arr[N] =null;
            if( N == maxSize/4){
                maxSize = maxSize/2;
            }
            N--;
            return item;
        }else{
            return null;
        }
    }
}
