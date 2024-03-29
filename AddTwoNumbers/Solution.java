package twosum;

import util.ListNode;


public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(0);
		ListNode current = dummy; ListNode p = l1, q = l2;
		int carry = 0;
		while(p!=null || q!=null){
			int x = p!=null? p.val:0;
			int y = q!=null? q.val:0;
			int sum = carry + x + y;
			carry = sum/10;
			current.next = new ListNode(sum%10);
			current = current.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(carry > 0){
			current.next = new ListNode(carry);
		}
		
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2); l1.next = new ListNode(4); l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5); l2.next = new ListNode(6); l2.next.next = new ListNode(4);
		System.out.println(new Solution().addTwoNumbers(l1, l2));
	}
}
