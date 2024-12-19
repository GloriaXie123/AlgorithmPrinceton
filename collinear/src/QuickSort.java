import edu.princeton.cs.algs4.StdRandom;

import java.util.function.ObjIntConsumer;
Public class QuickSort<T> implements Comparable<T>{

    private Object[] objects;
    private int low;
    private int high;

    public QuickSort<T>(Object[] objects){
        this.objects = objects;
        StdRandom.shuffle(objects);
    }

    //The partition method is kind of wrong, because the partition means something.
    public void partition(Object[] objects, int low, int high){
        int i, j;
        i = low;
        j = high;
        Object pivot = objects[high -1];

        while(i <= j){
            if (objects[i] > objects[pivot] && j > low) {
                swap(objects[i], objects[j]);
                j--;
            } else if (objects[i] <= objects[pivot] && i < high) {
                i++
            } else if (objects[j] < objects[pivot] && i < high) {
                swap(objects[i], objects[j]);
                i++;
            } else (objects[j] >= objects[pivot] && j > low) {
                j--;
            }
        }

        if(i >= j) {
            swap(objects[i], pivot);
        }

        if(i < high){
            partition(objects,i,high);
        }
        if(j > low){
            partition(objects,low,j);
        }
    }

}