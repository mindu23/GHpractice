package com.Solutions;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] values = {3,11,15,20,21,45};
		
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 45));
		System.out.println(Arrays.binarySearch(values, 11));
		System.out.println(Arrays.binarySearch(values, 30)); // -6 : 음수는 찾지 못함. (-1)*결과 - 1
		System.out.println(Arrays.binarySearch(values, 1)); // -1
		System.out.println(Arrays.binarySearch(values, 50)); // -7

//		즉 없는 값을 얻으려면 -(들어갈 인덱스 num)-1 이다.
//		즉 30은 5번째 index에 들어가고 이는 -1 * 5 - 1 = -6
		System.out.println(Arrays.binarySearch(values, 1, 4, 45));
	}

}
