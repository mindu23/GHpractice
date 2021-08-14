package com.ssafy.d2;
/**
	StringBuilder로 이어 붙이고 10씩 출력
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1946_간단한압축풀기 {

	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1946.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuffer();
			for(int n = 0; n < N; n++) {
				String[] str = br.readLine().split(" ");
				char c = str[0].charAt(0);
				int k = Integer.parseInt(str[1]);
				
				append(c, k);
				
			}
			System.out.println("#"+t);
			print();
			
		}
		
	}
	
	private static void print() {
		for(int i = 0; i < sb.length(); i++) {
			System.out.print(sb.charAt(i));
			if(i != 0 && i%10 == 9) System.out.println();
		}
		System.out.println();
	}
	
	private static void append(char c, int k) {
		for(int i = 0; i < k; i++) {
			sb.append(c);
		}
	}

}
