package com.ws;

public class Solution_네트워크 {

	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int ans = solution(n, computers);

		System.out.println(ans);
	}

	static int[] v;
	static int answer;
	private static int solution(int n, int[][] computers) {
		
		v = new int[n];
		int con = 1;
		for(int i = 0; i < n; i++) {
			// 연결 번호, n, r, computers
			if(v[i] != 0) continue;
			dfs(con++, n, i, computers);
		}
		answer = con-1;
		return answer;
		
	}
	private static void dfs(int con, int n, int i, int[][] computers) {
		
		for(int j = i; j < n; j++) {
			if(j == i) continue;
			if(v[j] != 0) continue;
			
			if(computers[i][j] == 1) {
				v[i] = con;
				v[j] = con;
				dfs(con, n, j, computers);
			}//
		}
		
	}


}
