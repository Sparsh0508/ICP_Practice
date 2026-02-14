import java.util.*;

public class CF_1883B {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();

            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            int odd =0;
            for (int f : freq) {
                if ((f % 2) == 1) {
                    odd++;
                }
            }
            int m = n - k;
            int need = Math.max(0, odd - (m % 2));

            if (k >= need) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
