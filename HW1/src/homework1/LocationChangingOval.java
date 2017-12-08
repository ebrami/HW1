package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A LocationChangingOval is a LocationChangingShape with the specified dimensions that make it an oval.
 */
public class LocationChangingOval extends LocationChangingShape {
	
	private Dimension dimension;
	
	/**
	 * Abstraction Function:	same as LocationChangingShape with the addition of a dimension, representing the 
	 * 							size properties of the oval.
	 */
	
	/**
	 * Rep. Invariant: same as LocationChangingShape.
	 */
	
	private void checkRep() {
		assert(this.getLocation() != null);
		assert(this.getColor() != null);
    	assert(this.getLocation().getX() >= 0);
    	assert(this.getLocation().getY() >= 0);
		assert(this.getVelocityX() >= -this.getMaxVelocity() && this.getVelocityX() <= this.getMaxVelocity() && 
				this.getVelocityX() != 0);
		assert(this.getVelocityY() >= -this.getMaxVelocity() && this.getVelocityY() <= this.getMaxVelocity() && 
				this.getVelocityY() != 0);
	}
	
	/**
     * @effects Initializes this with a given location, color and dimension. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
	LocationChangingOval(Point location, Color color, Dimension dimension) {
		super(location, color);
		this.dimension = null;
		if (dimension != null) {
			this.dimension = (Dimension)dimension.clone();
		}
		this.checkRep();
	}

	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		this.checkRep();
		//TODO: decide when should the exception be thrown and what will be the suggested size.
		try {
			this.dimension = (Dimension)dimension.clone();
		} catch(Exception e) {
			throw new ImpossibleSizeException(new Dimension(1, 1));
		}
		this.checkRep();
	}

	@Override
	public Rectangle getBounds() {
		this.checkRep();
		return new Rectangle(this.dimension);
	}

	@Override
	public void draw(Graphics g) {
		this.checkRep();
		g.setColor(this.getColor());
		g.fillOval((int)this.getLocation().getX(), (int)this.getLocation().getY(), 
				(int)this.dimension.getWidth(), (int)this.dimension.getHeight());
		this.checkRep();
	}
	
	/**
     * @effects Creates and returns a copy of this.
     */
	public Object clone() {
		this.checkRep();
		LocationChangingOval cloned;
		try {
			cloned = (LocationChangingOval)super.clone();
			cloned.dimension = (Dimension)dimension.clone();
		} catch(InternalError e) {
			throw e;
		}
		this.checkRep();
		return cloned;
	}

}
