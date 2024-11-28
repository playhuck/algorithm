import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String star = "*";
        int starIndex = 1;

        while (n > 0) {

            System.out.println(star.repeat(starIndex));

            n --;
            starIndex ++;
        }

    }
}