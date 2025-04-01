class Solution {
    public int reverse(int x){
    int reverse=0;
    while(x>0){
    reverse*=10;
    int rem=x%10;
    reverse+=rem;
    x/=10;
    }
    return reverse;
    }
    public boolean isPalindrome(int x) {
     if(x<0)  return  false;
     return x==reverse(x); 
    }
}