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

     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return new TreeNode(0);

    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {

        return buildTree2(
                inorder,
                0,
                inorder.length - 1,
                postorder,
                0,
                postorder.length - 1
        );

    }

    public TreeNode buildTree2(
            int[] inorder,
            int inStart,
            int inEnd,
            int[] postorder,
            int postStart,
            int postEnd) {

        if(inStart > inEnd || postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal); // 후위 마지막이 루트노드

        int rootIndex = 0; // rootVal 기준으로 inorder의 왼쪽 서브트리와 오른쪽 서브트리가 나뉨
        for(int i = inStart; i <= inEnd; i ++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart; // 중위순회에서 루트 인덱스 위치와 서브트리의 시작 사이 거리(서브트리 노드 개수)
        int rightSize = inEnd - rootIndex; // 서브트리 끝에서 루트위치 사이 거리, 오른쪽 서브트리 개수

        /*
            중위 -> [3, 5, 7, 8, 9, 10, 12, 15]
            후위 -> [3, 7, 9, 8, 5, 12, 15, 10]
        */
        root.left = buildTree2(
                inorder, // inorder는 inStart부터 rootIndex - 1 까지 범위를 가지게 됨
                inStart,
                rootIndex - 1,
                postorder, // postStart부터 시작해서 leftSize만큼의 노드를 포함함
                postStart,
                postStart + leftSize - 1 // -> 왼쪽 서브트리 끝
        );

        root.right = buildTree2(
                inorder,
                rootIndex + 1,
                inEnd,
                postorder,
                postEnd - rightSize,
                postEnd - 1
        );

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
