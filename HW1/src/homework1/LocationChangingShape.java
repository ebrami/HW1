package homework1;

import java.awt.*;
import java.util.Random;


/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationChangingShape extends Shape implements Animatable {
	
	private final int MAX_VELOCITY = 5;
	private int velocityX, velocityY;

	/**
     * Abstraction Function:	The class represents a shape that can move such that the shape's location is given as 
     * 							the top left corner of the bounding rectangle in the field 'location', the velocity of 
     * 							the shape is given as integers in the fields 'velocityX' and 'velocityY', representing 
     * 							a vector with velocity in the (X,Y) axes, and the color is given by the field 'color'.
     * 							The shape's size is determined by the shape type and might change between different 
     * 							shapes.
     */

	/**
     * Rep. Invariant:	(this.location != null) && (this.color != null)
     * 					(this.location.getX() >= 0 && this.location.getY() >= 0)
     * 					(this.velocityX >= -MAX_VELOCITY && this.velocityX <= MAX_VELOCITY && this.velocityX != 0)
     * 					(this.velocityY >= -MAX_VELOCITY && this.velocityY <= MAX_VELOCITY && this.velocityY != 0)
     */
	private void checkRep() {
		assert(this.velocityX >= -MAX_VELOCITY && this.velocityX <= MAX_VELOCITY && this.velocityX != 0);
		assert(this.velocityY >= -MAX_VELOCITY && this.velocityY <= MAX_VELOCITY && this.velocityY != 0);
	}


    /**
     * @effects Initializes this with a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    LocationChangingShape(Point location, Color color) {
        super(location, color);
        // Randomize X axis velocity and sign.
        int randVelocityX = new Random().nextInt(MAX_VELOCITY) + 1;
        int signVelocityX = new Random().nextInt(2);
        if (signVelocityX == 0) {
        	randVelocityX = -randVelocityX;
        }
        // Randomize Y axis velocity and sign.
        int randVelocityY = new Random().nextInt(MAX_VELOCITY) + 1;
        int signVelocityY = new Random().nextInt(2);
        if (signVelocityY == 0) {
        	randVelocityY = -randVelocityY;
        }
        
        this.velocityX = randVelocityX;
        this.velocityY = randVelocityY;
        this.checkRep();
    }


    /**
     * @return the horizontal velocity of this.
     */
    public int getVelocityX() {
    	this.checkRep();
        return this.velocityX;
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
    	this.checkRep();
    	return this.velocityY;
    }
    
    /**
     * @return the absolute maximal velocity of this.
     */
    public int getMaxVelocity() {
    	this.checkRep();
    	return this.MAX_VELOCITY;
    }


    /**
	 * @requires -5 <= velocityX <= 5 && -5 <= velocityY <= 5 && velocityX != 0 && velocityY != 0
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     *          vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
    	this.checkRep();
    	this.velocityX = velocityX;
    	this.velocityY = velocityY;
    	this.checkRep();
    }


    /**
     * @modifies this
     * @effects Let p = location
     *              v = (vx, vy) = velocity
     *              r = the bounding rectangle of this
     *          If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     *              If adding v to p would move r horizontally outside of bound,
     *                  vx = -vx
     *              If adding v to p would move r vertically outside of bound,
     *                  vy = -vy
     *          }
     *          p = p + v
     */
    public void step(Rectangle bound) {
    	this.checkRep();	
    	Point newLocation = new Point((int)getLocation().getX() + getVelocityX(), 
    								(int)getLocation().getY() + getVelocityY());
    	Rectangle shapeBounds = this.getBounds();
    	boolean notInBoundPlusVelX = shapeBounds.getMinX() + getVelocityX() < bound.getMinX() || 
    								shapeBounds.getMaxX() + getVelocityX() > bound.getMaxX();
    	boolean notInBoundPlusVelY = shapeBounds.getMinY() + getVelocityY() < bound.getMinY() || 
    								shapeBounds.getMaxY() + getVelocityY() > bound.getMaxY();
    	// If (part of r is outside bound) or (r is within bound but adding v to p would bring part of r outside bound)
    	if (!bound.contains(shapeBounds) || notInBoundPlusVelX || notInBoundPlusVelY) {
    		if (notInBoundPlusVelX) {
    			this.velocityX = -this.velocityX;
    		}
    		if (notInBoundPlusVelY) {
    			this.velocityY = -this.velocityY;
    		}
    	}
    	this.setLocation(newLocation);
    	this.checkRep();
    }
    
    /**
     * @effects Creates and returns a copy of this.
     */
    public Object clone() {
    	this.checkRep();
    	LocationChangingShape cloned;
        try {
        	cloned = (LocationChangingShape)super.clone();
        	cloned.setVelocity(this.getVelocityX(), this.getVelocityY());
        } catch (InternalError e) {
        	throw e;
        }
        this.checkRep();
        return cloned;
    }

}
