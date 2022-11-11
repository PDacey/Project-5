 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit test class for the MoreCodeConverter class
 * @author Paul Dacey
 *
 */
public class MorseCodeConverterTestPublic {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		
		//"This is a test to convert a morse code string to text using the morsecodeconverter class"
		String studentText = MorseCodeConverter.convertToEnglish("- .... .. ... / .. ... / .- / - . ... - / - --- / -.-. --- -. ...- . .-. - / .- / -- --- .-. ... . / -.-. --- -.. . / ... - .-. .. -. --. / - --- / - . -..- - / ..- ... .. -. --. / - .... . / -- --- .-. ... . -.-. --- -.. . -.-. --- -. ...- . .-. - . .-. / -.-. .-.. .- ... ...");
		assertEquals("this is a test to convert a morse code string to text using the morsecodeconverter class", studentText);
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);
		
		
	
		
		
	}
	/**
	 * tests the convertMorseFileToEnglishString(File file) method
	 */
	@Test
	public void testConvertMorseFileToEnglishString() 
	{	
		//Student test case
		File myFile = new File("src/testfile.txt");
		try
		{
			assertEquals("this is the student test to convert morse code to english using a file", MorseCodeConverter.convertToEnglish(myFile));
		}
		catch(FileNotFoundException f)
		{
			assertTrue("An unwanted exception was caught", false);
		}
		
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		
		File file = new File("src/howDoILoveThee.txt"); 
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
			
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
