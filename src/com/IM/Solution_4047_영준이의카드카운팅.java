package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	1~13의 숫자가 적힌 카드 * 4 = 52장
	몇장의 카드를 이미 가지고 있는데, 게임을 위해서 몇 장의 카드가 더 필요한가?
	이미 겹치는 카드를 가지고 있다면 오류 출력
 */
public class Solution_4047_영준이의카드카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		outer : for(int t = 1; t <= T; t++) {
			boolean[] cards = new boolean[53];
			char[] input = br.readLine().toCharArray();
			
			for(int i = 0; i < input.length; i+=3) {
				int num = 0;
				switch(input[i]) {
				case 'S':
					num = (input[i+1]-'0')*10 + input[i+2]-'0';
					num += 13*0;
					break;
				case 'D':
					num = (input[i+1]-'0')*10 + input[i+2]-'0';
					num += 13*1;
					break;
				case 'H':
					num = (input[i+1]-'0')*10 + input[i+2]-'0';
					num += 13*2;
					break;
				case 'C':
					num = (input[i+1]-'0')*10 + input[i+2]-'0';
					num += 13*3;
					break;
				}
				if(cards[num]) {
					System.out.println("#"+t+" ERROR");
					continue outer;
				}
				cards[num] = true;
				
			}
			System.out.print("#"+t+" ");
			for(int i = 0; i < 4; i++) {
				int cnt = 0;
				for(int j = i*13+1; j <= (i+1)*13; j++) {
					if(!cards[j]) cnt++;
				}
				System.out.print(cnt+" ");
			}
			System.out.println();
		}
		
	}

}
