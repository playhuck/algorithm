package leetcode.stack_queue.prev;

import java.util.ArrayList;
import java.util.List;

public class Stack735 {
    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < asteroids.length; i ++) {

            int a = asteroids[i];

            if(a >= 0) {

                list.add(a);
            } else {

                if(list.size() > 0) {

                    int last = Integer.MIN_VALUE;

                    while(
                            list.size() > 0 &&
                                    (
                                            Math.abs(a) >= list.get(list.size() - 1) &&
                                                    list.get(list.size() - 1) >= 0
                                    )
                    ) {

                        last = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        if(last == Math.abs(a)) {
                            break;
                        }

                    }

                    if(list.size() > 0 && list.get(list.size() - 1) < 0 && last != Math.abs(a)) {
                        list.add(a);
                        continue;
                    }

                    if(list.size() == 0 && last != Math.abs(a)) {
                        list.add(a);
                    }


                } else list.add(a);


            }

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
