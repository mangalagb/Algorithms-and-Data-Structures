// Binary tree with pre order traversal
//print all leaf nodes

package chapter4;

public class BinaryTree
{
	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int i)
		{
			this.data = i;
		}
	}
	
	public TreeNode createBinaryTree()
	{
		TreeNode root = new TreeNode(40);
		
		TreeNode node1 = new TreeNode(20);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(30);
		
		TreeNode node4 = new TreeNode(60);
		TreeNode node5 = new TreeNode(50);
		TreeNode node6 = new TreeNode(70);
		
		root.left = node1;
		root.right = node4;
		
		node1.left = node2;
		node1.right = node3;
		
		node4.left = node5;
		node4.right = node6;
		
		return root;
	}
	
	public void preOrder(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.data+"\t");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void prettyPrinting()
	{
		System.out.println("\n___________________________________________\n");
	}
	public void printLeafNodes(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		
		if(node.left == null && node.right == null)
			System.out.print(node.data+"\t");
		
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}
	
	/**
	 * Change a tree so that the roles of the left and right pointers are swapped at every node.
	 * So, Inorder 12345 becomes 54321 in Inorder
	 * @param node
	 */
	public void mirror(TreeNode node) {
		TreeNode newLeft = null;
		TreeNode newRight= null;
		if(node.left != null) {
			newRight = node.left;
			mirror(node.left);
		}
		if(node.right != null) {
			newLeft = node.right;
			mirror(node.right);
		}
		
		node.left = newLeft;
		node.right = newRight;
	}
	
	public static void main(String[] args)
	{
		BinaryTree bin = new BinaryTree();
		TreeNode root = bin.createBinaryTree();
		
		bin.preOrder(root);
		bin.prettyPrinting();
		
		bin.printLeafNodes(root);
		bin.prettyPrinting();
		
	}
	
}