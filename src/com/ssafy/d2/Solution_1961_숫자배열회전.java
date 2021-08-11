package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
	행렬 시계방향으로 90 180 270 회전한 모습
 */
public class Solution_1961_숫자배열회전 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			System.out.println("#"+t);
			rotate();
			
		}
	}

	private static void rotate() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(arr[N-1-j][i]);
			}
			System.out.print(" ");
			for(int j = 0; j < N; j++) {
				System.out.print(arr[N-1-i][N-1-j]);
			}
			System.out.print(" ");
			for(int j = 0; j < N; j++) {
				System.out.print(arr[j][N-1-i]);
			}
			System.out.println();
		}
	}

}
