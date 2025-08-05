package leetcode.binary_tree.mid;

import java.util.List;

public class BT129 {

    /*
        0부터 9까지의 숫자로만 구성된 이진 트리의 root가 주어집니다.

        트리의 각 루트-리프(root-to-leaf) 경로는 하나의 숫자를 나타냅니다.
        예를 들어, 루트-리프 경로 1 -> 2 -> 3은 숫자 123을 나타냅니다.

        모든 루트-리프 숫자의 총합을 반환하세요. 테스트 케이스는 반환되는 값이 32비트 정수에 맞도록 생성됩니다.

        리프(leaf) 노드는 자식이 없는 노드입니다.
     */

    private int sum = 0;

    public int sumNumbers(TreeNode root) {

        if(root == null) return 0;

        sumNumbers(root, new StringBuilder());

        return this.sum;

    }

    public void sumNumbers(TreeNode root, StringBuilder s) {

        StringBuilder s2 = s.append(root.val);
        if(root.left == null && root.right == null){

            this.sum += Integer.parseInt(s2.toString());

            return;
        }

        if(root.left != null){
            sumNumbers(root.left, s2);
        }

        if(root.right != null){
            sumNumbers(root.right, s2);
        }


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
