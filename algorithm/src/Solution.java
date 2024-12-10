import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(new RecentCounter().ping(
//                new String[]{"RecentCounter", "ping", "ping", "ping", "ping"}
//        ));
//        System.out.println(firstUniqChar(
//                "loveleetcode"
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(minNumber(
//                new int[]{3,5,2,6}, new int[]{3,1,7}
//        ));
//        System.out.println(firstUniqChar(
//                new int[]{9,9,9,9,9,9,9,9,9,9}, 1
//        ));
//        System.out.println(captureForts(
//                new int[]{-1,-1,0,1,0,0,1,-1,1,0}
//        ));
    }

    /*
        특정 시간 범위 내의 최근 요청 수를 계산하는 RecentCounter 클래스가 있습니다.
        RecentCounter 클래스를 다음과 같이 구현하세요:

        RecentCounter() 최근 요청이 0개인 상태로 카운터를 초기화합니다.
        int ping(int t) 시간 t에 새로운 요청을 추가합니다.
        여기서 t는 밀리초 단위의 시간을 나타내며,
        지난 3000 밀리초 동안 발생한 요청의 수(새로운 요청 포함)를 반환합니다.
        구체적으로, [t - 3000, t] 범위 내에서 발생한 요청의 수를 반환합니다.

        ping을 호출할 때마다 이전 호출보다 더 큰 t 값을 사용한다는 것이 보장됩니다.
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
        recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
        recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
        recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
     */

    public static int firstUniqChar(String s) {

         return -1;
    }
}