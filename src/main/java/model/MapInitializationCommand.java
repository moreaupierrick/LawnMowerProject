package model;

import org.apache.log4j.Logger;

import commons.Command;
import commons.Engine;

public class MapInitializationCommand extends Engine implements Command
{
	static final Logger logger = Logger.getLogger(MapInitializationCommand.class);
			
	public MapInitializationCommand(int x, int y)
	{
		this.setPositions(x, y);
	}

	@Override
	public void execute(LawnMowerModel lawnMowerModel)
	{
		if (this.getXPosition() < 0 || this.getYPosition() < 0)
		{
			logger.fatal("Map sizes cannot be under 0");
		}
		else
		{
			lawnMowerModel.setMapWidth(this.getYPosition());
			lawnMowerModel.setMapHeight(this.getXPosition());
		}
	}
}
