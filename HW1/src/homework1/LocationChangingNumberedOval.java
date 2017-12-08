package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * LocationChangingNumberedOval is LocationChangingOval that is numbered and its number is presented in its center.
 */
public class LocationChangingNumberedOval extends LocationChangingOval {
	
	private static int nextNumber = 1;
	private int serialNumber;
	
	/**
	 * Abstraction Function:	The serial number of the oval is given in the field serialNumber and represents the
	 * 							instance number of the oval from this class.
	 */
	
	/**
	 * Rep. Invariant:	Same as LocationChangingOval.
	 */

	/**
     * @effects Initializes this with a given location, color and dimension. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
	LocationChangingNumberedOval(Point location, Color color, Dimension dimension) {
		super(location, color, dimension);
		this.serialNumber = nextNumber;
		LocationChangingNumberedOval.nextNumber++;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.BLACK);
		g.drawString(new Integer(serialNumber).toString(),
				(int)this.getBounds().getCenterX(), (int)this.getBounds().getCenterY());
	}
	
	/**
	 * @modifies this
	 * @effects resets the nextNumber field for serializing numbered oval numbers.
	 */
	public void reset() {
		LocationChangingNumberedOval.nextNumber = 1;
	}

}
