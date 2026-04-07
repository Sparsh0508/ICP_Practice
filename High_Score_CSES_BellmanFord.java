import java.util.*;

public class High_Score_CSES_BellmanFord {

    static class Edge {
        int u, v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            long w = sc.nextLong();

            edges.add(new Edge(a, b, -w));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 0;

        for(int i = 1; i < n; i++){
            for(Edge e : edges){
                if(dist[e.u] != Long.MAX_VALUE &&
                        dist[e.u] + e.w < dist[e.v]){

                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(Edge e : edges){

                if(dist[e.u] != Long.MAX_VALUE &&
                        dist[e.u] + e.w < dist[e.v]){

                    dist[e.v] = Long.MIN_VALUE;
                }
            }
        }

        if(dist[n] == Long.MIN_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(-dist[n]);
        }
    }
}