import java.util.*;
public class CF_2218B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int[] arr = new int[7];
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0;i<7;i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                sum += arr[i];
            }
            System.out.println(-sum + max + max);
            
            
        }
    }
}
