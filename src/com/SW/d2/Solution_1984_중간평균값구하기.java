package com.SW.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;


/**
	10개의 수 입력 받아 최대, 최소 수를 제외한 나머지의 평균값 출력
 */
public class Solution_1984_중간평균값구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("10\r\n" + 
				"3 17 1 39 8 41 2 32 99 2\r\n" + 
				"22 8 5 123 7 2 63 7 3 46\r\n" + 
				"6 63 2 3 58 76 21 33 8 1\r\n" + 
				"345 37 2375 23 32 132 47 76 26 12\r\n" + 
				"765 26 346 16 263 36 61 569 35 70\r\n" + 
				"912 923 7456 879 8237 864 1170 6893 34 9\r\n" + 
				"934 73 456 3 47 32 74 18 23 345 \r\n" + 
				"72 812 73 384 23 76 54 94 556 834\r\n" + 
				"87 51 438 126 48 13 834 162 805 21\r\n" + 
				"213 21 45 87 476 59 98 325 900 11"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			ArrayList<Integer> input = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				input.add(Integer.parseInt(str[i]));
			}//setting
			input.sort((o1,o2)-> o1 - o2);
			
			input.remove(9);
			input.remove(0);
			
			int sum = 0;
			double ave = 0;
			for(int i = 0; i < input.size(); i++) {
				sum += input.get(i);
			}
			ave = Math.round((double)sum / input.size());
			
			System.out.println("#"+t+ " "+(int)ave);
		}
		
	}

}
