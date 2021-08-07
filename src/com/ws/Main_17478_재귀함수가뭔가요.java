package com.ws;

import java.util.Scanner;

public class Main_17478_재귀함수가뭔가요 {

	static StringBuffer sb = new StringBuffer("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chatbot(T);
		
	}
	
	private static void under1() {
		sb.append("____");
	}

	private static void under2() {
		sb.delete(0,4);
	}
	
	private static void chatbot(int T) {
		
		System.out.printf(sb+"\"재귀함수가 뭔가요?\"\n");
		if(T == 0) {
			System.out.printf(sb+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			System.out.printf(sb+"라고 답변하였지.\n");
			return ;
		}
		System.out.printf(sb+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		System.out.printf(sb+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		System.out.printf(sb+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		under1();
		chatbot(T-1);
		under2();
		System.out.printf(sb+"라고 답변하였지.\n");
	}

}
