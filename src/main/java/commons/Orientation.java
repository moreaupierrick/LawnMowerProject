package commons;

public enum Orientation
{
	NORTH_ORIENTATION('N'), 
	SOUTH_ORIENTATION('S'),
	EAST_ORIENTATION('E'), 
	WEST_ORIENTATION('W');
	
	private final char value;
	
	Orientation(char value)
	{
		this.value = value;
	}

	public char getValue()
	{
		return value;
	}
}
