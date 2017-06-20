package transformer.impl;

import transformer.CommandLineTransformer;
import model.CommandModel;

/**
 * Specific transformer used to parse the first line of the command file (map initialization)
 * @author PMoreau
 *
 */
public class FirstCommandLineTransformer implements CommandLineTransformer
{

	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public FirstCommandLineTransformer()
	{

	}


	/**
	 * transform method that get the two command parameters and create a model of command with its
	 */
	@Override
	public CommandModel transform(String line)
	{
		CommandModel command = new CommandModel();
		
		if (line != null)
		{
			String[] commandParameter = line.split(" +"); // the + symbol is used to avoid multiples spaces
			
			if (commandParameter.length == 2)
			{
				command.setPositions(Integer.parseInt(commandParameter[0]), Integer.parseInt(commandParameter[1]));
			}
		}
		
		return command;
	}
	
}