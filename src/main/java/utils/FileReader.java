package utils;

import java.io.File;
import java.io.IOException;
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
	public static FileReader instance; // one unique instance (singleton)

	public static FileReader getInstance() 
	{
		if (FileReader.instance == null)
		{
			FileReader.instance = new FileReader();
		}
		return FileReader.instance;
	}

	/**
	 * used to parse the file line after line
	 * @param filePath
	 * @throws Exception 
	 */
	public List<String> parseFile(String fileName) throws Exception
	{
		List<String> lines = new ArrayList<String>();

		File file = getFileFromRessources(fileName);
		try
		{
			Scanner scanner = new Scanner(file); // Scanner used because more simple to developed
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line != null && !line.isEmpty())
				{
					lines.add(line.trim()); // used to delete all the spaces at the beginning and the end of the line
				}
			}

			scanner.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return lines;
	}

	/**
	 * used to get a file from resources folder
	 * @param fileName
	 * @return
	 */
	private File getFileFromRessources(String fileName)
	{
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
}