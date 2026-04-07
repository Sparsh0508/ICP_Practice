import java.util.*;

public class Shortest_Routes {

    public static class Pair{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        int[] ans = shortestRoutes(n, m, edges);
        for(int i = 1;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
    }
   
    public static int[] shortestRoutes(int n,int m,int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(1,0 ));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.dist;
            for(Pair nei : adj.get(node)){
                int newDist = currDist + nei.dist;
                if(newDist < dist[nei.node]){
                    dist[nei.node] = newDist;
                    pq.add(new Pair(nei.node, newDist));
                }
            }
        }

        
        return dist;
    }
}