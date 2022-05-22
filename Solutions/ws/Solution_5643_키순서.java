package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

	static int N, M, ans, gtCnt, ltCnt;
	static boolean[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new boolean[N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 화살표가 있는 곳은 true
				map[a][b] = true;
			}
			
			ans = 0;
//			for(int i = 1; i <= N; i++) {
//				int gt = gtBFS(i);
//				int lt = ltBFS(i);
//				boolean[] visited = new boolean[N+1];
//				int gt = gtDFS(i, visited);
//				int lt = ltDFS(i, visited);
//				if(gt + lt == N-1)
//					ans++;
//			}
			
			for(int i = 1; i <= N; i++) {
				ltCnt = gtCnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt+ltCnt == N-1) ans++;
			}
			
			System.out.println("#"+t+" "+ans);
		}

	}
	
	
	private static void ltDFS(int i, boolean[] visited) {
		visited[i] = true;
		
		for(int j = 1; j <= N; j++) {
			if(!visited[j] && map[j][i]) {
				ltCnt++;
				ltDFS(j, visited);
			}
		}
	}


	private static void gtDFS(int i, boolean[] visited) {
		visited[i] = true;
		
		for(int j = 1; j <= N; j++) {
			if(!visited[j] && map[i][j]) {
				gtCnt++;
				gtDFS(j, visited);
			}
		}
	}


//	private static int gtBFS(int a) {
//		Queue<Integer> q = new LinkedList<>();
//		boolean[] visited = new boolean[N+1];
//		int cnt = 0;
//		q.offer(a);
//		visited[a] = true;
//		
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			
//			for(int i = 1; i <= N; i++) {
//				if(visited[i]) continue;
//				if(!map[cur][i]) continue;
//				q.offer(i);
//				visited[i] = true;
//				cnt++;
//			}
//		}
//		return cnt;
//	}
//	private static int ltBFS(int a) {
//		Queue<Integer> q = new LinkedList<>();
//		boolean[] visited = new boolean[N+1];
//		int cnt = 0;
//		q.offer(a);
//		visited[a] = true;
//		
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			
//			for(int i = 1; i <= N; i++) {
//				if(visited[i]) continue;
//				if(!map[i][cur]) continue;
//				q.offer(i);
//				visited[i] = true;
//				cnt++;
//			}
//		}
//		return cnt;
//	}

}
