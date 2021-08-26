package com.IM;

import java.util.Scanner;

public class Main_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[42];
		int cnt = 0;
		for(int i = 0; i < 10; i++) {
			input[ sc.nextInt()%42]++;
		}
		
		for(int i = 0; i < 42; i++) {
			if(input[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
