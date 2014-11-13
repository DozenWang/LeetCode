import java.util.BitSet;


public class CircleLinklist {

	// Definition for singly-linked list.
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		if(head.next == null) {
			return false;
		}
		ListNode ptr1 = head;
		ListNode ptr2 = head.next.next;

		while (ptr2 != null) {
			if(ptr1 == ptr2) {
				return true;
			}
			ptr1 = ptr1.next;
			if(ptr2.next == null) {
				return false;
			}
			ptr2 = ptr2.next.next;
		}
		return false;
	}

//	public static void main(String[] args) {
//		ListNode n1 = new ListNode(0);
//		ListNode n2 = new ListNode(1);
//		ListNode n3 = new ListNode(2);
//
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = null;
//
//		boolean ret = hasCycle(n1);
//		System.out.print(ret);
//
//	}

}
