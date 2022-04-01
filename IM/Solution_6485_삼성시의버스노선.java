package com.IM;
/*
	1부터 5000까지의 버스 정류장 번호
	노선은 N개
	i번째 버스 노선은 번호가 Ai이상 Bi이하인 모든 정류장만을 다니는 버스 노선이다.
	
	p개의 버스 정류장에 대해 각 정류장에 몇개의 버스 노선이 다니는지 구하자
 */

import java.util.Scanner;

public class Solution_6485_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for( int t = 1; t <= T; t++ ) {
			int N = sc.nextInt();
			
			int[] busStop = new int[5001]; //총 버스 정류장
			for(int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				for(int j = start; j <= end; j++) {
					busStop[j]++;
				}
			}
			
			int P = sc.nextInt();
			int[] result = new int[P];
			for(int i = 0; i < P; i++) {
				int b = sc.nextInt();
				result[i] = busStop[b];
			}

			System.out.print("#"+t+" ");
			for(int i = 0; i < P; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
