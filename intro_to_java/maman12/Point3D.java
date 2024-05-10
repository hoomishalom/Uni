/**
 * Maman 12 - Using a class to represent a point in 3D space
 * @author Tom Shabtay
 * @version 2024b
 */

public class Point3D {
    private final double DEFAULT_VALUE = 0.0;
    private double _x;
    private double _y;
    private double _z;

    //constructors:
    /**
     * Constructs and initializes a Point3D to (0,0,0).
     */
    public Point3D() {
        _x = DEFAULT_VALUE;
        _y = DEFAULT_VALUE;
        _z = DEFAULT_VALUE;
    }

    /**
     * Constructs and initializes a Point3D from the specified xyz coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    /**
     * Constructs and initializes a Point3D from the specified Point3D.
     * @param other which the new instance initialization will be based on
     */
    public Point3D(Point3D other) {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }

    /**  
     * returns the x coordinate
     * @return the value of the x coordinate
    */
    public double getX() {
        return _x;
    }

    /**  
     * returns the y coordinate
     * @return the value of the y coordinate
    */
    public double getY() {
        return _y;
    }

    /** 
     * returns the z coordinate
     * @return the value of the z coordinate
    */
    public double getZ() {
        return _z;
    }

    /**
     * sets the x coordinate to the given x
     * @param num the x value to set
     */
    public void setX(double num) {
        _x = num;
    }

    /**
     * sets the y coordinate to the given y
     * @param num the y value to set
     */
    public void setY(double num) {
        _y = num;
    }

    /**
     * sets the z coordinate to the given z
     * @param num the z value to set
     */
    public void setZ(double num) {
        _z = num;
    }

    /**
     * Returns a string representation of this Point3D.
     * @return a string representation of this point and its location in the (x,y,z) coordinate space.
     */
    @Override
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     * Determines whether or not two points are equal.
     * @param other a Point3D object to be compared with this Point3D
     * @return true if the two Point3D objects are equal (containing the same x, y, and z values), false otherwise.
     */
    public boolean equals(Point3D other) {
        return (_x == other._x && _y == other._y && _z == other._z);    // returns true if _x,_y,_z are equal to other._x, other._y, other._z respectively, false otherwise 
    }

    /**
     * Checks if this point is above the other point.
     * @param other The point to check whether this point is above it
     * @return true if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other) {
        return (_z > other._z);     // checks if _z > other._z and returns the result
    }

    /**
     * Checks if this point is under the other point.
     * @param other The point to check whether this point is under i
     * @return true if this point is under the other point, false otherwise
     */
    public boolean isUnder(Point3D other) {
        return other.isAbove(this);
    }

    /**
     * Checks if this point is to the left of the other point.
     * @param other The point to check whether this point is left of it
     * @return true if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other) {
        return (_y < other._y);     // checks if _y < other._y and returns the result
    }

    /**
     * Checks if this point is to the right of the other point.
     * @param other The point to check whether this point is right of it
     * @return true if this point is to the right of the other point, false otherwise
     */
    public boolean isRight(Point3D other) {
        return other.isLeft(this);
    }

    /**
     * Checks if this point is behind the other point.
     * @param other The point to check whether this point behind it
     * @return true if this point is behind the other point, false otherwise
     */
    public boolean isBehind(Point3D other) {
        return (_x < other._x);         // checks if _x < other._x and returns the result
    }

    /**
     * Checks if this point is in front of the other point.
     * @param other The point to check if this point is in front of it
     * @return true if this point is in front of the other point, false otherwise
     */
    public boolean isInFrontOf(Point3D other) {
        return other.isBehind(this);
    }

    /**
     * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and dz along the z axis 
     * so that it now represents the Point3D in the following 3D coordintes (x+dx,y+dy,z+dz).
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y vlaue
     * @param dz the addtion for coordinate z value
     */
    public void move(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    /**
     * Returns the distance between this point and other point p.
     * @param p the other point
     * @return returns the distance
     */
    public double distance(Point3D p) {
        double distance;
        
        distance = Math.sqrt(Math.pow((_x - p._x), 2) + Math.pow((_y - p._y), 2) + Math.pow((_z - p._z), 2));   // equation to calculate distance between two points
        
        return distance;
    }
}