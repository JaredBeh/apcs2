public class myLinkedList{
    public myLNode head,current;
    public myLinkedList(myLNode a){
	head=a;
	current=a;
    }
    public String toString(){
	String ans=""+current.getValue();
	while(current.getNext()!=null){
	    current=current.getNext();
	    ans+=", "+current.getValue();
	}
    }
    public static void main(String[]args){
	LNode a=new LNode();
	LNode b=new LNode(5,a);
	myLinkedList c=new myLinkedList(b);
	System.out.println(c);
    }
}