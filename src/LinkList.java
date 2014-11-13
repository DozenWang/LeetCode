public class LinkList {

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeList(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode pNode = null;
		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode head = null;
		if (p1.val < p2.val) {
			head = p1;
			p1 = p1.next;
		} else {
			head = p2;
			p2 = p2.next;
		}
		pNode = head;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				pNode.next = p1;
				p1 = p1.next;
			} else {
				pNode.next = p2;
				p2 = p2.next;
			}
			pNode = pNode.next;
		}
		if (p1 == null) {
			pNode.next = p2;
		} else if (p2 == null) {
			pNode.next = p1;
		}
		return head;
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode pNode = head;
		ListNode preNode = null;
		boolean swap = false;
		while (pNode != null) {
			if (preNode != null && !swap) {
				preNode.next = pNode.next;
				pNode.next = preNode;

				preNode = pNode;
				pNode = preNode.next;

				if (pNode == head) {
					head = preNode;
				}
				swap = true;
			} else {
				preNode = pNode;
				pNode = preNode.next;
				swap = false;
			}
		}
		return head;
	}

	private static void printListNode(ListNode p) {
		System.out.println();
		while (p != null) {
			System.out.print(p.val + " ,");
			p = p.next;
		}
	}

//	public static void main(String[] args) {
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(3);
//		ListNode n3 = new ListNode(5);
//		ListNode n4 = new ListNode(2);
//
//
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(6);
//		n5.next = n6;
//
//		// ListNode p1 = mergeList(n1, n4);
//		// printListNode(p1);
//		printListNode(n1);
//		ListNode head = swapPairs(n1);
//		printListNode(head);
//
//	}

}
