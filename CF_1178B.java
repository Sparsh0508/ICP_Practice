import java.util.*;
public class CF_1178B {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        long total = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == 'v' && s.charAt(i+1) == 'v'){
                total++;
            }
        }

        long left = 0;
        long ans = 0;

        for(int i = 0; i < s.length(); i++){

            if(i > 0 && s.charAt(i) == 'v' && s.charAt(i-1) == 'v'){
                left++;
            }

            if(s.charAt(i) == 'o'){
                ans += left * (total - left);
            }
        }

        System.out.println(ans);
    }
}