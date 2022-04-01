package com.Solutions.백트래킹;

import java.util.Scanner;

public class Main_14888_연산자끼워넣기 {

	static int N, max, min, opCnt;
	static int[] A, op, copy_op;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		op = new int[4];
		copy_op = new int[4];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		//0:+ 1:- 2:* 3:/
		for(int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		//op가 0이 아닌 것 중에 하나 골라서 보내기
		solve(A[0], 0, 0, 0, 0, 1);
		
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	private static void solve(int result, int plus, int minus, int mul, int div, int cnt) {
		if(cnt == N) {
			if(max < result) max = result;
			if(min > result) min = result;
			return ;
		}
		
		if(plus < op[0])
			solve(result+A[cnt], plus+1, minus, mul, div, cnt+1);
		if(minus < op[1])
			solve(result-A[cnt], plus, minus+1, mul, div, cnt+1);
		if(mul < op[2])
			solve(result*A[cnt], plus, minus, mul+1, div, cnt+1);
		if(div < op[3])
			solve(result/A[cnt], plus, minus, mul, div+1, cnt+1);
	}
	
	
}
