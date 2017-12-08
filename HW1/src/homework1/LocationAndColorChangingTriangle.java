package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class LocationAndColorChangingTriangle extends ColorAndLocationChangingShape {
	
	private Dimension dimension;
	
	//TODO: abstraction function.
	
	//TODO: rep. inv.

	/**
     * @effects Initializes this with a given location, color and dimension. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
	LocationAndColorChangingTriangle(Point location, Color color, Dimension dimension) {
		super(location, color);
		try {
			this.dimension = (Dimension)dimension.clone();
		} catch(Exception e) {
			this.dimension = null;
		}
		
	}

	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		//TODO: decide when should the exception be thrown and what will be the suggested size.
		try {
			this.dimension = (Dimension)dimension.clone();
		} catch(Exception e) {
			throw new ImpossibleSizeException(new Dimension(1, 1));
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.dimension);
	}

	@Override
	public void draw(Graphics g) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		xPoints[0] = (int)this.getLocation().getX();
		yPoints[0] = (int)this.getLocation().getY();
		xPoints[1] = (int)this.getLocation().getX() + (int)this.dimension.getWidth();
		yPoints[1] = (int)this.getLocation().getY();
		xPoints[2] = (int)this.getLocation().getX();
		yPoints[2] = (int)this.getLocation().getY() + (int)this.dimension.getHeight();
		g.setColor(this.getColor());
		g.fillPolygon(xPoints, yPoints, 3);
	}

}
