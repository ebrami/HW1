package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * An AngleChangingSector is a Shape that can change its sector angle using its step()
 * method. An AngleChangingSector has a startAngle property that determines the animation's base angle.
 * Thus, a typical AngleChangingSector consists of the following set of
 * properties: {location, color, size, start angle}
 */
public class AngleChangingSector extends Shape implements Animatable {

	private static final int MAX_ANGLE = 359;
	private int startAngle;
	private int sectorAngle;
	private boolean goingUp;
	private Dimension dimension;
	
	/**
	 * Abstraction Function:	The class represents an angle changing sector in a way that the angle animation base is
	 * 							given in the field startAngle and the angle between that base and the rest of the 
	 * 							visible sector is given by the field sectorAngle. The direction of the animation is
	 * 							given by the field goingUp. The size is given by the special field dimension.
	 */
	
	/**
	 * Rep. Invariant:	0 <= (startAngle, sectorAngle) < 360
	 */
	
	/**
	 * @requires 0 <= (startAngle, sectorAngle) < 360
	 * @effects Initializes this with location, color, dimension, angles.
	 */
	public AngleChangingSector(Point location, Color color, Dimension dimension, int startAngle, int sectorAngle) {
		super(location, color);
		try {
			this.dimension = (Dimension)dimension.clone();
		} catch(Exception e) {
			this.dimension = null;
		}
		this.startAngle = startAngle;
		this.sectorAngle = sectorAngle;
		this.goingUp = true;
	}

	@Override
	public void step(Rectangle bound) {
		if (this.sectorAngle == AngleChangingSector.MAX_ANGLE) {
			this.goingUp = false;
		} else if (this.sectorAngle == 0) {
			this.goingUp = true;
		}
		this.sectorAngle += (this.goingUp ? 1 : -1);
	}

	@Override
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
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
		g.setColor(this.getColor());
		g.fillArc((int)this.getLocation().getX(), (int)this.getLocation().getY(), 
				(int)this.dimension.getWidth(), (int)this.dimension.getHeight(), 
				this.startAngle, this.sectorAngle);
	}

}
