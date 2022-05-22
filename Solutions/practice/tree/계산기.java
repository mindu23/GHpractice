package com.practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class 계산기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("6528-*2/+"));
		
		Stack<Integer> stack = new Stack<>();
		String str = br.readLine();
		for(int i = 0; i < "6528-*2/+".length(); i++) {
			char input = str.charAt(i);
			int a, b;
			if (Character.isDigit(input)) {
				stack.push(input - '0');
			}else {
				switch(input) {
				case '+':
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
				case '-':
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
				case '*':
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);
					break;
				case '/':
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
					break;
				}
			}
		}
		
		System.out.println(stack.pop());
		
	}

}
