package com.IM;

import java.util.Arrays;
import java.util.Scanner;

/**
	일차원 배열로 걸리는 시간을 받자.
	Comparator? 순열을 사용해 보자.
 */

public class Main_11399_ATM {

	static int N;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];
		for(int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time); 
		
		int t = 0;
		int total = 0;
		for(int i = 0; i < N; i++) {
			t += time[i];
			total += t;
		}
		
		System.out.println(total);
		sc.close();
	}

}
