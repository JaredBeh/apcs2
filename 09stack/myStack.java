public class myStack<T>{
    private myLinkedList<T> stack;
    public myStack(){
	stack = new myLinkedList<T>(new myLNode<T>(null));
    }
    public void push(T thing){
	stack.add(0,thing);
    }
    public T pop(){
	if(empty())/*throw new EmptyStackException()*/return null;
	T ans=stack.get(0);
	return stack.remove(0);
    }
    public boolean empty(){
	return stack.size()<=1;
    }
    public T peek(){
	if(empty())return null;
	return stack.get(0);
    }
    public String toString(){
	return stack.toString();
    }
    public static void main(String[]args){
	myStack<Integer> buster=new myStack<Integer>();
	buster.push(15);
	System.out.println(buster.pop());
	System.out.println(buster);
    }
}
