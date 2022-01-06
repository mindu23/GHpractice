package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	N 볼 수 있는 상담 일수 입력
	N개의 T와 P 입력
 */
public class Solution_휴가 {

	static int N, ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tmp = new int[N][2];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tmp[n][0] = Integer.parseInt(st.nextToken()); // T
			tmp[n][1] = Integer.parseInt(st.nextToken()); // P
		}// 입력
		
		// 날짜, 수익, 선택
		dfs(0, 0, new boolean[N]);
		
		System.out.println(ans);
	}
	
	private static void dfs(int i, int j, boolean[] visited) {
		
		if(i > 7) return ;
		if(j > ans) ans = j;
		
		for(int k = i; k < 7; k++) {
			if(visited[k]) continue;
			visited[k] = true;
			dfs(i+tmp[k][0], j+tmp[k][1], visited);
		}
		
	}
	

}
