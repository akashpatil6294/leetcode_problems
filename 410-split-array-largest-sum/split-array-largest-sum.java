class Solution {
    public int countsubarrays(int[] nums,int maxsum){
        int count=1;
        int currSum=0;
        for(int  num:nums){
            if(currSum+num<=maxsum){
                currSum+=num;
            }
            else{
                count++;
                currSum=num;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        int ans=-1;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countsubarrays(nums,mid)<=k){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}