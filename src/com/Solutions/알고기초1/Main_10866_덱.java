package com.Solutions.알고기초1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 LinkedList<Integer> dq = new LinkedList<>();
		 StringBuilder sb = new StringBuilder();
		 
		 for(int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 String command = st.nextToken();
			 int num;
			 switch(command) {
			 case "push_back":
				 num = Integer.parseInt(st.nextToken());
				 dq.offerLast(num);
				 break;
			 case "push_front":
				 num = Integer.parseInt(st.nextToken());
				 dq.offerFirst(num);
				 break;
			 case "pop_back":
				 if(dq.isEmpty()) {
					 sb.append("-1\n");
				 }else {
					 sb.append(dq.pollLast()+"\n");					 
				 }
				 break;
			 case "pop_front":
				 if(dq.isEmpty()) {
					 sb.append("-1\n");
				 }else {
					 sb.append(dq.pollFirst()+"\n");
				 }
				 break;
			 case "size":
				 sb.append(dq.size()+"\n");
				 break;
			 case "empty":
				 if(dq.isEmpty()) {
					 sb.append("1\n");
				 }else {
					 sb.append("0\n");
				 }
				 break;
			 case "front":
				 if(dq.isEmpty()) {
					 sb.append("-1\n");
				 }else {
					 sb.append(dq.peekFirst()+"\n");
				 }
				 break;
			 case "back":
				 if(dq.isEmpty()) {
					 sb.append("-1\n");
				 }else {
					 sb.append(dq.peekLast()+"\n");
				 }
				 break;
			 }
		 }
		 System.out.println(sb.toString());
	}

}
