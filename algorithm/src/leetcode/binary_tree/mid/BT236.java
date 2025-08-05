package leetcode.binary_tree.mid;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class BT236 {

    /*
        이진 트리가 주어졌을 때, 주어진 두 노드 p와 q의 **최소 공통 조상(LCA)**을 찾으세요.

        위키피디아의 LCA 정의에 따르면,
        “최소 공통 조상은 두 노드 p와 q를 모두 자손으로 가지는
        트리 T 내의 가장 낮은(lowest) 노드로 정의됩니다
        (이때, 한 노드가 자기 자신의 자손이 되는 것도 허용합니다).”

        All Node.val are unique. ( 모든 값은 유일 )
        p != q ( p 랑 q는 다른 값 )

        만약 q나 p가 q나 p의 자식이라면 p나 q가 lca 노드가 될 수 있음

        깊이를 기준으로 만들고, Map에 Child , Parent 형태로 저장한 다음에
        깊이가 더 깊은거 기준으로, map에서 발견된 첫번째꺼가 그건데,
        만약 depth가 둘 다 같다면 그래도 첫번째꺼가.. LinkedHashMap으로 하면 순서대로 체크할 수 있으니까
     */

    private TreeNode target;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        helper(root, p, q);

        return target;

    }

    public boolean helper(TreeNode node, TreeNode p, TreeNode q) {

        /*
            왼쪿 오른쪽 찾아서, 찾으면 TreeNode를 return하고 못찾으면 null을 return하는데
            left right가 모두 null을 return하지 않는 그 첫번째 부모 노드가 lca가 된다.
         */

        if(node == null) return false;

        boolean cur = Objects.equals(node, p) || Objects.equals(node, q);

        boolean l = helper(node.left, p, q);
        boolean r = helper(node.right, p, q);

        if(l && r ) {
            target = node;
        } else if (l && cur) {
            target = node;
        } else if (r && cur) {
            target = node;
        }

        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
