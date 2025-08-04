package leetcode.binary_tree.mid;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class BT106 {

    /*
        두 개의 정수 배열 inorder와 postorder가 주어집니다.
        inorder는 이진 트리의 중위 순회(in-order traversal) 결과이고,
        postorder는 같은 트리의 후위 순회(post-order traversal) 결과입니다.
        이 두 배열을 사용하여 이진 트리를 구축하고 반환하세요.

        inorder -> 중위순회 = 왼쪽부터 쭈우우욱
        postorder -> 후위순회 = 왼쪽 오른쪽 루트

        inorder의 루트노드 다음 노드와 일치하는 값 이전 값이 왼쪽 서브트리입니다.
        그러면 왼쪽 서브트리의 첫번째 루트노드를 구하면

        중위 -> [3, 5, 7, 8, 9, 10, 12, 15]
        후위 -> [3, 7, 9, 8, 5, 12, 15, 10]

        후위 마지막은 루트노드입니다.
        후위마지막과 일치하는 중위의 인덱스 오른쪽부터 오른쪽 서브트리입니다.
        후위마지막과 일치하는 중위의 인덱스 왼쪽까지 왼쪽 서브 트리입니다.
        후위 정해진 array 지역 왼쪽부터 왼쪽 루트노드입니다.
        후위 정해진 array 지역 마지막부터 오른쪽 노드입니다.

        root.left = recursion(postorder, postOrderStart + 1)
        root.right = recursion(postorder, postOrderEnd - 1)

        오른쪽의 루트노드는 언제나 후위 순회위치에서 - 1 왼쪽은 후위 순회위치에서 + 1
        왼쪽의 루트노드는 postorder[postOrderStart]
        오른쪽의 루트노드는 postorder[전체 길이 - ]
        35789, 5 -> 3 / 789
        37985, 5 -> 8

     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) map.put(postorder[i], i);

    }

    public TreeNode recursion(
            TreeNode root,
            int[] postorder,
            int postOrderStart,
            int postOrderEnd) {

        root.left = recursion(root, postorder, postOrderStart + 1, postOrderEnd);
        root.right = recursion(root, postorder, postOrderStart - 1, postOrderEnd);

        return root;
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
