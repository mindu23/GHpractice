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

		for(int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			stack.clear();
			
			input = new char[len];
			input = br.readLine().toCharArray();
			int result = check();
			
			System.out.println("#"+t+" "+result);
		}

	}
	
	//만약 
	private static int check() {
		for(int i = 0; i < input.length; i++) {
			if("({[<".contains(String.valueOf(input[i]))) {
				stack.add(input[i]);
			}else {//닫는 것
				if("({[<".indexOf(input[i]) == ")}]>".indexOf(stack.peek())) { //넣을 거랑 top에 있는게 같으면 ok
					stack.pop();
				}else return 0;
			}
			if(stack.isEmpty()) return 0;
		}
		return 1;
	}

}
