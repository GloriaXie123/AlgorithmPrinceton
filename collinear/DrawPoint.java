import edu.princeton.cs.algs4.StdDraw;

public class DrawPoint {
    public static void main(String[] args) {
        // Set the scale of the drawing canvas to accommodate (100, 100)
        StdDraw.setXscale(-200, 32768); // Adjust the range as needed
        StdDraw.setYscale(-200, 32768); // Ensure the Y scale matches the X scale

        // Set the pen radius to make the point more visible
        StdDraw.setPenRadius(0.01);

        // Draw a point at coordinates (100, 100)
        StdDraw.point(100, 100);
    }
}