//First Approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int [n+m];
        int k = 0;
        for(int i= 0;i<nums1.length;i++){
            arr[k] = nums1[i];
            k++;
        }
        for(int i= 0;i<m;i++){
            arr[k] = nums2[i];
            k++;
        }
        Arrays.sort(arr);
        if(arr.length%2==1){
            return arr[arr.length/2];
        }else{

        return(double) (arr[arr.length/2]+arr[arr.length/2-1])/2;
        }
    }
}
