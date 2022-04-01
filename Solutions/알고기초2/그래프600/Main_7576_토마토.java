package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
					visited[i][j] = true;
					cnt++;
				}
			}
		}
		if(cnt == N*M) {
			System.out.println(0);
		}else {
			bfs();
		}
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs() {
		int day = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			day = cur[2];
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == -1) continue;
				q.offer(new int[] {nr,nc, day+1});
				visited[nr][nc] = true;
				map[nr][nc] = 1;
			}
		}
		
		if(check()) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
	}
	private static boolean check() {
		boolean ok = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) ok = false;
			}
		}
		return ok;
	}

}
