package binarytreelevelorder_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class recursive {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		/*root.right.right.right.right = new TreeNode_old(2);*/
		
		root.left = new TreeNode(9);
		root.left.left = null;
		root.left.right = null;
		/*root.left.left.left.left = new TreeNode_old(2);*/
		
		System.out.println(new recursive().levelOrder(root));
	}
}
