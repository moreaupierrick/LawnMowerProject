package transformer;

import java.util.ArrayList;
import java.util.List;

import commons.Constants;

import model.CommandModel;
import transformer.impl.FirstCommandLineTransformer;
import transformer.impl.OddCommandLineTransformer;
import transformer.impl.PairCommandLineTransformer;
import utils.FileReader;

/**
 * used to manage all the file transformation in one java class
 * @author PMoreau
 *
 */
public class FileTransformer
{
	private FirstCommandLineTransformer firstCommanndLineTransformer;
	private OddCommandLineTransformer oddCommandLineTransformer;
	private PairCommandLineTransformer pairCommandLineTransformer;

	public FileTransformer()
	{
		init();
	}
	
	private void init()
	{
		this.firstCommanndLineTransformer = new FirstCommandLineTransformer();
		this.oddCommandLineTransformer = new OddCommandLineTransformer();
		this.pairCommandLineTransformer = new PairCommandLineTransformer();
	}

	public FirstCommandLineTransformer getFirstCommanndLineTransformer()
	{
		return firstCommanndLineTransformer;
	}

	public OddCommandLineTransformer getOddCommandLineTransformer()
	{
		return oddCommandLineTransformer;
	}

	public PairCommandLineTransformer getPairCommandLineTransformer()
	{
		return pairCommandLineTransformer;
	}
	
	/**
	 * method that get the file from resources, parse it, and create a list of commands
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<CommandModel> transformFile(String fileName) throws Exception
	{
		List<CommandModel> commands = new ArrayList<CommandModel>();
		List<String> lines = FileReader.getInstance().parseFile(fileName);
		
		int i = Constants.ZERO_CONSTANT;
		
		if (lines != null && !lines.isEmpty())
		{
			for (String line : lines)
			{
				CommandModel command;
				if (i == Constants.ZERO_CONSTANT)
				{
					command = firstCommanndLineTransformer.transform(line);
				}
				else if (i % Constants.PAIR_DIVIDER == Constants.ZERO_CONSTANT)
				{
					command = pairCommandLineTransformer.transform(line);
				}
				else
				{
					command = oddCommandLineTransformer.transform(line);
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