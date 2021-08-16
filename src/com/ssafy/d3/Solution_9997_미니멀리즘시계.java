package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9997_미니멀리즘시계 {

	static int H,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_9997.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int angle = Integer.parseInt(br.readLine());
			int H = Hour(angle);
			int M = Minute(angle);
			
			System.out.println("#"+t+" "+H+" "+M);
		}
	}
	
	private static int Minute(int angle) {
		return (angle * 12 /6)%60;
	}
	
	private static int Hour(int angle) {
		return (angle / 30)%30;
		
	}

}
