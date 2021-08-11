package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
	길이 N을 오름차순 정렬
 */

public class Solution_1966_숫자를정렬하자 {
	
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. tc 반복
		//2. N 입력
		//3. N개의 수 입력 -> 오름차순 정렬
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			Arrays.sort(arr);
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i]+" ");				
			}
			System.out.println();
		}
		
	}
}
