package com.IM;

import java.util.Scanner;

/**
	1부터 시계방향으로 N까지 앉기
	1번부터 공을 던진다.
	한 사람이 공을 M번 받으면 게임이 끝난다.
	M번보다 적게 받은 사람이 공을 던질때, 
	현재 공을 받은 횟수가 홀수번이면 현재 위치에서 시계방향으로 L번째에 있는 사람에게
					짝수번이면 현재 위치에서 반시계방향으로 L번째에 있는 사람에게 공을 던진다.
 */
public class Main_1592_영식이와친구들 {

	static int[] player;
	static int N, M, L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		int cnt = 0;
		
		player = new int[N];
		int i = 0;
		while(true) {
//			System.out.println(i);
			player[i]++;
			if(player[i] == M) break;
			cnt++;
			if(player[i]%2 == 1) {
				i += L;
				i %= N;
			}else {
				if(i < L) {
					i = i+N-L;
				}else {
					i -= L;
				}
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
