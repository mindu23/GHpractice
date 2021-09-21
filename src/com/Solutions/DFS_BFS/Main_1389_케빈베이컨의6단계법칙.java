package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {

	static int N, M, kevinCnt, result, resultIdx;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		result = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		
		for(int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N+1];
			kevinCnt = 0;
			dfs(i, visited, 0);
			System.out.println(i +" "+kevinCnt + " "+ result);
			if(kevinCnt < result) {
				result = kevinCnt;
				resultIdx = i;
			}
		}
		
		System.out.println(resultIdx);
		
		
	}
	
	private static void dfs(int start, boolean[] visited, int cnt) {
		visited[start] = true;
		kevinCnt++;
		if(cnt == N) {
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			if(start == i) continue;
			if(map[start][i] && !visited[i]) {
				dfs(i, visited, cnt+1);
			}
		}

		
	}

}
