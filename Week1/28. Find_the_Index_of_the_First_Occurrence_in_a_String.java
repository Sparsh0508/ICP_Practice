class Solution {
    public int strStr(String haystack, String needle) {

        //Brute Force
        int n1 = haystack.length();
        int n2 = needle.length();
        int k = 0;
        for(int i = 0;i<n1;i++){
            if(haystack.charAt(i)==needle.charAt(k)){
                int j =i;
                k=0;
                boolean flag = true;
                while(k<n2){
                    if(haystack.charAt(j) != needle.charAt(k)){
                        flag = false;
                        break;
                    }else{
                        j++;
                        k++;
                    }

                }
                if(flag) return i;
            }
        }
        return -1;

        // First Approach
        return haystack.indexOf(needle);

       // Second Approach
        if(haystack.length()<needle.length()) return -1;
        int n1 = haystack.length();
        int n2 = needle.length();
        for(int i = 0;i<=n1-n2;i++){
            String str = haystack.substring(i,i+n2);
            if(str.equals(needle)){
                return i;
            }
        }
        return -1;
    
       
    }
}
