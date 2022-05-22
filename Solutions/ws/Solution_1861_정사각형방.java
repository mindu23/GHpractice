package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1861_정사각형방 {

	static int[][] map;
	static int N, maxMoveCnt, cnt, minRoomNo;
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
				한칸씩 방문해서 확인해보자
				한칸한칸을 flat하게 보자. dfs 재귀를 사용해보자
				움직임이 제일 큰 횟수를 고르고 그 횟수의 방 중 방 번호가 가장 작은 것 출력!
			 */
			maxMoveCnt = cnt = 1;
			minRoomNo = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visit(i, j);
					
					if(cnt > maxMoveCnt) {
						maxMoveCnt = cnt;
						minRoomNo = map[i][j];
					}else if (cnt == maxMoveCnt && map[i][j] < minRoomNo){
						minRoomNo = map[i][j];
					}
					cnt = 1;
				}
			}
			
			System.out.println("#"+t+" "+ minRoomNo+" "+maxMoveCnt);
			
		}
	}
	
	private static void visit(int i, int j) {
		int nr, nc;
		int num = map[i][j];
		for(int dir = 0; dir < 4; dir++) {
			nr = i + dr[dir];
			nc = j + dc[dir];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == num+1) {
				cnt++;
				visit(nr, nc);
			}
		}
	}

}
