package model;

import org.apache.log4j.Logger;

import commons.Orientation;
import commons.Engine;

/**
 * Data model that represents the Lawn mower engine inside the map
 * @author PMoreau
 *
 */
public class LawnMowerModel extends Engine
{
	static final Logger logger = Logger.getLogger(LawnMowerModel.class);
			
	private Orientation orientation;
	private int mapWidth;
	private int mapHeight;

	/**
	 * first constructor
	 * @param width
	 * @param height
	 */
	public LawnMowerModel ()
	{
		super();
	}


	/**
	 * used to get the orientation of the engine (can be N, S, W, and E)
	 */
	public Orientation getOrientation()
	{
		return this.orientation;
	}

	/**
	 * used to change the orientation of the engine (can be N, S, W, and E)
	 */
	public void setOrientation(Orientation orientation)
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
	public void move()
	{
		if (this.orientation != null)
		{
			if (this.orientation.equals(Orientation.NORTH_ORIENTATION))
			{
				if (this.getYPosition() < this.mapHeight)
				{
					logger.debug("Move from ["+this.getXPosition()+","+this.getYPosition()+"]" + "Initial Position : ["+this.getXPosition()+","+(this.getYPosition()+1)+"]");
					this.setYPosition(this.getYPosition() + 1);
				}
			}
			else if (this.orientation.equals(Orientation.SOUTH_ORIENTATION))
			{
				if (this.getYPosition() > 0)
				{
					logger.debug("Move from ["+this.getXPosition()+","+this.getYPosition()+"]" + "Initial Position : ["+this.getXPosition()+","+(this.getYPosition()-1)+"]");
					this.setYPosition(this.getYPosition() - 1);
				}
			}
			else if (this.orientation.equals(Orientation.EAST_ORIENTATION))
			{
				if (this.getXPosition() < this.mapWidth)
				{
					logger.debug("Move from ["+this.getXPosition()+","+this.getYPosition()+"]" + "Initial Position : ["+(this.getXPosition()+1)+","+this.getYPosition()+"]");
					this.setXPosition(this.getXPosition() + 1);
				}
			}
			else if (this.orientation.equals(Orientation.WEST_ORIENTATION))
			{
				if (this.getXPosition() > 0)
				{
					logger.debug("Move from ["+this.getXPosition()+","+this.getYPosition()+"]" + "Initial Position : ["+(this.getXPosition()-1)+","+this.getYPosition()+"]");
					this.setXPosition(this.getXPosition() - 1);
				}
			}
		}
	}

	/**
	 * call when the engine need to make a right-turn
	 */
	public void turnRight()
	{
		if (this.orientation != null)
		{
			logger.debug("Turn right from " + this.orientation);
			if (this.orientation.equals(Orientation.NORTH_ORIENTATION))
			{
				this.orientation = Orientation.EAST_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.SOUTH_ORIENTATION))
			{
				this.orientation = Orientation.WEST_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.EAST_ORIENTATION))
			{
				this.orientation = Orientation.SOUTH_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.WEST_ORIENTATION))
			{
				this.orientation = Orientation.NORTH_ORIENTATION;
			}
		}
	}

	/**
	 * call when the engine need to make a left-turn
	 */
	public void turnLeft()
	{
		if (this.orientation != null)
		{
			logger.debug("Turn left from " + this.orientation);
			if (this.orientation.equals(Orientation.NORTH_ORIENTATION))
			{
				this.orientation = Orientation.WEST_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.SOUTH_ORIENTATION))
			{
				this.orientation = Orientation.EAST_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.EAST_ORIENTATION))
			{
				this.orientation = Orientation.NORTH_ORIENTATION;
			}
			else if (this.orientation.equals(Orientation.WEST_ORIENTATION))
			{
				this.orientation = Orientation.SOUTH_ORIENTATION;
			}
		}
	}

	/**
	 * used to display the result of all the transformation
	 */
	@Override
	public String toString()
	{
		return this.getXPosition() + " " + this.getYPosition() + " " + this.getOrientation().getValue();
	}
}
