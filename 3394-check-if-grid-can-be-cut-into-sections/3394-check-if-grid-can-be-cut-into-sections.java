class Solution {
    public class  pair{
    int first;
    int second;
    public pair(int first,int second){
this.first=first;
this.second=second;
    }
    }
    public boolean findCheck(List<pair> arr){
    int lines=0;
    int overlap=0;
    for(pair it:arr){
    if(it.second==0) overlap--;
    else overlap++;
    if(overlap==0) lines++;
    }
    return lines>=3;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
      //we will use sweep lines to find the answer we will amke sweep on x and y axis
List<pair> x_coordinate=new ArrayList<>();
List<pair> y_coordinate=new ArrayList<>();
for(int i=0;i<rectangles.length;i++){
x_coordinate.add(new pair(rectangles[i][0],1));
x_coordinate.add(new pair(rectangles[i][2],0));
y_coordinate.add(new pair(rectangles[i][1],1));
y_coordinate.add(new pair(rectangles[i][3],0));
}
 x_coordinate.sort((a, b) -> a.first == b.first ? a.second - b.second : a.first - b.first);
        y_coordinate.sort((a, b) -> a.first == b.first ? a.second - b.second : a.first - b.first);

return findCheck(x_coordinate) || findCheck(y_coordinate);
    }
}