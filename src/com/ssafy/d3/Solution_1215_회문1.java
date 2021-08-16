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

	static int len, wordLen, ans;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	static char[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			arr = new char[8][8];
			for(int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			//한 곳에 방문
			//갈수 있는 한 방향으로 len만큼 진행
			//회문 검사 맞다면 ans++
			//다른 곳 방문해서 반복
			
			ans = 0;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					wordLen = 0;
					search(i, j);
				}
			}
			System.out.println("#"+t+" "+ ans/2);
		}
	}
	
	private static void search(int i, int j) {
		int dir = 0;
		int nr = i, nc = j;
		StringBuffer sb = new StringBuffer();
		sb.append(arr[i][j]); 
		while(true) {
			if(dir == 4) return;
			nr = nr + dr[dir];
			nc = nc + dc[dir];
			
			if(nr < 8 && nr >= 0 && nc < 8 && nc >= 0) { //범위 내면 실행 아니면 다음 방향 탐색
				sb.append(arr[nr][nc]);
				wordLen++;
				
				if(wordLen == len-1) {
//					System.out.println("--------");
//					System.out.println(sb);
					palindrome(sb);//회문 검사 후, 다음 방향 탐색하기
					sb.setLength(1); // 첫번째만 남겨두자
					wordLen = 0;
				}else continue;
			}
			sb.setLength(1); // 첫번째만 남겨두자
			wordLen = 0;
			dir++; //방향이 바뀌면 처음 위치에서 다시 시작해야한다.
			nr = i;
			nc = j;
			continue;
		}
	}
	
	private static void palindrome(StringBuffer sb) {
		String str = sb.reverse().toString();
		String str1 = sb.reverse().toString();
		if(str.equals(str1)) {
//			System.out.println("--------");
//			System.out.println(str);
//			System.out.println(str1);
			ans++;
		}
	}

}
