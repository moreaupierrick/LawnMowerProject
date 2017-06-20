package utils;

/**
 * all string method that do not exists yet
 * @author PMoreau
 *
 */
public class StringUtils
{
	/**
	 * test that the string is not null and not empty
	 * @param tmp
	 * @return
	 */
	public static boolean isBlank(String tmp)
	{
		return tmp == null || tmp.isEmpty() || tmp.equals("");
	}
}