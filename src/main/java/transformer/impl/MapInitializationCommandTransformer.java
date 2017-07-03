package transformer.impl;

import commons.Command;

import model.MapInitializationCommand;

/**
 * Specific transformer used to parse the first line of the command file (map initialization)
 * @author PMoreau
 *
 */
public class MapInitializationCommandTransformer
{

	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public MapInitializationCommandTransformer()
	{

	}


	/**
	 * transform method that get the two command parameters and create a model of command with its
	 */
	public Command transform(String line)
	{
		String[] commandParameter = line.split(" +"); // the + symbol is used to avoid multiples spaces
		
		return  new MapInitializationCommand(Integer.parseInt(commandParameter[0]), Integer.parseInt(commandParameter[1]));
	}
	
}