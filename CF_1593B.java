import java.util.*;
public class CF_1593B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String[] target = {"00","25","50","75"};
        while (l-- >0) {
            String s = sc.next();
            int n = s.length();
            int ans = Integer.MAX_VALUE;
            for(String t : target){
                int d = 0;
                int j = 1;
                for(int i = n-1;i>=0;i--){
                    if(s.charAt(i) == t.charAt(j)){
                        j--;
                        if(j<0){
                            ans = Math.min(ans,d);
                            break;
                        }
                    }else{
                        d++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
