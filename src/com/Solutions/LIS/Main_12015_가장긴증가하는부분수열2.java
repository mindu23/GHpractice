package com.Solutions.LIS;

import java.util.Arrays;
import java.util.Scanner;

public class Main_12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		for(int i = 0; i < N; i++) {
			LIS[i] = 1;
			
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]));
			//같은 값일 경우 해당 LIS[temp]에 넣어준다.
			if(temp >= 0 && temp < size) {
				temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]));
				LIS[temp] = arr[i];
			}else {
				temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
				LIS[temp] = arr[i];
			}
			if(size == temp) ++size;
		}
		
		System.out.println(size);
		
	}

}
