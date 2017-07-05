package launcher;

import java.util.List;

import org.apache.log4j.Logger;

import commons.Command;
import transformer.FileTransformer;
import map.MapManager;

/**
 * launcher of the application
 * if you call the program, you can pass in parameters the name of the file (that has to be in the project resources)
 * @author PMoreau
 *
 */
public class Main
{
	static final Logger logger = Logger.getLogger(Main.class);
	/**
	 * call method
	 * @param args
	 */
	public static void main (String[] args)
	{
		logger.debug("Begin ---------------------------");
		try
		{
			List<Command> commands = new FileTransformer().transformFile(args.length > 0 ? args[0] : "LawnMowerCase.txt");
			//System.out.println(commands);
			if (commands != null && !commands.isEmpty())
			{
				new MapManager().execute(commands);
			}
		}
		catch (Exception e)
		{
			logger.fatal(e.getCause() + " - " + e.getMessage());
		}
		logger.debug("End -----------------------------");
	}
}
