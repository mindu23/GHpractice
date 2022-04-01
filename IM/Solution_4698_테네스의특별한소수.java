package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4698_테네스의특별한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[1000001];
		for(int i = 2; i <= 1000000; i++) {
			int j = 2;
			while(true) {
				if(i*j > 1000000) break;
				isPrime[i*j] = true;
				j++;
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[1]);
			int B = Integer.parseInt(s[2]);
			
			for(int a = A; a <= B; a++) {
				if(a==1 || isPrime[a]) continue;
				if(Integer.toString(a).contains(s[0])) ans++;
			}
			
			System.out.println("#"+t+" "+ ans);
		}
		
		
	}

}
