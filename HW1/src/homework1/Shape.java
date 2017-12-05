package homework1;

import java.awt.*;

import javax.management.RuntimeErrorException;


/**
 * A Shape is an abstraction of a shape object. A typical Shape consists of
 * a set of properties: {location, color, shape, size}.
 * Shapes are mutable and cloneable.
 */
public abstract class Shape implements Cloneable {

    private Point location;
    private Color color;


    /**
     * Abstraction Function:	The class represents a shape such that the shape's location is given as the top left 
     * 							corner of the bounding rectangle in the field 'location' and the color is given by the 
     * 							field 'color'. The shape's size is determined by the shape type and might change
     * 							between different shapes.
     */

    /**
     * Rep. Invariant:	(this.location != null) && (this.color != null)
     * 					(this.location.getX() >= 0 && this.location.getY() >= 0)
     */
    
    //OK OK NO PROBLEM THIS WORKS NOW
    
    protected void checkRep() {
    	assert(this.location != null);
    	assert(this.color != null);
    	assert(this.location.getX() >= 0);
    	assert(this.location.getY() >= 0);
    }


    /**
     * @effects Initializes this with a given location and color.
     */
    public Shape(Point location, Color color) {
    	this.location = (Point)location.clone();
    	this.color = color;
    	this.checkRep();
    }


    /**
     * @return the top left corner of the bounding rectangle of this.
     */
    public Point getLocation() {
    	this.checkRep();
        return (Point)location.clone();
    }


    /**
     * @modifies this
     * @effects Moves this to the given location, i.e. this.getLocation()
     *          returns location after call has completed.
     */
    public void setLocation(Point location) {
    	this.checkRep();
        this.location = (Point)location.clone();
        this.checkRep();
    }


    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     *          dimension.
     *          If this cannot be resized to the specified dimension =>
     *          this is not modified, throws ImpossibleSizeException
     *          (the exception suggests an alternative dimension that is
     *           supported by this).
     */
    public abstract void setSize(Dimension dimension)
        throws ImpossibleSizeException;


    /**
     * @return the bounding rectangle of this.
     */
    public abstract Rectangle getBounds();


    /**
     * @return true if the given point lies inside the bounding rectangle of
     *         this and false otherwise.
     */
    public boolean contains(Point point) {
    	this.checkRep();
        return getBounds().contains(point);
    }


    /**
     * @return color of this.
     */
    public Color getColor() {
    	this.checkRep();
        return color;
    }


    /**
     * @modifies this
     * @effects Sets color of this.
     */
    public void setColor(Color color) {
    	this.checkRep();
        this.color = color;
        this.checkRep();
    }


    /**
     * @modifies g
     * @effects Draws this onto g.
     */
    public abstract void draw(Graphics g);


    /**
     * @effects Creates and returns a copy of this.
     */
    public Object clone() {
    	this.checkRep();
    	Shape cloned;
        try {
        	cloned = (Shape)super.clone();
        	cloned.setColor(this.color);
        	cloned.setLocation(this.location);
        } catch (CloneNotSupportedException e) {
        	throw new InternalError("Should not happen! Object class has no clone???", e);
        }
        this.checkRep();
        return cloned;
    }
}
