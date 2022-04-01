package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int N, M, V;
//	static Node[] input;
	static boolean[][] adjMatrix;
//	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		
		sb = new StringBuilder();
		boolean[] visited = new boolean[N+1];
		dfs(V, visited);
		System.out.println(sb.toString());
		sb.setLength(0);
		bfs();
		System.out.println(sb.toString());
		
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
//		sb.append(V+" ");
		q.offer(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur+" ");
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adjMatrix[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	private static void dfs(int cur, boolean[] visited) {
		visited[cur] = true;
		sb.append(cur+ " ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adjMatrix[cur][i])
				dfs(i,visited);
		}
	}
}
