class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int minPenalty = Integer.MAX_VALUE;
        int minHour = 0;
    //     //if shop is closed on Nth hour find the toal count of n when shop is opened for entire time
    //     int Ncount = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (customers.charAt(i) == 'N') {
    //             Ncount++;
    //         }
    //         int penalty = 0;
    //         int j = i - 1;
    //         //shop is opened 
    //         while (j >= 0) {
    //             if (customers.charAt(j) == 'N') {
    //                 penalty++;
    //             }
    //             j--;
    //         }
    //         j = i;
    //         while (j < n) {
    //             if (customers.charAt(j) == 'Y') {
    //                 penalty++;
    //             }
    //             j++;
    //         }
    //         if (penalty < minPenalty) {
    //             minPenalty = penalty;
    //             minHour = i;
    //         }
    //     }
    // if(Ncount<minPenalty){
    // minHour=n;
    // }
    //     return minHour;
//for evrry index we are gain and gain calculating N count and Y count;
int[] prefixOpen=new int[n+1];
int[] suffixClose=new int[n+1];
//for 0 index no previous N count if we close at 0
prefixOpen[0]=0;
//for nth index means if we close the shop on nth index no Y from that 
suffixClose[n]=0;
for(int i=1;i<=n;i++){
//we are closing at this index means previous one are opened 
if(customers.charAt(i-1)=='N'){
prefixOpen[i]=1+prefixOpen[i-1];
}
else {
prefixOpen[i]=prefixOpen[i-1];
}
}
//Calculate for Y if it shop closes on ith index
for(int i=n-1;i>=0;i--){
if(customers.charAt(i)=='Y'){
suffixClose[i]=1+suffixClose[i+1];
}
else {
suffixClose[i]=suffixClose[i+1];  
}
}
//find min penalty for every index if shop closes on ith index
for(int i=0;i<=n;i++){
int penalty=prefixOpen[i]+suffixClose[i];
if(penalty<minPenalty){
minPenalty=penalty;
minHour=i;
}
}
return minHour;
    }
}