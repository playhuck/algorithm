package stack_queue;

import java.util.*;

public class Stack94_BinaryTreeInOrderTraversal {
    /*
        이진 트리의 root가 주어질 때, 해당 노드들의 값을 중위 순회한 결과를 반환하세요.
        1,2,3,4,5,null,8,null,null,6,7,9

            부모 데이터는 stack으로 관리
            내 현재 노드는 cur로 관리

            cur가 왼쪽이 더 이상 없을 때 자신을 추가하게 된다.
            그리고 거슬러 올라오면서 부모 노드를 추가한다.
            부모노드를 추가하고 오른쪽이 있다면 오른쪽 노드로 내려간다.
            다시 왼쪽이 더이상없을 때 자신을 추가한다...
            ...
            반복 후 거슬러 올라오면서 한 번 추가된 노드는 그냥 넘어가고
            stack도 제거한다.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }

        Map<Integer, Integer> nodeMap = new LinkedHashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (root.right != null || root.left != null) {

            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(!nodeMap.containsKey(curr.val)) {
                nodeMap.put(curr.val, 1);
            }
            curr.left = null;

            if(curr.right != null){
                stack.push(curr.right);
                curr = curr.right;
            }

        }

        if(nodeMap.isEmpty()) {
            nodeMap.put(root.val, 1);
        }

        return new ArrayList<>(nodeMap.keySet());
    }


    public static class TreeNode {
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
