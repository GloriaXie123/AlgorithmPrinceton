/**
 * throw unsupportedOperationException
 * if the client calls remove() method
 * in the iterator.
 * */

/**
 your main method must call directly every public constructor and method to make sure that
they work as prescribed.(e.g. by printing results to standard output.)

performance requirements:
your deque implementation must support each deque operation within constant worst-case time,
a deque containing n items must use at most 48n+192 bytes of memory. Addtionally, your iterator
implementation must support all the operations within constant worst-case time.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Permutation {

   public static void main(String args[]){

       int k = 0;

       if(args.length !=0){
           k = Integer.parseInt(args[0]);
       }

       Scanner sc = new Scanner(System.in);

       String ln = sc.nextLine();

       String[] it;

       it = ln.trim().split(" ");

       RandomizedQueue dq = new RandomizedQueue();

       for(int i = 0; i < it.length; i++){
           dq.enqueue(it[i]);
       }

       while(k > 0){
           String s = (String) dq.sample();
           System.out.println(s);
       }







   }

}
