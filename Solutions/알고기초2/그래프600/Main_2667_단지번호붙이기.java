package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	static int N, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new int[1];
		for(int i = 0; i < N; i++) {
			char[] m = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = m[j]-'0';
			}
		}
		
		ans = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1)
					bfs(i, j);
			}
		}
		
		System.out.println(ans-1);
		Arrays.sort(result);
		for(int i = 0; i < result.length;i++) {
			if(result[i] == 0) continue;
			System.out.println(result[i]);
		}
	}
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j, ans});
		visited[i][j] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int danji = cur[2];
			cnt++;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;
				map[nr][nc] = danji;
				q.offer(new int[] {nr, nc, danji});
				visited[nr][nc] = true;
			}
		}
		result[ans-1] = cnt;
		result = Arrays.copyOf(result, result.length+1);
		ans++;
	}

}
