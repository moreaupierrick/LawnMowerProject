package model;

import commons.Constants;
import commons.Movable;
import commons.PointXY;
import commons.Turnable;

/**
 * Data model that represents the Lawn mower engine inside the map
 * @author PMoreau
 *
 */
public class LawnMowerModel extends PointXY implements Movable,Turnable
{
	private char orientation;
	private int mapWidth;
	private int mapHeight;
	
	/**
	 * simple constructor (useless but kept for prepare new features)
	 */
	public LawnMowerModel()
	{
		super();
	}
	
	/**
	 * first constructor that only need the map sizes
	 * @param width
	 * @param height
	 */
	public LawnMowerModel (int width, int height)
	{
		this();
		this.mapHeight = height;
		this.mapWidth = width;
	}
	
	/**
	 * complete constructor with map sizes, positioning and orientation
	 * @param width
	 * @param height
	 * @param xPosition
	 * @param yPosition
	 * @param orientation
	 */
	public LawnMowerModel(int width, int height, int xPosition, int yPosition, char orientation)
	{
		this(width, height);
		if (xPosition >= 0 && xPosition <= width - 1)
		{
			super.setXPosition(xPosition);
		}
		else
		{
			super.setXPosition(0);
		}
		
		if (yPosition >= 0 && yPosition <= height - 1)
		{
			super.setYPosition(yPosition);
		}
		else
		{
			super.setYPosition(0);
		}
		
		this.setOrientation(orientation);
	}
	
	
	/**
	 * used to get the orientation of the engine (can be N, S, W, and E)
	 */
	public char getOrientation()
	{
		return this.orientation;
	}
	
	/**
	 * used to change the orientation of the engine (can be N, S, W, and E)
	 */
	public void setOrientation(char orientation)
	{
		this.orientation = orientation;
	}

	/**
	 * used to get the map height
	 * @return
	 */
	public int getMapWidth()
	{
		return mapWidth;
	}

	/**
	 * setter of the map width
	 * @param mapWidth
	 */
	public void setMapWidth(int mapWidth)
	{
		this.mapWidth = mapWidth;
	}

	/**
	 * used to keep the map width
	 * @return
	 */
	public int getMapHeight()
	{
		return mapHeight;
	}


	/**
	 * used to set the map height
	 * @param mapHeight
	 */
	public void setMapHeight(int mapHeight)
	{
		this.mapHeight = mapHeight;
	}

	/**
	 * That method uses the positioning of the engine on the map and its orientation to compute its new positioning
	 */
	@Override
	public void move()
	{
		switch (this.getOrientation())
		{
			case Constants.NORTH_ORIENTATION: {
				// used to check if the engine can go ahead depends of its positioning and its orientation
				if (this.getYPosition() < this.mapHeight)
				{
					this.setYPosition(this.getYPosition() + 1);
					break;
				}
			}
			case Constants.SOUTH_ORIENTATION: {
				// used to check if the engine can go ahead depends of its positioning and its orientation
				if (this.getYPosition() > 0)
				{
					this.setYPosition(this.getYPosition() - 1);
					break;
				}
			}
			case Constants.EAST_ORIENTATION: {
				// used to check if the engine can go ahead depends of its positioning and its orientation
				if (this.getXPosition() < this.mapWidth)
				{
					this.setXPosition(this.getXPosition() + 1);
					break;
				}
			}
			case Constants.WEST_ORIENTATION: {
				// used to check if the engine can go ahead depends of its positioning and its orientation
				if (this.getXPosition() > 0)
				{
					this.setXPosition(this.getXPosition() - 1);
					break;
				}
			}
			default: break;
		}
	}

	/**
	 * call when the engine need to make a righ-turn
	 */
	@Override
	public void turnRight()
	{
		//System.out.println("Orientation before right : " + this.getOrientation());
		switch (this.orientation)
		{
			case Constants.NORTH_ORIENTATION: this.setOrientation(Constants.EAST_ORIENTATION); break;
			case Constants.SOUTH_ORIENTATION: this.setOrientation(Constants.WEST_ORIENTATION); break;
			case Constants.EAST_ORIENTATION:  this.setOrientation(Constants.SOUTH_ORIENTATION); break;
			case Constants.WEST_ORIENTATION:  this.setOrientation(Constants.NORTH_ORIENTATION); break;
			default: break;
		}
		//System.out.println("Orientation after right : " + this.getOrientation());
	}

	/**
	 * call when the engine need to make a left-turn
	 */
	@Override
	public void turnLeft()
	{
		//System.out.println("Orientation before left : " + this.orientation);
		switch (this.orientation)
		{
			case Constants.NORTH_ORIENTATION: this.orientation = Constants.WEST_ORIENTATION;break;
			case Constants.SOUTH_ORIENTATION: this.orientation = Constants.EAST_ORIENTATION;break;
			case Constants.EAST_ORIENTATION:  this.orientation = Constants.NORTH_ORIENTATION;break;
			case Constants.WEST_ORIENTATION:  this.orientation = Constants.SOUTH_ORIENTATION;break;
			default: break;
		}
		//System.out.println("Orientation after left : " + this.orientation);
	}
	
	/**
	 * used to display the result of all the transformation
	 */
	@Override
	public String toString()
	{
		return this.getXPosition() + " " + this.getYPosition() + " " + this.getOrientation();
	}
}
