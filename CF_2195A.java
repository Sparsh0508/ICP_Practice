import java.util.*;

public class CF_2195A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean flag = solve(arr, 0, 1);
            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static boolean solve(int[] arr, int idx, int product) {
        if (product == 67) return true;
        
        if (idx == arr.length || product > 67) return false;
        
        boolean take = false;
        if (67 % (product * arr[idx]) == 0) {
            take = solve(arr, idx + 1, product * arr[idx]);
        }
        
        boolean notTake = solve(arr, idx + 1, product);

        return take || notTake;
    }
}