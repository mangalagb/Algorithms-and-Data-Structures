package chapter4;

import java.util.ArrayList;
import java.util.Stack;

class dfs
{	
	ArrayList<ArrayList<Integer>> adj;
	boolean[] visited;
	int rootNode;
	int numberOfNodes;
	
	public dfs(int n)
	{
		adj = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[n];
		rootNode = 0;
		numberOfNodes = n;
	}
	public void traverse_dfs()
	{
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(rootNode);
		visited[rootNode] = true;
		System.out.print(rootNode+"\t");
		
		while(!stack.isEmpty())
		{
			int n,child;
			
			n= stack.peek().intValue();
			
			child = getUnvisitedChild(n);
			
			if(child != -1)
			{
				visited[child] = true;
				System.out.print(child+"\t");
				stack.push(child);
			}
			else
			{
				stack.pop();
			}	
		}
		clearVisited();	
	}
	
	private void clearVisited() {
		
		for(int i=0; i<visited.length;i++)
		{
			visited[i] = false;
		}
		
	}

	private int getUnvisitedChild(int n) {
		
		for(int j : adj.get(n))
		{
			if(visited[j] != true)
				return j;
		}
		return -1;
		
	}
	
	public void initializeAdjacencyMatrix()
	{	
		for(int i=0;i<numberOfNodes;i++)
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
	
	public static void main(String[] args)
	{
		dfs d = new dfs(6);
		
		d.initializeAdjacencyMatrix();
		d.traverse_dfs();
	}
}