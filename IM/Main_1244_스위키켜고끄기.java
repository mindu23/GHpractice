package com.IM;
/*
	1 ON 0 OFF
	1남학생은 num의 배수마다 switch
	2여학생은 num을 중심으로 좌우 대칭인 구간 찾아 switch
 */
import java.util.Scanner;

public class Main_1244_스위키켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] S = new int[N+1]; //1부터 시작
		for(int i = 1; i <= N; i++) {
			S[i] = sc.nextInt();
		}
		int studentNum = sc.nextInt();
		for(int i = 0; i < studentNum; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			int j;
			switch(gender) {
			case 1://남학생
				j = 1;
				while(num*j <= N) {
					S[num*j] = S[num*j]==0?1:0;
					j++;
				}
				break;
			case 2: //여학생
				j = 0;
				while(true) {
					int l = num-j;
					int r = num+j;
					
					if(l <= 0 || r > N) break; //범위 밖이면 끝
					
					if(S[l] == S[r]) {
						S[l] = S[r] = S[l]==0?1:0;
					}else break;
					j++;
				}
				break;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(S[i]+ " ");
			if(i%20==0) System.out.println();
		}
		sc.close();
	}

}
