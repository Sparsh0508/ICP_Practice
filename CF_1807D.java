import java.util.*;
public class CF_1807D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         while (t-- > 0) {

            int n = sc.nextInt();
            int q = sc.nextInt();

            long[] arr = new long[n + 1];
            long[] prefix = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextLong();
                prefix[i] = prefix[i - 1] + arr[i];
            }

            long totalSum = prefix[n];

            while (q-- > 0) {

                int l = sc.nextInt();
                int r = sc.nextInt();
                long k = sc.nextLong();

                long segmentSum = prefix[r] - prefix[l - 1];
                long len = r - l + 1;

                long newSum = totalSum - segmentSum + len * k;

                if (newSum % 2 == 1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
