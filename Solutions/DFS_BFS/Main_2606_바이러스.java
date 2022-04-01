package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */
public class Main_2606_바이러스 {

	static int N, M, cnt;
	static boolean[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		StringTokenizer st = null;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = true;
			map[to][from] = true;
		}
		
		visited = new boolean[N+1];
		cnt = 0;
		dfs(1, visited);
		
		System.out.println(cnt);
	}
	
	private static void dfs(int cur, boolean[] visited) {
		visited[cur] = true;
		
		for(int i = 1; i <= N; i++) {
			if(map[cur][i] && !visited[i]) {
				dfs(i, visited);
				cnt++;
			}
		}
		
	}

}
