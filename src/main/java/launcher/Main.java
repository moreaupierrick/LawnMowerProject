package launcher;

import java.util.List;

import commons.Command;

import transformer.FileTransformer;
import map.MapManager;

/**
 * launcher of the application
 * if you call the program, you can pass in params the name of the file (that has to be in the project resources)
 * @author PMoreau
 *
 */
public class Main
{
	/**
	 * call method
	 * @param args
	 */
	public static void main (String[] args)
	{
		try
		{
			List<Command> commands = new FileTransformer().transformFile(args.length > 0 ? args[0] : "LawnMowerCase.txt");
			System.out.println(commands);
			if (commands != null && !commands.isEmpty())
			{
				new MapManager().execute(commands);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
