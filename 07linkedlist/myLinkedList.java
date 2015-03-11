public class myLinkedList{
    public myLNode head;
    public int size;
    public myLinkedList(myLNode a){
	head=a;
	myLNode current=a;
	size=1;
	while(current.getNext()!=null){
	    size++;
	    current=current.getNext();
	}
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
    public void set(int index,int value){
	if (index<0||index>=size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	myLNode current=head;
	while(--index>-1){
	    current=current.getNext();
	}
	current.setValue(value);
    }
    public int get(int index){
	if (index<0||index>=size)throw new ArrayIndexOutOfBoundsException();
	myLNode current=head;
	while(--index>-1)current=current.getNext();
	return current.getValue();
    }
    public void add(int value){
	myLNode current=head;
	int index=size;
	while(--index>0)current=current.getNext();
	current.setNext(new myLNode(value));
    }
    public void add(int index,int value){
	if (index<0||index>size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (index==size){
	    add(value);
	    return;
	}
	myLNode current=head;
	while(--index>-1)current=current.getNext();
	int temp=current.getValue();
	current.setValue(value);
	current.setNext(new myLNode(temp,current.getNext()));
    }
    public void swap(int index1,int index2){
	int value1=get(index1);
	set(index1,get(index2));
	set(index2,value1);
    }
    public int indexOf(int value){
	myLNode current=head;
	int index=-1;
	try{
	    while(get(++index)!=value);
	}catch (ArrayIndexOutOfBoundsException e){
	    return -1;
	}
	return index;
    }
    public int remove(int index){
	if (index<0||index>=size){
	    throw new ArrayIndexOutOfBoundsException();
	}
	if (index==0){
	    int ans=head.getValue();
	    head=head.getNext();
	    return ans;
	}
	myLNode current=head;
	while(--index>0)current=current.getNext();
	int ans=current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	return ans;
    }
    public static void main(String[]args){
	myLNode a=new myLNode();
	myLNode b=new myLNode(5,a);
	myLinkedList l=new myLinkedList(b);
	System.out.println(l);
	System.out.println(l.get(1));
	l.add(0,-1);
	l.swap(0,1);
	System.out.println(l.indexOf(0));
	System.out.println(l);
    }
}
