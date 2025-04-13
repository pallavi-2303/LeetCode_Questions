class LRUCache {
Node head=new Node(0,0);
Node tail=new Node(0,0);
int capacity;
HashMap<Integer,Node> mp=new HashMap<>();
    public LRUCache(int capacity) {
      this.capacity=capacity;
      head.next=tail;
      tail.prev=head;  
    }
   public void deleteNode(Node node) {
Node nextNode=node.next;
Node prevNode=node.prev;
nextNode.prev=prevNode;
prevNode.next=nextNode;
   }
public void insertAfterHead(Node node){
Node headNext=head.next;
node.next=headNext;
head.next=node;
node.prev=head;
headNext.prev=node;
}
    public int get(int key) {
     //if the key if not present in map
     if(!mp.containsKey(key)) return -1;
     Node node=mp.get(key);
     deleteNode(node);
     insertAfterHead(node);
     return node.value; 
    }
    
    public void put(int key, int value) {
    //if the key is already present in map just update its value
   if(mp.containsKey(key)){
Node node=mp.get(key);
node.value=value;
mp.put(key,node);
deleteNode(node); 
insertAfterHead(node);
   }
   else {
//if size == capacity  delte the last node
if(mp.size()==capacity){
Node tailprev=tail.prev;
//delte this nnode
deleteNode(tailprev);
mp.remove(tailprev.key);
}
//the node is delte if size is full now insert the new node
Node newNode=new Node(key,value);
mp.put(key,newNode);
insertAfterHead(newNode);
   }

    }
public class Node{
Node prev;
Node next;
int key;
int value;
Node(int key,int value){
this.key=key;
this.value=value;
}
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */