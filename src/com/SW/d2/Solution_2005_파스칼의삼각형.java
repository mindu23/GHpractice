package com.SW.d2;

import java.util.Scanner;

public class Solution_2005_파스칼의삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			
			System.out.println("#"+t);
			for(int i = 1; i <= N; i++) {
				System.out.print(1+" ");
				if(i > 1) {
					if(i > 2) {
						for(int j = 1; j < i-1; j++) {
							System.out.print(i-1+" ");
						}
					}
					System.out.print(1);
				}
				System.out.println();
			}
			
			
		}
		

	}

}
