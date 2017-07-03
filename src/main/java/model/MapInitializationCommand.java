package model;

import commons.Command;
import commons.Engine;

public class MapInitializationCommand extends Engine implements Command
{
	public MapInitializationCommand(int x, int y)
	{
		this.setPositions(x, y);
	}

	@Override
	public void execute(LawnMowerModel lawnMowerModel)
	{
		if (this.getXPosition() < 0 || this.getYPosition() < 0)
		{
			// TODO EXCEPTION
		}
		else
		{
			lawnMowerModel.setMapWidth(this.getYPosition());
			lawnMowerModel.setMapHeight(this.getXPosition());
		}
	}
}
