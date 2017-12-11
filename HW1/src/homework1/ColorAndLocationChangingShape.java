package homework1;

import java.awt.*;
import java.util.Random;


/**
 * A ColorAndLocationChaningShape is a Shape that can change its location and color using its step()
 * method.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class ColorAndLocationChangingShape extends LocationChangingShape{
	
	private static final int COLOR_MAX_PARAM = 256;

    /**
     * Abstraction Function:	Same as in LocationChangingShape. The only update is that COLOR_MAX_PARAM describes
     * 							the number of possible values for each of the shape's color red, green and blue 
     * 							channels.
     */

    /**
     * Rep. Invariant:	Same as in LocationChangingShape.
     */


    /**
     * @effects Initializes this with a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
	ColorAndLocationChangingShape(Point location, Color color) {
        super(location, color);
    }

    /**
     * @modifies this
     * @effects Changes the location of this as described in the specification
     *          of LocationChangingShape.step(Rectangle bound) &&
	 *			if the velocity of this needs to be changed (as described in LocationChangingShape.step(Rectangle bound)),
	 *			changes the color of this to a new random color;
	 *			else, does not change the color of this.
     */
    public void step(Rectangle bound) {
    	Point oldVelocity = new Point(this.getVelocityX(), this.getVelocityY());
        super.step(bound);
        Point newVelocity = new Point(this.getVelocityX(), this.getVelocityY());
        if (!newVelocity.equals(oldVelocity)) {
        	// If the velocity changed, set a new random color.
        	this.setColor(
        		new Color(
	    			new Random().nextInt(COLOR_MAX_PARAM), 
	    			new Random().nextInt(COLOR_MAX_PARAM), 
	    			new Random().nextInt(COLOR_MAX_PARAM)
        		)
        	);
        }
    }
}
