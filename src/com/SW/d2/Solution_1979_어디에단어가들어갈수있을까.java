package com.SW.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
	1. tc입력 반복
	2. N입력 단어퍼즐 NxN, 단어의 길이 K입력
	3. 연속된 1이 K인 개수 찾기
 */
public class Solution_1979_어디에단어가들어갈수있을까 {
	
	static int[][] puzzle;
	static int N, K, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			puzzle = new int[N][N];
			K = Integer.parseInt(str[1]);
			
			for(int i = 0; i < N; i++) {
				String[] str2 = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					puzzle[i][j] = Integer.parseInt(str2[j]);
				}
			}
			//setting
			
			//1. 행먼저 3인곳 찾기 -> 열 3인곳 찾기 ans증가
			ans = 0;
			findLen();
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void findLen() {
		//행 탐색
		for(int i = 0; i < N; i++) {
			int len = 0;
			for(int j = 0; j < N; j++) {
				if(puzzle[i][j] == 0) len = 0;
				else len++;
				if(len == K) ans++;
				if(len == K+1) ans--;
			}
		}
		
		//열 탐색
		for(int i = 0; i < N; i++) {
			int len = 0;
			for(int j = 0; j < N; j++) {
				if(puzzle[j][i] == 0) len = 0;
				else len++;
				if(len == K) ans++;
				if(len == K+1) ans--;
			}
		}
	}

}
