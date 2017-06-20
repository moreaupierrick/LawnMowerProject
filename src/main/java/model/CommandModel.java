package model;

import commons.Constants;
import commons.PointXY;

/**
 * Data model of command (used for map initialization, engine moves and engine initializations)
 * @author PMoreau
 *
 */
public class CommandModel extends PointXY
{
	private char orientation;
	private String commands;
	
	/**
	 * simple command constructor. If there is no orientation (initialization of the map), we set it to NO_ORIENTATION
	 */
	public CommandModel()
	{
		super();
		this.orientation = Constants.NO_ORIENTATION;
		this.setPositions(-1, -1);
	}
	
	
	/**
	 * get the orientation of the command
	 */
	public char getOrientation()
	{
		return this.orientation;
	}
	
	/**
	 * set the orientation of the command
	 */
	public void setOrientation(char orientation)
	{
		this.orientation = orientation;
	}

	/**
	 * get all the commands (used to get the engine move command lines) with pattern 'DGA+'
	 * @return
	 */
	public String getCommands()
	{
		return commands;
	}

	/**
	 * set all the engine move command lines
	 * @param commands
	 */
	public void setCommands(String commands)
	{
		this.commands = commands;
	}
}