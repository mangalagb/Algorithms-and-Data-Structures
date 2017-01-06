package chapter4;

/*
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced 
 * tree is defined to be a tree such that no two leaf 
 * nodes differ in distance from the root by more than one.
 * 
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
	1) Left subtree of T is balanced
	2) Right subtree of T is balanced
	3) The difference between heights of left subtree and right subtree is not more than 1.
 */

public class Question1{
	public class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int i){
			data = i;
			left = null;
			right = null;
		}
	}
	
	Node root;
	public Question1(){
		root = null;
	}
	
	public void insert(int data){
		if(root == null){
			root = new Node(data);
		}else{
			insertHelper(root, data);
		}
	}
	
	private void insertHelper(Node node, int data){
		if(data <= node.data){
			if(node.left == null){
				node.left = new Node(data);
			}else{
				insertHelper(node.left, data);
			}
		}
		
		if(data > node.data){
			if(node.right == null){
				node.right = new Node(data);
			}else{
				insertHelper(node.right, data);
			}
		}
	}
	
	public void displayInOrder(){
		if(root == null){
			System.out.println("Empty");
			return;
		}else{
			displayInOrderHelper(root);
			System.out.print("\n_______________________________________________________________\n");
		}
	}
	
	private void displayInOrderHelper(Node node){
		if(node.left != null){
			displayInOrderHelper(node.left);
		}
		System.out.print(node.data + "\t");
		if(node.right != null){
			displayInOrderHelper(node.right);
		}
	}
	
	public boolean isBalanced(){
		if(root == null){
			System.out.println("Empty");
			return false;
			
		}else{
			return isBalancedHelper(root);
		}
	}
	
	public boolean isBalancedHelper(Node node){
		if(node == null){
			return true;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		Double result = (double) Math.abs(leftHeight - rightHeight);
		if(result <= 1 && isBalancedHelper(node.left) && isBalancedHelper(node.right)){
			return true;
		}
		return false;
	}
	
	public int height(Node node){
		if(node == null){
			return 0;
		}		
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public static void main(String[] args){
		Question1 tree1 = new Question1();
		tree1.insert(10);
		tree1.insert(9);
		tree1.insert(8);
		tree1.insert(15);
		tree1.insert(14);
		tree1.insert(13);
		tree1.insert(19);
		tree1.displayInOrder();		
		System.out.println(tree1.isBalanced() + "\n");
		
		Question1 tree2 = new Question1();
		tree2.insert(10);
		tree2.insert(9);
		tree2.insert(8);
		tree2.insert(15);
		tree2.insert(14);
		tree2.insert(13);
		tree2.displayInOrder();		
		System.out.println(tree2.isBalanced());
	}
}