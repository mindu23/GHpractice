package com.SW.d3;
/**
	N과 N의 제곱근이 모두 회문인 수를 찾아라
	ans++
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_10570_제곱팰린드롬수 {

	static int ans, A, B;
	static int[] range;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("3\r\n" + 
				"1 9\r\n" + 
				"10 99\r\n" + 
				"100 1000"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			A = Integer.parseInt(str[0]);
			B = Integer.parseInt(str[1]);
			
			ans = 0;
			palindrome();
			System.out.println("#"+t+" "+ ans);
		}
	}

	private static void palindrome() {
		for(int i = 0; i <= B; i++) {
			StringBuffer sb = new StringBuffer(String.valueOf(i));
			String af = sb.reverse().toString();
			String be = sb.reverse().toString();
			
			if(be.equals(af)) {
				squared(i);
			}
		}
	}
	
	private static void squared(int i) {
		int ii = i*i;
		StringBuffer sb = new StringBuffer(String.valueOf(ii));
		String af = sb.reverse().toString();
		String be = sb.reverse().toString();
		
		if(be.equals(af)) {
			if(ii >= A && ii <= B) {
				ans++;
			}
		}
	}
}
