package com.Solutions.알고기초2.그래프600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_DFS와BFS {

	static int N, M, V;
	static boolean[][] adjMatrix;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println(sb.toString());
		sb.setLength(0);
		bfs(V);
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			
			for(int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				if(adjMatrix[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		sb.append(start+" ");
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			if(adjMatrix[start][i]) {
				dfs(i, visited);
			}
		}
		
	}
	
	

}
