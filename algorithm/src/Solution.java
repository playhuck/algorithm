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
//        System.out.println(inorderTraversal(
//                "(()})"
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
//        System.out.println(captureForts(
//                new int[]{-1,-1,0,1,0,0,1,-1,1,0}
//        ));
    }

    /*
        이진 트리의 root가 주어질 때, 해당 노드들의 값을 후위 순회한 결과를 반환하세요.
        후위 순회

        왼쪽 전부 탐색 후 오른쪽 탐색
        탐색은 가장 왼쪽이 있으면 왼쪽우선 탐색 후 오른쪽 노드가 더이상 자식 노드를 가지고 있지 않을 때
        오른쪽 노드를 추가하고 위로 올라가면 된다.
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> postOrderTraversalStack = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        if (Objects.isNull(root)) {
            return List.of();
        }

        while (root.left != null || root.right != null) {

            while (Objects.nonNull(curr.left)) {
                stack.push(curr);
                curr = curr.left;
            }

            if (Objects.isNull(curr.right)) {
                if (curr.val != Integer.MIN_VALUE) {
                    if (Objects.equals(curr, root)) {
                        if (Objects.isNull(root.right) && Objects.isNull(root.left)) {
                            postOrderTraversalStack.add(root.val);
                        }
                    } else {
                        postOrderTraversalStack.add(curr.val);
                    }
                    curr.val = Integer.MIN_VALUE;
                }
                TreeNode prev = curr;
                curr = stack.pop();
                if (Objects.equals(curr.left, prev)) {
                    curr.left = null;
                } else if (Objects.equals(curr.right, prev)) {
                    curr.right = null;
                }
            } else {
                stack.push(curr);
                curr = curr.right;
            }
        }

        postOrderTraversalStack.add(root.val);

        return postOrderTraversalStack.stream().toList();

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