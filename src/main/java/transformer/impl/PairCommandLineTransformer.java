package transformer.impl;

import transformer.CommandLineTransformer;
import model.CommandModel;

/**
 * Specific transformer used to parse the pair lines of the command file (list of engine move commands)
 * @author PMoreau
 *
 */
public class PairCommandLineTransformer implements CommandLineTransformer
{
	
	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public PairCommandLineTransformer()
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
			command.setCommands(line.replace(" ", "").toUpperCase()); // the replace is used to delete multiple space between command identifiers
		}
		
		return command;
	}
}