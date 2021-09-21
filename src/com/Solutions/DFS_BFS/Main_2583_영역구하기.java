package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		list = new ArrayList<>();
		visited = new boolean[M][N];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int areaCnt = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					areaCnt++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(areaCnt);
		for(int n : list) {
			System.out.print(n +" ");
		}
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		int n = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < dr.length; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(visited[nr][nc] || map[nr][nc] == 1) continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				n++;
			}
		}
		list.add(n);
	}

}
