import java.util.*;

public class CF_1873C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            char[][] grid = new char[10][10];

            for (int i = 0; i < 10; i++) {
                grid[i] = sc.next().toCharArray();
            }

            int ans = 0;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    if (grid[i][j] == 'X') {
                        int ring = Math.min(
                                Math.min(i, j),
                                Math.min(9 - i, 9 - j)
                        );

                        ans += ring + 1;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}