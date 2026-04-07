import java.util.*;
public class CF_0020C {
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
        ArrayList<Integer> ans = shortestPath(n, m, edges);

        if(ans.size() == 1 && ans.get(0) == -1){
            System.out.println(-1);
            return;
        }

        for(int x : ans){
            System.out.print(x + " ");
        }
    }
    public static ArrayList<Integer> shortestPath(int n,int m,int[][] edges){
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
        int[] par = new int[n+1];
        for(int i = 1;i<=n;i++){
            par[i] = i;
        }

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int dis = curr.dist;
            if(dis > dist[node]){
                continue;
            }
            for(Pair nei : adj.get(node)){
                int adjNode = nei.node;
                int wei = nei.dist;
                if(dis + wei < dist[adjNode]){
                    dist[adjNode] = dis + wei;
                    par[adjNode] = node;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[n] == Integer.MAX_VALUE){
            return new ArrayList<>(Arrays.asList(-1));
        }
        ArrayList<Integer> path = new ArrayList<>();
        int node = n;
        while(par[node] != node){
            path.add(node);
            node = par[node];   
        }
        path.add(1);
        Collections.reverse(path);
        return path;
     }
}
