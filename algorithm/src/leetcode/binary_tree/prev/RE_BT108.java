package leetcode.binary_tree.prev;

public class RE_BT108 {
    /*
        원소들이 오름차순으로 정렬된 정수 배열 nums가 주어질 때, 이를 높이 균형 이진 탐색 트리로 변환하세요.
        [참고: 높이 균형 이진 트리란 모든 노드의 왼쪽과 오른쪽 하위 트리의 높이 차이가 1 이하인 이진 트리를 말합니다.]

        모든 값들은 중간값을 기준으로 정렬됩니다.
     */

    public TreeNode sortedArrayToBST(int[] nums) {

        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursion(nums, left, mid - 1);
        node.right = recursion(nums, mid + 1, right);
        return node;
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
