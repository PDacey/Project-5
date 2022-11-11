import java.util.ArrayList;
/**
 *     This is a MorseCodeTree which is specifically used for the conversion of morse code to english

    It relies on a root (reference to root of the tree)

    The root is set to null when the tree is empty.

    The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode)

    The constructor will call the buildTree


 * @author Paul Dacey
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root = null;
	private String temp;
	
	/**
	 * Constructor uses buildTree method to create the tree
	 */
	MorseCodeTree()
	{
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method: 
	 * 1. if there is only one character 
	 * a. if the character is '.' (dot) store to the left of the current root 
	 * b. if the character is "-" (dash) store to the right of the current root 
	 * c. return 
	 * 2. if there is more than one character 
	 * a. if the first character is "." (dot) new root becomes the left child 
	 * b. if the first character is "-" (dash) new root becomes the right child 
	 * c. new code becomes all the remaining characters in the code (beyond the first character) 
	 * d. call addNode(new root, new code, letter)
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				if(root != null)
				{
					root.left = new TreeNode<String>(letter);
				}
				
			}
			if(code.equals("-"))
			{
				if(root != null)
				{
					root.right = new TreeNode<String>(letter);
				}
				
			}
			
		}
		if(code.length() > 1)
		{
			if(code.charAt(0) == '.')
			{
				if(root != null)
				{
					addNode(root.left, code.substring(1), letter);
				}
				
			}
			if(code.charAt(0) == '-')
			{
				if(root != null)
				{
					addNode(root.right, code.substring(1), letter);
				}
				
			}
		}
		
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) 
	 * level one: insert(".", "e"); insert("-", "t"); 
	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. 
	 * Look at the tree and the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree() 
	{
		root = new TreeNode<String>("");
		
		insert(".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		

	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException 
	{
		
		return null;
	}
	
	
	@Override
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 */
	public String fetch(String code) 
	{
		return fetchNode(root, code);
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left. 
	 * A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) 
	{
		
		if(root != null)
		{
			if(code.length() == 1)
			{
				if(code.charAt(0) == '.')
				{
					temp = root.left.getData();
				}
				if(code.charAt(0) == '-')
				{
					temp = root.right.getData();
				}
			}
			if(code.length() > 1)
			{
				if(code.charAt(0) == '.')
				{
					fetchNode(root.left, code.substring(1));
				}
	                
	            else
	            {
	            	fetchNode(root.right, code.substring(1));
	            }
	                
			}

		}

		return temp;
		
	}
	
	@Override
	public TreeNode<String> getRoot() 
	{
		return root;
	}

	@Override
	public void insert(String code, String result)
	{
		addNode(root, code, result);
	}
	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		if(root != null)
		{
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
		
	}

	/**
	 * Sets the root of the tree to the given TreeNode
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		this.root = newNode;
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		
		return list;
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException 
	{
		
		return null;
	}

	

	

	
}
