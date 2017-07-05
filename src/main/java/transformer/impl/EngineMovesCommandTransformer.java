package transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import utils.StringUtils;
import commons.Command;
import commons.CommandType;
import model.EngineMovesCommand;

/**
 * Specific transformer used to parse the pair lines of the command file (list of engine move commands)
 * @author PMoreau
 *
 */
public class EngineMovesCommandTransformer
{
	static final Logger logger = Logger.getLogger(EngineMovesCommandTransformer.class);
	/**
	 * Simple constructor (useless actually but can be used after)
	 */
	public EngineMovesCommandTransformer()
	{

	}
	
	/**
	 * transform method that get the two command parameters and create a model of command with its
	 */
	public Command transform(String line) 
	{
		line = line.replace(" ", "");
		List<CommandType> commandTypes = new ArrayList<CommandType>();
		Command command = null;
		
		if (!StringUtils.isBlank(line))
		{
			for (char commandChar : line.toCharArray())
			{
				CommandType tmp = char2CommandType(commandChar);
				if (tmp != null)
				{
					commandTypes.add(tmp);
				}
			}
		}
		
		if (commandTypes != null && !commandTypes.isEmpty())
		{
			command = new EngineMovesCommand(commandTypes); 
		}
		
		return command;
	}
	
	private CommandType char2CommandType(char commandChar)
	{
		CommandType commandType = null;
		
		if (commandChar == CommandType.LEFT_COMMAND.getValue())
		{
			commandType =  CommandType.LEFT_COMMAND;
		}
		else if (commandChar == CommandType.RIGHT_COMMAND.getValue())
		{
			commandType = CommandType.RIGHT_COMMAND;
		}
		else if (commandChar == CommandType.MOVE_COMMAND.getValue())
		{
			commandType = CommandType.MOVE_COMMAND;
		}
		else 
		{
			logger.fatal("Unknown move type : " + commandChar);
		}
		
		return commandType;
	}
}