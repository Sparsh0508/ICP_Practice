import java.util.Scanner;

public class CF_1899B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            long[] pref = new long[n+1];
            for(int i=0;i<n;i++){
                pref[i+1] = pref[i] + arr[i];
            }
            long ans = 0;
            for(int k = 1;k<=n;k++){
                if(n%k == 0){
                    long minSum = Long.MAX_VALUE;
                    long maxSum = Long.MIN_VALUE;
                    for(int i = 0;i<n;i+=k){
                        long sum = pref[i+k] - pref[i];
                        minSum = Math.min(minSum,sum);
                        maxSum = Math.max(maxSum,sum);
                    }
                    ans = Math.max(ans,maxSum - minSum);
                }
            }
            System.out.println(ans);
        }
    }
}
