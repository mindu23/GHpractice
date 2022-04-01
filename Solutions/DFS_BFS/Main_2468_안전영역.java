package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int N, safeCnt, rainLen;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 map = new int[N][N];
	
		 rainLen = Integer.MIN_VALUE;
		 for(int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 for(int j = 0; j < N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
				 if(map[i][j] > rainLen) rainLen = map[i][j];
			 }
		 }
		 
		 safeCnt = Integer.MIN_VALUE;
		 for(int k = 0; k <= rainLen; k++) {
			 visited = new boolean[N][N];
			 int cnt = 0;
			 for(int i = 0; i < N; i++) {
				 for(int j = 0; j < N; j++) {
					 if(map[i][j] > k && !visited[i][j]) {
						 bfs(i, j, k);
						 cnt++;
					 }
				 }
			 }
			 if(cnt > safeCnt)
				 safeCnt = cnt;
		 }
		 
		 System.out.println(safeCnt);
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(int r, int c, int k ) {
		Queue<int[]> q = new LinkedList<>();
		 
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < dr.length; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc] || map[nr][nc] <= k) continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}

}
