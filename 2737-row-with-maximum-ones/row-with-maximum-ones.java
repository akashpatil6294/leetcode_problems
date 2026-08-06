class Solution {     
    public int[] rowAndMaximumOnes(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int ans=-1;
       int countmax=-1;
       for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<m;j++){
            if(mat[i][j]==1){
                count++;
            }
        }
        if(count>countmax){
            countmax=count;
            ans=i;

        }
       }
       return new int[]{ans,countmax};
    }
}