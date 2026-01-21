//First Approach 

class Solution {
    public int minNumberOperations(int[] target) {
        int cnt = target[0];
        for(int i = 1;i<target.length;i++){
            if(target[i]>target[i-1]){
                cnt+=target[i]-target[i-1];
            }
        }
        return cnt;
    }
}

//Second Approach

class Solution {
    public int minNumberOperations(int[] target) {
        Stack<Integer> st = new Stack<>();
        int n = target.length;
        int cnt = target[0];
        st.push(cnt);
        for(int i = 1;i<n;i++){
            cnt += Math.max(target[i]-st.peek(),0);    
            st.push(target[i]);
        }
        return cnt;
    }
}

