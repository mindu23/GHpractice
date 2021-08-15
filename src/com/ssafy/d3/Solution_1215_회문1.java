package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
	2차원 배열에서 level과 같이 어디서 읽어도 같은 회문의 총 개수를 구하자
 */
public class Solution_1215_회문1 {

	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	static char[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			arr = new char[8][8];
			for(int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			//한 곳에 방문
			//갈수 있는 한 방향으로 len만큼 진행
			//회문 검사 맞다면 ans++
			//다른 곳 방문해서 반복
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					palindrome(i, j);
				}
			}
			
		}
	}
	
	private static void palindrome(int i, int j) {
		
	}

}
