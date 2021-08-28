package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t <= T; t++) {
			int ans = 0;
			
			char[] input = br.readLine().toCharArray();
			int stick = 0;
			for(int i = 0; i < input.length; i++) {
				if(input[i] == '(') {
					stick++;
				}else {// ')'
					if(i >= 1 && input[i-1] == '(') {
						//laser //stick인줄 착각
						stick--;
						ans += stick;
					}else {
						stick--;
						ans++;						
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}

}
