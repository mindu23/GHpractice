package com.SW.d3;
/**
	주어진 장애물에서 올라갈 때의 높이 변화와 내려갈 때의 높이 변화 중
	가장 높이 변화가 심한 부분을 난이도라고 하자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_6730_장애물경주난이도 {

	static int[] input;
	static int upMax, downMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("5\r\n" + 
				"5\r\n" + 
				"10 70 30 50 90\r\n" + 
				"2\r\n" + 
				"30 100\r\n" + 
				"2\r\n" + 
				"100 20\r\n" + 
				"3\r\n" + 
				"40 40 40\r\n" + 
				"7\r\n" + 
				"12 345 678 901 23 45 6"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			input = new int[N];
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(str[i]);
			}//setting
			
			upMax = 0;
			downMax = 0;
			int be = input[0];
			for(int i = 1; i < N; i++) {
				if(be > input[i]) { //내려감
					downMax = Math.max(downMax, be-input[i]);
				}else if (be < input[i]) {
					upMax = Math.max(upMax, input[i]-be);
				}
				be = input[i];
			}
			
			System.out.println("#"+t+" "+ upMax + " "+ downMax);
		}

	}

}
