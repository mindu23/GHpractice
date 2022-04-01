package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	static int K;
	static int[] direct;
	static boolean[] contact, canMove;
	static int[][] magnet, move;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			contact = new boolean[5];
			move = new int[K][2];
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j ++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j ++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
				
				int movMagnet = move[i][0]-1;
				int dir = move[i][1]; // 1이면 시계방향. -1이면 반시계방향
				//접합부 회전 가능 여부 확인
				
				canMove = new boolean[4];
				direct = new int[4];
				ContactMove(movMagnet, dir);//움직여도 되는지 확인하기 ture이고 회전학 자석과 사이에 false가 없으면 움직일 수 있다.
				
				
				for(int r = 0; r < 4; r++) {
					Rotate(r);
				}
			}
			
			System.out.println("#"+t+" "+Score());
		}
	}

	private static int Score() {
		int score = 0;
		score += magnet[0][0];
		score += 2*magnet[1][0];
		score += 4*magnet[2][0];
		score += 8*magnet[3][0];
		return score;
	}

	private static void Rotate(int r) {
		if(canMove[r]) { //움직일 수 있으면 direct 방향으로 움직여주자.
			if(direct[r] == 1) { //시계방향
				int temp = magnet[r][7];
				for(int i = 6; i >= 0; i--) {
					magnet[r][i+1] = magnet[r][i];
				}
				magnet[r][0] = temp;
			}else { // 반시계방향
				int temp = magnet[r][0];
				for(int i = 1; i < 8; i++) {
					magnet[r][i-1] = magnet[r][i];
				}
				magnet[r][7] = temp;
			}
		}
		
	}

	static int[] dc = {-1,1};
	private static void ContactMove(int movMagnet, int dir) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] v = new boolean[4];
		q.offer(new int[] {movMagnet, dir});
		canMove[movMagnet] = true;
		direct[movMagnet] = dir;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int n = cur[0];
			int di = cur[1];
			
			for(int d = 0; d < dc.length; d++) {
				int nc = n + dc[d];
				//범위 체크
				if(nc < 0 || nc >= 4) continue;
				if(nc == 0) {
					if(v[nc]) continue;
					if(magnet[nc][2] == magnet[n][6])
						canMove[nc] = false;
					else {
						canMove[nc] = true;
						direct[nc] = -1 * di;
						q.offer(new int[] {nc, direct[nc]});
					}
					//고려했다.
					v[nc] = true;
				}else if(nc == 3) {
					if(v[nc]) continue;
					if(magnet[n][2] == magnet[nc][6])
						canMove[nc] = false;
					else {
						canMove[nc] = true;
						direct[nc] = -1 * di;
						q.offer(new int[] {nc, direct[nc]});
					}
					v[nc] = true;
				}else { // 1, 2
					//왼쪽
					if(v[nc]) continue;
					if(d == 0) {
						if(magnet[n][6] == magnet[nc][2])
							canMove[nc] = false;
						else {
							canMove[nc] = true;
							direct[nc] = -1 * di;
							q.offer(new int[] {nc, direct[nc]});
						}
					}
					//오른쪽
					if(d == 1) {
						if(magnet[n][2] == magnet[nc][6])
							canMove[nc] = false;
						else {
							canMove[nc] = true;
							direct[nc] = -1 * di;
							q.offer(new int[] {nc, direct[nc]});
						}
					}
					v[nc] = true;
				}
			}
		}
		
	}

}
