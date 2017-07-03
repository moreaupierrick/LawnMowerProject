package commons;

import model.LawnMowerModel;

public interface Command
{
	public void execute(LawnMowerModel lawnMowerModel);
}
