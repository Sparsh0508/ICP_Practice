class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //Brute force first approach
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
           if(i>0 && nums[i] == nums[i-1]) continue;
           for(int j = i+1;j<n-1;j++){
            if(j>i+1 && nums[j] == nums[j-1]) continue;
            for(int k = j+1;k<n;k++){
                if(k>j+1 && nums[k]==nums[k-1]) continue;
                if(nums[i]+nums[j]+nums[k] == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
           }
        }

        //Brute force second approach
        int n = nums.length;
        
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    List<Integer> curr = new ArrayList<>(); 
                    if(nums[i]+nums[j]+nums[k]==0){
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        Collections.sort(curr);
                         boolean duplicate = false;
                        for (List<Integer> list : res) {
                            if (list.equals(curr)) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (!duplicate) {                            
                            res.add(curr);
                        }   
                       
                    }
                }
            }
        }
        return res;
    }
    // Third Approach
            Arrays.sort(nums);
            int n =  nums.length;
            for(int i = 0;i<n;i++)
            {
                if(i>0 && nums[i]==nums[i-1]) continue;
                int j = i+1;
                int k = n-1;
                while(j<k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum<0){
                        j++;
                    }else if(sum>0){
                        k--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;
                        while(j<k && nums[j]==nums[j-1]) j++;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    }
                }
                
            }
        return res;
}
