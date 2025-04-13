class Solution {
    public int mod=(int)1e9+7;
    public long findPower(long number,long power){
    if(power==0) return 1;
    long res=1;
    number=number%mod;
    while(power>0){
    if(power%2==1){
    res=res*number%mod;
    power-=1;
    }
    else {
    number=(number*number)%mod;
    power/=2;
    }
    }
    return res%mod;
    }
    public int countGoodNumbers(long n) {
    //since we have to make good numbers let say n=5 even indices 3 and odd=2 //even index has 5 possibiblity and odd index has 4 as 0 2 4 6 8 and 2 3 5 7
    long even=(n+1)/2;
    long odd=n/2;
    long first=findPower(5,even)%mod;
    long second=findPower(4,odd)%mod;
    long result=(first*second)%mod;
    return (int)result;
    }
}