import java.util.Scanner;

public class CF_2200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            
            int max = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                max = Math.max(max, a[i]);
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == max) {
                    c++;
                }
            }
            
            System.out.println(c);
        }
    }
}
