class Solution {
    public int maxArea(int[] height) {
    //since we have to increase the area we will take those length and width wihc are greater
int n=height.length;
int i=0;
int j=n-1;
int maxi=0;
while(i<j){
int length=Math.min(height[i],height[j]);
int width=j-i;
int area=length*width;
maxi=Math.max(maxi,area);
if(height[i]<height[j]){
i++;
}
else {
j--;
}
} 
return maxi;   
    }
}