package com.Solutions.알고기초2.BFS610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {

	// bfs
	static int N, M, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] a = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = a[j] - '0';
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		
		System.out.println(map[N-1][M-1]);
	}
	
	static int[] dr = {0,1,0,-1}; // 좌 우 하 상
	static int[] dc = {1,0,-1,0};
	static int[][] visited;
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new int[N][M];
		
		q.offer(new int[] {0,0,0}); // r, c, 깬 벽
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			
			for(int d = 0; d < dr.length; d++) {
				int nr = dr[d]+r;
				int nc = dc[d]+c;
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] < map[nr][nc]+cnt) continue;
				
				if(map[nr][nc] == 1) {
					q.offer(new int[] {nr, nc, cnt+1});
					visited[nr][nc] = cnt+1;
				}else {
					q.offer(new int[] {nr, nc, cnt});
					visited[nr][nc] = cnt;
					
				}
			}
			
		}
		
		
	}

}
