package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy1921_EliminateMaximumNumberOfMonsters {
    /*
        비디오 게임에서 당신은 n개의 몬스터 그룹으로부터 도시를 방어하고 있습니다.
        크기가 n인 0부터 시작하는 정수 배열 dist가 주어지며,
        dist[i]는 i번째 몬스터의 도시로부터의 초기 거리(킬로미터)입니다.
        몬스터들은 일정한 속도로 도시를 향해 걷습니다.
        각 몬스터의 속도는 크기가 n인 정수 배열 speed로 주어지며, speed[i]는 i번째 몬스터의 속도(킬로미터/분)입니다.
        당신은 완전히 충전되면 하나의 몬스터를 제거할 수 있는 무기를 가지고 있습니다.
        하지만 무기는 충전하는 데 1분이 걸립니다. 무기는 처음에 완전히 충전되어 있습니다.
        어떤 몬스터든 도시에 도달하면 당신은 패배합니다.
        만약 무기가 완전히 충전되는 정확한 순간에 몬스터가 도시에 도달하면, 그것은 패배로 간주되며,
        당신이 무기를 사용하기 전에 게임이 끝납니다.
        패배하기 전에 제거할 수 있는 몬스터의 최대 수를 반환하세요.
        만약 몬스터들이 도시에 도달하기 전에 모든 몬스터를 제거할 수 있다면 n을 반환하세요.
        Input: dist = [1,3,4], speed = [1,1,1]
        Output: 3
     */

    public static int eliminateMaximum(int[] dist, int[] speed) {

        PriorityQueue<double[]> min = new PriorityQueue<>(Comparator.comparingDouble(a -> a[2]));

        for (int i = 0; i < speed.length; i++) {
            min.add(new double[]{dist[i], speed[i], (double)dist[i]/speed[i]});
        }

        min.poll();

        int time = 1;
        int result = 1;

        while (!min.isEmpty()) {

            double[] monster = min.poll();
            if(monster[2] == 0){
                break;
            } else {
                if(monster[0] - (time * monster[1]) > 0){
                    result ++;
                    time ++;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    int eliminateMaximum2(int[] dist, int[] speed) {

        int result = 1;

        double[] min = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            min[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(min);

        int time = 1;

        min[0] = Integer.MAX_VALUE;

        for (double v : min) {

            if(v == Integer.MAX_VALUE) {
                continue;
            }

            if(v - time > 0) {
                result ++;
                time ++;
            } else {
                break;
            }
        }

        return result;
    }
}
