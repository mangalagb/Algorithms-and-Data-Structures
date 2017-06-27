package Easy;

/*
 * X := seed
For each i in (0, 1, ..., N-1)
	p[i] := i
	X := (X * 295397169) % 1073741789;
	If (X * 1000000) / 1073741789 < limit
		X := (X * 295397169) % 1073741789
		// generate j within [0, i]
		j := (X * (i + 1)) / 1073741789
		// j <= i, so p[j] is already initialized
		swap(p[i], p[j])
	End
End
 */



public class BSTConstruction {

	private int[] generatePermutation(int N, long seed, long limit){
		long[] P = new long[N];
		long X = seed;
		
		for(int i=0; i<N; i++){
			
			P[i] = i;
			X = (X * 295397169) % 1073741789;
			if((X * 1000000) / 1073741789 < limit){
				X = (X * 295397169) % 1073741789;
				
				// generate j within [0, i]
				int j = (int)((X * (i + 1)) / 1073741789);
				
				// j <= i, so p[j] is already initialized
				//swap(p[i], p[j]);
				if(j <= i){
					long temp = P[i];
					P[i] = P[j];
					P[j] = temp;
				}
			}
		}		
		
		int[] permutation = new int[N];
		for(int i=0;i<N;i++){
			permutation[i] = (int)P[i];
		}		
		return permutation;
	}
	

	
	class BST{
		class Node{
			int data;
			Node left;
			Node right;
			
			public Node(int i){
				data = i;
				left = null;
				right = null;
			}
		}
		
		Node root;
		public BST(){
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
			if(data < node.data){
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

		
		public long findHeights(){
			int sum = 1;			
			int result = findHeightsHelper(root, sum, 0);
			return result;
		}
		
		private int findHeightsHelper(Node node, int sum, int rollingSum){
			rollingSum += sum;
			int leftSum = 0;
			int rightSum = 0;
			
			if(node.left != null){
				leftSum = findHeightsHelper(node.left, ++leftSum, rollingSum);
			}
			
			if(node.right != null){
				rightSum = findHeightsHelper(node.right, ++rightSum, rollingSum);
			}			
			return leftSum + rightSum + rollingSum;
		}
	}
	
	public long createTree(int[] permutation){
		BST bst = new BST();
		
		for(int i=0;i<permutation.length;i++){
			bst.insert(permutation[i]);
		}		
		return bst.findHeights();
	}
	
	public long sumHeights(int N, int seed, int limit){
		int[] permutation = generatePermutation(N, (long)seed, (long)limit);
		return createTree(permutation);
	}
	
	public static void main(String[] args){
		BSTConstruction bstConstruction = new BSTConstruction();
		int N = 1;
		int seed = 99988877;
		int limit =	12345;
		
		
		System.out.println(bstConstruction.sumHeights(N, seed, limit));
	}
}