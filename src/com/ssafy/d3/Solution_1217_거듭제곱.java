package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_1217_거듭제곱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("1\r\n" + 
				"9 8\r\n" + 
				"2\r\n" + 
				"2 8\r\n" + 
				"3\r\n" + 
				"6 5\r\n" + 
				"4\r\n" + 
				"10 7\r\n" + 
				"5\r\n" + 
				"6 7\r\n" + 
				"6\r\n" + 
				"7 2\r\n" + 
				"7\r\n" + 
				"9 8\r\n" + 
				"8\r\n" + 
				"3 2\r\n" + 
				"9\r\n" + 
				"4 8\r\n" + 
				"10\r\n" + 
				"8 6"));
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			String[] str = br.readLine().split(" ");
			int ans = squared(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			System.out.println("#"+t+ " "+ ans);
		}
	}
	
	private static int squared(int i , int j) {
		int ans = 1; 
		for(int n = 0; n < j; n++) {
			ans *= i;
		}
		return ans;
	}

}
