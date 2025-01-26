class LRUCache {
Node head=new Node(0,0);
Node tail=new Node(0,0);
HashMap<Integer,Node> mp=new HashMap<>();
int capacity;
    public LRUCache(int capacity) {
      this.capacity=capacity;
      tail.prev=head;
      head.next=tail;  
    }
    public void deleteTheNode(Node node){
    Node nextNode=node.next;
    Node prevNode=node.prev;
    //we have to delte the articular node 
    nextNode.prev=prevNode;
    prevNode.next=nextNode;
    }
public void insertAfterHead(Node node){
   Node afterHead=head.next;
   head.next=node;
   node.prev=head;
   node.next=afterHead;
   afterHead.prev=node; 
    }
    public int get(int key) {
//if key is not present in the map
if(!mp.containsKey(key)) {
return -1;
}  
//if key is present in map
 Node node=mp.get(key); //it will give its value
 deleteTheNode(node);
 insertAfterHead(node);
return node.value;
    }
    
    public void put(int key, int value) {
    //first case if the key is already present then just update its value
   if(mp.containsKey(key)){
    Node node=mp.get(key);
    node.value=value;
    mp.put(key,node);
deleteTheNode(node);
 insertAfterHead(node);
   }
   else {
if(mp.size()==capacity){
Node node=tail.prev;
//we have to remove this node
deleteTheNode(node);
mp.remove(node.key);
}
//Now ew have to pput this
Node node=new Node(key,value);
mp.put(key,node);
insertAfterHead(node);//it is the recnt node
   }
    }
//let just first create the class of Node
public class Node{
    Node prev;
    Node next;
int key,value;
public Node(int key,int value){
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