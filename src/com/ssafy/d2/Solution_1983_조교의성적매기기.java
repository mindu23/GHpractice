package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
	a +0- b+0- c+0- d
	총점 = 중간(35%) + 기말(45%) + 과제(20%)
 */
public class Solution_1983_조교의성적매기기 {

	static int N, K;
	static int[] score, rate = new int[] {35,45,20};
	static String[] grade = new String[] {"D0", "C-", "C0","C+","B-","B0","B+", "A-", "A0", "A+"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);

			score = new int[N];
			int Kscore = -1;
			for(int n = 0; n < N; n++) {
				String[] str2 = br.readLine().split(" ");
				for(int i = 0; i < 3; i++) {
					score[n] += Integer.parseInt(str2[i]) * rate[i];
				}
			}
			
			Kscore = score[K-1];
			
			Arrays.sort(score);
			int num = 1;
			for(int i = 0; i < N; i++) {
				if(Kscore == score[i]) num = i; 
			}
			
			int ans = num/(N/10);
			System.out.println("#"+t + " "+grade[ans]);
		}

	}

}
