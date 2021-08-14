package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//모르겠쉅
public class Solution_1861_정사각형방 {

	static int[][] map;
	static int N, ans, roomNum;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}//setting
			
			/**
				한칸씩 방문해서 4방탐색하며 하나 큰 방 찾기
				방찾기가 끝나면 roomNum 방번호(최소 방)과 ans 방의 이동 횟수 출력해주기
			 */
			ans = 1;
			roomNum = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visit(i, j);
				}
			}
			
			System.out.println("#"+t+" "+ roomNum+" "+ans);
			
		}
	}
	
	private static void visit(int i, int j) {
		int nr, nc;
		int dir = 0, cnt = 1;
		int num = map[i][j];
		while(dir < 4) {
			nr = i + dr[dir];
			nc = j + dc[dir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
				dir++;
				continue;
			}
			
			if(num+1 == map[nr][nc]) {//갖다면 자리 옮기자
				cnt++; //옮긴 횟수
				//System.out.println(cnt);
				i = nr; //방 change
				j = nc;
				dir = 0; // 처음부터 다시 돌기
			}else {
				dir++;
			}
		}//탐색이 끝남
		if(ans < cnt) {
			ans = cnt;
			roomNum = num;
		}
		
	}

}
