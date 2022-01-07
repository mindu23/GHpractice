package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
	배추는 띄엄띄엄 심어져있다.
	배추가 상하좌우 한곳에 닿아있으면 배추벌레는 움직일 수 있다.
	모든 배추를 지치기위해 필요한 최소의 배추흰지렁이 마리 수를 구해라
	
	tc T
	row N
	col M
	배추 개수 K
	K개의 배추 위치
 */
public class Main_1012_유기농배추 {

	static int N, M, K, ans;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}// 입력 끝
			
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visited[i][j] || map[i][j] == 0) continue;
					
					bfs(i, j);
				}
			}
			
			System.out.println(ans);
		}

	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int r = a[0];
			int c = a[1];
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
		ans++;
	}

}
