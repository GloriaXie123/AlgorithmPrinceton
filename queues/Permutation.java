import edu.princeton.cs.algs4.StdIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* read N items from the command line, print k of them, each item only be selected once;
*/
public class Permutation {

    public static void main(String[] args) {


        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while(!StdIn.isEmpty()){
            rq.enqueue(StdIn.readString());
        }
        while(k > 0){
            String popS;
            popS = rq.dequeue();
            k--;
            System.out.println(popS);
        }
    }
}
