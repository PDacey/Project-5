/**
 * The external Tree Node for Linked Trees
 * @author Paul Dacey
 *
 * @param <T> - data type of TreeNoded
 */

public class TreeNode<T>
{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	TreeNode(T dataNode)
	{
		left = null;
		right = null;
		this.data = dataNode;
	}
	
	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	TreeNode(TreeNode<T> node)
	{
		this.left = node.left;
		this.right = node.right;
		this.data = node.data;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return data within the TreeNode
	 */
	public T getData()
	{
		return data;
	}
	
	
	
}
