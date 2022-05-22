package com.SW.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
	1. tc 
	2. N명의 사람이 돌 던지기
	3. 각 사람들 마다 돌이 떨어진 위치 입력
	4. 0에 가깝게 떨어진 곳과의 차이, 그렇게 던진 사람의 수
 */
public class Solution_1285_아름이의돌던지기 {

	static int N, ans;
	static int[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1285.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new int[N];
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				input[i] = Math.abs(Integer.parseInt(str[i]));
			}
			
			Arrays.sort(input);
			int n = input[0];
			int i = 1;
			ans = 1;
			while(true) {
				if(n == input[i]) {
					ans++; 
					i++;
				}else break;
				if(i == N) break;
			}
			System.out.println("#"+t+" "+n+" "+ans);
		}
	}

}
