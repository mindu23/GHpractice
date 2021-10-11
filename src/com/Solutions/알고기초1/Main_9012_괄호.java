package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
	//stack을 사용하자, 짝이 맞지 않을때, 다끝나고 스택에 남아있을때

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] command = br.readLine().toCharArray();
			String result = solve(command);
			System.out.println(result);
		}
	}

	private static String solve(char[] command) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : command) {
			if(c == '(')
				stack.push(c);
			else {
				//아직 다 안뺏는데 남아있으면
				if(stack.isEmpty()) return "NO";
				char k = stack.pop();
				if(k == ')') return "NO";
			}
		}
		if(!stack.isEmpty()) return "NO";
		
		return "YES";
	}

}
