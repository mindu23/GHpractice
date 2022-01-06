package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	0100을 만드려면 0000 -> 0111 -> 0100
	끝까지 바뀐다. 최소 몇 번이나 고쳐야 하는가
 */
public class Solution_1289_원재의메모리복구하기2 {

	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			ans = 0;
			char[] s = br.readLine().toCharArray();
			if(s[0] == '1') {
				ans = 1;
			}
			for(int j = 1; j < s.length; j++) {
				if(s[j-1] != s[j]) {
					ans++;
				}
			}
			System.out.println("#"+i+" "+ans);
		}
		
		
	}

}
