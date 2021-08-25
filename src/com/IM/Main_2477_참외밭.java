package com.IM;

import java.util.Scanner;

public class Main_2477_참외밭 {

	static int K, ans;
	static int[][] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		num = new int[6][2];
		//h,w 찾기
		int maxH = 0;
		int maxHIdx = 0;
		int maxW = 0;
		int maxWIdx = 0;
		int sWIdx = 0;
		int sHIdx = 0;
		
		for(int i = 0; i < 6; i++) {
			num[i][0] = sc.nextInt();
			num[i][1] = sc.nextInt();
			
			//가장 큰 width와 height 구하자.
			if(num[i][0] == 1 || num[i][0] == 2 ) {
				if(maxW < num[i][1]) {
					maxW = num[i][1];
					maxWIdx = i;
				}
			}else {
				if(maxH < num[i][1]) {
					maxH = num[i][1];
					maxHIdx = i;
				}
			} 
		}
		
		//작은 사각형을 빼야하므로 small width와 small height를 구하자.
		//만약 긴 가로가 먼저 나오고 다음에 긴 세로가 나온다면
		if(maxHIdx+1 == maxWIdx || maxWIdx == 0 && maxHIdx == 5) {
			sWIdx = (maxWIdx+2)%6;
			sHIdx = (maxHIdx+4)%6;
		}else { // 긴 세로가 먼저 나오고 긴 가로가 나온다면.
			sWIdx = (maxWIdx+4)%6;
			sHIdx = (maxHIdx+2)%6;
		}
		
		ans = K * (num[maxHIdx][1] * num[maxWIdx][1] - num[sWIdx][1] * num[sHIdx][1]);
		System.out.println(ans);
	}
}
