package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9093_단어뒤집기 {
	
	static String solve(char[] s) {
		char[] s2 = new char[s.length];
		
		int j = 0;
		for(int i = s.length-1; i >= 0; i--) {
			s2[j++] = s[i];
		}
		
		String result = new String(s2);
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String result = solve(st.nextToken().toCharArray());
				System.out.print(result+" ");
			}
			System.out.println();
		}

	}

}
