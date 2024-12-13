import java.util.function.ObjIntConsumer;
Public class QuickSort<T> implements Comparable<T>{

    private Object[] objects;
    private int low;
    private int high;

    public QuickSort<T>(Object[] objects){
        this.objects = objects;
        shuffle(objects);
    }

    public void partition(){
        for(int pivot = objects.length -1; pivot > = 0; pivot--){
            low = 0;
            high = objects.length -1;
            sort(objects,low, high,pivot);
        }
    }
    //Sort out array
    public void sort(Object[] objects, int i, int j, int pivot){
        while (i < j) {
            if (objects[i] > objects[pivot]) {
                swap(i, j);
                i++;
            } else if (objects[i] <= objects[pivot]) {
                i++
            } else if (objects[j] < objects[pivot]) {
                swap(i, j);
                j--;
            } else (objects[j] >= objects[pivot]) {
                j--;
            }
        }
        if (objects[j] > objects[pivot]) {
            swap(j, pivot);
        } else if (objects[i] < objects[pivot]) {
            swap(i++, pivot);
        }
    }
}