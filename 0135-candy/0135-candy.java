class Solution {
    public int candy(int[] ratings) {
 int n=ratings.length;
int i=1;
int sum=1;
while(i<n){
if(ratings[i]==ratings[i-1]) {
 sum+=1;
 i++;
 continue;
}
//for upward curve
int peak=1;
while(i<n && ratings[i]>ratings[i-1]) {
 peak+=1;
 sum+=peak;
 i++;
}
//for downward curve
int down=1;
while(i<n && ratings[i-1]>ratings[i]) {
 sum+=down;
 down+=1;
 i++;
}
if(down>peak){
 sum+=(down-peak);
}
}
return sum;
        
    }
}