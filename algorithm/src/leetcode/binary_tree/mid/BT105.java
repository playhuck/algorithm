package leetcode.binary_tree.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BT105 {

    /*
        두 개의 정수 배열 preorder와 inorder가 주어집니다.
        preorder는 이진 트리의 전위 순회(preorder traversal) 결과이고,
        inorder는 같은 트리의 중위 순회(inorder traversal) 결과입니다.
        이 두 배열을 사용하여 이진 트리를 구축하고 반환하세요.

        전위 > 루트 - 왼쪽 - 오른쪽
        중위 > 왼쪽 - 루트 - 오른쪽
     */

    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return recursion(preorder, 0, 0, inorder.length - 1);

    }

    /*
        전위순회의 첫번째 값과 일치하는 중위순회 값이 그 노드의 루트입니다. 왼쪽이 왼쪽루트, 오른쪽이 오른쪽 루트
        preorderStart = 재귀로 호출된 서브트리의 루트 노드지점
        inorderStart = inorder 배열에서 현재 서브트리의 시작 인덱스
        inorderEnd = inorder 배열에서 현재 서브트리의 끝 인덱스
     */
    public TreeNode recursion(
            int[] preorder,
            int preorderStart,
            int inorderStart,
            int inorderEnd
    ) {

        if(inorderStart > inorderEnd || preorderStart >= preorder.length) {
            return null;
        }

        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        int rootInInOrder = inOrderMap.get(rootVal);
        int leftSubTreeSize = rootInInOrder - inorderStart; // 6 - 1 5

        /*
            preorder -> 그냥
            preorderStart +1 -> 왼쪽 노드 첫 번째가 언제나 +1이니까
            inorderStart -> 왼쪽 끝이 첫번쨰 노드니까
            rootInInOrder = 현재 루트노드 위치
         */
        root.left = recursion(
                preorder,
                preorderStart + 1,
                inorderStart,
                rootInInOrder - 1
        );

        /*
            preorder -> 그냥
            preorderStart + 1 + leftSubTreeSize
            -> lSTS = 현재 노드 기준으로 왼쪽 서브트리에 몇개 노드 있는지 그레서
            -> 오른쪽의 그 다음 루트노드가 몇 번쨰부터 있는지 알려줌
            inorderStart + 1 ->


            맨 처음에, arr 0 0 7
            right -> arr 6 1
         */
        root.right = recursion(
                preorder,
                preorderStart + 1 + leftSubTreeSize, // 0 + 1 + 5 -> 6
                rootInInOrder + 1, // 0 + 1
                inorderEnd
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
