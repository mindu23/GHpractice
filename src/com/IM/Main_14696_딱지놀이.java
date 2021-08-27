package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	별 > 동그라미 > 네모 > 세모
	4 > 3 > 2 > 1
	
	총 N라운드
	a, b
 */
public class Main_14696_딱지놀이 {

	static int N, aCnt, bCnt;
	static int[][] cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			cnt = new int[5][2]; //a b
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			aCnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < aCnt; j++) {
				cnt[Integer.parseInt(st.nextToken())][0]++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			bCnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < bCnt; j++) {
				cnt[Integer.parseInt(st.nextToken())][1]++;
			}
			game();
		}

	}

	private static void game() {
		for(int i = 4; i >= 1; i--) {
			if(cnt[i][0] > cnt[i][1]) {
				System.out.println("A");
				return ;
			}else if(cnt[i][0] < cnt[i][1]) {
				System.out.println("B");
				return ;
			}
		}
		System.out.println("D");
	}
}
