package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		String[] sArr = br.readLine().split("");
		for(String s: sArr) {
			left.push(s);
		}
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			String x = null;
			if(st.hasMoreTokens()) {
				x = st.nextToken();
			}

			switch(command) {
			case "L":
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case "D":
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case "B":
				if(!left.isEmpty()) left.pop();
				break;
			case "P":
				left.push(x);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb.toString());
	}

}
