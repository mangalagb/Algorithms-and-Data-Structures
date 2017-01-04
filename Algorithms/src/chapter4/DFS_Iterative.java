package chapter4;

import java.util.ArrayList;
import java.util.Stack;

class DFS_Iterative {
	ArrayList<ArrayList<Integer>> adjacencyMatrix;
	boolean[] visited;
	int rootNode;
	int numberOfNodes;

	public DFS_Iterative(int numberOfNodes) {
		adjacencyMatrix = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[numberOfNodes];
		rootNode = 0;
		this.numberOfNodes = numberOfNodes;
	}

	public void traverseDfs() {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(rootNode);
		visited[rootNode] = true;
		System.out.print(rootNode + "\t");

		while (!stack.isEmpty()) {
			int topNode, child;
			topNode = stack.peek().intValue();
			child = getUnvisitedChild(topNode);

			if (child != -1) {
				visited[child] = true;
				System.out.print(child + "\t");
				stack.push(child);
			} else {
				stack.pop();
			}
		}
		clearVisited();
	}

	private void clearVisited() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

	}

	private int getUnvisitedChild(int n) {
		for (int j : adjacencyMatrix.get(n)) {
			if (visited[j] != true)
				return j;
		}
		return -1;
	}

	public void initializeAdjacencyMatrix() {
		for (int i = 0; i < numberOfNodes; i++) {
			adjacencyMatrix.add(new ArrayList<Integer>());
		}

		adjacencyMatrix.get(0).add(1);
		adjacencyMatrix.get(0).add(3);

		adjacencyMatrix.get(1).add(0);
		adjacencyMatrix.get(1).add(2);

		adjacencyMatrix.get(2).add(1);
		adjacencyMatrix.get(2).add(4);
		adjacencyMatrix.get(2).add(5);

		adjacencyMatrix.get(4).add(2);

		adjacencyMatrix.get(5).add(2);

		adjacencyMatrix.get(3).add(0);

	}

	public static void main(String[] args) {
		DFS_Iterative dfs = new DFS_Iterative(6);

		dfs.initializeAdjacencyMatrix();
		dfs.traverseDfs();
	}
}