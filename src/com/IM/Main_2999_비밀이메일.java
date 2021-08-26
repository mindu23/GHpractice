package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메일은 총 N글자
 * R <= C 
 * R * C = N (여러개일 경우 R이 제일 큰 것 선택)
 * 
 * 123456789
 * 
 * 123
 * 456
 * 789
 * 
 * 147258369
 * 
 */
public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String code = br.readLine();
		
		int N = code.length();
		int R = 1, C = 1;
		for(int i = 1; i < N; i++) {
			if(N%i == 0 && i <= N/i) {
				R = i;
				C = N/i;
			}
		}
		
		char[][] encode = new char[R][C];

		int c = 0;
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				encode[j][i]=code.charAt(c++);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(encode[i][j]);
			}
		}
		
	}

}
