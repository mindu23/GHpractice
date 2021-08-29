package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2007_패턴마디의길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			StringBuffer sb = new StringBuffer();
			
			sb.append(str.charAt(0));
			for(int i = 1; i <= 10; i++) {
				if(str.substring(i, i*2).contains(sb)) break;
				
				sb.append(str.charAt(i));
			}
			
		}

	}

}
