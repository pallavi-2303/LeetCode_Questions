class Solution {
    public int[] queryResults(int limit, int[][] queries) {
     int n=queries.length;
     int[] res=new int[n];
     HashMap<Integer,Integer> balls=new HashMap<>();
     HashMap<Integer,Integer> colors=new HashMap<>();
      for(int i=0;i<n;i++) {
    int ball=queries[i][0];
    int color=queries[i][1];
    //if this ball is not colored previouly
    if(!balls.containsKey(ball)){
    balls.put(ball,color) ;
    colors.put(color,colors.getOrDefault(color,0)+1); 
    }
    else {
    //if this ball is already present in ball array and it is already colored
    int oldColor=balls.get(ball);
    colors.put(oldColor,colors.get(oldColor)-1);
    if(colors.get(oldColor)==0){
        colors.remove(oldColor);
    }
   colors.put(color,colors.getOrDefault(color,0)+1);
balls.put(ball,color);
    }
    res[i]=colors.size();
      }
      return res;
    }
}