package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS257 {
    /*
        이진 트리의 `root`가 주어질 때, *모든 루트에서 리프까지의 경로를 **아무 순서로나** 반환*하세요.
        **리프**는 자식이 없는 노드입니다.

        Input: root = [1,2,3,null,5]
        Output: ["1->2->5","1->3"]
     */

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        if(root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        path(root, res, "");

        System.out.println(Arrays.toString(res.toArray()));

        return res;

    }

    public void path(TreeNode node, List<String> list, String path) {

        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            list.add(path + node.val);
            return;
        }

        path(node.left, list, path + node.val + "->");
        path(node.right, list, path + node.val + "->");

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
