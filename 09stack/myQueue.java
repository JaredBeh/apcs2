import java.util.*;
public class myQueue<T>{
    private myLinkedList<T> q;
    public myQueue(){
	q=new myLinkedList<T>();
    }
    public T enqueue(T thing){
	if(thing==null)throw new NullPointerException();
	q.add(thing);
	return thing;
    }
    public T dequeue(){
	if(q.size()==0)throw new NoSuchElementException();
	return q.remove(0);
    }
    public T element(){
	if(q.size()==0)throw new NoSuchElementException();
	return q.get(0);
    }
    public String toString(){
	return q.toString();
    }
    public static void main(String[]args){
	myQueue<Integer> q=new myQueue<Integer>();
	System.out.println(q.enqueue(3));
	System.out.println(q.enqueue(1));
	System.out.println(q.element());
	System.out.println(q);
    }
}
