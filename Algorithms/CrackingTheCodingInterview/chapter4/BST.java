package chapter4;

//For questions in this exercise, go to http://cslibrary.stanford.edu/110/BinaryTrees.html

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
	int count;
	
	public BST()
	{
		root = null;
		count = 0;
	}
	
	public void insert(int value)
	{
		if(root == null)
		{
			root = new Node(value);
			count += 1;
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
				count += 1;
			}
		}
		
		if(value <= node.data)
		{
			if(node.left != null)
			{
				insertNode(node.left, value);
			}
			else
			{
				node.left = new Node(value);
				count += 1;
			}
		}
	}
	
	public void getNumberOfNodes() {
		System.out.print("\nNumber of nodes in tree : " + count + "\n");
	}
	
	public void maxDepth() {
		int count = 0;
		if(root == null) {
			System.out.print("Max depth  = "+ count);
		}else {
			int maxdepth = findMaxDepthRecursively(root, count);
			System.out.print("\n Max depth : "+ maxdepth + "\n");
		}
	}
	
	private int findMaxDepthRecursively(Node node, int count) {
		if(node.left == null && node.right == null) {
			return count;
		}
		int leftDepth = count;
		int rightDepth = count;
		if(node.left != null) {
			leftDepth = findMaxDepthRecursively(node.left, ++leftDepth);
		}
		if(node.right != null) {
			rightDepth = findMaxDepthRecursively(node.right, ++rightDepth);
		}
		
		if(leftDepth >= rightDepth) {
			return leftDepth;
		}else {
			return rightDepth;
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
	
	/**
	 * Find any two nodes in a BST that sum up to a target value  
	 * @param target
	 */
	public void findSumNodes(int target) {
		if(root == null) {
			System.out.print("Error empty tree");
		}else {
			findSumNodesRecursively(root, target);
		}
	}
	
	private void findSumNodesRecursively(Node node, int target) {
		if(node != null && node.left != null) {
			if(node.data  + node.left.data == target) {
				System.out.print("\n Nodes : "+ node.data + " , "+ node.left.data);				
			}
			findSumNodesRecursively(node.left, target);
		}
		if (node != null && node.right != null) {
			if(node.data + node.right.data == target) {
				System.out.print("\n Nodes : "+ node.data + " , "+ node.right.data);
			}
			findSumNodesRecursively(node.right, target);
		}
	}
	
	/**
	 * Given a binary tree and a sum, return true if the tree has a root-to-leaf path such that adding up 
	 * all the values along the path equals the given sum. Return false if no such path can be found. 
	 */
	public boolean hasPathSum(int target) {
		if(root == null) {
			System.out.print("Error. Empty tree");
			return false;
		}else {
			System.out.print("\nTarget : " + target + "\n");
			boolean result = hasPathSumHelper(root, target, "", 0);
			if(!result) {
				System.out.print("\nError. Path not found\n");
			}
			return result;
		}
	}
	
	public boolean hasPathSumHelper(Node node, int target, String path, int sum) {
		path = path + "\t" + Integer.toString(node.data);
		sum += node.data;
		if(node.left == null && node.right == null && sum == target) {
			System.out.print("\nPath : "+ path);
			return true;
		}	
		
		if(node.left != null) {
			hasPathSumHelper(node.left, target, path, sum);
		}
		
		if(node.right != null) {
			hasPathSumHelper(node.right, target, path, sum);
		}
		return false;
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
	
	/**
	 * For each node in a binary search tree, create a new duplicate node, and insert the duplicate as the left child of the original node. 
	 * The resulting tree should still be a binary search tree.
	 * So Inorder - 123 should become 112233. And 456 should be 445566
	 * @param node
	 */
	public void doubleTree() {
		if(root == null) {
			System.out.print("Error.Empty tree");
		}else {
			doubleTreeHelper(root);
		}
	}
	
	private void doubleTreeHelper(Node node) {		
		if(node.left != null){
			Node newLeft = new Node(node.data);
			Node temp = node.left;
			node.left = newLeft;
			newLeft.left = temp;
			doubleTreeHelper(temp);
		}
		
		if(node.right != null) {
			doubleTreeHelper(node.right);
		}
		
		if(node.left == null && node.right == null) {
			node.left = new Node(node.data); 
			return;
		}
	}
	
	public void search(int value)
	{
		boolean val = searchHelper(root, value);
		
		if(val == true)
			System.out.println("Found value :  "+value);
		else
			System.out.println("Value not found : " + value);
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
	
	/**Given a binary search tree and a value k, find a node in the binary search tree whose value is closest to k. 
	 * 
	 */
	public void findClosest(int target) {
		if(root == null) {
			System.out.print("\nError empty tree\n");
		}else{
			System.out.println(findClosestHelper(root, null, target, -1).data);
		}
	}
	
	public Node findClosestHelper(Node node, Node parent, int target, int parentDifference) {
		if(node.data == target) {
			System.out.print("\nFound node\n");
			return node;
		}
		
		int currentDifference = Math.abs(node.data - target);
			
		if(target > node.data && node.right != null) {
			return findClosestHelper(node.right, node, target, currentDifference);
		}else if(target < node.data && node.left != null) {
			return findClosestHelper(node.left, node, target, currentDifference);
		}
		
		if(parentDifference <= currentDifference && parentDifference != -1) {
			return parent;
		}
		
		return node;
	}
	
	public static void main(String[] args)
	{
		BST tree = new BST();
		
		tree.insert(5);
		tree.insert(2);
		tree.insert(18);
		tree.insert(4);
//		tree.insert(3);
		tree.inOrder();
		
		tree.findClosest(15);
		
//		tree.getNumberOfNodes();
//		
//		tree.findMinMax();
//		
//		tree.search(8);
//		
//		tree.findSumNodes(5);
//		
//		tree.maxDepth();
	}
}