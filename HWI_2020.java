import java.util.*;
public class HWI_2020 {
    static final int MAX = 2000005;
    static boolean[] isPrime = new boolean[MAX];
    static ArrayList<Integer> primes = new ArrayList<>();

    // Sieve of Eratosthenes
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }

    // Binary search: first prime >= x
    static int lowerBound(int x) {
        int l = 0, r = primes.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (primes.get(mid) >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // Compute minimum cost to convert (a, b)
    static long costToPair(int a, int b) {
        int idx = lowerBound(a);
        if (idx == -1) return Long.MAX_VALUE;

        // Try few primes ahead (primes are dense)
        for (int i = idx; i < Math.min(idx + 50, primes.size() - 1); i++) {
            int p = primes.get(i);
            int nextP = primes.get(i + 1);

            if (nextP >= b) {
                return (p - a) + (nextP - b);
            }
        }

        return Long.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sieve();

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        long ops = 0;

        for (int i = 0; i < n; i++) {
            st.push(A[i]);

            while (st.size() >= 2) {
                int b = st.pop();
                int a = st.pop();

                long cost = costToPair(a, b);

                if (cost == Long.MAX_VALUE) {
                    // cannot pair → restore
                    st.push(a);
                    st.push(b);
                    break;
                } else {
                    ops += cost + 1; // +1 deletion
                }
            }
        }

        System.out.println(ops);
    }
}
