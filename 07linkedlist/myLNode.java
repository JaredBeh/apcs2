public class myLNode{
    private Object value;
    private myLNode next;
    public myLNode(Object a,myLNode n){
	setValue(a);
	setNext(n);
    }
    public myLNode(Object a){
	setValue(a);
    }
    public myLNode(){
	this(0);
    }
    public void setValue(Object n){
	value=n;
    }
    public void setNext(myLNode n){
	next=n;
    }
    public Object getValue(){
	return value;
    }
    public myLNode getNext(){
	return next;
    }
    public String toString(){
	return value.toString();
    }
}
