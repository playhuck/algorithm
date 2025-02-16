package leetcode.sort;

import java.util.Arrays;

public class Sort1491_AverageSalaryExcludingtheMinimumandMaximumSalary {
    double average(int[] salary) {

        Arrays.sort(salary);

        int count = 0;
        int sum = 0;

        for (int i = 1; i < salary.length - 1; i++) {

            sum += salary[i];
            count ++;
        }

        return (double) sum / count;

    }
}
