package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	static int N, totalCnt;
	static int[][] map;
	static int[] danjiCnt;
	static ArrayList<Integer> list;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//bfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					bfs(new int[] {i,j, 0});
					totalCnt++;
				}
			}
		}
		
		System.out.println(totalCnt);
		Collections.sort(list);
		for(int n : list) {
			System.out.println(n);
		}
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs(int[] cur) {
		Queue<int[]> q = new LinkedList<>();
//		visited = new boolean[N][N];
		
		q.offer(cur);
		visited[cur[0]][cur[1]] = true;
		int cnt = 0; 
		while(!q.isEmpty()) {
			int[] current = q.poll();
			cnt++;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				q.offer(new int[] {nr, nc, cur[2]+1});
				visited[nr][nc] = true;
			}
		}
		list.add(cnt);
	}
}
