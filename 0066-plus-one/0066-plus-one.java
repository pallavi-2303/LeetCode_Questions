class Solution {
    public int[] plusOne(int[] digits) {
     long res=0;
     for(int num:digits){
    res*=10;
    res+=num;
     } 
    res+=1;
int[] ans = Integer.toString((int)res).chars().map(c -> c - '0').toArray();
return ans;
    }
}