package commons;

/**
 * All mapped class is represented by a positioning (x,y). 
 * Used to simplify the integration of a new type of engine (example : an engine that move from 2 blocks instead of one)
 * @author PMoreau
 *
 */
public class Engine
{
	private int xPosition;
	private int yPosition;
	
	/**
	 * initialize the point outside of the space
	 */
	public Engine()
	{
		this.xPosition = -1;
		this.yPosition = -1;
	}
	
	/**
	 * get X Position method
	 */
	public int getXPosition()
	{
		return this.xPosition;
	}
	
	/**
	 *  get Y position method
	 */
	public int getYPosition()
	{
		return this.yPosition;
	}
	
	/**
	 * set of the Y position of the point
	 */
	public void setYPosition(int newPosition)
	{
		this.yPosition = newPosition;
	}
	
	/**
	 *  set of the X position of the point 
	 */
	public void setXPosition(int newPosition)
	{
		this.xPosition = newPosition;
	}
	
	/**
	 *  complex setter of the point with (xPosition and Yposition)
	 */
	public void setPositions(int xPosition, int yPosition)
	{
		this.setXPosition(xPosition);
		this.setYPosition(yPosition);
	}
}