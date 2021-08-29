package com.IM;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1984_중간평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int[] input = new int[10];
			
			for(int i = 0; i < 10; i++) {
				input[i] = sc.nextInt();
			}
			
			Arrays.sort(input);
			double sum = 0;
			double avg = 0;
			for(int i = 1; i < 9; i++) {
				sum += (double)input[i];
			}
			avg = sum / 8;
			System.out.println("#"+t+" "+ Math.round(avg));
		}
		sc.close();
	}

}
