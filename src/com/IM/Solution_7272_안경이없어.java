package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	알파벳 배문자로이루어진 두 문자열을 비교하자.
	문자열을 문자 단위로 구별할 수는 있지만, 정확히 같은 지는 알지 못한다.
	문자에 나 있는 구멍의 개수가 같으면 같은 문자. 다르면 다른 문자
	구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ는 같은 문자
	구멍이 하나인 ADOPQR
	구멍이 두 개인 B
	경근이의 판별을 맞춰보자 
 */
public class Solution_7272_안경이없어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		outer : for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			if(str[0].length() != str[1].length()) {
				System.out.println("#"+t+" "+"DIFF");
				continue;
			}
			
			for(int i = 0; i < str[0].length(); i++) {
				if("CEFGHIJKLMNSTUVWXYZ".contains(Character.toString(str[0].charAt(i)))
						&& "CEFGHIJKLMNSTUVWXYZ".contains(Character.toString(str[1].charAt(i)))){
					//같은 문자라고 생각
					continue;
				}else if("ADOPQR".contains(Character.toString(str[0].charAt(i))) 
						&& "ADOPQR".contains(Character.toString(str[1].charAt(i)))) {
					continue;
				}else {
					if(str[0].charAt(i) == 'B' && str[1].charAt(i) == 'B' ) continue;
					
					System.out.println("#"+t+" "+"DIFF");
					continue outer;
				}
			}
			System.out.println("#"+t+" "+"SAME");
		}
	}

}
