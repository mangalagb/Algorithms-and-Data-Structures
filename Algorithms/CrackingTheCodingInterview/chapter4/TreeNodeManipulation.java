// Insert a node
//print all leaf nodes

package chapter4;

public class TreeNodeManipulation
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
	
	TreeNode root;
	
	public TreeNodeManipulation()
	{
		root = null;
	}
	
	public void createBinaryTree()
	{
		 root = new TreeNode(40);
		
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
		
		
	}
	
	public TreeNode findNode(TreeNode node, int key)
	{
		if(node == null)
			return null;
		
		TreeNode result = new TreeNode(-1);
		
		if(node.data == key)
		{
			return node;
		}
	
		if(node.left !=null)
		result = findNode(node.left, key);
		
		if(node.right !=null)
		result = findNode(node.right, key);
		
		return result;
		
	}
	
	public void insertNode(int key, int value)
	{
		TreeNode node7 = new TreeNode(value);
		
		TreeNode o = findNode(this.root, key);
		
		if(o.left == null)
			o.left = node7;
		
		else if(o.right == null)
			o.right = node7;
		
		else
			System.out.print("The node has 2 children");
		
		
		
	}
	
	public void deleteNode( TreeNode root, int key)
	{
		if (root != null) {
			
			if(root.left != null && root.left.data == key)
			{
				root.left = null;
				return;
			}
			
			if(root.right != null && root.right.data == key)
			{
				root.right = null;
				return;
			}
			
			deleteNode(root.left,key);
			deleteNode(root.right,key);
			
			
		}
		
	}
	
	public void inOrder(TreeNode node)
	{
		if (node != null) {

			inOrder(node.left);
			System.out.print(node.data + "\t");
			inOrder(node.right);
		}
	}
	
	
	public void prettyPrinting()
	{
		System.out.println("\n___________________________________________\n");
	}
	
	public static void main(String[] args)
	{
		TreeNodeManipulation bin = new TreeNodeManipulation();
		bin.createBinaryTree();
		
		bin.inOrder(bin.root);
		bin.prettyPrinting();
		
		bin.insertNode(70, 100);
		bin.inOrder(bin.root);
		bin.prettyPrinting();
		
		 bin.deleteNode(bin.root,40);
		bin.inOrder(bin.root);
		bin.prettyPrinting();
		
	}
	
}