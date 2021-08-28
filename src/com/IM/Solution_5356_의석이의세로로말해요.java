package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5356_의석이의세로로말해요 {

	static int N = 5;
	static char[][] input;
	static int len;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			input = new char[N][15];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 15; j++) {
					input[i][j] = '-';
				}
			}
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < s.length(); j++) {
					input[i][j] = s.charAt(j);
				}
			}
			
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < N; j++) {
					if(input[j][i] == '-') continue;
					sb.append(input[j][i]);
				}
			}
			System.out.println("#"+t+" "+sb.toString());
		}
	}
}