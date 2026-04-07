import java.util.*;
public class CF_0071A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(s.length() <= 10){
                System.out.println(s);
                continue;
            }
            System.out.print(s.charAt(0));
            System.out.print(s.length()-2);
            System.out.print(s.charAt(s.length()-1));
            System.out.println();
        }
    }
}
