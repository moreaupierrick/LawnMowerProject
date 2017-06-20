package transformer;

import model.CommandModel;

/**
 * used to indicates a command transformer (common method transform)
 * @author PMoreau
 *
 */
public interface CommandLineTransformer
{
	public CommandModel transform(String line);
}
