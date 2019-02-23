package binarytreeinorder_94;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-recursive-traversal/discuss/31404/Concise-JAVA-solution-based-on-Stack
 */

public class usingstack2 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) { 
			while (cur != null) {// Travel to each node's left child, till reach the left leaf
				stack.push(cur);
				cur = cur.left;				
			}		 
			cur = stack.pop(); // Backtrack to higher level node A
			res.add(cur.val);  // Add the node to the result list
			cur = cur.right;   // Switch to A'right branch
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left=null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.left.left = new TreeNode(4);
		System.out.println(new usingstack2().inorderTraversal(root));
	}
}
