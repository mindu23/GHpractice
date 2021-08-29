package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	특정한 수 이상이 되어야 기립박수를 한다.
	각 사람이 기립 박수를 하려면 최소 몇 명의 사람들이 기립 박수를 하고 있어야 하는가
 */
public class Solution_4789_성공적인공연기획 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] c = br.readLine().toCharArray();
			int[] input = new int[c.length+1];
			for(int i = 1; i <= c.length;i++) {
				input[i] = c[i-1]-'0';
			}
			
			int ans = 0;
			int clap = input[1]; //이미 박수를 치는 사람들
			for(int i = 2; i <= c.length; i++) {
				if(clap >= i-1) {
					clap += input[i];
				}else {
					ans += i-1-clap;
					clap = i-1;
					clap += input[i];
				}
			}
		
			System.out.println("#"+t+" "+ ans);
		}
	}

}
