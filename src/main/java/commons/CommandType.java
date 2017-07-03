package commons;

public enum CommandType
{
	LEFT_COMMAND('G'), 
	RIGHT_COMMAND('D'),
	MOVE_COMMAND('A');
	
	private final char value;
	
	CommandType(char value)
	{
		this.value = value;
	}

	public char getValue()
	{
		return value;
	}
}
