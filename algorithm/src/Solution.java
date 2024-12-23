import com.sun.source.tree.Tree;
import stack_queue.Stack144_BinaryTreePreorderTraversal;

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
//        System.out.println(simplifyPath(
//                "/home/../../.."
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
        System.out.println(maxProductDifference(
                new int[]{2,9,5,9,1}
        ));
    }

    /*
        곱의 차이는 두 쌍 (a, b)와 (c, d) 사이에서 (a * b) - (c * d)로 정의됩니다.

        예를 들어, (5, 6)과 (2, 7) 사이의 곱의 차이는 (5 * 6) - (2 * 7) = 16입니다.

        정수 배열 nums가 주어질 때, 쌍 (nums[w], nums[x])와 (nums[y], nums[z])
        사이의 곱의 차이가 최대가 되도록 하는 네 개의 서로 다른 인덱스 w, x, y, z를 선택하세요.
        최대 곱의 차이를 반환하세요.

     */

    public static int maxProductDifference(int[] nums) {

        Arrays.sort(nums);

        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);

    }

}