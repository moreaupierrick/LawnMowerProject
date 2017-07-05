package transformer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
	static final Logger logger = Logger.getLogger(FileTransformer.class);
	
	private MapInitializationCommandTransformer mapInitializationCommandTransformer;
	private EngineInitializationCommandTransformer engineInitializationCommandTransformer;
	private EngineMovesCommandTransformer engineMovesCommandTransformer;

	public FileTransformer()
	{
		init();
	}
	
	private void init()
	{
		logger.debug("Initialization of all sub-transformers");
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
		logger.debug("Start transforming the file " + fileName);
		List<Command> commands = new ArrayList<Command>();
		List<String> lines = FileReader.parseFile(fileName);
		
		int i = Constants.ZERO_CONSTANT;
		
		if (lines != null && !lines.isEmpty())
		{
			for (String line : lines)
			{
				logger.debug("Start transforming the line " + i);
				Command command;
				if (i == Constants.ZERO_CONSTANT)
				{
					logger.debug("line " + i + "is a map initialization command");
					command = mapInitializationCommandTransformer.transform(line);
				}
				else if (i % Constants.PAIR_DIVIDER == Constants.ZERO_CONSTANT)
				{
					logger.debug("line " + i + "is an egine moves command");
					command = engineMovesCommandTransformer.transform(line);
				}
				else
				{
					logger.debug("line " + i + "is an engine initialization command");
					command = engineInitializationCommandTransformer.transform(line);
				}
				
				if (command != null)
				{
					commands.add(command);
				}
				
				i++;
			}
			
			logger.debug("end file transformation");
		}
		else
		{
			System.out.println("Your file is empty !");
			logger.error("The file " + fileName + "exists but it's empty");
		}
		
		return commands;
	}
}