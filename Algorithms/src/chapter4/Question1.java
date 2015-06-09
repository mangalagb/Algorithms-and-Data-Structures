/*
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced 
 * tree is defined to be a tree such that no two leaf 
 * nodes differ in distance from the root by more than one.
 */

// Binary tree with pre order traversal
//print all leaf nodes

package chapter4;

import java.util.ArrayList;

public class Question1
{
	int maxdepth;
	boolean balanced;
	ArrayList<Integer> leafDepth; 
	
	public Question1()
	{
		maxdepth =0;
		balanced = true;
		leafDepth = new ArrayList<Integer>();
	}
	
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
		
		TreeNode node7 = new TreeNode(80);
		TreeNode node8 = new TreeNode(90);
		
		root.left = node1;
		root.right = node4;
		
		node1.left = node2;
		node1.right = node3;
		
		node4.left = node5;
		node4.right = node6;
		
		node6.right = node7;
		node7.right = node8;
		
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
	
	public void printBalanced()
	{
		System.out.println("\n\nBalanced? = "+balanced);
		System.out.println("Max Depth = "+maxdepth);
	}
	public void prettyPrinting()
	{
		System.out.println("\n___________________________________________\n");
		
	}
	
	public void anotherbalance(TreeNode root, int depth)
	{
		if(root!= null)
		{
		if(root.left == null && root.right == null)
		{
			
			leafDepth.add(depth);
		}
		else
		{
		
			depth++;
			
			if(depth > maxdepth)
				maxdepth = depth;
			
			anotherbalance(root.left, depth);
			anotherbalance(root.right, depth);
		}
		}
		
	}
	public void isBalanced(TreeNode root)
	{
		anotherbalance(root, 0);
		
		for(int i : leafDepth)
		{
			for(int j = leafDepth.get(1); j<leafDepth.size()-1; j++)
			{
				int k = i-j;
				if(Math.abs(k) <=1)
					balanced = true;
				else
					balanced = false;
			}
		}
		
		printBalanced();
		prettyPrinting();
		
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
	public static void main(String[] args)
	{
		Question1 bin = new Question1();
		TreeNode root = bin.createBinaryTree();
		
		bin.preOrder(root);
		bin.prettyPrinting();
		
		bin.isBalanced(root);
		
		
	}
	
}