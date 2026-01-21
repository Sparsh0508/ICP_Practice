class Solution {
    public int maxSumMinProduct(int[] nums) {
       // Brute Force
        long ans =0;
        long mod = 1_000_000_007;
        for(int i = 0;i<nums.length;i++){
            long min = nums[i];
            long sum = 0;
            for(int j = i;j<nums.length;j++){
                min = Math.min(min,nums[j]);
                sum += nums[j];
                ans = Math.max(ans,min*sum);
            }

        }
        return (int)(ans%mod);
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Optimal Approach
        long[] pre = new long[nums.length+1];
        // pre[0] = nums[0]; 
        long ans = 0;
        for(int i = 0;i<nums.length;i++){
            pre[i+1] = pre[i]+nums[i];
        }
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        int[] nse = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
             while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        for(int i = 0;i<nums.length;i++){
            int l = pse[i]+1;  
            int r = nse[i]-1;
            long sum =  pre[r+1]-pre[l];
            long subarray = sum * nums[i];
            ans = Math.max(ans,subarray);
        }
        return (int)(ans%1_000_000_007);

    }
}
