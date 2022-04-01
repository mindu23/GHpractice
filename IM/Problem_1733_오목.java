package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1733_오목 {

	//오른쪽가로 아래 오른쪽아래 왼쪽아래
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[21][21];
		int winR = 0, winC = 0, win = 0;
		
		for(int i = 1; i <= 19; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < 19; j++) {
				map[i][j+1] = Integer.parseInt(s[j]);
			}
		}//setting
		
		//왼쪽에서 오른쪽으로, 위에서 아래로 옮기며 탐색하자
		outer : for(int i = 1; i < 20; i++) {
			for(int j = 1; j < 20; j++) {
				if(map[i][j] == 0) continue;
				//오른쪽가로
				int cnt = 1;
				while(map[i][j-1] != map[i][j] && map[i][j+cnt]==map[i][j]) {
					cnt++;
				}
				if(cnt == 5) {
					win = map[i][j];
					winR = i;
					winC = j;
					break outer;
				}
				//아래
				cnt = 1;
				while(map[i-1][j] != map[i][j] && map[i+cnt][j]==map[i][j]) {
					cnt++;
				}
				if(cnt == 5) {
					win = map[i][j];
					winR = i;
					winC = j;
					break outer;
				}
				
				//오른쪽 아래
				cnt = 1;
				while(map[i-1][j-1] != map[i][j] && map[i+cnt][j+cnt]==map[i][j]) {
					cnt++;
				}
				if(cnt == 5) {
					win = map[i][j];
					winR = i;
					winC = j;
					break outer;
				}
				
				//오른쪽위
				cnt = 1;
				while(map[i+1][j-1] != map[i][j] && map[i-cnt][j+cnt]==map[i][j]) {
					cnt++;
				}
				if(cnt == 5) {
					win = map[i][j];
					winR = i;
					winC = j;
					break outer;
				}
			}
		}
		if(win == 0) {
			System.out.println(0);
		}else {
			System.out.println(win);
			System.out.println(winR+" "+winC);
		}
		
	}

}
