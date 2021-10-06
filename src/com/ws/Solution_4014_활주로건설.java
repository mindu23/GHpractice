package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

	static int N, x, ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				row(i);
				col(i);
			}
			
			System.out.println("#"+t+" "+ ans);
		}

	}
	private static void col(int i) {
		int a = map[0][i];
		int cnt = 1;
		boolean isDown = false;
		for(int j = 1; j < N; j++) {
			if(a == map[j][i]) { // 높이가 같다면
				cnt++;
				if(isDown&& cnt == x) {
					isDown = false;
					cnt = 0;
				}
			}else {// 높이가 변화한다면
				if(Math.abs(a-map[j][i]) > 1) return ;
				if(isDown && cnt < x) return ;
				if( a < map[j][i]) { // 높아진다면 이미 나왔던 길이가 중요하다.
					if(cnt < x) { // 경사로 생기기 전에 끝남
						return ;
					}
					//경사로 생성
					cnt = 1;
					isDown = false;
				}else if( a > map[j][i]) { // 낮아진다면 뒤에 나오는 길이가 중요하다.
					if(isDown && cnt < x) { // 경사로 생기기 전에 끝남
						return ;
					}
					// 경사로 생성
					cnt = 1;
					isDown = true;
				}
			}
			a = map[j][i];
		}
		if(isDown && cnt < x) return;
//		System.out.println("c "+i);
		ans++;
		
	}
	private static void row(int i) {
		int a = map[i][0];
		int cnt = 1;
		boolean isDown = false;
		for(int j = 1; j < N; j++) {
			if(a == map[i][j]) { // 높이가 같다면
				cnt++;
				if(isDown&& cnt == x) {
					isDown = false;
					cnt = 0;
				}
			}else {// 높이가 변화한다.
				if(Math.abs(a-map[i][j]) > 1) return ;
				if(isDown && cnt < x) return ;
				if( a < map[i][j]) { // 높아진다면 이미 나왔던 길이가 중요하다.
					if(cnt < x) { // 경사로 생기기 전에 끝남
						return ;
					}
					//경사로 생성
					cnt = 1;
					isDown = false;
				}else if( a > map[i][j]) { // 낮아진다면 뒤에 나오는 길이가 중요하다.
					
					// 경사로 생성
					cnt = 1;
					isDown = true;
				}
			}
			a = map[i][j];
		}
		if(isDown && cnt < x) return;
//		System.out.println("r "+i);
		ans++;
	}

}
