public class myQueue<T> extends myStack<T>{
    public T enqueue(T thing){
	stack.add(thing);
	return thing;
    }
    public T dequeue(){
	return pop();
    }
    public static void main(String[]args){
	myQueue<Integer> q=new myQueue<Integer>();
	q.enqueue(3);
	System.out.println(q.dequeue());
    }
}