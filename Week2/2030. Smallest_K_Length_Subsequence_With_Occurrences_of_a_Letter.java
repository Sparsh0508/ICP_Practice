// Brute Force 
class Solution {
    ArrayList<String> al = new ArrayList<>();
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        subSeq(s, 0, "",k);
        String ans = "";
        for(int i=0;i<al.size();i++){
            if(al.get(i).length()==k){
                if(valid(al.get(i),letter,repetition)){
                    if(ans.equals("")) ans += al.get(i);
                    else ans = check(ans,al.get(i));
                }
            }
        }
        return  ans;
    }
    public void subSeq(String s, int i , String curr , int k){
        if(i==s.length()){
            if(curr.length()==k) al.add(curr);
            return;
        }
        subSeq(s,i+1,curr,k);
        curr+=s.charAt(i);
        subSeq(s,i+1,curr,k);
    }
    public boolean valid(String s , char c, int r){
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==c){
                cnt++;
            }
        }
        return cnt>=r;
    }
    public String check(String s, String p){
        int i =0;
        while(i<s.length()){
            if(s.charAt(i)<p.charAt(i)) return s;
            else if(s.charAt(i)>p.charAt(i)) return p;
            i++;
        }
        return s;
    }
}


