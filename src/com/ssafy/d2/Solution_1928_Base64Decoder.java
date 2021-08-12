package com.ssafy.d2;
/**
	1. tc의 개수
	2. 문자열 입력. 문자열의 길이는 4의 배수. 
	3. 문자열을 decoding하여 원문 출력
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1928_Base64Decoder {

	static byte[] buffer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1928.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			buffer = new byte[3];
			
		}

		
	}

}
