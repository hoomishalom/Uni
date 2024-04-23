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
    /**
     * creates a new Box3D object and initializes _base to a deafult Point3D object
     * and _length,_width,_height to DEFAULT_VALUE
     */
    public Box3D(){
        _base = new Point3D();
        _length = DEFAULT_VALUE;
        _width = DEFAULT_VALUE;
        _height = DEFAULT_VALUE;
    }

    /**
     * creates a new Box3D object, check if values are valid, if not initializes 
     * _length,_width,_height to DEFAULT_VALUE
     * @param base a Point3D object
     * @param length the initial _length value
     * @param width the initial _width value
     * @param height the initial _height value
     */
    public Box3D(Point3D base, int length, int width, int height) {
        _base = new Point3D(base);
        if(length >= MIN_POSITIVE_INT) {
            _length = length;
        } else {
            _length = DEFAULT_VALUE;
        }

        if(width >= MIN_POSITIVE_INT) {
            _width = width;
        } else {
            _width = DEFAULT_VALUE;
        }

        if(height >= MIN_POSITIVE_INT) {
            _height = height;
        } else {
            _height = DEFAULT_VALUE;
        }
    }

    /**
     * copy constructor
     * @param other Box3D object to be copied
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /** gets _length */
    public int getLength() {
        return _length;
    }

    /** gets _width */
    public int getWidth() {
        return _width;
    }

    /** gets _height */
    public int getHeight() {
        return _height;
    }

    /** gets _base */
    public Point3D getBase() {
        return _base;
    }

    /**
     * sets _length if num is valid
     * @param num new _length value
     */
    public void setLength(int num) {
        if (num >= MIN_POSITIVE_INT) {
            _length = num;
        }
    }

    /**
     * sets _width if num is valid
     * @param num new _width value
     */
    public void setWidth(int num) {
        if (num >= MIN_POSITIVE_INT) {
            _width = num;
        }
    }

    /**
     * sets _height if num is valid
     * @param num new _height value
     */
    public void setHeight(int num) {
        if (num >= MIN_POSITIVE_INT) {
            _height = num;
        }
    }

    /**
     * sets _base
     * @param p new _base value
     */
    public void setBase(Point3D p) {
        _base = new Point3D(p);
    }

    /**
     * @return data of the Box3D object in the following format:
     * The base point is (x,y,z), length = _length, width = _width, height = _height
     */
    public String toString() {
        return "The base point is " + _base.toString() + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }

    /**
     * checks whether the two Box3D objects are equal and returns the result
     * @param other Box3D object to compare against
     * @return true if equal based on _base,_length,_width,_height false otherwise 
     */
    public boolean equals(Box3D other) {
        if(_base.equals(other._base) && _length == other._length 
            && _width == other._width && _height == other._height) 
        {
            return true;
        } else 
        {
            return false;
        }
    }

    /**
     * copies the Box3D object moves it and returns result
     * @param dx change in _x
     * @param dy change in _y
     * @param dz change in _z
     * @return new moved Box3D object
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
     * calculates location of the up right back point and returns result
     * @return new Point3D object which represents the 
     * up right back point of the box object
     */
    public Point3D getUpRightBackPoint() {
        Point3D result;
        double x,y,z;

        x = _base.getX() - _length;
        y = _base.getY() + _width;
        z = _base.getZ() + _height;

        result = new Point3D(x, y, z);

        return result;
    }

    /**
     * calculates location of the center of the box and returns result
     * @return new Point3D object which represents the center of the box
     */
    public Point3D getCenter() {
        Point3D result;
        double x,y,z;

        x = _base.getX() - (_length / (double) 2);
        y = _base.getY() + (_width / (double) 2);
        z = _base.getZ() + (_height / (double) 2);

        result = new Point3D(x, y, z);

        return result;
    }

    /**
     * calculates the distance between the base points and returns the result
     * @param other other box to calculate distance between
     * @return distance between the base points
     */
    public double distance(Box3D other) {
        double result;

        result = this.getCenter().distance(other.getCenter());

        return result;
    }

    /**
     * calculates volume of the box and returns result
     * @return volume of the box
     */
    public int getVolume() {
        int result;

        result = _length * _width * _height;

        return result;
    }

    /**
     * calculates the surface area of the box and returns result
     * @return surface area of the box
     */
    public int getSurfaceArea() {
        int result;
        int sideA,sideB,sideC;
        
        sideA = _length * _width;
        sideB = _length * _height;
        sideC = _width * _height;

        result = 2 * sideA + 2 * sideB + 2 * sideC;

        return result;
    }

    /**
     * checks which box has a more volume
     * @param other the box to compare to
     * @return true if the box which the function was called from has more volume
     * than the box "other" represents false otherwise
     */
    public boolean isLargerCapacity(Box3D other) {
        return (this.getVolume() > other.getVolume());
    }

    /**
     * check if the box the function was called from can contain the box "other" represents
     * @param other the box to compare to
     * @return true if _length,_width,_height are bigger than 
     * other._length,other._width,other._height respectively false otherwise 
     */
    public boolean contains(Box3D other) {
        if((_length > other._length) && (_width > other._width)
        && (_height > other._height))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if the box which the function was called from  is above the box "other"
     * @param other the box to compare to
     * @return true if the base point of the box is above the top point of "other"
     */
    public boolean isAbove(Box3D other) {
        return (_base.isAbove(other.getUpRightBackPoint()));
    }
}
