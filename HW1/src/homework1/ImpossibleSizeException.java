package homework1;

import java.awt.Dimension;

/**
 * An ImpossibleSizeException is an exception that is thrown in response to a wrong size being set to a shape of some
 * sort. It enables the possibility of a suggested size instead of the bad value that caused the exception.
 */
public class ImpossibleSizeException extends RuntimeException {
	
	private Dimension dimension;
	
	/**
	 * Abstraction Function:	The field dimension contains the suggested size to replace the bad value that raised
	 * 							the exception.
	 */
	
	/**
	 * Rep. Invariant:	none.
	 */
	
	public ImpossibleSizeException(Dimension dimension) {
		this.dimension = dimension;
	}
	
	/**
	 * @return the dimension of this
	 */
	public Dimension getDimension() {
		return this.dimension;
	}
}
