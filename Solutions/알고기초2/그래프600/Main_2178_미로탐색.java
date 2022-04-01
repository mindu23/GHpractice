package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] m = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = m[j] - '0';
			}
		}//settng
		
		bfs();
		
		System.out.println(ans);
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,1});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			ans = cur[2];
			
			if(r == N-1 && c == M-1) break;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
				q.offer(new int[] {nr, nc, ans+1});
				visited[nr][nc] = true;
			}
		}
		
	}

}
