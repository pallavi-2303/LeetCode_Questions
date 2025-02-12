class Solution {
    public int findReverse(int num){
    long reverse=0;
    while(num>0){
    int rem=num%10;
    reverse*=10;
    reverse+=rem;
    num/=10;
    }
    return (int)reverse;
    }
    public boolean isPalindrome(int x) {
      if(x<0)  return false;
      int num=Math.abs(x);
      return x==findReverse(num);
    }
}