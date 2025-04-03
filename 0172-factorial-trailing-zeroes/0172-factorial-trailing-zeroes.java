class Solution {
    public int trailingZeroes(int n) {
   //brute force
//    long fact=1;
//    for(int i=1;i<=n;i++){
//     fact*=(long)i;
//    }  
// String factorial=Long.toString(fact);
// long count=0;
// int m=factorial.length();
// for(int i=m-1;i>=0;i--){
// int ch=factorial.charAt(i)-'0';
// if(ch==0) count++;
// else if(ch>0) break;
// }
// return (int)count;
//trailling zero in tthe nnumber come from multile of 10 as 5*2 so number of times  5 and 2 come tailing zero come or number of times 5 coes zero comes
int count=0;
while(n>=5){
n/=5;
count+=n;
}
return count;
    }
}