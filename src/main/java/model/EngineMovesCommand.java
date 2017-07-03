package model;

import java.util.List;

import commons.Command;
import commons.CommandType;

public class EngineMovesCommand implements Command
{
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
				lawnMowerModel.turnLeft();
			}
			else if (command.equals(CommandType.RIGHT_COMMAND))
			{
				lawnMowerModel.turnRight();
			}
			else if (command.equals(CommandType.MOVE_COMMAND))
			{
				lawnMowerModel.move();
			}
		}
		System.out.println(lawnMowerModel.toString());
	} 
}
