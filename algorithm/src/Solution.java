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
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            res.add(root.val);
            return res;
        }

        Map<Integer, Integer> nodeMap = new LinkedHashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        int rootCount = 0;
        int treeCount = Objects.isNull(root.left) || Objects.isNull(root.right) ? 2 : 3;

        while (rootCount < treeCount) {

            if (cur.equals(root)) {
                rootCount++;
            }

            if(cur.left != null) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }

            /*
                여기부터는 cur.left가 Null이라는 가정, 올라가야 한다.
                왼쪽 끝에서, 오른쪽 까지 없는 경우, 일반적으로 바로 nodeMap.put한다.
                근데 혹시 모르니 포함여부 확인 포함 없다면 추가 아니면 위로
             */
            if(Objects.isNull(cur.right)){
                if(!nodeMap.containsKey(cur.val)){
                    nodeMap.put(cur.val, cur.val);
                }
                if(!stack.isEmpty()){
                    cur = stack.pop();
                }

                /*
                    근데 오른쪽이 있다면
                 */
            } else {

                if(!nodeMap.containsKey(cur.val)){
                    nodeMap.put(cur.val, cur.val);
                }
                stack.push(cur);
                cur = cur.right;
                continue;
            }


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