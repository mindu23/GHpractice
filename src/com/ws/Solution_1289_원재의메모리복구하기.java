package com.ws;

import java.io.BufferedReader;
/**
	1. 같은 문자열 비교하기
	2. 첫번째 1을 찾고 그 이후 바뀔 때마다 하나씩 체크
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {

	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src//inputFile//input_1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<= T; t++) {
			String str = br.readLine();
			char c = '0';
			cnt = 0;
			for(int i = 0; i < str.length();i++) {
				if(c != str.charAt(i)) {
					cnt++;
					c = str.charAt(i);
				}
					
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
