class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalsum=0,left=0,right=0;
        for (int num:nums){
            totalsum+=num;
        }
        for (int i=0;i<nums.length;i++){
            right=totalsum-left-nums[i];
            if(right==left){
                return i;
            }
            left+=nums[i];
        }
        return -1;
        
    }
}