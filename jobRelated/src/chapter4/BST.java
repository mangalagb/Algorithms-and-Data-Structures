package chapter4;

class BST
{
	class Node
	{
		Node left;
		Node right;
		int data;
		
		public Node(int value)
		{
			data = value;
		}
	}
	Node root;
	
	public BST()
	{
		root = null;
	}
	
	public void insert(int value)
	{
		if(root == null)
		{
			root = new Node(value);
			return;
		}
		insertNode(root,value);
	}
	
	public void insertNode(Node node, int value)
	{
		if(value > node.data)
		{
			if(node.right != null)
			{
				insertNode(node.right, value);
			}
			else
			{
				node.right = new Node(value);
			}
		}
		
		if(value < node.data)
		{
			if(node.left != null)
			{
				insertNode(node.left, value);
			}
			else
			{
				node.left = new Node(value);
			}
		}
	}
	
	public void inOrderHelper(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		inOrderHelper(node.left);
		System.out.print(node.data+"\t");
		inOrderHelper(node.right);
	}
	
	public void inOrder()
	{
		inOrderHelper(root);
		System.out.println("\n_____________________________________________________\n");
	}
	
	public void findMinMax()
	{
		if(root == null)
		{
			return;
		}
		
		Node current = root;
		
		while(current.left != null)
		{
			current = current.left;
		}
		System.out.println("Minimum value =    "+ current.data);
		
		current = root;
		
		while(current.right != null)
		{
			current = current.right;
		}
		System.out.println("Maximum value =    "+ current.data);
		
	}
	
	public void search(int value)
	{
		boolean val = searchHelper(root, value);
		
		if(val == true)
			System.out.println("Found value :  "+value);
		else
			System.out.println("Value not found");
	}
	
	public boolean searchHelper(Node node, int value)
	{
		if(value == node.data)
			return true;
		
		if(value > node.data)
		{
			if(node.right == null)
				return false;
			else
				return searchHelper(node.right, value);
		}
		
		if(value < node.data)
		{
			if(node.left == null)
				return false;
			else
				return searchHelper(node.left, value);
		}
		
		return false;
		
	}
	
	public static void main(String[] args)
	{
		BST tree = new BST();
		
		tree.insert(5);
		tree.insert(18);
		tree.insert(2);
		tree.insert(-4);
		tree.insert(3);
		tree.inOrder();
		
		tree.insert(4);
		tree.inOrder();
		
		tree.findMinMax();
		
		tree.search(8);
	}
}