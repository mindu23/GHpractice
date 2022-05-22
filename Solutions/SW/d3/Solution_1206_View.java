package com.SW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	왼쪽, 오른쪽 둘다 2이상의 거리가 확보된 조망권이 있는 아파트의 칸 개수를 구하자
	가로 길이 N
	총 N개의 아파트 높이가 주어진다.
	양쪽으로 두번씩 자기보다 낮은지 확인한다.
 */

public class Solution_1206_View {

	static int N;
	static int[] apt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			apt = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				apt[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println("print");
		}
		
	}
}
