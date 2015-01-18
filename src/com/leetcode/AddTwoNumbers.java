package com.leetcode;

public class AddTwoNumbers {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	int bit = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = l1.getValue() + l2.getValue();
		if(sum + bit > 9){
			l1.setValue(sum + bit -10);
			bit = 1;
		}else{
			l1.setValue(sum + bit);
			bit = 0;
		}
		if(l2.getNext() == null){
			return l1;
		}
		if(l1.getNext() == null){
			l1.setNext(l2.getNext());
			return l1;
		}
		return addTwoNumbers(l1.getNext(), l2.getNext());
	}
	
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		
		int sum = l1.getValue() + l2.getValue();
		ListNode next1 = l1.getNext();
		ListNode next2 = l2.getNext();
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode result = a.new ListNode(0);
		ListNode temp = result;
		int bit = 0;
		
		if(sum + bit > 9){
			result.setValue(sum + bit -10);
			bit = 1;
		}else{
			result.setValue(sum + bit);
			bit = 0;
		}
		while(next1 != null){			
			if(next2 == null){
				result.setNext(next1);
				return result;
			}
			
			sum = next1.getValue() + next2.getValue();
			if(sum + bit > 9){
				next1.setValue(sum + bit -10);
				bit = 1;
			}else{
				next1.setValue(sum + bit);
				bit = 0;
			}
			result.setNext(next1);
			result = next1;
			next1 = next1.getNext();
			next2 = next2.getNext();
		}
		
		if(next2 != null){			
			result.setNext(next2);
		}
		return temp;
	}

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
		
		public ListNode getNext(){
			return next;
		}
		
		public void setNext(ListNode next){
			this.next = next;
		}
		
		public int getValue(){
			return val;
		}
		
		public void setValue(int value){
			this.val = value;
		}
	}
	
	public static void main(String[] args){
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l1 = a.new ListNode(6);
		ListNode la = a.new ListNode(4);
		ListNode lb = a.new ListNode(3);
		l1.setNext(la);
		la.setNext(lb);
		
		ListNode l2 = a.new ListNode(5);
		ListNode lc = a.new ListNode(6);
		ListNode ld = a.new ListNode(4);
		ListNode le = a.new ListNode(5);
		l2.setNext(lc);
		lc.setNext(ld);
		ld.setNext(le);
		
		ListNode result = a.addTwoNumbers1(l1, l2);
		
		ListNode temp = result; 
		while(temp != null){
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}
}