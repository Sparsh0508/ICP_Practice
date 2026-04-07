import java.util.*;

public class EasyLuckyTickets {
    static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] digits = new int[k];
        for (int i = 0; i < k; i++) digits[i] = sc.nextInt();

        int m = n / 2;
        int maxSum = 9 * m;

        long[] dp = new long[maxSum + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            long[] ndp = new long[maxSum + 1];
            for (int s = 0; s <= maxSum; s++) {
                if (dp[s] == 0) continue;
                for (int d : digits) {
                    ndp[s + d] = (ndp[s + d] + dp[s]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = 0; s <= maxSum; s++) {
            ans = (ans + dp[s] * dp[s]) % MOD;
        }

        System.out.println(ans);
    }
}