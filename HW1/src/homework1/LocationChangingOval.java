package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A LocationChangingOval is a LocationChangingShape with the specified dimensions that make it an oval.
 */
public class LocationChangingOval extends LocationChangingShape implements Cloneable {
	
	private Dimension dimension;
	
	/**
	 * Abstraction Function:	same as LocationChangingShape with the addition of a dimension, representing the 
	 * 							size properties of the oval.
	 */
	
	/**
	 * Rep. Invariant: same as LocationChangingShape.
	 */
	
	/**
     * @throws ImpossibleSizeException 
	 * @effects Initializes this with a given location, color and dimension. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
	LocationChangingOval(Point location, Color color, Dimension dimension) throws ImpossibleSizeException {
		super(location, color);
		this.setSize(dimension);
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
	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		if (dimension.getHeight() <= 0 || dimension.getWidth() <= 0) {
			throw new ImpossibleSizeException(new Dimension(1, 1));
		}
		this.dimension = (Dimension)dimension.clone();
	}

	/**
     * @return the bounding rectangle of this.
     */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.dimension);
	}

	/**
     * @modifies g
     * @effects Draws this onto g.
     */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval((int)this.getLocation().getX(), (int)this.getLocation().getY(), 
				(int)this.dimension.getWidth(), (int)this.dimension.getHeight());
	}
	
	/**
     * @effects Creates and returns a copy of this.
     */
	public Object clone() {
		LocationChangingOval cloned;
		try {
			cloned = (LocationChangingOval)super.clone();
			cloned.dimension = (Dimension)dimension.clone();
		} catch(InternalError e) {
			throw e;
		}
		return cloned;
	}

}
