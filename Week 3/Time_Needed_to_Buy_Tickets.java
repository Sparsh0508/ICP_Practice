class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int sum = 0;
        while(arr[k] > 0){
            for(int i = 0;i<arr.length;i++){
                if(arr[i] > 0){
                    if(arr[k] <= 0){
                        return sum;
                    }
                arr[i]--;
                sum++;
                }
            }
        }
        return sum;
    }
}
