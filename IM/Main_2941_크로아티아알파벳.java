package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	c / l / n/ s/ z나오면 뒤에 글자까지 두글자 확인
	d나오면 2글자 확인 뒤가 z면 세글자까지
 */
public class Main_2941_크로아티아알파벳 {

	static String input;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		int cnt = 0;
		
		String[] croatia = new String[] {"c=", "c-", "dz=", "d-","lj","nj","s=","z="};
		
		for(int i = 0; i < croatia.length; i++) {
			if(input.contains(croatia[i])) {
				input = input.replace(croatia[i], "0");
			}
		}
		System.out.println(input.length());
	}

}
