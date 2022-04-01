package com.Solutions.알고기초2.BFS610;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	static int N, K, ans;
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs();
		System.out.println(ans);
		sc.close();
	}
	
	static int[] dc = {-1,1,2};
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.offer(new int[] {N, 0});
		visited[N] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int now = cur[0];
			cnt = cur[1];
			
			if(now == K) break;
			
			for(int d = 0; d < dc.length; d++) {
				int nowd = now + dc[d];
				if(dc[d] == 2) nowd = now*2;
				
				if(nowd < 0 || nowd >= 100001 || visited[nowd]) continue;
				q.offer(new int[] {nowd, cnt+1});
				visited[nowd] = true;
			}
		}
		ans = cnt;
	}

}
