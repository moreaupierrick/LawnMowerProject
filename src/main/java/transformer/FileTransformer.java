package transformer;

import java.util.ArrayList;
import java.util.List;

import commons.Command;
import commons.Constants;
import transformer.impl.EngineInitializationCommandTransformer;
import transformer.impl.MapInitializationCommandTransformer;
import transformer.impl.EngineMovesCommandTransformer;
import utils.FileReader;

/**
 * used to manage all the file transformation in one java class
 * @author PMoreau
 *
 */
public class FileTransformer
{
	private MapInitializationCommandTransformer mapInitializationCommandTransformer;
	private EngineInitializationCommandTransformer engineInitializationCommandTransformer;
	private EngineMovesCommandTransformer engineMovesCommandTransformer;

	public FileTransformer()
	{
		init();
	}
	
	private void init()
	{
		this.mapInitializationCommandTransformer = new MapInitializationCommandTransformer();
		this.engineInitializationCommandTransformer = new EngineInitializationCommandTransformer();
		this.engineMovesCommandTransformer = new EngineMovesCommandTransformer();
	}

	public MapInitializationCommandTransformer getMapInitializationCommandTransformer()
	{
		return this.mapInitializationCommandTransformer;
	}

	public EngineInitializationCommandTransformer getEngineInitializationCommandTransformer()
	{
		return this.engineInitializationCommandTransformer;
	}

	public EngineMovesCommandTransformer getEngineMovesCommandTransformer()
	{
		return this.engineMovesCommandTransformer;
	}
	
	/**
	 * method that get the file from resources, parse it, and create a list of commands
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<Command> transformFile(String fileName) throws Exception
	{
		List<Command> commands = new ArrayList<Command>();
		List<String> lines = FileReader.parseFile(fileName);
		
		int i = Constants.ZERO_CONSTANT;
		
		if (lines != null && !lines.isEmpty())
		{
			for (String line : lines)
			{
				Command command;
				if (i == Constants.ZERO_CONSTANT)
				{
					command = mapInitializationCommandTransformer.transform(line);
				}
				else if (i % Constants.PAIR_DIVIDER == Constants.ZERO_CONSTANT)
				{
					command = engineMovesCommandTransformer.transform(line);
				}
				else
				{
					command = engineInitializationCommandTransformer.transform(line);
				}
				
				if (command != null)
				{
					commands.add(command);
				}
				
				i++;
			}
		}
		else
		{
			System.out.println("Your file is empty !");
		}
		
		return commands;
	}
}