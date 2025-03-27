class Solution {
    public int candy(int[] ratings) {
     //brute force making a left and right array 
     int n=ratings.length;
//     int[] left=new int[n] ;
//    // int[] right=new int[n];
//     //brute force
//     left[0]=1;
//     for(int i=1;i<n;i++) {
//     if(ratings[i]>ratings[i-1]){
//     left[i]=left[i-1]+1;
//     }
//     else {
//         left[i]=1;
//     }
//     }
// right[n-1]=1;
// for(int i=n-2;i>=0;i--){
// if(ratings[i]>ratings[i+1]){
// right[i]=right[i+1]+1;
// }
// else {
// right[i]=1;
// }
// }
// int sum=0;
// for(int i=0;i<n;i++){
// sum+=Math.max(left[i],right[i]);
// }
// return sum;
//better solution of using a variable to store right index
// int sum=Math.max(1,left[n-1]);
// int curr=1;
// int right=0;
// for(int i=n-2;i>=0;i--){
//     if(ratings[i]>ratings[i+1]){
// right=curr+1;
//     }
//     else {
//     right=1;
//     }
// sum+=Math.max(left[i],right);
// curr=right;
// }
//most optimal aproach
//let just use the concept of upward and downward slope
int i=1;
int sum=1;
while(i<n){
if(i<n && ratings[i]==ratings[i-1]){
sum+=1;
i++;
continue;
}
//for the upward slope
int peak=1;
while(i<n && ratings[i]> ratings[i-1]){
peak++;
sum+=peak;
i++;
}
//for the downward slope
int down=1;
while(i<n && ratings[i]<ratings[i-1]){
sum+=down;
down++;
i++;
}
if(down>peak){
sum+=(down-peak);
}}
return sum;
    }
}