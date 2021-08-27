package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
	문자열 S에서 단어만 뒤집자
	태그는 단어가 아니다.
	단어는 공백으로 구분된다.
	단어와 태그사이에는 공백이 없다.
 */

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		boolean isTag = false;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				isTag = true;
				sb.append(input[i]);
			}else if(input[i] == '>') {
				isTag = false;
				sb.append(input[i]);
			}else if(input[i] == ' '){ 
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(input[i]);
			}else {
				if(isTag) {
					sb.append(input[i]);
				}else {//단어다
					stack.push(input[i]);
				}
			}
			
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
		
	}

}
