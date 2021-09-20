package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {
	
	static public class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int N, cycleCnt;
	static int[] P;
	static Node[] adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			adjList = new Node[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				adjList[i] = new Node(Integer.parseInt(st.nextToken()), adjList[i]);
			}
			
			cycleCnt = 0;
			boolean[] visited = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				dfs(i, visited, i);
			}
			System.out.println(cycleCnt);
		}
	}
	
	private static void dfs(int vertex, boolean[] visited, int start) {
		visited[vertex] = true;
		
		for(Node temp = adjList[vertex]; temp != null; temp = temp.link) {
			if(temp.vertex == start) cycleCnt++;
			if(!visited[temp.vertex]) {
				dfs(temp.vertex, visited,start);
			}
		}
	}

}
