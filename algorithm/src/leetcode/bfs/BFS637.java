package leetcode.bfs;

import java.util.*;

public class BFS637 {
    /*
        이진 트리의 root가 주어질 때, 각 레벨에 있는 노드들의 평균값을 배열 형태로 반환하세요.
        실제 답과 10-5 이내의 오차가 있는 답은 허용됩니다.
     */

    public List<Double> averageOfLevels(TreeNode root) {

        HashMap<Integer, Long> levelSumMap = new LinkedHashMap<>();
        HashMap<Integer, Integer> levelSumCountMap = new HashMap<>();

        recursion(root, 1, levelSumMap, levelSumCountMap);

        List<Double> averageList = new ArrayList<>();

        for(Map.Entry<Integer, Long> entry : levelSumMap.entrySet()) {

            int level = entry.getKey();
            long sum = entry.getValue();
            int sumCount = levelSumCountMap.get(level);

            averageList.add((double) sum / sumCount);
        }

        return averageList;
    }

    public void recursion(
            TreeNode node,
            Integer level,
            Map<Integer, Long> levelSumMap,
            Map<Integer, Integer> levelSumCountMap
    ) {

        if (node == null) {
            return;
        }

        levelSumMap.put(level, levelSumMap.getOrDefault(level, 0L) + node.val);
        levelSumCountMap.put(level, levelSumCountMap.getOrDefault(level, 0) + 1);

        recursion(node.left, level + 1, levelSumMap, levelSumCountMap);
        recursion(node.right, level + 1, levelSumMap, levelSumCountMap);

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
