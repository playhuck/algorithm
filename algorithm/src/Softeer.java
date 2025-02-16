import java.util.*;
import java.util.regex.*;

public class Softeer {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.main("s"));
    }

    static public class Solution {

        public boolean main(String s) {

            List<Integer> list = new ArrayList<>();
            Collections.sort(list, (a,b) -> {
                return b - a;
            });
            Pattern pattern = Pattern.compile("[0-9]");

            int[] arr = list.stream().mapToInt(i -> i).toArray();

            PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b) -> {

                return b.get(0) - a.get(0);
            });

            Map<Integer, List<Integer>> map = new HashMap<>();

            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            }

            int[] arr2 = new int[]{3,1,2};

            List<Integer> list2 = Arrays.stream(arr2).boxed().toList();
            List<Integer> list3 = Arrays.stream(arr2).boxed().toList();

            int[] arr3 = list3.stream().mapToInt(i -> i).toArray();
            String[] str = list3.stream().toArray(String[]::new);

            Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

            String st = "Hello";

            System.out.println(st.charAt(0));
            System.out.println(st.substring(0,3));

            return false;
        }

    }

}
