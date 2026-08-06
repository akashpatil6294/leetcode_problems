class Solution {
    public int productdigit(int num){
        int prod=1;
        while(num>0){
            prod*=num%10;
            num/=10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
       
        while(true){
            if(productdigit(n)%t==0){
                return n;
            }
            n++;
        }

    
    }
}