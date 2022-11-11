import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;



/**
 * Student test for the MorseCodeTree class
 * @author Paul Dacey
 *
 */

public class MorseCodeTreeTest 
{
	/**
	 * MorseCodeTree object to test methods
	 */
	MorseCodeTree test1;
	/**
	 * String to hold morse code
	 */
	String code;
	/**
	 * ArrayList to hold ArrayList object retrieved from toArrayList() method
	 */
	ArrayList<String> list = new ArrayList<String>();
	
	/**
	 * Sets up variables
	 */
	@Before
	public void setUp()
	{
		code = "....";//"h"
		test1 = new MorseCodeTree();
	}
	
	/**
	 * Resets variables
	 */
	@After
	public void tearDown()
	{
		//test1 = null;
		code = "";
	}
	
	/**
	 * Tests fetch() which uses the fetchNode(TreeNode, String code) method
	 */
	@Test
	public void testFetch()
	{
		assertEquals("h", test1.fetch(code));
		assertEquals("p", test1.fetch(".--."));
		assertEquals("b", test1.fetch("-..."));
		assertEquals("m", test1.fetch("--"));
	}
	
	/**
	 * Tests the toArrayList() method which also uses the LNRoutputTraversal method
	 */
	@Test
	public void testToArrayList()
	{
		list = test1.toArrayList();
		assertEquals("h", list.get(0));
		assertEquals("s", list.get(1));
		assertEquals("v", list.get(2));
		assertEquals("o", list.get(list.size() - 1));
		assertEquals("p", list.get(10));
	}
	
	/**
	 * Tests the insert(String, String) method which uses the addNode(TreeNode, String, String) method
	 */
	@Test
	public void testInsert()
	{
		test1.insert("...--", "3");
		list = test1.toArrayList();
		System.out.println(list.toString());
		assertEquals("3", list.get(3));
		
		test1.insert("-.--.", "(");
		list = test1.toArrayList();
		assertEquals("(", list.get(21));
		
	}
	
	
	
	
	
}
