package com.IM;

import java.util.Scanner;

/**
	10개의 버섯이 일렬로 놓여져 있다.
	버섯을 나온 순서대로 집으려고한다.
	중간에 먹는 것을 중단하면 그 이후에는 먹을 수 없다.
	마리오는 받은 점수의 함을 최대한 100에 가깝게 만들려고한다.

 */
public class Main_2851_슈퍼마리오 {

	static int[] mushroom = new int[10];
	static boolean[] sel = new boolean[10];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		
		int score = 0;
		for(int i = 0; i < 10; i++) {
			score += mushroom[i];
			if(Math.abs(ans-100) == Math.abs(score-100)) {
				ans = Math.max(ans, score);
			}
			if(Math.abs(ans-100) > Math.abs(score-100)) {
				ans = score;
			}
			if(score > 100) break;
		}
		System.out.println(ans);
	}

}
