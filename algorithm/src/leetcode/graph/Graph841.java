package leetcode.graph;

import java.util.*;

public class Graph841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Map<Integer, Integer> visit = new HashMap<>(); // 이미 방문한 배열
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
            return a - b;
        });

        List<Integer> list = rooms.get(0);

        int next = 0;
        boolean isNext = false;
        int visitCount = 1;

        while(true) {

            int tmp = next;

            Collections.sort(list);

            for(Integer n : list) {
                if(n == 0) continue;

                if(!visit.containsKey(n) && !isNext) {
                    next = n;
                    isNext = true;
                }
                que.add(n);
            }

            if(tmp == next) {

                while(que.size() > 0) {

                    int q = que.poll();
                    if(visit.containsKey(q)) {
                        continue;
                    } else {
                        next = q;
                        break;
                    }
                }

                if(tmp == next) {
                    break;
                } else {
                    list = rooms.get(next);
                    visit.put(next, visit.getOrDefault(next, 0) + 1);
                    visitCount ++;
                }
            } else {

                list = rooms.get(next);
                visit.put(next, visit.getOrDefault(next, 0) + 1);
                visitCount ++;
            }

            isNext = false;

            if(visitCount == rooms.size()) {
                break;
            }
        }

        return visitCount == rooms.size();

    }
}
