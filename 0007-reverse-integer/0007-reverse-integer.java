class Solution {
    public int reverse(int x) {
   long rev=0;
        int temp=x;
        while(temp!=0){
            rev*=10;
            int rem=temp%10;
            rev+=rem;
            temp/=10;
            if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)rev;
    }
}