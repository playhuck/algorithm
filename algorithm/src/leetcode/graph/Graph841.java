package leetcode.graph;

import java.util.*;

public class Graph841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        /*
            1. 가능한 모든 방을 방문해야한다.
            2. 열쇠가 없으면 잠긴 방을 들어갈 수 없다.
            3. 방을 방문하면 방안에 개별 키 세트가 있다.(다른 방으로 갈 수 있는)
            4. 모든 방을 방문할 수 있다면 true OR false;
        */

        boolean[] visit = new boolean[rooms.size()];
        visit[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int count = 1;

        while( stack.size() > 0) {
            for(int n : rooms.get(stack.pop())) {

                if(!visit[n]) {
                    stack.push(n);
                    visit[n] = true;
                    count ++;
                }
            }
        }

        return rooms.size() == count;


    }
}
