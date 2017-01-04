package chapter4;

import java.util.ArrayList;

public class DFS_Recursive{
	int numberOfNodes;
	
	public DFS_Recursive(int number){
		numberOfNodes = number;
	}
	
	public int getNumberOfNodes(){
		return numberOfNodes;
	}
	
	public void dfs(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited){
		if(adjacencyList.isEmpty()){
			System.out.println("Empty list");
			return;
		}else{
			int root = 0;
			dfs_Helper(adjacencyList, visited, root);
			System.out.print("\n_________________________________________________________\n");
		}
	}
	
	private void dfs_Helper(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int node){
		if(!visited[node]){
			System.out.print(node + "\t");
			visited[node] = true;
			
			ArrayList<Integer> nodeChildren = adjacencyList.get(node);
			for(Integer child : nodeChildren){
				dfs_Helper(adjacencyList, visited, child);
			}
		}
	}
	
	public static void main(String[] args){
		DFS_Recursive dfs = new DFS_Recursive(7);
				
		//Create data structures
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[dfs.getNumberOfNodes()];
		
		//Initialize adjacency list
		for(int i=0; i<dfs.getNumberOfNodes(); i++){
			adjacencyList.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		
		//Assign edges
		//vertex 0
		adjacencyList.get(0).add(1);
		adjacencyList.get(0).add(2);
		adjacencyList.get(0).add(3);
         
        //vertex 1
		adjacencyList.get(1).add(5);
		adjacencyList.get(1).add(6);
         
        //vertex 2
		adjacencyList.get(2).add(4);
     
        //vertex 3
		adjacencyList.get(3).add(2);
		adjacencyList.get(3).add(4);
 
        //vertex 4
		adjacencyList.get(4).add(1);
 
        //vertex 5
		adjacencyList.get(6).add(4);
		
		//The output of the program is: 0 1 5 6 4 2 3
		dfs.dfs(adjacencyList, visited);
	}
}