import com.sun.source.tree.Tree;
import stack_queue.Stack144_BinaryTreePreorderTraversal;

import javax.swing.tree.TreeNode;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(new RecentCounter().ping(
//                new String[]{"RecentCounter", "ping", "ping", "ping", "ping"}
//        ));
//        System.out.println(simplifyPath(
//                "/home/../../.."
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(countStudents(
//                new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}
//        ));
//        System.out.println(timeRequiredToBuy(
//                new int[]{5,1,1,1}, 0
//        ));
        System.out.println(splitPainting(
                new int[][]{
                        {1, 4, 5},
                        {4, 7, 7},
                        {1, 7, 9}
                }
        ));
    }

    /*
        이진 탐색 트리의 root와 정수 k가 주어질 때,
        BST 안에 두 원소의 합이 k와 같은 경우가 있으면 true를, 그렇지 않으면 false를 반환하세요.
     */

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();

        recursion(root, list);

        boolean isFindTarget = false;


        for (int i = 0; i < list.size(); i++) {

            int cur = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {

                int next = list.get(j);
                if ((cur + next) == k) {
                    return true;
                }
            }
        }

        return isFindTarget;

    }

    public void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);

        recursion(node.left, list);
        recursion(node.right, list);

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
