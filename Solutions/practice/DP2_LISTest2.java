package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_LISTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];	// 모든 원소의 값은 다르다.
		int[] LIS = new int[N]; // 해당 길이를 증가수열 중 맨 끝을 최소값으로 유지
								// 길이가 1일 때, 가장 끝에 오는 놈
								// 길이가 2일 때, 가장 끝에 오는 놈 ..
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();	
		}
		
		int size = 0; // LIS에 채워진 원소 수
		for(int i = 0; i < N; i++) {
			// 내가 어디 들어가야 하는지 구하기
			// 중복 값이 없으므로 탐색은 실패한다. -> 음수값 리턴 -> 삽입 위치로 환산
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
			LIS[temp] = arr[i];
			
			// 추가된 위치가 맨 뒤라면 사이즈 증가
			if(temp == size) size++;
		}
		System.out.println(size);
		sc.close();
	}

}
