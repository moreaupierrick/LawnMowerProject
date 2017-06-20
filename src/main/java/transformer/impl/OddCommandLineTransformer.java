package transformer.impl;

import transformer.CommandLineTransformer;
import model.CommandModel;

/**
 * Specific transformer used to parse the odd lines of the command file (engine initialization)
 * @author PMoreau
 *
 */
public class OddCommandLineTransformer implements CommandLineTransformer
{
	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public OddCommandLineTransformer()
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
			String[] commandParameter = line.split(" +"); // the + symbole is used to avoid multiples spaces
			
			if (commandParameter.length == 3)
			{
				command.setPositions(Integer.parseInt(commandParameter[0]), Integer.parseInt(commandParameter[1]));
				command.setOrientation(commandParameter[2].charAt(0));
			}
		}
		
		return command;
	}

}
