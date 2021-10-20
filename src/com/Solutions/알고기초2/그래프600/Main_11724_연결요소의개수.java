package com.Solutions.알고기초2.그래프600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11724_연결요소의개수 {

	static int N, M, ans;
	static boolean[][] adjMatrix;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjMatrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjMatrix[u][v] = true;
			adjMatrix[v][u] = true;
		}
			
		ans = 0;
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			bfs(i);
			ans++;
		}
		
		System.out.println(ans);
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				if(adjMatrix[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
}