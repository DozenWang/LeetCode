import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.soap.Node;

public class BinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<TreeNode> preOrderTranverse(TreeNode root) {
		List<TreeNode> list = new ArrayList<BinaryTree.TreeNode>();
		Stack<TreeNode> stack = new Stack<BinaryTree.TreeNode>();
		TreeNode pNode = root;
		do {
			if (pNode != null) {
				stack.push(pNode);
				list.add(pNode);
				pNode = pNode.left;
			} else {
				pNode = stack.pop();
				pNode = pNode.right;
			}
		} while (!stack.isEmpty() || pNode != null);

		return list;
	}

	public static List<TreeNode> inOrderTranverse(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		do {
			if (pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else {
				if (!stack.isEmpty()) {
					pNode = stack.pop();
					list.add(pNode);
					pNode = pNode.right;
				}
			}
		} while (!stack.isEmpty() || pNode != null);
		return list;
	}

	public static List<Integer> postOrderTranverse(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> outputStack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode pNode = stack.peek();
			outputStack.push(pNode);
			stack.pop();
			if (pNode.left != null) {
				stack.push(pNode.left);
			}
			if (pNode.right != null) {
				stack.push(pNode.right);
			}
		}
		while (!outputStack.isEmpty()) {
			TreeNode node = outputStack.pop();
			list.add(node.val);
		}
		return list;
	}

	public static List<List<Integer>> levelOrderTranverse(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int curLevelCount = 1;
		int nextLevelCount = 0;
		boolean needReverse = false;
		List<Integer> tmpList = new ArrayList<Integer>();

		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			curLevelCount --;
			tmpList.add(node.val);
			if(node.left != null) {
				queue.add(node.left);
				nextLevelCount ++;
			}
			if(node.right != null) {
				queue.add(node.right);
				nextLevelCount ++;
			}

			if(curLevelCount == 0) {
				if(needReverse) {
					Collections.reverse(tmpList);
				}
				list.add(tmpList);
				tmpList = new ArrayList<Integer>();
				needReverse = !needReverse;
				curLevelCount = nextLevelCount;
				nextLevelCount = 0;
			}
		}
		return list;
	}

//	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		TreeNode r2 = new TreeNode(2);
//		TreeNode r3 = new TreeNode(3);
//		root.left = r2;
//		root.right = r3;
//
//		List<List<Integer>> list = levelOrderTranverse(root);
//		for (List<Integer> listNode : list) {
//			System.out.println(listNode);
//		}
//
//	}
}
