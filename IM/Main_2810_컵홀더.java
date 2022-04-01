package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	극장 한 줄에는 자리가 N개 서로 인접한 좌석 사이에는 컵홀더가 하나씩 있다.
	양끝 좌석에는 컵 홀더가 하나씩 더 있다. 커플석 사이에는 컵홀더가 없다.
	한 줄에 모든 사람들이 앉았을 때, 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수.
	모든 사람은 컵을 한개만 들고있고, 양옆 홀더에만 꽂을 수 있다.
	S는 일반좌석 LL은 커플석
 */
public class Main_2810_컵홀더 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] seat = br.readLine().toCharArray();
		int holderCnt = 0;
		holderCnt++;
		boolean iscouple = true;
		for(int i = 0; i < N; i++) {
			if(seat[i] == 'S') holderCnt++;
			if(iscouple && seat[i] == 'L') {
				iscouple = false;
			}else if(!iscouple && seat[i] == 'L') {
				holderCnt++;
				iscouple = true;
			}
		}
		
		System.out.println((holderCnt>N)?N:holderCnt);
	}

}
