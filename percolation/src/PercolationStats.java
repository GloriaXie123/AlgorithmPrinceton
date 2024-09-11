import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats{
    private  static double confidence_95 = 1.96;
    private int n;
    private int trials;
    private double[] trialResults;
    public PercolationStats(int trials, int n){
        if(n <= 0 || trials <= 0){
            throw new IllegalArgumentException("illegal argumens: n,trials "+n+","+trials+"\n");

        }else{
            this.n = n;
            this.trials = trials;
            trialResults = new double[trials];
        }
    }

    public double mean(){
        return StdStats.mean(trialResults);
    }

    public double stddev(){
        return StdStats.stddev(trialResults);
    }

    public double confidenceLo(){
        double average = mean();
        double stddev = stddev();
        return average - confidence_95*stddev/Math.sqrt(trials);
    }

    public double confidenceHi(){
        double average = mean();
        double stddev = stddev();
        return average + confidence_95*stddev/Math.sqrt(trials);
    }

    private void Trials(){
        for(int i = 0; i < trials;i++){
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates()){
                int sitesRow = StdRandom.uniformInt(n)+1;
                int stiesCol = StdRandom.uniformInt(n)+1;
                if(!percolation.isOpen(sitesRow,stiesCol)){
                    percolation.open(sitesRow,stiesCol);
                    percolation.isFull(sitesRow,stiesCol);
                }
            }
            double opensitesPer = (double)percolation.numberOfOpenSites()/(n*n);
            trialResults[i] = opensitesPer;
        }
    }
    public static void main(String[] args){
        int T = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
//        int T = 1;
//        int n = 2;
        PercolationStats percolationStats = new PercolationStats(T,n);
        percolationStats.Trials();
        System.out.printf("mean\t= %f\n",percolationStats.mean());
        System.out.printf("stddev\t= %f\n",percolationStats.stddev());
        System.out.printf("%%95 confidence interval = [%f,%f]",percolationStats.confidenceLo(),percolationStats.confidenceHi());
    }
}
