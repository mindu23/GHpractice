package com.Solutions.재귀;

import java.util.Scanner;

public class Main_11729_하노이탑이동순서 {

	static int N, cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(cnt-1);
		System.out.println(sb.toString());
		sc.close();

	}
	
	private static void hanoi(int n, int start, int temp, int end) {
		if(n == 0) {
			cnt++;
			return;
		}
		
		hanoi(n-1, start, end, temp);
		
		sb.append(start +" "+ end+"\n");
		
		hanoi(n-1, temp, start, end);

	}

}
