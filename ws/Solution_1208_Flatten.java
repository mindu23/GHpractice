package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {

	static int N = 100;
	static int min = 0, max = 99;
	static int[] boxs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int dumpCnt = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			StringTokenizer tokens = new StringTokenizer(str," ");
			boxs = new int[N];
			for(int i = 0; i < N; i++) {
				boxs[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println("#"+t + " " + solve(dumpCnt));
			
		}
	}
	
	private static int solve(int dumpCnt) {
		Arrays.sort(boxs);
		
		for(int i = 0; i < dumpCnt; i++) {
			if(boxs[max] - boxs[min] < 2) {
				return boxs[max] - boxs[min];
			}
			
			boxs[min]++;
			boxs[max]--;
			
			getMin();
			getMax();
		}
		return boxs[max] - boxs[min];
	}

	private static void getMin() {
			if(boxs[min] <= boxs[min+1]) {
				min = 0;
			}else
				min++;
	}
	
	private static void getMax() {
		if(boxs[max] >= boxs[max-1]) {
			max = 99;
		}else
			max--;
	}
}
