package launcher;

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
		MapManager map = new MapManager();
		if (args.length > 0)
		{
			// get the first parameter of the program call and use it at the fileName
			map.execute(args[0]);
		}
		else
		{
			map.execute("LawnMowerCase.txt");
		}
	}
}
