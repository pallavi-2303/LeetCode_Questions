class Solution {
public int findReverse(int num){
long reverse=0;
while(num!=0){
int rem=num%10;
reverse*=10;
reverse+=rem;
if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE ) return 0;
num/=10;
}
return (int)reverse;
}
    public int reverse(int x) {
    int num=Math.abs(x);
int Reverse=findReverse( num);
return x< 0 ? -(Reverse) :Reverse;
    }
}