import java.util.*;

public class CF_1832B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            long[] pref = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pref[i + 1] = pref[i] + arr[i];
            }

            long maxSum = 0;

            for (int i = 0; i <= k; i++) {
                int left = 2 * i;
                int right = n - (k - i);

                if (left <= right) {
                    long sum = pref[right] - pref[left];
                    maxSum = Math.max(maxSum, sum);
                }
            }

            System.out.println(maxSum);
        }
    }
}