import java.util.Arrays;
import java.util.Scanner;

public class CF_2200B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            
            int maxLen = 1;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j] <= a[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            
            System.out.println(maxLen);
        }
    }
}
