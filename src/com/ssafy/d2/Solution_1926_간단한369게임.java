package com.ssafy.d2;

import java.util.Scanner;

public class Solution_1926_간단한369게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			
			play(i);
		}
	}
	
	private static void play(int i) {
		String str = Integer.toString(i);
		char[] c = str.toCharArray();
		
		int k = isthree(c);
		
		if(k == 0) {
			System.out.print(i+" ");
		}else {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < k; j++) {
				sb.append("-");
			}
			
			System.out.print(sb +" ");
		}

	}
	
	private static int isthree(char[] c) {
		int k = 0;
		for(int j = 0; j < c.length; j++) {
			if("369".contains(Character.toString(c[j]))) {
				k++;
			}
		}
		
		return k;
	}
}
