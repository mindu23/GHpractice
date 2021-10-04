package com.SW.d2;
/**
	1~9까지 9x9
	한 row, col 3x3에 1~9가 겹치면 안됨
	정상적인 스도쿠면 1, 아니면 0
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1974_스도쿠검증 {

	static int[][] sudoku;
	static boolean[] numbers;
	static int N = 9;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			sudoku = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					sudoku[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int a = rowCheck();
			int b = colCheck();
			int c = gridCheck();
			if(a == 0 || b == 0 || c == 0) { //하나라도 0이면 0
				System.out.println("#"+t+" 0");
			}else {
				System.out.println("#"+t+" 1");
			}
			
		}
	}
	
	private static int gridCheck() {
		for(int k = 0; k < N; k += 3) { //맨 위 행
			numbers = new boolean[N+1]; // 1은 idx0에 삽입
			for(int i = 0; i < 3; i++) {
				for(int j = k; j < 3+k; j++) {
					int idx = sudoku[i][j];
					if(numbers[idx] == true) {
						return 0;
					}else {
						numbers[idx] = true;
					}
				}
			}
		}
		for(int k = 0; k < N; k += 3) { //맨 위 행
			numbers = new boolean[N+1]; // 1은 idx0에 삽입
			for(int i = 3; i < 6; i++) {
				for(int j = k; j < 3+k; j++) {
					int idx = sudoku[i][j];
					if(numbers[idx] == true) {
						return 0;
					}else {
						numbers[idx] = true;
					}
				}
			}
		}
		for(int k = 0; k < N; k += 3) { //맨 위 행
			numbers = new boolean[N+1]; // 1은 idx0에 삽입
			for(int i = 6; i < 9; i++) {
				for(int j = k; j < 3+k; j++) {
					int idx = sudoku[i][j];
					if(numbers[idx] == true) {
						return 0;
					}else {
						numbers[idx] = true;
					}
				}
			}
		}
		return 1;
	}

	private static int colCheck() {
		//열 검색
		for(int i = 0; i < N; i++) {
			numbers = new boolean[N+1]; // 1은 idx0에 삽입
			for(int j = 0; j < N; j++) {
				int idx = sudoku[j][i];
				if(numbers[idx] == true) {
					return 0;
				}else {
					numbers[idx] = true;
				}
			}
		}
		return 1;
	}

	private static int rowCheck() {
		//행 검색
		for(int i = 0; i < N; i++) {
			numbers = new boolean[N+1]; // 1은 idx0에 삽입
			for(int j = 0; j < N; j++) {
				int idx = sudoku[i][j];
				if(numbers[idx] == true) {
					return 0;
				}else {
					numbers[idx] = true;
				}
			}
		}
		return 1;
	}

}
