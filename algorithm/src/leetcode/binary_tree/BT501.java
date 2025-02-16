package leetcode.binary_tree;

import java.util.*;

public class BT501 {
    /*
        이진 탐색 트리(BST)의 root가 주어질 때, 모든 최빈값(들)(즉, 가장 자주 나타나는 원소)을 반환하세요.
        트리에 최빈값이 여러 개 있다면, 아무 순서로나 반환하세요.
        BST는 다음과 같이 정의됩니다:

        노드의 왼쪽 서브트리는 해당 노드의 키보다 작거나 같은 키를 가진 노드들만 포함합니다.
        노드의 오른쪽 서브트리는 해당 노드의 키보다 크거나 같은 키를 가진 노드들만 포함합니다.
        왼쪽과 오른쪽 서브트리 모두 이진 탐색 트리여야 합니다.
     */

    public int[] findMode(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();

        getFrequencies(root, map);

        int maxValue = Collections.max(map.values());
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() == maxValue) {
                res.add(entry.getKey());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();

    }

    public void getFrequencies(TreeNode node, Map<Integer, Integer> map) {

        if (node == null) {
            return;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        if(node.left == null && node.right == null) {
            return;
        }

        getFrequencies(node.left, map);
        getFrequencies(node.right, map);
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
