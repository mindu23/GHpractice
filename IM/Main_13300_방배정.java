package com.IM;

import java.util.Scanner;

/**
	총 학생수 N
	성별끼리(남1 여0), 같은 학년끼리
	최대 인원수 K가 주어진다.
	모든 학생을 배정하기 위해 필요한 방의 최소 개수
	
	각 방에 한명씩 넣고 받은 값이 K를 넘어간다면.. 
 */

public class Main_13300_방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] s = new int[7][2]; //학년 성별
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			s[grade][gender]++;
		}//setting
		
		int ans = 0;
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 2; j++) {
				int m = s[i][j];
				if(m == 0) continue;
				
				if(s[i][j]%K == 0) ans += m/K;
				else ans += m/K + 1;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}
