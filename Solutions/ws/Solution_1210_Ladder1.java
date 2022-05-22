package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1210_Ladder1 {

	static int[] dc = {-1,1};
	static int N = 100;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			char[][] sadari = new char[N][N];
			for(int i = 0; i < N; i++) {
				sadari[i] = br.readLine().replace(" ", "").toCharArray();
			}
			
			// 시작 위치 찾기
			int[] start = new int[2];
			int k = 0;
			for(int i = 0; i < N; i++) {
				if(sadari[0][i] == '1') {
					if(k == start.length) {
						start = Arrays.copyOf(start, start.length+1);
					}
					start[k] = i;
					k++;
				}
			}
			
			// 탈출구 찾기
			for(int i = 0; i < N; i++) {
				if(sadari[99][i] == '2') {
					k = i;//start[]의 시작 인덱스
					break;
				}
			}
			
			int kIdx = 0;
			for(int i = 0; i < start.length; i++) {
				if(start[i] == k) {
					kIdx = i;
					break;
				}
			}
			
			int r = 99;
			while(true) {
				if(r < 0) {
					break;
				}
				
				if(k-1 >= 0 && sadari[r][k-1] == '1') { // 왼쪽 길이 있다면
					kIdx--;
					k = start[kIdx];
				}else if(k+1 < N && sadari[r][k+1] == '1') { //오른쪽 길이 있다면
					kIdx++;
					k = start[kIdx];
				}
				r--;
			}
			System.out.println("#"+t+" "+start[kIdx]);
		}
		
	}

}
