package com.ws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 	스위치 번호는 1부터
	1. 남학생은 스위치 받은 수의 배수 
	2. 여학생은 받은 번호 좌우 대칭
 **/
public class Main_1244_스위키켜고끄기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src//inputFile//input_1244.txt"));
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int[] sInput = new int[cnt+1];
		for(int i = 1; i <= cnt; i++) {
			sInput[i] = sc.nextInt();
		}
		
		
		int studentCnt = sc.nextInt();
		for(int i = 0; i < studentCnt; i++) {
			int gender = sc.nextInt();
			int switchNum = sc.nextInt();
			
			switch(gender) {
			case 1:
				for(int n = switchNum; n <= cnt; n += switchNum) {
					sInput[n] = (sInput[n]%2==0)?1:0;
				}
				break;
			case 2: 
				sInput[switchNum] = (sInput[switchNum]%2==0)?1:0;
				int k = 1;
				while(true) {
					int l = switchNum-k;
					int r = switchNum+k;
					if(r > cnt || l < 1 )
						break;
					if(sInput[l] == sInput[r]) {
						sInput[l] = (sInput[r]%2==0)?1:0;
						sInput[r] = (sInput[r]%2==0)?1:0;
						k++;
					}else break;
				}
				break;
			}
		}
		for(int i = 1; i <= cnt; i++) {
			System.out.print(sInput[i]+" ");
			if(i % 20 == 0) System.out.println();
		}
		sc.close();
	}

}
