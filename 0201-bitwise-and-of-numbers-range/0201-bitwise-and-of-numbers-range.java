class Solution {
    public int rangeBitwiseAnd(int left, int right) {
     //brute force
  while(left<right){
right=right&(right-1);
  }
return left&right;
    }
}