package map;

import java.util.List;

import commons.Command;
import model.LawnMowerModel;

/**
 * call used to represent the map created. When you call a command, the command is executed on the map and the map will retrieve the engine specified.
 * @author PMoreau
 *
 */
public class MapManager
{
	private LawnMowerModel currentLawnMower;
	
	public MapManager()
	{
		this.currentLawnMower = new LawnMowerModel();
	}

	/** 
	 * first call of the application
	 * it first call the FileTransformer to generate CommandModel using the file in parameters
	 * Then, depends of the content of the commands, it executes different types of command : 
	 * - initialization of the map (first line of the file)
	 * - initialization of an engine (pair lines of the file)
	 * - execution of few move commands (odd lines of the file)
	 * @param fileName
	 */
	public void execute(List<Command> commands)
	{
		if (commands != null && !commands.isEmpty())
		{
			// for each commandModel, there is three case different (one per type of command)
			for (Command command : commands)
			{
				command.execute(this.currentLawnMower);
			}
		}
	}

	/**
	 * used to retrieve the current engine
	 * @return
	 */
	public LawnMowerModel getLawnMower()
	{
		return currentLawnMower;
	}

	/**
	 * used to change the current engine
	 * @param lawnMower
	 */
	public void setLawnMower(LawnMowerModel lawnMower)
	{
		this.currentLawnMower = lawnMower;
	}
}