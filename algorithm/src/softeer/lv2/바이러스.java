package softeer.lv2;

import java.math.BigInteger;
import java.util.Scanner;

public class 바이러스 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long k = sc.nextInt();
        long p = sc.nextInt();
        long n = sc.nextInt();

        BigInteger kp = new BigInteger(String.valueOf(k));
        BigInteger val = new BigInteger("1000000007");

        while(n > 0) {

            kp = kp.multiply(BigInteger.valueOf(Long.parseLong(String.valueOf(p))));

            n -= 1;
        }

        System.out.println(kp.remainder(val));
    }

}
