package com.IM;

import java.util.Scanner;

/*
 * 홀수는 하나씩
 * 짝수는 2빼고 두개이상..
 */
public class Main_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(i%j == 0 && j <= i/j) {
//					System.out.println(j+ " "+ i/j);
					cnt++;
					
				}
			}
		}

		System.out.println(cnt);
	}

}
