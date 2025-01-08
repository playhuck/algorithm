package binary_tree;

import java.util.Objects;
import java.util.Stack;

public class BT100 {
    boolean isSameTree(TreeNode p, TreeNode q) {

        if(Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }

        if(Objects.isNull(p)) {
            return false;
        }

        if(Objects.isNull(q)) {
            return false;
        }

        Stack<TreeNode> pNextSearchStack = new Stack<>();
        Stack<TreeNode> qNextSearchStack = new Stack<>();

        pNextSearchStack.push(p);
        qNextSearchStack.push(q);

        while (!pNextSearchStack.isEmpty() || !qNextSearchStack.isEmpty()) {

            TreeNode pCurrentNode = pNextSearchStack.pop();
            TreeNode qCurrentNode = qNextSearchStack.pop();

            if (Objects.nonNull(pCurrentNode) && Objects.nonNull(qCurrentNode)) {
                if(!Objects.equals(pCurrentNode.val, qCurrentNode.val)) {
                    return false;
                }
                if(Objects.isNull(pCurrentNode.right) && Objects.nonNull(qCurrentNode.right)) {
                    return false;
                }
                if(Objects.isNull(pCurrentNode.left) && Objects.nonNull(qCurrentNode.left)) {
                    return false;
                }
                if(Objects.nonNull(pCurrentNode.left) && Objects.isNull(qCurrentNode.left)) {
                    return false;
                }
                if(Objects.nonNull(pCurrentNode.right) && Objects.isNull(qCurrentNode.right)) {
                    return false;
                }
                if (Objects.nonNull(pCurrentNode.right)) {
                    pNextSearchStack.push(pCurrentNode.right);
                    qNextSearchStack.push(qCurrentNode.right);
                }
                if (Objects.nonNull(pCurrentNode.left) && Objects.nonNull(qCurrentNode.left)) {
                    pNextSearchStack.push(pCurrentNode.left);
                    qNextSearchStack.push(qCurrentNode.left);
                }
            }
        }

        return true;

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
