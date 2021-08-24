package com.IM;

import java.util.Scanner;

/**
	육각형
 */
public class Main_2292_벌집 {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int i = 1;
		int k = 1;
		int cnt = 1;
		while(true) {
			if(N <= k) break;
			k = i*6+k;
			i++;
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
