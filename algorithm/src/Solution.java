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
        System.out.println(simplifyPath(
                "/home/user/Documents/../Pictures"
        ));
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
        Unix 스타일 파일 시스템을 위한 절대 경로가 주어지며, 이는 항상 슬래시 '/'로 시작합니다.
        이 절대 경로를 단순화된 정규 경로로 변환하는 것이 당신의 과제입니다.
        Unix 스타일 파일 시스템의 규칙은 다음과 같습니다:

        단일 마침표 '.'는 현재 디렉토리를 나타냅니다.
        이중 마침표 '..'는 이전/상위 디렉토리를 나타냅니다.
        '//'와 '///'같은 연속된 여러 개의 슬래시는 단일 슬래시 '/'로 취급됩니다.
        위의 규칙과 일치하지 않는 마침표들의 시퀀스는 유효한 디렉토리 또는 파일 이름으로 취급되어야 합니다.
        예를 들어, '...'와 '....'는 유효한 디렉토리나 파일 이름입니다.

        단순화된 정규 경로는 다음 규칙을 따라야 합니다:

        경로는 반드시 하나의 슬래시 '/'로 시작해야 합니다.
        경로 내의 디렉토리들은 정확히 하나의 슬래시 '/'로 구분되어야 합니다.
        루트 디렉토리가 아닌 경우, 경로는 슬래시 '/'로 끝나서는 안 됩니다.
        경로에는 현재 또는 상위 디렉토리를 나타내는 단일 또는 이중 마침표('.'와 '..')가 사용되어서는 안 됩니다.

        단순화된 정규 경로를 반환하세요.
     */
    static public String simplifyPath(String path) {

        String[] strings = path.split("/");

        for (int i = 0; i < strings.length - 1; i++) {

            if(strings[i].equals("..")) {

                for(int j = i; j > 0; j--) {

                }
            }
        }

        return String.join("/", strings);
    }

}