package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {

	static int I, ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			map[startR][startC] = 1;
			st = new StringTokenizer(br.readLine());
			int destR = Integer.parseInt(st.nextToken());
			int destC = Integer.parseInt(st.nextToken());
			map[destR][destC] = 2;
			
			bfs(startR, startC);
			
			System.out.println(ans);
		}

	}
	
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	private static void bfs(int startR, int startC) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[I][I];
		q.offer(new int[] {startR, startC, 0});
		visited[startR][startC] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			cnt = cur[2];
			
			if(map[r][c] == 2) break;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= I || nc < 0 || nc >= I || visited[nr][nc]) continue;
				q.offer(new int[] {nr, nc, cnt+1});
				visited[nr][nc] = true;
			}
			
		}
		ans = cnt;
		
	}

}
