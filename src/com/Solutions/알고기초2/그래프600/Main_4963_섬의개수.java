package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

	static int w, h, ans;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			
			if(w == 0 && h == 0) break;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//setting
			
			ans = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
			
		}
		
	}
	
	static int[] dr = {0,0,-1,1,-1,1,-1,1};
	static int[] dc = {-1,1,0,0,-1,1,1,-1};
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc] || map[nr][nc] == 0) continue;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		ans++;
		
	}

}
