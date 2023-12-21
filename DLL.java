public class DLL<T>{


public class Node<U> {
    
    private T store; 
    private Node<T> next;
    private Node<T> prev; 


    public Node(){

    } 

    public Node(T store){
    this.store = store;
    } 

    public Node(T store, Node<T> prev, Node<T> next){
    this.store = store;
    this.next = next;
    this.prev = prev;
    } 
    
    public void setStore(T store){ //setter method
        this.store = store;
    }

    public T getStore(){ //getter method
        return store; 
    }
    
    public void setNext(Node<T> next){ //setter method
        this.next = next;
    }
     
    public Node<T> getNext(){ //getter method
        return next; 
   }

    public void setPrev(Node<T> prev){ //setter method
        this.prev = prev;
    }
     
    public Node<T> getPrev(){ //getter Method
        return prev; 
   }
   
   public String toString(){ //Allows toString() to work properly
   return String.valueOf(store);
   }

}


private Node<T> head;
private Node<T> tail;
private int counter; 

public DLL(){}

public int size(){
return counter;
}

public boolean isEmpty(){ // If empty returns true, if not returns false
if (counter > 0)
{
return false;
}
else{
return true;
}
}


public T first(){ // returns first element in the list
if(head != null){
System.out.println(head);
return head.getStore();
}
else{
return null; 
}
}

public T last(){ // returns last element in the list
if(tail != null){
System.out.println(tail.getStore());
return tail.getStore();
}
else{
return null; 
}
}


public void addFirst(T store){ // adds first element in the list
Node<T> node=new Node<T>(store);
if(head == null){            // Got idea and logic from https://github.com/JamieMac96/LinkedList-Implementation/blob/master/src/com/macmanus/linkedlist/LinkedList.java
head=node;
tail=node;
node.setNext(null);
node.setNext(null);
}
else{
node.setNext(head);
head.setPrev(node);
head=node;
}
counter ++; 
}

public void addLast(T store){ //adds last eleent in the list
Node<T> node=new Node<T>(store);
if(tail==null){
head=node;
tail=node;
node.setNext(null);
node.setNext(null);
} 
else{
node.setPrev(tail);
tail.setNext(node);
tail=node;
}
counter++;
}

public String toString(){  //Got idea to use StringBuilder from https://github.com/mulepati/LinkedList/blob/master/src/main/java/LinkedList.java
    if(head != null){
    Node<T> node = head;
    StringBuilder print = new StringBuilder();
    for(int i = 0; i < counter; i++) { // allows me to traverse list, in order to print out elements
    print.append(node.store + " ");
    node = node.next;
    }
    return print.toString();
}
else{
System.out.println("List is empty");
return null;
}
}




public T removeFirst(){ //removes first element
while(head != null){
if(head.next != null){
System.out.println(head);
head = head.next;
counter--;
return head.getStore();
}
if(head.next == null){
head = null;
counter--;
return null;
}
}
return null;
}






public T removeLast(){ // removes last element
if(tail != null){
System.out.println(tail);
tail = tail.prev;
counter--;
return tail.getStore();
}
else{
return null;
}
} 

public void insert(int index, T store){ //inserts an element at the index you choose
    if(index == counter)
    addLast(store);
    else if (index == 0){
    addFirst(store);
    }
    else if(counter < index ){
    System.out.println("You are out of bounds. Make sure your index isn't greater than your list for insert().");
    }
    else {
    Node<T> node=new Node<T>(store);                      
    Node<T> newNode = head; 
    for (int i = 0; i < index - 1; i++) {
        newNode = newNode.next;
    }
    node.next = newNode.next;
    newNode.next = node; 
    counter++;
    }
}

public T get(int index){ // finds an element at the index you give it
if(index == counter-1)
{
System.out.println(tail);
return tail.getStore();
}
else if (head == null){
System.out.println("List is empty or this index doesn't exist in your list");
return null;
}
else{
Node<T> node = head; 
  for (int i = 0; i < index; i++) {
        node = node.getNext();
        
    }
  T value = node.getNext().getStore();
  System.out.println(node);
  return value;

}
}


public void remove(int index){ // removes an element from the index you choose
if(index==0)
removeFirst();
else if(counter == index){
index--;
counter++;
removeLast();
}
else if(isEmpty()){
System.out.println("List is Empty. No element to remove.");
}
else if(index > counter){
System.out.println("There is no node at this index.");
}
else{
Node<T> node= new Node<T>();
node = head; 
for (int i = 0; i < index-1; i++) {
        node = node.next;
    }
System.out.println(node.next);
counter--;
node.next = node.next.next; 
}
} 

public void remove(Node<T> x) { // removes a node you choose, use find() method in main method in order to do this
Node<T> node = head;
Node<T> prev = null; 
if(isEmpty()){
System.out.println("Add elements.");
}
else if(node != x){
System.out.println("This node doesn't exist.");
}
else{
for(int i = 0; i < counter; i++){
if(node.equals(x)){
prev.next = node.next;
counter--; 
}
prev = node; 
node = node.next;
}
}

}

public DLL<T>.Node<T> findNode(T value) { // Made in order to make a swap node method
    DLL<T>.Node<T> node = head;
    for(int i = 0; i < counter; i++) {
        if (node.getStore().equals(value)) {
        return node;
        }
        node = node.getNext();
    }
    return null; 
}

public void swap(Node<T> x, Node<T> y){ // Swaps nodes
Node<T> prevNodeX = null; // //Got idea from https://www.javatpoint.com/program-to-swap-nodes-in-a-singly-linked-list-without-swapping-data 
Node<T> nodeX = head;
Node<T> prevNodeY = null;
Node<T> nodeY = head; 

if(head == null){
System.out.println("List is empty.");
return;
}

if(x == y){
System.out.println("Can't swap the same node or your values aren't in the list.");
return;
}

while(nodeX != null && nodeX != x){
prevNodeX = nodeX;
nodeX = nodeX.next;
}

while(nodeY != null && nodeY != y){
prevNodeY = nodeY;
nodeY = nodeY.next;
}

if(nodeX != null && nodeY != null){

if(prevNodeX != null)
prevNodeX.next = nodeY;
else 
head = nodeY;

if(prevNodeY != null)
prevNodeY.next = nodeX;
else
head = nodeX;

Node<T> temp = nodeX.next;
nodeX.next = nodeY.next;
nodeY.next = temp;
}

else{
System.out.println("Can't swap.");
}
        
}  




public Node<T> find(T store){ //Finds the refrence for the node conainting the element you were looking for. Put node.find().getStore() in order to show that you are getting the correct node, should show element you are looking for.
    Node<T> node = head;
for (int i = 0; i < counter; i++) {
    if(node.getStore().equals(store)) {
    return node;}
    node = node.getNext(); }

System.out.println("This store value doesn't exist.");
return null; 
}   



public void clear() //Clears list
{
head = null;
counter = 0;
tail = null;
}



public T set(int index, T store){  //Choose an index and replace the elemnt inside with what you place in store
if(isEmpty()){
System.out.println("In order to set you need to have elements currently stored. Use addFirst() and addLast().");
return null;
}
else if(index == 0){
addFirst(store);
remove(1);
return null;
}
else if(index > counter){
System.out.println("Your index doesn't exist in your set() method. Try again.");
return null;
}
else{
  Node<T> node = head; 
  for (int i = 0; i < index-1; i++) {
        node = node.getNext();
    }
  System.out.println(node);
  T value = node.getNext().getStore();
  node.getNext().setStore(store);
  return value;
}
}



}












