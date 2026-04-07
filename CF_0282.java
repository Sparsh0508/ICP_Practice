import java.util.Scanner;

public class CF_0282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for(int i = 0;i<n;i++){
            String s = sc.next();
            if(s.charAt(1) == '+'){
                ans++;
            }else{
                ans--;
            }
        }
        System.out.println(ans);
    }
}
