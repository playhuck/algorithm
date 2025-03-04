package leetcode.dfs;

import java.util.PriorityQueue;

public class DFS236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;
    private int left = 0;
    private int right = 0;
    private PriorityQueue<TreeNode> cq = new PriorityQueue<>();
    private PriorityQueue<TreeNode> lq = new PriorityQueue<>();
    private PriorityQueue<TreeNode> rq = new PriorityQueue<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        recursion(root.left, p.val, q.val, true);
        recursion(root.right, p.val, q.val, false);

        if(this.left == 2) {
            return lq.poll();
        }

        if(this.right == 2) {
            return rq.poll();
        }

        return cq.poll();

    }

    public void recursion(TreeNode node, int p, int q, boolean isLeft) {

        if (node == null) return;

        if (node.val == p || node.val == q) {
            if (isLeft) {
                this.left++;
            } else {
                this.right++;
            }
            this.count ++;
            if(this.count == 2) return;
        }

        if (isLeft) {
            this.lq.add(node);
        } else {
            this.rq.add(node);
        }

        cq.add(node);

        recursion(node.left, p, q, isLeft);
        recursion(node.right, p, q, isLeft);
    }
}
