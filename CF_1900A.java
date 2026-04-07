import java.util.*;

public class CF_1900A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean flag = false;
            for(int i = 2;i<n;i++){
                if(s.charAt(i-2) == '.' && s.charAt(i-1) == '.' && s.charAt(i) == '.'){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(2);
                continue;
            }
            int count= 0;
            for(int i= 0;i<n;i++){
                if(s.charAt(i) == '.'){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
