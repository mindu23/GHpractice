package com.SW.d2;

import java.util.Scanner;

public class Solution_1970_쉬운거스름돈 {

	static int[] pay = {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			System.out.println("#"+t);
			for(int i = 0; i < pay.length; i++) {
				System.out.print(N/pay[i]+" ");
				N %= pay[i];
			}
			System.out.println();
		}
		
	}

}
