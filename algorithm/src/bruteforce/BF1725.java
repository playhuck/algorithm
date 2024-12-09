package bruteforce;

import java.util.HashMap;
import java.util.Map;

public class BF1725 {
    /*
       여러 개의 직사각형 정보가 담긴 배열 rectangles가 주어집니다. 각 직사각형의 정보는 rectangles[i] = [li, wi] 형태로 주어지는데,
       이는 i번째 직사각형의 길이가 li이고 너비가 wi라는 뜻입니다.이 직사각형들을 잘라서 정사각형을 만들 수 있습니다. 단, 정사각형의 한 변의 길이를 k라고 할 때,
       k는 해당 직사각형의 길이와 너비보다 작거나 같아야 합니다. 예를 들어 [4,6] 크기의 직사각형이 있다면, 이 직사각형으로는 최대 4×4 크기의 정사각형을 만들 수 있습니다.
       이제 주어진 모든 직사각형들 중에서 만들 수 있는 가장 큰 정사각형의 한 변의 길이를 maxLen이라고 합시다.
       maxLen 크기의 정사각형을 만들 수 있는 직사각형이 몇 개인지 그 개수를 구하는 것
     */
    public static int countGoodRectangles(int[][] rectangles) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int[] rectangle : rectangles) {

            int kk = Math.min(rectangle[0], rectangle[1]) * 2;

            if (kk >= max) {
                max = kk;
            }

            if (map.containsKey(kk)) {
                map.put(kk, map.get(kk) + 1);
            } else {
                map.put(kk, 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getKey().equals(max)) {
                return entry.getValue();
            }

        }

        return 1;
    }
}
