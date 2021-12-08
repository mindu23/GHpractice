package com.Solutions.재귀;

import java.util.Scanner;

public class Main_10870_피보나치수5 {

	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		ans = fib(N);
		
		System.out.println(ans);
		sc.close();
	}
	
	private static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fib(n-1)+fib(n-2);
	}

}
