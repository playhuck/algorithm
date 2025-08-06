package leetcode.graph.mid;

import java.util.*;

public class Graph399 {

    /*
        문자열 변수 쌍으로 이루어진 배열 equations와 실수 배열 values가 주어집니다.
        equations[i] = [Ai, Bi]는 Ai와 Bi라는 두 변수를 나타냅니다.
        values[i]는 Ai / Bi = values[i]라는 방정식을 나타냅니다.
        또한, queries 배열이 주어지는데, queries[j] = [Cj, Dj]는 Cj / Dj = ?에 대한 답을 찾아야 하는 j번째 질의를 나타냅니다.
        모든 질의에 대한 답을 반환하세요. 만약 하나의 답이라도 결정할 수 없는 경우에는 -1.0을 반환하세요.

        참고:
        입력은 항상 유효합니다.
        질의를 평가할 때 0으로 나누는 경우는 없다고 가정할 수 있습니다.
        모순이 없다고 가정할 수 있습니다.
        equations 목록에 나타나지 않는 변수는 정의되지 않은 것으로 간주하므로, 이들에 대한 답은 결정할 수 없습니다.
     */

    /*
        a / b이 values[1]이고 2.0
        b / c가 values[2]인데 3.0 인데, 이러면 a는 b의 2배, b는 c의 3배가 된다.
        이런식으로 a c는 그러면 2 * 3이라 6이된다. 식을 구해보고, 만약 합리적인 식이 없다면 -1을 return한다.
        점화식을 먼저 세워야 한다.

        a / b = 2. 0 , b / c = 3.0, a / c = 6.0, 자 이제 c = 3 b,

        Map<char, int[2]> int[ 배수, char ] 두 인자의 get했을 때 배수 기준으로,
     */

    Map<String, Map<String, Double>> map = new HashMap<>();

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {

        double[] ans = new double[queries.size()];

        for(int i = 0; i < equations.size(); i ++) {

            String l = equations.get(i).get(0);
            String r = equations.get(i).get(1);

            double v = values[i];

            map.computeIfAbsent(l, k -> new HashMap<>()).put(r, v);
            map.computeIfAbsent(r, k -> new HashMap<>()).put(r, 1.0 / v);

        }

        double[] results = new double[queries.size()];

        // 3. 각 쿼리에 대해 DFS 탐색
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // 변수가 그래프에 없으면 -1.0
            if (!map.containsKey(start) || !map.containsKey(end)) {
                results[i] = -1.0;
            } else {
                // DFS 탐색 시작. Set은 매 쿼리마다 초기화
                results[i] = helper(start, end, new HashSet<>(), 1.0);
            }
        }

        return results;

    }

    public double helper(
            String start,
            String end,
            Set<String> visited,
            double current
    ) {

        if(start.equals(end)) {
            return current;
        }

        visited.add(start);

        Map<String, Double> neighbors = map.get(start);
        if(neighbors != null) {
            for(Map.Entry<String, Double> entry : neighbors.entrySet()) {

                String nextNode = entry.getKey();
                double value = entry.getValue();

                if(!visited.contains(nextNode)) {

                    double result = helper(nextNode, end, visited, current * value);

                    if(result != -1.0) return result;
                }
            }
        }

        return -1.0;

    }

    class Node {

        String val;
        double weight;

        Node(String val, double weight) {

            this.val = val;
            this.weight = weight;
        }
    }
}
