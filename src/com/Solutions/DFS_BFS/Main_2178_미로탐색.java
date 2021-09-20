package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
//dfs : 이동한 정점의 값을 가지고 계속 연산을 하는 경우
//bfs : 최단거리 문제
	static int N, M, minCnt;
	static int[][] adjMatrix;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N+2][M+2];
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				adjMatrix[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		minCnt = Integer.MAX_VALUE;
		sb = new StringBuilder();
		bfs();
		System.out.println(minCnt);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+2][M+2];
		q.offer(new int[] {1,1,1});
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N && cur[1] == M) {
				if(cur[2] < minCnt)
					minCnt = cur[2];
				return ;
			}
			for(int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
			 
				if(adjMatrix[nr][nc] == 0 || visited[nr][nc]) continue;
			
				q.offer(new int[] {nr,nc,cur[2]+1});
				visited[nr][nc] = true;
			}
		}
		
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
//	private static void dfs(int[] cur, boolean[][] visited, int cnt) {
//		
//		if(cur[0] == N && cur[1] == M) {
//			if(cnt < minCnt)
//				minCnt = cnt;
//			return ;
//		}
//		visited[cur[0]][cur[1]] = true;
//		
//		for(int d = 0; d < 4; d++) {
//			int nr = cur[0]+dr[d];
//			int nc = cur[1]+dc[d];
//			
////			System.out.println(nr+" "+nc);
////			if(nr < 1 || nr > N || nc < 1 || nc > M) continue; 
//			if(adjMatrix[nr][nc] == 0 || visited[nr][nc]) continue;
//			dfs(new int[] {nr,nc}, visited, cnt+1);
//			visited[nr][nc] = false;
//		}
//	}
	
	

}
