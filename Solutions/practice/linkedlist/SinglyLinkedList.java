package com.practice.linkedlist;

import com.sun.jndi.cosnaming.IiopUrl.Address;

public class SinglyLinkedList {

	private Node head; // 첫번째 노드

	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	//마지막 노드 찾기
	public Node getLastNode() {
		for(Node current = head; current != null; current = current.link) {
			if(current.link == null) {
				return current;
			}
		}
		return null;
	}
	
	public void addLastNode(String data) {
		if(head == null) {
			addFirstNode(data);
		}else {
			Node lastNode = getLastNode();
			Node newNode = new Node(data);
			lastNode.link = newNode;
		}
	}
	
	public void insertAfterNode(Node preNode, String data) {
		if(preNode == null) {
			addFirstNode(data);
			return ;
		}
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	
	// data를 갖는 처음 노드
	public Node getNode(String data) {
		for(Node current = head; current != null; current = current.link) {
			if(current.data == data) {
				return current;
			}
		}
		return null;
	}

	// target의 이전 노드 찾기
	public Node getPreviousNode(Node target) {
		for(Node current = head; current != null; current = current.link) {
			if(current.link == target) {
				return current;
			}
		}
		return null;
	}
	
	// data를 가지는 노드 삭제
	public void deleteNode(String data) {
		
		Node targetNode = getNode(data);
		if(targetNode == null) {
			System.out.println("삭제할 노드 없음");
			return ;
		}
		
		Node preNode = getPreviousNode(targetNode);
		if(preNode == null) {
			head = targetNode.link;
		}else {
			preNode.link = targetNode.link;
		}
		targetNode.link = null;
	}
}
