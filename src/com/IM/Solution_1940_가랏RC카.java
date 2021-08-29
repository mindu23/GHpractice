package com.IM;

import java.util.Scanner;

public class Solution_1940_가랏RC카 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int speed = 0;
			int dis = 0;
			for(int i = 0; i < N; i++) {
				switch(sc.nextInt()) {
				case 1:
					speed += sc.nextInt();
					break;
				case 2:
					speed -= sc.nextInt();
					break;
				}
				if(speed < 0) speed = 0;
				dis += speed;
			}
			
			System.out.println("#"+t+" "+ dis);
		}
		sc.close();
	}

}
