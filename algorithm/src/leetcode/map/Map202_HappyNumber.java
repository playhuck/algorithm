package leetcode.map;

public class Map202_HappyNumber {

    public boolean isHappy(int n) {

        int target = n;

        int count = 0;

        while (target != 1) {

            int sum = 0;
            if(count == 20) break;

            while (target > 0) {

                sum += ((target % 10) * (target % 10));

                target = (target / 10);
            }

            target = sum;
            count++;
        }

        return target == 1;

    }

}
