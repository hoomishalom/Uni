/**
 * Maman 12 - Using a class to represent a box in 3D space
 * @author Tom Shabtay
 * @version 2024b
 */
public class Box3D{
    private final int DEFAULT_VALUE = 1;
    private final int MIN_POSITIVE_INT = 1;
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    // constructors
    /** Constructs and initializes a box with a default base point and all dimensions to 1. */
    public Box3D(){
        _base = new Point3D();     
        _length = DEFAULT_VALUE;
        _width = DEFAULT_VALUE;
        _height = DEFAULT_VALUE;
    }

    /**
     * Constructs and initializes a box object from a given base point and 3 integers as the dimentions of the Box 
     * _length,_width,_height to DEFAULT_VALUE
     * @param base a Point3D object
     * @param length the initial _length value
     * @param width the initial _width value
     * @param height the initial _height value
     */
    public Box3D(Point3D base, int length, int width, int height) {
        _base = new Point3D(base);
        if(length >= MIN_POSITIVE_INT) {    // checks if length is valid, and sets _length accordingly
            _length = length;
        } else {
            _length = DEFAULT_VALUE;
        }

        if(width >= MIN_POSITIVE_INT) {     // checks if width is valid, and sets _width accordingly
            _width = width;
        } else {
            _width = DEFAULT_VALUE;
        }

        if(height >= MIN_POSITIVE_INT) {    // checks if height is valid, and sets _height accordingly
            _height = height;
        } else {
            _height = DEFAULT_VALUE;
        }
    }

    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other Box3D object to be copied
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /** 
     * returns the length dimension 
     * @return the length of the box
    */
    public int getLength() {
        return _length;
    }

    /** 
     * returns the width dimension
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }

    /** 
     * returns the height dimension
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    /** 
     * returns the lower-left-front (base) Point3D of the box 
     * @return the base point of the box
    */
    public Point3D getBase() {
        return new Point3D(_base);
    }

    /**
     * Sets the length of the box only if the given value is equal or greater than 1.
     * @param num the length to set
     */
    public void setLength(int num) {
        if (num >= MIN_POSITIVE_INT) {      // checks if num is valid, and sets _length accordingly
            _length = num;
        }
    }

    /**
     * Sets the width of the box only if the given value is equal or greater than 1.
     * @param num the width to set
     */
    public void setWidth(int num) { 
        if (num >= MIN_POSITIVE_INT) {      // checks if num is valid, and sets _width accordingly
            _width = num;
        }
    }

    /**
     * Sets the height of the box only if the given value is equal or greater than 1.
     * @param num the height to set
     */
    public void setHeight(int num) {
        if (num >= MIN_POSITIVE_INT) {      // checks if num is valid, and sets _height accordingly
            _height = num;
        }
    }

    /**
     * Sets the base point of the box
     * @param p the Point3D to set
     */
    public void setBase(Point3D p) {
        _base = new Point3D(p);
    }

    /**
     * Returns a string representation of this Box3D object.
     * @return a string representation of this box containing the location of its base point in the coordinate space and its dimensions.
     */
    @Override
    public String toString() {
        return "The base point is " + _base.toString() + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }

    /**
     * Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     * @return true if the Box3D object to be compared has the same values; false otherwise.
     */
    public boolean equals(Box3D other) {
        if(_base.equals(other._base) && _length == other._length        
            && _width == other._width && _height == other._height)      // checks if _base, _length, _width, _height equals the other box _base, _length, _width, _height 
        {
            return true;
        } else 
        {
            return false;
        }
    }

    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without changing the box dimensions
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y vlaue
     * @param dz the addtion for coordinate z value
     * @return the new box in its new location
     */
    public Box3D move(double dx, double dy, double dz) {
        Box3D result;
        Point3D movedBase;

        movedBase = new Point3D(_base);
        movedBase.move(dx, dy, dz);
        
        result = new Box3D(movedBase, _length, _width, _height);

        return result;
    }

    /**
     * Calculates and returns the upper-right-back point of this box
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint() {
        Point3D result;
        double x,y,z;

        x = _base.getX() - _length;         // gets the x,y,z of the Up Right Back Point
        y = _base.getY() + _width;
        z = _base.getZ() + _height;

        result = new Point3D(x, y, z);

        return result;
    }

    /**
     * Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter() {
        Point3D result;
        double x,y,z;

        x = _base.getX() - (_length / (double) 2);      // gets the x,y,z of the Center Point
        y = _base.getY() + (_width / (double) 2);
        z = _base.getZ() + (_height / (double) 2);

        result = new Point3D(x, y, z);

        return result;
    }

    /**
     * Computes the distance between two boxes based on the distance of their center points.
     * @param other a Box3D object that will be usd to calculate the distance between it to this Box3D object
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other) {
        double result;

        result = this.getCenter().distance(other.getCenter());  // gets the distance between the two _base points

        return result;
    }

    /**
     * Computes the volume of the box.
     * @return volume of the Box3D object
     */
    public int getVolume() {
        int result;

        result = _length * _width * _height;    // equation to get volume of a box

        return result;
    }

    /**
     * Computes the surface area of a box.
     * @return the surface area of a Box3D object
     */
    public int getSurfaceArea() {
        int result;
        int faceA,faceB,faceC;
        
        faceA = _length * _width;   // gets surface area of each face of the box
        faceB = _length * _height;
        faceC = _width * _height;

        result = 2 * (faceA + faceB + faceC);   // equation to get surface area of a box

        return result;
    }

    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     * @return true if this object has a greater volume, false otherwise.
     */
    public boolean isLargerCapacity(Box3D other) {
        return (this.getVolume() > other.getVolume());  // checks wich box has more volume
    }

    /**
     * Determines whether this box can contain the other box.
     * @param other a Box3D object to check if it can be contained within this box
     * @return true if this Box3D object can contain the other, false otherwise.
     */
    public boolean contains(Box3D other) {
        if((_length > other._length) && (_width > other._width) // checks if _length, _width, _height are bigger than the other box _length, _width, _height
        && (_height > other._height))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if this box is above the other box.
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other) {
        return (_base.isAbove(other.getUpRightBackPoint()));
    }
}
