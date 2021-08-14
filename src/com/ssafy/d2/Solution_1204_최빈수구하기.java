package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1204_최빈수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1204.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine());
			int[] freq = new int[100+1];
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < 1000; i++) {
				freq[Integer.parseInt(str[i])]++;
			}

			int ans = Integer.MIN_VALUE;
			int ansIdx = 0;
			for(int i = 0; i <= 100; i++) {
				if(freq[i] >= ans) {
					ans = freq[i];
					ansIdx = i;
				}
			}
			System.out.println("#"+t+" "+ansIdx);
		}
	}

}
