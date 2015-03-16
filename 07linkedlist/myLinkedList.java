public class myLinkedList<T>{
    public myLNode head,tail;
    public int size;
    public myLinkedList(myLNode a){
	head=a;
	myLNode current=a;
	tail=head;
	size=1;
	while(current.getNext()!=null){
	    tail=tail.getNext();
	    size++;
	    current=current.getNext();
	}
    }
    public String name(){
	return "beh.jared";
    }
    public String toString(){
	myLNode current=head;
	String ans="["+current.getValue();
	while(current.getNext()!=null){
	    current=current.getNext();
	    ans+=", "+current.getValue();
	}
	return ans+"]";
    }
    public void set(int index,T value){
	if (index<0||index>=size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	myLNode current=head;
	while(--index>-1){
	    current=current.getNext();
	}
	current.setValue(value);
    }
    public T get(int index){
	if (index<0||index>=size)throw new ArrayIndexOutOfBoundsException();
	myLNode current=head;
	while(--index>-1)current=current.getNext();
	return current.getValue();
    }
    public void add(T value){
	tail.setNext(new myLNode(value));
	size++;
	tail=tail.getNext();
    }
    public void add(int index,T value){
	if (index<0||index>size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (index==size){
	    add(value);
	    return;
	}
	myLNode current=head;
	while(--index>-1)current=current.getNext();
	T temp=current.getValue();
	current.setValue(value);
	current.setNext(new myLNode(temp,current.getNext()));
	size++;
    }
    public void swap(int index1,int index2){
	T value1=get(index1);
	set(index1,get(index2));
	set(index2,value1);
    }
    public int indexOf(T value){
	myLNode current=head;
	int index=-1;
	try{
	    while(get(++index)!=value);
	}catch (ArrayIndexOutOfBoundsException e){
	    return -1;
	}
	return index;
    }
    public T remove(int index){
	if (index<0||index>=size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (index==0){
	    T ans=head.getValue();
	    head=head.getNext();
	    size--;
	    return ans;
	}
	myLNode current=head;
	while(--index>0)current=current.getNext();
	T ans=current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	size--;
	return ans;
    }
    public int size(){
	return size;
    }
    public static void main(String[]args){
	myLNode a=new myLNode(0);
	myLNode b=new myLNode(5,a);
	myLinkedList l=new myLinkedList(b);
	System.out.println(l);
	System.out.println(l.get(1));
	l.add(0,-1);
	l.swap(0,1);
	l.remove(1);
	System.out.println(l.indexOf(0));
	System.out.println(l);
    }
}
