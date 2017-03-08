package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS{
	ArrayList<ArrayList<Integer>> adjList;
	boolean[] visited;
	int numberOfNodes;
	int root;
	
	public BFS(int n){
		numberOfNodes = n;
		adjList = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[numberOfNodes];
		root = 0;
	}
	
	public void createAdjList(){
		for(int i=0;i<numberOfNodes;i++){
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(0).add(1);

		adjList.get(1).add(0);
		adjList.get(1).add(2);

		adjList.get(2).add(1);
		adjList.get(2).add(4);
		adjList.get(2).add(5);

		adjList.get(4).add(2);

		adjList.get(5).add(2);

		adjList.get(3).add(0);
	}
	
	public void clearVisited(){
		for(int i=0;i<visited.length; i++){
			visited[i] = false;
		}
	}
	
	public void BFSIterative(){
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//visit root first
		visited[root] = true;
		queue.add(root);
		System.out.print(root + "\t");
		
		while(!queue.isEmpty()){
			int node = queue.remove();
			ArrayList<Integer> connectedEdjes = adjList.get(node);
			for(int edge : connectedEdjes){
				if(visited[edge] != true){
					visited[edge] = true;
					queue.add(edge);
					System.out.print(edge + "\t");
				}
			}			
		}
	}
	
	public void BFSRecursive(){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		doBFS(queue);
	}
	
	private void doBFS(Queue<Integer> queue){		
		if(queue.isEmpty()){
			return;
		}
		
		int node = queue.remove();
		visited[node] = true;
		System.out.print(node + "\t");
		
		ArrayList<Integer> connectedEdjes = adjList.get(node);
		for(int edge : connectedEdjes){
			if(visited[edge] != true){
				queue.add(edge);
			}
		}
		doBFS(queue);
	}
	
	public static void main(String[] args){
		BFS bfs = new BFS(6);
		bfs.createAdjList();
		bfs.BFSIterative();
		
		bfs.clearVisited();		
		System.out.println("\n_______________________________________________\n");
		bfs.BFSRecursive();
	}
}