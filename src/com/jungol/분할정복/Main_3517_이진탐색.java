package com.jungol.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3517_이진탐색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			sb.append(binarySearch(a, 0, N-1, Integer.parseInt(st.nextToken()))+" ");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int binarySearch(int[] a, int start, int end, int target) {
		int mid;
		while(start <= end) {
			mid = (start + end)/2;
			if(a[mid] == target) {
				return mid;
			}else if(a[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return -1;
	}

}
