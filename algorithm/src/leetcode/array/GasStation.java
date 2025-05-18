package leetcode.array;

public class GasStation {
    /*
        4번째에서 출발하면, 가스 4
        다음으로 이동하는데 가스 5를 채울 수 있고 현재 코스트인 4번째 코스트 -1 => 4 - 1 + 5 => 8
        8 - 2 + 1 = 7
        7 - 3 + 2 = 6

        출발 하는 위치 - 다음에 소모될 가스 + 다음 위치에서 얻은 가스 => 이 공식대로
        사이클을 한 번 돌 수 있는 위치의 station 위치를 찾고 없다면 -1
        현재 위치에서 다음 위치로 갈 수 있다면 계속 돌고 갈 수 없다면 break;
        1 <= n <= 105
        0 <= gas[i], cost[i] <= 104
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int p1 = 0;
        int p2 = 0;
        int len = gas.length;
        int station = -1; // 스테이션 위치
        int rGas = gas[p1]; // 남은 가스
        int circle = 0; // 순회 숫자

        if(gas.length == 1) {
            if(gas[0] >= cost[0]) return 0;
            else return -1;
        };

        // p1부터 차례대로 돈다.
        // p2는 최대치를 넘어가면 처음으로 가야하기 때문에 p2 = p2 % cost.length
        while (p1 < len) {

            System.out.println(p1 + " " + p2 + " " + rGas);

            rGas = rGas - cost[p2++]; // 현재 보유랑 - 소모량
            circle ++;
            if(rGas <= 0) {
                if(circle == len && rGas == 0) {
                    station = p1;
                    break;
                }
                p1 ++;
                p2 = p1;
                circle = 0;
                if(p1 == len) break;
                rGas = gas[p1];
                continue;
            }
            if(p2 == len) p2 = p2 % len;

            rGas = rGas + gas[p2];

            if(p2 == len) p2 = p2 % len;
            // System.out.println(p1 + " " + p2 + " " + rGas + " " + circle);
            if(circle == len) {
                station = p1;
                break;
            }

        }

        return station;

    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int len = gas.length;

        if(len == 1) {
            if(gas[0] >= cost[0]) return 0;
            else return -1;
        };

        int tGas = 0, tCost = 0;
        for(int i =0; i < len; i ++) {
            tGas += gas[i];
            tCost += cost[i];
        }

        if(tGas < tCost) return -1;

        int curGas = 0, start = 0;

        for(int i =0; i < len; i ++) {
            curGas = curGas + gas[i] - cost[i];
            if(curGas < 0) {
                curGas = 0;
                start = i + 1;
            }
        }

        return start;

    }
}
