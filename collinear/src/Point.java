import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;
    public Point(int x, int y){                 //constructs the point(x, y)
        this.x = x;
        this.y = y;
        if(x > 32767 || x < 0 || y < 0 || y > 32767){
            throw new IllegalArgumentException("The point is out of boundary");
        }
    }

    public void draw(){                        //draws this point
        StdDraw.point(x,y);
    }

    public void drawTo(Point that){
        StdDraw.line(this.x, this.y, that.x, that.y);
    }//draws the line segment from this point to that point

    public String toString(){
        return  "(" + x + ", " + y + ")";
    }                  //string representation

    public int compareTo(Point that){
        if(y < that.y || y == that.y && x < that.x){
            return -1;
        } else if (y == that.y && x == that.x) {
            throw new IllegalArgumentException("there is redundant points.")
        }else{
            return 1;
        }
    }//compare two points by y-coordinates, breaking ties by x-coordinates

    public double slopeTo(Point that){
        if(this.x != that.x && this.y != that.y){
            return (that.y - this. y) / (that.x - this.x);
        } else if (this.y == that.y && this.x != that.x) {
            return 0;
        } else if (this.y != that.y && this.x == that.x) {
            return Float.POSITIVE_INFINITY;
        }else if(this.x == that.x && this.y == that.y) {
            return Float.NEGATIVE_INFINITY;
        }
    }//the slope between this point and that point
    
    public Comparator<Point> slopeOrder(){
        return new BySlope();
    }//compare two points by slopes they make with this point

    //inner class Comparator<Point>
    private static class BySlope implements Comparator<Point>{
        public int compare(double slopeToPointA, double slopeToPointB){
            if(slopeToPointA < slopeToPointB){
                return -1;
            } else if (slopeToPointA == slopeToPointB) {
                return 0;
            } else if (slopeToPointA > slopeToPointB) {
                return 1;
            }
        }
    }

}
