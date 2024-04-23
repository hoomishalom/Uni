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
     * creates a new Point3D objects and initializes _x,_y,_z to DEFAULT_VALUE
     */
    public Point3D() {
        _x = DEFAULT_VALUE;
        _y = DEFAULT_VALUE;
        _z = DEFAULT_VALUE;
    }

    /**
     * creates a new Point3D object
     * @param x the initial _x value
     * @param y the initial _y value
     * @param z the initial _z value
     */
    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    /**
     * copy constructor
     * @param other Point3D object to be copied
     */
    public Point3D(Point3D other) {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }

    /** gets _x */
    public double getX() {
        return _x;
    }

    /** gets _y */
    public double getY() {
        return _y;
    }

    /** gets _z */
    public double getZ() {
        return _z;
    }

    /**
     * sets _x
     * @param num new _x value
     */
    public void setX(double num) {
        _x = num;
    }

        /**
     * sets _y
     * @param num new _y value
     */
    public void setY(double num) {
        _y = num;
    }

        /**
     * sets _z
     * @param num new _z value
     */
    public void setZ(double num) {
        _z = num;
    }

    /**
     * @return String that represents the location of the point
     * in the following format: (x,y,z)
     */
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     * checks if two points are equal based on their _x,_y,_z values
     * @param other the other point check with
     * @return true if both points are equal else otherwise
     */
    public boolean equals(Point3D other) {
        return (_x == other._x && _y == other._y && _z == other._z);
    }

    /**
     * checks which point is higher
     * @param other the point to compare to
     * @return true if the _z value of the point which the function was called
     * from is higher than the point which "other" represents and thus higher false otherwise
     */
    public boolean isAbove(Point3D other) {
        return (_z > other._z);
    }

    /**
     * checks which point is lower
     * @param other the point to compare to
     * @return true if the _z value of the point which the function was called
     * from is lower than the point which "other" represents thus lower false otherwise
     */
    public boolean isUnder(Point3D other) {
        return other.isAbove(this);
    }

    /**
     * checks which point is more left
     * @param other the point to compare to
     * @return true if the _y value of the point which the function was called
     * from is lower than the point which "other" represents and thus more left false otherwise
     */
    public boolean isLeft(Point3D other) {
        return (_y < other._y);
    }

    /**
     * checks which point is more right
     * @param other the point to compare to
     * @return true if the _y value of the point which the function was called
     * from is higher than the point which "other" represents and thus more right false otherwise
     */
    public boolean isRight(Point3D other) {
        return other.isLeft(this);
    }

    /**
     * checks which point is behind
     * @param other the point to compare to
     * @return true if the _x value of the point which the function was called
     * from is lower than the point which "other" represents and thus behind false otherwise
     */
    public boolean isBehind(Point3D other) {
        return (_x < other._x);
    }

    /**
     * checks which point is in front
     * @param other the point to compare to
     * @return true if the _x value of the point which the function was called
     * from is higher than the point which "other" represents and thus in front false otherwise
     */
    public boolean isInFrontOf(Point3D other) {
        return other.isBehind(this);
    }

    /**
     * changes the _x,_y,_z value of the point by dx,dy,dz respectively
     * @param dx change in _x
     * @param dy change in _y
     * @param dz change in _z
     */
    public void move(double dx, double dy, double dz) {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    /**
     * calculates the distance between two points
     * @param p other point to calculate distance between
     * @return distance between the two points
     */
    public double distance(Point3D p) {
        double distance;
        
        distance = Math.sqrt(Math.pow((_x - p._x), 2) + Math.pow((_y - p._y), 2) + Math.pow((_z - p._z), 2));
        
        return distance;
    }
}