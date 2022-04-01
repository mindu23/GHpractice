package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845_큐 {
	static int[] queue = new int[10000];
	static int front = 0;
	static int rear = 0;
	
	private static void push(int x) {
		queue[rear] = x;
		rear++;
	}
	
	private static int pop() {
		if(empty()==1) return -1;
		return queue[front++];
	}
	
	private static int size() {
		return (rear-1)-front+1;
	}
	
	private static int empty() {
		return front==rear?1:0;
	}
	
	private static int front() {
		if(empty()==1) return -1;
		return queue[front];
	}
	
	private static int back() {
		if(empty()==1) return -1;
		return queue[rear-1];
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
			case "front":
				result = front();
				break;
			case "back":
				result = back();
				break;
			}
			if(result != -2)
				System.out.println(result);
		}

	}

}
