package model;

import commons.Command;
import commons.Constants;
import commons.Orientation;
import commons.Engine;


public class EngineInitializationCommand extends Engine implements Command
{
	private Orientation orientation;
	
	public  EngineInitializationCommand(int x, int y, Orientation orientation)
	{
		super();
		this.setPositions(x, y);
		this.setOrientation(orientation);
	}

	public Orientation getOrientation()
	{
		return orientation;
	}

	public void setOrientation(Orientation orientation)
	{
		this.orientation = orientation;
	}

	@Override
	public void execute(LawnMowerModel lawnMowerModel)
	{		
		if (this.getXPosition() > Constants.ZERO_CONSTANT && this.getXPosition() < lawnMowerModel.getMapWidth())
		{
			if (this.getYPosition() > Constants.ZERO_CONSTANT && this.getYPosition() < lawnMowerModel.getMapHeight())
			{
				if (this.orientation != null)
				{
					lawnMowerModel.setPositions(this.getXPosition(), this.getYPosition());
					lawnMowerModel.setOrientation(this.orientation);
				}
			}
			else
			{
				// TODO EXCEPTION
			}
		}
		else
		{
			// TODO EXCEPTION
		}
	}
}
