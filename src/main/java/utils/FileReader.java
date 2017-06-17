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
	public static FileReader instance;

	public static FileReader getInstance()
	{
		if (FileReader.instance == null)
		{
			FileReader.instance = new FileReader();
		}
		return FileReader.instance;
	}

	/**
	 * 
	 * @param filePath
	 * @throws Exception 
	 */
	public List<String> parseFile(String fileName) throws Exception
	{
		List<String> lines = new ArrayList<String>();

		File file = getFileFromRessources(fileName);
		try
		{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line != null && !line.isEmpty())
				{
					lines.add(line.trim());
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
	 * 
	 * @param fileName
	 * @return
	 */
	private File getFileFromRessources(String fileName)
	{
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}
	
	public static void main(String[] args)
	{
		FileReader reader = FileReader.getInstance();
		
		if (reader != null)
		{
			try
			{
				System.out.println(reader.parseFile("LawnMowerCase.txt"));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}