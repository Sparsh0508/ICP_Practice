import java.util.Scanner;

public class Shortest_RoutesII_FloydWarshell {
   public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int q = sc.nextInt();

    long INF = (long)1e18;
    long[][] dist = new long[n+1][n+1];

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }

    for(int i = 0; i < m; i++){
        int a = sc.nextInt();
        int b = sc.nextInt();
        long w = sc.nextLong();

        dist[a][b] = Math.min(dist[a][b], w);
        dist[b][a] = Math.min(dist[b][a], w);
    }
    for(int k = 1; k <= n; k++){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][k] != INF && dist[k][j] != INF){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    while(q-- > 0){
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(dist[a][b] == INF) System.out.println(-1);
        else System.out.println(dist[a][b]);
    }
   }
}