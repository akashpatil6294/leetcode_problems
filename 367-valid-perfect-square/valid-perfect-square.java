class Solution {
    public boolean isPerfectSquare(long num) {
        long low=1;
        long high=num;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(num/mid==mid && num%mid==0){
                return true;
            }
            else if(mid<=num/mid){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;

        
    }
}