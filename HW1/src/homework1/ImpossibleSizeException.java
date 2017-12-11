package homework1;

import java.awt.Dimension;

public class ImpossibleSizeException extends Exception {
	
	private Dimension dimension;
	
	public ImpossibleSizeException(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
}
