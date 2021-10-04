package com.practice;

import java.util.Arrays;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] arr = {10,4,6,20,35,7};
		Arrays.sort(arr);
		System.out.println(binarySerch(arr, 6));
		System.out.println(binarySerch(arr, 35));
		System.out.println(binarySerch(arr, 50));
	}

	private static int binarySerch(int[] arr, int i) {
		int start = 0, end = arr.length-1;
		while(start <= end) {
			int half = (start + end)/2;
			if(arr[half] == i) return half;
			else if(i < arr[half]) 
				end = half-1;
			else if(i > arr[half])
				start = half+1;
		}
		return -1;
	}
}

