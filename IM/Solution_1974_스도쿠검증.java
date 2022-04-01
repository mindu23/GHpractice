package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1974_스도쿠검증 {

	static int[][] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			input = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < 9; j++) {
					input[i][j] = Integer.parseInt(s[j]);
				}
			}//setting
			
			CheckRow();
			
			CheckCol();
			
			CheckGrid();
			
			if(CheckRow() && CheckCol() && CheckGrid()) System.out.println("#"+t+" "+"1");
			else System.out.println("#"+t+" "+"0");
		}
	}
	
	private static boolean CheckGrid() {
		for(int k = 0; k < 9; k+=3) {
			boolean[] check = new boolean[10];
			for(int i = k; i < k+3; i++) {
				for(int j = 0; j < 3; j++) {
					if(check[input[j][i]]) return false;
					check[input[j][i]] = true;
				}
			}
		}
		for(int k = 0; k < 9; k+=3) {
			boolean[] check = new boolean[10];
			for(int i = 0; i < 3; i++) {
				for(int j = k; j < 3+k; j++) {
					if(check[input[j][i]]) return false;
					check[input[j][i]] = true;
				}
			}
		}
		
		return true;
	}
	
	private static boolean CheckCol() {
		for(int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(check[input[j][i]]) return false;
				check[input[j][i]] = true;
			}
		}
		return true;
	}
	
	private static boolean CheckRow() {
		for(int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(check[input[i][j]]) return false;
				check[input[i][j]] = true;
			}
		}
		return true;
	}

}
