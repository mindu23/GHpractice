package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {

	static Stack<Character> stack;
	static char[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: for(int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			stack.clear();
			
			input = new char[len];
			input = br.readLine().toCharArray();

			for(char c : input) {
				if("[{(<".contains(String.valueOf(c))) {
					stack.push(c);
					continue;
				}
				//닫는 괄호일 경우, 스택이 비어있거나 인덱스가 다르면 0
				if(stack.isEmpty() || "]})>".indexOf(c) != "[{(<".indexOf(stack.pop())) {
					System.out.println("#"+t+" "+0);
					continue outer;
				}
				
			}
			//끝났는데 스택이 비어있지 않은 경우
			if(!stack.isEmpty()) {
				System.out.println("#"+t+" "+0);
				continue outer;
			}else {
				System.out.println("#"+t+" "+1);
				continue outer;
			}
		}
	}
}
