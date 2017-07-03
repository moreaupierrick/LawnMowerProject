package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * That class is used to parse a text file line by line
 * @author PMoreau
 *
 */
public class FileReader
{
	/**
	 * used to parse the file line after line
	 * @param filePath
	 * @throws Exception 
	 */
	public static List<String> parseFile(String fileName) throws Exception
	{
		List<String> lines = new ArrayList<String>();

		File file = getFileFromRessources(fileName);
		Scanner scanner = new Scanner(file);
		try	
		{
			// Scanner used because more simple to developed
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line != null && !line.isEmpty())
				{
					lines.add(line.trim()); // used to delete all the spaces at the beginning and the end of the line
				}
			}
		}
		finally
		{
			scanner.close();
		}

		return lines;
	}

	/**
	 * used to get a file from resources folder
	 * @param fileName
	 * @return
	 */
	private static File getFileFromRessources(String fileName)
	{
		//Get file from resources folder
		ClassLoader classLoader = FileReader.class.getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
}