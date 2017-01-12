package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class bfs
{
	ArrayList<ArrayList<Integer>> adj;
	int noOfNodes;
	boolean[] visited;
	int rootNode;
	
	public bfs(int i)
	{
		adj = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[i];
		noOfNodes = i;
		rootNode =0;
	}
	
	public void initializeAdjacencyList()
	{
		for(int i=0;i<noOfNodes;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(0).add(3);
		
		adj.get(1).add(0);
		adj.get(1).add(2);
		
		adj.get(2).add(1);
		adj.get(2).add(4);
		adj.get(2).add(5);
		
		adj.get(4).add(2);
		
		adj.get(5).add(2);
		
		adj.get(3).add(0);
	}

	public void clearVisited()
	{
		for(int i=0;i<visited.length-1;i++)
		{
			visited[i] = false;
		}
	}
	
	public void traverse_bfs()
	{
		Queue<Integer> myQueue = new LinkedList<Integer>();
		
		myQueue.add(rootNode);
		System.out.print(rootNode+"\t");
		visited[rootNode] = true;
		
		while(!myQueue.isEmpty()) 
		{
			int n = myQueue.remove();
			
			for(int j : adj.get(n))
			{
				if(!visited[j])
				{
					System.out.print(j+"\t");
					visited[j] = true;
					myQueue.add(j);
				}
			}
		}
		System.out.print("\n");
		clearVisited();
	}
	
	public static void main(String[] args)
	{
		bfs b = new bfs(6);
		b.initializeAdjacencyList();
		b.traverse_bfs();
	}
}