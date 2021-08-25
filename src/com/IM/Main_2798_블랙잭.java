package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
	카드의 합이 21을 넘지 않아야한다.
	정인, 상근, 창영
	각 카드에 양의 정수가 쓰여있다. N장의 카드를 모두 숫자가 보이도록 바닥에 둔다.
	딜러가 M을 말하면 제한된 시간안에 N장의 카드중에서 3장의 카드를 골라야한다.
	플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야한다.
	
	조합
 */
public class Main_2798_블랙잭 {
	
	static int[] sel, card;
	static boolean[] use;
	static int N, M, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}//setting
		use = new boolean[N];
		sel = new int[3];
		max = Integer.MIN_VALUE;
		comp(0,0,0);
		System.out.println(max);
	}
	
	private static void comp(int cnt, int start, int sum) {
		
		if(cnt == 3) {
			if(sum > M) {
				return ;
			}
			max = Math.max(max, sum);
			return ;
		}
		
		for(int i = start; i < N; i++) {
			if(use[i]) continue;
			sel[cnt] = card[i];
			use[i] = true;
			comp(cnt+1, start+1, sum+card[i]);
			use[i] = false;
		}
	}

}
