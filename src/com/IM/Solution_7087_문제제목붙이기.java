package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	N개의 제목을 만들었다.
	자영은 제목의 앞글자에 A부터 Z가 순서대로 한번씩 등장
	만약 도중 특정 알파벳이 맨 앞 글자로 설정되지 않으면 그 이후의 알파벳 사용X
	Air, Dad, Ear, Blue, Ace -> C가 없으므로 총 제목 2개
 */
public class Solution_7087_문제제목붙이기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println('Z'-'A');
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] input = new char[N];
			for(int i = 0; i < N; i++) {
				input[i] = br.readLine().charAt(0);
			}
			//A = 65
			boolean[] count = new boolean[26];
			for(int i = 0; i < N; i++) {
				count[input[i]-'A'] = true;
			}
			
			int cnt = 0;
			for(int i = 0; i < 26; i++) {
				if(count[i]) cnt++;
				else break;
			}
			System.out.println("#"+t+" "+cnt);
		}
		
	}

}
