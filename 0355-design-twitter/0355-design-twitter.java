class Tweet implements Comparable<Tweet>{
int tweetId;
int time;
public Tweet(int tweetId,int time){
this.tweetId=tweetId;
this.time=time;
}
public int compareTo(Tweet that){
//arrange the tweet in decending order
return that.time-this.time;
}
}
class User{
int userId;
List<Tweet> tweets;
HashSet<Integer> followers;
public User(int userId){
this.userId=userId;
tweets=new LinkedList<>();
followers=new HashSet<>();
followers.add(userId);
}
public void addTweet(Tweet t){
tweets.add(0,t);
}
public void addFollower(int followerId){
followers.add(followerId);
}
public void removeFollower(int followerId){
followers.remove(followerId);
}
}
class Twitter {
HashMap<Integer,User> userMap;
int timestamps;
    public Twitter() {
      userMap=new HashMap<>();
     this.timestamps=0;
    }
    
    public void postTweet(int userId, int tweetId) {
    timestamps++;
    //if the user Id doesnot exist in usermap;
    if(!userMap.containsKey(userId))  {
   userMap.put(userId,new User(userId));
    }
User user=userMap.get(userId);
//insertion of tweet at the head of the tweets 
user.addTweet(new Tweet(tweetId,timestamps));
    }
    
    public List<Integer> getNewsFeed(int userId) {
if(!userMap.containsKey(userId)){
return new ArrayList<>();}
PriorityQueue<Tweet> pq=new PriorityQueue<>();
//We have to get 10 recent post of this is
User user=userMap.get(userId);
for(int followerId:user.followers){
int count=0;
for(Tweet tweet:userMap.get(followerId).tweets){
pq.offer(tweet);
if(count>10) break;}}
List<Integer> ans=new ArrayList<>();
int index=0;
while(!pq.isEmpty() && index<10){
index++;
Tweet tweet=pq.poll();
ans.add(tweet.tweetId);}
return ans;   
    }
    
    public void follow(int followerId, int followeeId) {
      //if the user doesnot exist than create the user
      if(!userMap.containsKey(followerId)){
   userMap.put(followerId,new User(followerId));
      }
      if(!userMap.containsKey(followeeId)){
   userMap.put(followeeId,new User(followeeId));
      }
User user=userMap.get(followerId);
user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
      //if the follower or the folowwe doesnot exist
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
    return;
      } 
User user=userMap.get(followerId);
user.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */