class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0,high=n-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=n-mid;
            if(citations[mid]>=count){
                ans=count;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
}