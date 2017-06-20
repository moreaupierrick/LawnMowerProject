package utils;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileParserTest
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}

	private FileReader reader;

	@Before
	public void setUp() throws Exception
	{
		this.reader = FileReader.getInstance();
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void test()
	{
		this.reader = FileReader.getInstance();
		
		if (reader != null)
		{
			try
			{
				  testFileValues(reader.parseFile("LawnMowerCase.txt"));
				  testComplexFileValues(reader.parseFile("LawnMowerComplexCase.txt"));
			}
			catch (Exception e)
			{
				e.printStackTrace();
				Assert.fail("exception during files parsing");
			}
		}
	}
	
	private void testFileValues(List<String> lines)
	{
		Assert.assertEquals("5 5", lines.get(0));
	    Assert.assertEquals("1 2 N", lines.get(1));
	    Assert.assertEquals("GAGAGAGAA", lines.get(2));
	    Assert.assertEquals("3 3 E", lines.get(3));
	    Assert.assertEquals("AADAADADDA", lines.get(4));
	}
	
	private void testComplexFileValues(List<String> lines)
	{
		Assert.assertEquals("5 5", lines.get(0));
	    Assert.assertEquals("1 2 N", lines.get(1));
	    Assert.assertEquals("GAA    GAGA     GA    GAG  A", lines.get(2));
	}
}
