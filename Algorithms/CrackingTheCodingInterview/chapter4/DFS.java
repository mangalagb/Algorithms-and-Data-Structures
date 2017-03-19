package chapter4;
import java.util.ArrayList;
import java.util.Stack;

public class DFS{
	
	private ArrayList<ArrayList<Integer>>adjacencyMatrix;
	private int rootnode;
	boolean[] visited;
	int numberOfNodes;
	
	public DFS(int n){
		rootnode = 0;
		numberOfNodes = n;
		visited = new boolean[n];
		adjacencyMatrix = new ArrayList<ArrayList<Integer>>();
	}
	
	public void initializeNodes(){
		for(int i=0;i<numberOfNodes;i++){
			adjacencyMatrix.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<numberOfNodes;i++){
			visited[i] = false;
		}
		
		adjacencyMatrix.get(0).add(1);
		//adjacencyMatrix.get(0).add(3);

		adjacencyMatrix.get(1).add(0);
		adjacencyMatrix.get(1).add(2);

		adjacencyMatrix.get(2).add(1);
		adjacencyMatrix.get(2).add(4);
		adjacencyMatrix.get(2).add(5);

		adjacencyMatrix.get(4).add(2);

		adjacencyMatrix.get(5).add(2);

		adjacencyMatrix.get(3).add(0);			
	}
	
	public void clearVisited(){
		for(int i=0;i<numberOfNodes;i++){
			visited[i] = false;
		}
	}
	
	public void DFSIterative(){
		if(adjacencyMatrix.isEmpty()){
			System.out.println("Empty list");
			return;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(rootnode);
		visited[rootnode] = true;
		System.out.print(rootnode + "\t");
		
		while(!stack.isEmpty()){
			int node = (int)stack.peek();
			int child = findUnvisitedChild(node);
			
			if(child != -1){
				stack.push(child);
				visited[child] = true;
				System.out.print(child + "\t");				
			}else{
				stack.pop();
			}
		}
	}
	
	private int findUnvisitedChild(int node){
		ArrayList<Integer> children = adjacencyMatrix.get(node);
		for(Integer child : children){
			if(!visited[child]){
				return child;
			}
		}
		return -1;
	}
	
	public void DFSRecursive(){
		if(adjacencyMatrix.isEmpty()){
			System.out.println("Empty list");
			return;
		}else{
			DFSRecursiveHelper(rootnode);
		}
	}
	
	private void DFSRecursiveHelper(int node){
		if(!visited[node]){
			visited[node] = true;
			System.out.print(node + "\t");
			
			ArrayList<Integer> children = adjacencyMatrix.get(node);
			for(Integer child : children){
				if(visited[child] != true){
					DFSRecursiveHelper(child);
				}
			}
		}
	}
	
	public static void main(String[] args){
		DFS dfs = new DFS(6);
		dfs.initializeNodes();
		dfs.DFSIterative();
		
		dfs.clearVisited();
		System.out.println("\n_____________________________________________________\n");
		
		dfs.DFSRecursive();
	}
}