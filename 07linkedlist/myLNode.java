public class myLNode<T>{
    private T value;
    private myLNode<T> next;
    public myLNode(T a,myLNode<T> n){
	setValue(a);
	setNext(n);
    }
    public myLNode(T a){
	setValue(a);
    }
    public void setValue(T n){
	value=n;
    }
    public void setNext(myLNode<T> n){
	next=n;
    }
    public T getValue(){
	return value;
    }
    public myLNode<T> getNext(){
	return next;
    }
    public String toString(){
	return value.toString();
    }
}
