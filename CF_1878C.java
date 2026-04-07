import java.util.*;
public class CF_1878C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();

            long minSum = k * (k + 1) / 2;
            long maxSum = k * (2 * n - k + 1) / 2;

            if (x >= minSum && x <= maxSum)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}