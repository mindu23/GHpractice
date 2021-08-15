package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_사칙연산유효성검사 {

	static int ans;
	static String[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new String[N+1];
			ans = 1;
			for(int i = 1 ; i <= N; i++) {
				String[] str = br.readLine().split(" ");
				int cur = Integer.parseInt(str[0]); //position
				input[cur] = str[1];
				
				//내가 연산자가 아니라면 즉 내가 숫자라면
				//내 부모가 없거나 내 부모가 연산자가 아니라면 false
				if(!"+-*/".contains(input[cur] )) {
					if(cur/2 > 0 && !"+-*/".contains(input[cur/2])) {
						ans = 0;
					}
				}
				
				
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
