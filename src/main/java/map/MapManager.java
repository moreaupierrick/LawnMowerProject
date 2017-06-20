package map;

import java.util.List;

import commons.Constants;
import model.CommandModel;
import model.LawnMowerModel;
import transformer.FileTransformer;
import utils.StringUtils;

/**
 * call used to represent the map created. When you call a command, the command is executed on the map and the map will retrieve the engine specified.
 * @author PMoreau
 *
 */
public class MapManager
{
	private int width;
	private int height;
	private LawnMowerModel currentLawnMower;

	public MapManager()
	{
		this.width = -1;
		this.height = -1;
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
	public void execute(String fileName)
	{
		FileTransformer fileTransformer = new FileTransformer();
		System.out.println("start file ------------------");

		try
		{
			// call of the transformer to get all the commandModels from the file passed
			List<CommandModel> commands = fileTransformer.transformFile(fileName);

			if (commands != null && !commands.isEmpty())
			{
				// for each commandModel, there is three case different (one per type of command)
				for (CommandModel command : commands)
				{
					if (!StringUtils.isBlank(command.getCommands()))
					{
						// moving commands
						//System.out.println("before move : " + this.getLawnMower().toString());
						//System.out.println("before move commands: " + command.getCommands());
						for (char commandType : command.getCommands().toUpperCase().toCharArray())
						{
							if (commandType == Constants.COMMAND_GO)
							{
								this.getLawnMower().move();
							}
							else if (commandType == Constants.COMMAND_LEFT)
							{
								this.getLawnMower().turnLeft();
							}
							else if (commandType == Constants.COMMAND_RIGHT)
							{
								this.getLawnMower().turnRight();
							}
						}
						System.out.println("After move : " + this.getLawnMower().toString());

					}
					else if (command.getOrientation() == Constants.NO_ORIENTATION)
					{
						// init map command
						this.setWdith(command.getXPosition());
						this.setHeight(command.getYPosition());
					}
					else
					{
						// lawn mower init command 
						this.setLawnMower(new LawnMowerModel(this.getWidth(), this.getHeight(), command.getXPosition(), command.getYPosition(), command.getOrientation()));
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}

		System.out.println("end file ------------------");
	}

	/**
	 * get the map height
	 * @return
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * get the map width
	 * @return
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * set the map height
	 * @param height
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

	/**
	 * set the map width
	 * @param width
	 */
	public void setWdith(int width)
	{
		this.width = width;
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