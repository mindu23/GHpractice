package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			char[] input = br.readLine().toCharArray();
			int cnt = input[0]=='0'?0:1;
			
			for(int i = 1; i < input.length; i++) {
				if(input[i-1]!= input[i]) cnt++;
			}
			System.out.println("#"+t+" "+cnt);
		}
		

	}

}
