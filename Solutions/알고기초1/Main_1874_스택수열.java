package com.Solutions.알고기초1;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len+1];
		for(int i = 1; i <= len; i++) {
			arr[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int k = 1; // 넣을 수
		int[] arr2 = new int[len+1];
		for(int i = 1; i <= len; i++) {
			while(arr[i] >= k) {
				stack.push(k++);
				sb.append("+\n");
			}
			
			if(stack.peek() >= arr[i]) {
				int x = stack.pop();
				sb.append("-\n");
				arr2[i] = x;
				if(arr[i] != arr2[i]) {
					System.out.println("NO");
					return ;
				}
			}
		}
		System.out.println(sb.toString());

	}

}
