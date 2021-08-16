package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_10505_소득불균형 {

	static int[] input;
	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("3\r\n" + 
				"7\r\n" + 
				"15 15 15 15 15 15 15\r\n" + 
				"10\r\n" + 
				"1 1 1 1 1 1 1 1 1 100\r\n" + 
				"7\r\n" + 
				"2 7 1 8 2 8 4"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			input = new int[N];
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(str[i]);
			}
			ans = 0;
			Avg();
			System.out.println("#"+t+ " "+ ans);
		}
		
	}

	private static void Avg() {
		double sum = 0;
		double avg = 0;
		for(int i = 0; i < N; i++) {
			sum += input[i];
		}
		avg = sum / (double)N;
		
		for(int i = 0; i < N; i++) {
			if(input[i] <= avg) ans++;
		}
	}
}
