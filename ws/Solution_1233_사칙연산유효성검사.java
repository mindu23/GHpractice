package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_사칙연산유효성검사 {

	static int ans;
	static String[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new String[N+1];
			ans = 1;
			for(int i = 1 ; i <= N; i++) {
				String[] str = br.readLine().split(" ");
				int cur = Integer.parseInt(str[0]); //position
				input[cur] = str[1];
				
				//내가 연산자가 아니라면 즉 내가 숫자라면
				//내 부모가 없거나 내 부모가 연산자가 아니라면 false
				if(!"+-*/".contains(input[cur] )) {
					if(cur/2 > 0 && !"+-*/".contains(input[cur/2])) {
						ans = 0;
					}
				}
				
				//자식의 입장에서 leaf들만 숫자고 나머지는 숫자가 아니어야 한다.
				//내가 자식이라면 내 부모는 연산자여야 한다. 그리고 부모가 있는지 확인해야한다.
				//내가 자식이라는 전제하므로 cur/2가 0보다 커야한다. 즉 root까지만
				
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
