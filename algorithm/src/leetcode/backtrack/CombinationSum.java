package leetcode.backtrack;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < candidates.length; i ++) {

            backtrack(
                    set,
                    Arrays.copyOfRange(candidates,i,candidates.length),
                    target,
                    new ArrayList<Integer>(),
                    0
            );

        }

        for(List<Integer> list : set) {

            System.out.println(Arrays.toString(list.toArray()));
        }

        return new ArrayList<>(set);
    }

    public void backtrack(Set<List<Integer>> set, int[] candidates, int target, List<Integer> list, int sum) {

        // target보다 작을 때 같은 거 계속 추가, target보다 크거나 같을 때 종료

        if(sum >= target) {
            if(sum == target){
                set.add(list);
            }
            return;
        }
        if(candidates.length == 0) return;

        list.add(candidates[0]);

        // 자기 자신만 계속 호출하는 경우 1
        // 자신을 제외한 그 다음수를 호출하는 경우 2

        backtrack(set, candidates, target, list, sum += candidates[0]);
        backtrack(
                set,
                Arrays.copyOfRange(candidates, 1, candidates.length),
                target,
                list,
                sum += candidates[0]
        );
    }

}
