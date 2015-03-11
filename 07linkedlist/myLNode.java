public class myLNode{
    private int value;
    private myLNode next;
    public myLNode(int a,myLNode n){
	setValue(a);
	setNext(n);
    }
    public myLNode(int a){
	setValue(a);
    }
    public myLNode(){
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
