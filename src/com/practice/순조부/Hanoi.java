package com.practice.순조부;

public class Hanoi {

	
	//source temp dest
	public static void main(String[] args) {
		
		//원판 3개
		int N = 3;
		hanoi(N, 1, 2, 3);
		
	}
	
	private static void hanoi(int N, int start, int temp, int dest) {
		
		if(N == 0) return;

		// 자신의 위쪽의 n-1개의 원판 들어내기 : temp
		hanoi(N-1, start, dest, temp);
		// 자신의 원판 넘기기 : dest;
		System.out.println(N + ":"+start+">"+dest);
		// 들어냈던 n-1개의 원판 dest위에 쌓기
		hanoi(N-1, temp, start, dest);
	}

}
