import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter class used to convert morse code to English
 * @author Paul Dacey
 *
 */
public class MorseCodeConverter 
{
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile File containing the morse code
	 * @return String of file in English
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String str = "";
		String result = "";
		Scanner scan = new Scanner(codeFile);
		
		while(scan.hasNext())
		{
			str += scan.nextLine();
		}
		scan.close();
		result = convertToEnglish(str);

		return result;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	Example:
	code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	string returned = "Hello World"
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code)
	{
		MorseCodeTree morse = new MorseCodeTree();
		String result = "";
		String[] temp;
		String[] str;
		str = code.split(" / ");
		
		
		for(int i = 0; i < str.length; i++)
		{
			temp = str[i].split(" ");
			
			for(int k = 0; k < temp.length; k++)
			{
				result += morse.fetch(temp[k]);
			}
			if(i < str.length - 1)
			{
				result += " ";
			}
			
		}

		return result;
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. 
	 * Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	"h s v i f u e l r a p w j b d x n c k y t z g q m o"
	Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between 
	the right most child of the left tree (j) and the left most child of the right tree (b). 
	This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree()
	{
		MorseCodeTree temp = new MorseCodeTree();
		ArrayList<String> list = temp.toArrayList();
		String str = "";
		
		for(int i = 0; i < list.size(); i++)
		{
			if(i == list.size() - 1)
			{
				str += list.get(i);
				break;
			}
			str += list.get(i) + " ";
		}
		return str;
	}
	
}
