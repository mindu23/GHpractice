package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1989_초심자의회문검사 {

	static char[] word;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			word = br.readLine().toCharArray();
			
			System.out.println("#"+t+" "+ palindrome());
		}
	}
	
	static private int palindrome() {
		for(int i = 0, j = word.length-1; i < word.length/2; i++, j--) {
			if(word[i] != word[j]) {
				return 0;
			}
		}
		return 1;
	}

}
