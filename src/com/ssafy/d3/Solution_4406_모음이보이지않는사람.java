package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;

public class Solution_4406_모음이보이지않는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("3\r\n" + 
				"congratulation\r\n" + 
				"synthetic\r\n" + 
				"fluid"));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			LinkedList<Character> list = new LinkedList<>();
			list.clear();
			
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}//setting
			
			for(int i = list.size()-1; i >= 0; i--) {
				if("aeiou".contains(String.valueOf(list.get(i)))) {
					list.remove(i);
				}
			}
			
			System.out.print("#"+t+" ");
			for(char a : list) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}
