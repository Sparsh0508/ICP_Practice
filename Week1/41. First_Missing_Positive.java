//First Approach
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for(int i : nums){
            if(i==num)
            {
                num++;
            }
        }
        return num;
    }
}

//Second Approach 
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        int i = 1;
        boolean flag = true;
        while(flag){
            if(!hs.contains(i)){
                return i;

            }
            i++;
        }
        return  0;

    }
}
