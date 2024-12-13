import edu.princeton.cs.algs4.*;

public class BruteCollinearPoints {

    Point[] points;
    public BruteCollinearPoints(Point[] points) {//finds all line segments containing 4 points
        this.points = points;
        if (points == null) {
            throw new IllegalArgumentException("No points found.");
        }

        /* find the smallest point among all the points,
        I can use QuickSort to find the smallest point, The theory of QuickSort is, firstly, find a pivot, secondly,
        put all the elements smaller than the pivot on the left, put all the elements larger than the pivot on the right.
        This is related to a method called Iteration or Devide-N-Conquer.*/
    }

    public int numberOfSegments() {
        LineSegment[] lineSegments = segments(points);
        return lineSegments.length;
    }                    //the number of line segments

    public LineSegment[] segments(Point[] points) {
        int l = 0;
        LineSegment[] lineSegments = new LineSegment[32767];
        QuickSort(points);
        Point minimum = points[0];
        /*slope of Line segements, Assume we found the smallest point now, What we can do is to get the polar angles
        of the rest of the points to this base point*/
        Double[] slopes;
        for(int i = 0; i < points.length; i++){
            slopes[i] = points[i].slopeTo(minimum);
        }
        //sort the slope of line segments
        QuickSort(slopes);

        for(int i = 0; i < slopes.length; i++){
            k = 0;
            Point[] fourPoints = new Point[4];
            fourPoints[0] = slopes[i];
            for(j = i+1; j < slopes.length; j++){
                if(slopes[j] == fourPoints[0] && k < 3){
                    fourPoints[k +1] = Point[j];
                }
            }

            if(k == 3){
                LineSegment ls = LineSegment(fourPoints[0], fourPoints[3]);
            }
            lineSegments[l++] = ls;
        }
        return lineSegments;
    }                   //the line segments

    public static void main(String[] args) {
        //read n points from a file
        In in = new In(args[0]);

        int n = in.readInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        //draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        //print and draw the line segments
        BruteCollinearPoints collinearPoints = new BruteCollinearPoints(points);
        LineSegment[] segments = collinearPoints.segments();
        for (LineSegment segment : segments) {
            segment.draw();
        }
        StdDraw.show();
    }
}
