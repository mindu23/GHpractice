package com.Solutions.재귀;

import java.util.Scanner;

public class Main_10872_팩토리얼 {

	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = fac(N);
		
		System.out.println(ans);
		sc.close();
	}
	
	private static int fac(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n*fac(n-1);
	}
	
}
