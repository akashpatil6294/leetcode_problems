class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int rows=mat.length;
        int cols=mat[0].length;
        int low=0;
        int high=rows*cols-1;
     
        while(low<=high){
            int mid=low+(high-low)/2;
           int  row=mid/cols;
            int col=mid%cols;
            if(mat[row][col]==target) return true;
            else if(mat[row][col]>target) high=mid-1;
            else low=mid+1;
        }
  

        return false;
    }
}