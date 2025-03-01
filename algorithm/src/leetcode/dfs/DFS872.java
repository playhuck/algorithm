package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        /*
            두 노드의 리프노드가 같은지 확인하는 것
        */
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        recursion(root1, list1);
        recursion(root2, list2);

        if(list1.size() != list2.size()) {
            return false;
        }

        for(int i = 0; i < list1.size(); i ++) {

            int l1 = list1.get(i);
            int l2 = list2.get(i);

            if(l1 != l2) {
                return false;
            }
        }

        return true;

    }

    public void recursion(TreeNode node, List<Integer> list) {

        if(node.left == null && node.right == null) {
            list.add(node.val);
        } else {
            if(node.left != null) {
                recursion(node.left, list);
            }

            if(node.right != null) {
                recursion(node.right, list);
            }
        }

    }
}
