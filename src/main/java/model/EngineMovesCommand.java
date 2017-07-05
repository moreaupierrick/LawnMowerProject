package model;

import java.util.List;

import org.apache.log4j.Logger;

import commons.Command;
import commons.CommandType;

public class EngineMovesCommand implements Command
{
	static final Logger logger = Logger.getLogger(EngineMovesCommand.class);
			
	private List<CommandType> commands;

	public EngineMovesCommand(List<CommandType> commands)
	{
		this.commands = commands;
	}

	public List<CommandType> getCommands()
	{
		return commands;
	}

	public void setCommands(List<CommandType> commands)
	{
		this.commands = commands;
	}

	@Override
	public void execute(LawnMowerModel lawnMowerModel)
	{
		for (CommandType command : this.commands)
		{
			if (command.equals(CommandType.LEFT_COMMAND))
			{
				logger.debug("turn left");
				lawnMowerModel.turnLeft();
			}
			else if (command.equals(CommandType.RIGHT_COMMAND))
			{
				logger.debug("turn right");
				lawnMowerModel.turnRight();
			}
			else if (command.equals(CommandType.MOVE_COMMAND))
			{
				logger.debug("move !!");
				lawnMowerModel.move();
			}
		}
		System.out.println(lawnMowerModel.toString());
	} 
}
