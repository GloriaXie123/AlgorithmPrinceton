import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdDraw;
import java.lang.Math;


public class Percolation {
    private boolean[] open;
    private boolean[] full;
    private int arrLen;
    private WeightedQuickUnionUF percolationUF;
    private WeightedQuickUnionUF percolationUFTOP;
    private int topIndex;
    private int bottomIndex;
    //initialize an int array of size n square, and set all sites blocked
    public Percolation(int n){
        if(n <= 0){
            throw new IllegalArgumentException("illegal argumens: n\n "+n);

        }
        percolationUF = new WeightedQuickUnionUF(n*n+2);
        percolationUFTOP = new WeightedQuickUnionUF(n*n+1);
        arrLen = n;
        topIndex = arrLen * arrLen;
        bottomIndex = topIndex +1;
        for(int i = 0; i < n;i++){
            percolationUF.union(i,topIndex);
            percolationUFTOP.union(i,topIndex);
        }

        for(int i = arrLen * (arrLen -1); i < arrLen * arrLen; i++){
            percolationUF.union(i,bottomIndex);
        }
        open = new boolean[n * n];
        full = new boolean[n*n];
        for(int i = 0; i < n * n; i++){
            open[i] = false;
            full[i] = false;
        }
    }
    //visualize n*n grids;
//    public void openViualizer(){
//        StdDraw.enableDoubleBuffering();
//        StdDraw.clear();
//        StdDraw.setPenColor(StdDraw.BLACK);
//        show(open, false);
//        StdDraw.setPenColor(StdDraw.GRAY);
//        show(full, true);
//        StdDraw.show();
//    }

    // draw the n-by-n boolean matrix to standard draw
//    public void show(boolean[] a, boolean which) {
//        int n = arrLen;
//        StdDraw.setXscale(-1, n+1);
//        StdDraw.setYscale(-1, n+1);
//        for (int i = 1; i <= n; i++)
//            for (int j = 1; j <= n; j++)
//                if (a[index(i,j)] == which)
//                    StdDraw.filledSquare(j, n-i-1, 0.5);
//    }
    public void open(int row, int col){
        int index = index(row,col);
        open[index] = true;
        if(row - 1 > 0 && row - 1 <= arrLen){
            int upper = index(row -1,col);
            if(open[upper] && percolationUF.find(index) != percolationUF.find(upper)){
                percolationUF.union(index,upper);
            }
            if(open[upper] && percolationUFTOP.find(index) != percolationUFTOP.find(upper)){
                percolationUFTOP.union(index,upper);
            }

        }
        if(row + 1 >0 && row +1 <= arrLen){
            int below = index(row +1,col);
            if(open[below] && percolationUF.find(index) != percolationUF.find(below)){
                percolationUF.union(index,below);
            }
            if(open[below] && percolationUFTOP.find(index) != percolationUFTOP.find(below)){
                percolationUFTOP.union(index,below);
            }
        }

        if(col - 1>0 && col -1 <= arrLen){
            int left = index(row,col - 1);
            if(open[left] && percolationUF.find(index) != percolationUF.find(left)){
                percolationUF.union(index,left);
            }
            if(open[left] && percolationUFTOP.find(index) != percolationUFTOP.find(left)){
                percolationUFTOP.union(index,left);
            }
        }
        if(col + 1 >0 && col +1 <= arrLen){
            int right = index(row,col + 1);
            if(open[right] && percolationUF.find(index) != percolationUF.find(right)){
                percolationUF.union(index,right);
            }
            if(open[right] && percolationUFTOP.find(index) != percolationUFTOP.find(right)){
                percolationUFTOP.union(index,right);
            }
        }

    }

    public boolean isOpen(int row, int col){
        return open[index(row,col)];
    }

    private int index(int row , int col){
        int index;
        if(row < 1 || row > arrLen || col < 1 || col > arrLen){

            throw new IllegalArgumentException("row,col:"+row+","+col+" is out of bound\n");
        }else{
            index = (row - 1) * arrLen + col -1;
            return index;
        }
    }


    public boolean isFull(int row, int col){
        int p = index(row,col);
        if(full[p]){
            return true;
        }else{
            if(row == 1 && open[p] ||open[p]&& percolationUFTOP.find(p) == percolationUFTOP.find(topIndex)){
                full[p] = true;
                return full[p];
            }else{
                return false;
            }
        }
    }

    public int numberOfOpenSites(){
        int count = 0;
        for(int i = 0; i < arrLen*arrLen;i++){
            if(open[i]){
               count++;
            }
        }
        return count;
    }

    public boolean percolates(){
        if(percolationUF.find(topIndex) == percolationUF.find(bottomIndex)){
            return true;
        }else{
            return false;
        }
    }
}
