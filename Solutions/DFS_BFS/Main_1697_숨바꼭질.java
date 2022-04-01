package com.Solutions.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	static int N, K, result;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		result = Integer.MAX_VALUE;
		visited = new boolean[100001];
		bfs(N);
		System.out.println(result);
		sc.close();
	}
	
	private static void bfs(int n) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {n , 0});
		visited[n] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == K) {
				if(result > cur[1])
					result = cur[1];
				return;
			}
			
			for(int d = 0; d < 3; d++) {
				int nc = 0;
				if(d == 0) nc = cur[0] + 1;
				else if(d==1) nc = cur[0] - 1;
				else nc = cur[0] * 2;
				
				if(nc < 0 || nc > 100000) continue;
				if(visited[nc]) continue;

				q.offer(new int[] {nc, cur[1]+1});
				visited[nc] = true;
			}
			
			
		}
	}

}
