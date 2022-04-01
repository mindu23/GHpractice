package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	// 배열을 활용하자.
	static int[] stack = new int[10000];
	static int top = -1;
	
	private static void push(int x) {
		stack[++top] = x;
	}
	
	private static int pop() {
		if(empty()==1) return -1;
		int result = stack[top--];
		return result;
	}
	
	private static int size() {
		return top+1;
	}
	
	private static int empty() {
		return top==-1?1:0;
	}
	
	private static int top() {
		if(top == -1) return -1;
		return stack[top];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = null;
			int x = -1;
			command = st.nextToken();
			if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
			int result = -2;
			switch(command) {
			case "push":
				push(x);
				break;
			case "pop":
				result = pop();
				break;
			case "size":
				result = size();
				break;
			case "empty":
				result = empty();
				break;
			case "top":
				result = top();
				break;
			}
			if(result != -2)
				System.out.println(result);
		}

	}

}
