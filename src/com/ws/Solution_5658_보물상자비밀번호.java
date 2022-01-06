package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
	각 변에 16진수가 적힌 보물상자
	보물 상자의 뚜껑은 시계방향으로 돌릴 수 있고, 한 번 돌리면 숫자가 시계방향으로 한칸씩 회전
	각 변에는 동일한 개수의 숫자, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸다.
	
	1A3, B54, 8F9, D66
	61A, 3B5, 48F, 9D6
	자물쇠 -> 보물상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진수로 나타낸 수
	N개의 숫자가 입력으로 주어질 때, 비밀번호를 출력해라
 */
public class Solution_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N, n, K;
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			n = N/4;
			
			LinkedList<Character> dq = new LinkedList<>();
			char[] c = br.readLine().toCharArray();
			for(int i = 0; i < N; i++) {
				dq.offerLast(c[i]);
			}
			
			LinkedList<Integer> list = new LinkedList<>();
						
			for(int i = 0; i < n; i++) { // 총 N/4번 돌면 원상복구
				for(int j = 0; j < dq.size(); j += n) {
					String s = "";
					for(int k = j; k < j+n; k++) {
						s+= dq.get(k);
					}
//					System.out.println(s);
					int num = Integer.parseInt(s, 16);
					boolean same = false;
					for(int k = 0; k < list.size(); k++) {
						if(list.get(k) == num) {
							same = true;
						}
					}
					if(!same) {
						list.add(num);
					}
				}
				char one = dq.pollLast();
				dq.offerFirst(one);
			}
			
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
//			System.out.println(list.toString());
			System.out.println("#"+t+" "+list.get(K-1));
		}

	}

}
