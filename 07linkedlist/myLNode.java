public class myLNode{
    private int value;
    private myLNode next;
    public LNode(int a,LNode n){
	setValue(a);
	setNext(n);
    }
    public LNode(int a){
	setValue(a);
    }
    public LNode(){
	this(0);
    }
    public void setValue(int n){
	value=n;
    }
    public void setNext(myLNode n){
	next=n;
    }
    public int getValue(){
	return value;
    }
    public myLNode getNext(){
	return next;
    }
    public String toString(){
	return ""+value;
    }
}