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
        System.out.println(Arrays.toString(findRelativeRanks(
                new int[]{10,3,8,9,4}
        )));
    }

    /*
        크기가 n인 정수 배열 score가 주어지며, score[i]는 대회에서 i번째 선수의 점수입니다.
        모든 점수는 고유함이 보장됩니다.
        선수들은 그들의 점수를 기반으로 순위가 매겨지며,
        1등 선수는 가장 높은 점수를, 2등 선수는 2번째로 높은 점수를 가지는 식입니다.
        각 선수의 순위는 다음과 같이 결정됩니다:

        1등 선수의 순위는 "Gold Medal"입니다.
        2등 선수의 순위는 "Silver Medal"입니다.
        3등 선수의 순위는 "Bronze Medal"입니다.
        4등부터 n등까지의 선수들의 순위는 그들의 등수 숫자입니다 (즉, x등 선수의 순위는 "x"입니다).

        크기가 n인 배열 answer를 반환하세요. 여기서 answer[i]는 i번째 선수의 순위입니다.
     */

    public static String[] findRelativeRanks(int[] score) {

        return new String[0];
    }

}