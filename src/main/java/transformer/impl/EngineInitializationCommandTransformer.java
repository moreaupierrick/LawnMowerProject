package transformer.impl;

import org.apache.log4j.Logger;

import utils.StringUtils;
import commons.Command;
import commons.Orientation;
import model.EngineInitializationCommand;

/**
 * Specific transformer used to parse the odd lines of the command file (engine initialization)
 * @author PMoreau
 *
 */
public class EngineInitializationCommandTransformer
{
	static final Logger logger = Logger.getLogger(EngineInitializationCommandTransformer.class);
	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public EngineInitializationCommandTransformer()
	{

	}

	/**
	 * transform method that get the two command parameters and create a model of command with its
	 */
	public Command transform(String line)
	{
		String[] commandParameter = line.split(" +"); // the + symbol is used to avoid multiples spaces
		EngineInitializationCommand command = null;
		Orientation orientation = null;

		if (!StringUtils.isBlank(commandParameter[2]))
		{
			orientation = char2Orientation(commandParameter[2].trim().charAt(0));
			command = new EngineInitializationCommand(Integer.parseInt(commandParameter[0]), Integer.parseInt(commandParameter[1]), orientation);
		}
		else 
		{
			logger.fatal("The line doesn't contain three parameters");
		}

		return command;
	}
	
	private Orientation char2Orientation(char orientationChar)
	{
		Orientation orientation = null;
		
		if (orientationChar == Orientation.EAST_ORIENTATION.getValue())
		{
			orientation =  Orientation.EAST_ORIENTATION;
		}
		else if (orientationChar == Orientation.WEST_ORIENTATION.getValue())
		{
			orientation = Orientation.WEST_ORIENTATION;
		}
		else if (orientationChar == Orientation.NORTH_ORIENTATION.getValue())
		{
			orientation = Orientation.NORTH_ORIENTATION;
		}
		else if (orientationChar == Orientation.SOUTH_ORIENTATION.getValue())
		{
			orientation = Orientation.SOUTH_ORIENTATION;
		}
		else 
		{
			logger.fatal("Unknown orientation : " + orientationChar);
		}
		
		return orientation;
	}

}
