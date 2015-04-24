import java.util.*;
import java.io.*;
public class BTree<E>{
    public static final int PRE_ORDER=0;
    public static final int IN_ORDER=1;
    public static final int POST_ORDER=2;
    private TreeNode<E> root;
    
    public BTree(){
	root=null;
    }
    public BTree(E d){
	root=new TreeNode<E>(d);
    }
    public void add(E d){
	if(root==null){
	    root=new TreeNode<E>(d);
	    return;
	}
	add(root,new TreeNode<E>(d));
    }
    public void add(TreeNode<E> curr,TreeNode<E> bn){
	if(curr.hasSpace()==0)curr.setLeft(bn);
	else if(curr.hasSpace()==1)curr.setRight(bn);
	else{
	    Random r=new Random();
	    int a=r.nextInt(2);
	    if(a==0){
		add(curr.left,bn);
		return;
	    }
	    add(curr.right,bn);
	}
    }
    public void preOrder(TreeNode<E> curr){
	if(curr==null)return;
	System.out.println(curr.getValue());
	preOrder(curr.left);
	preOrder(curr.right);
    }
    public void inOrder(TreeNode<E> curr){
	if(curr==null)return;
	inOrder(curr.left);
	System.out.println(curr.getValue());
	inOrder(curr.right);
    }
    public void postOrder(TreeNode<E> curr){
	if(curr==null)return;
	postOrder(curr.left);
	postOrder(curr.right);
	System.out.println(curr.getValue());
    }
    private class TreeNode<E>{
	private TreeNode<E> left,right;
	public E value;
	public TreeNode(E v){
	    value=v;
	}
	public E getValue(){
	    return value;
	}
	public void setValue(E v){
	    value=v;
	}
	public void setLeft(E v){
	    left=new TreeNode<E>(v);
	}
	public void setLeft(TreeNode<E> t){
	    left=t;
	}
	public void setRight(TreeNode<E> t){
	    right=t;
	}
	public void setRight(E v){
	    right=new TreeNode<E>(v);
	}
	public E getLeft(){
	    return left.getValue();
	}
	public E getRight(){
	    return right.getValue();
	}
	public int hasSpace(){
	    if(left==null)return 0;
	    if(right==null)return 1;
	    return -1;
	}
    }
    public String toString(){
	TreeNode<E> n=root;
	String ans="";
	int c=0;
	int b=1;
	Queue<TreeNode<E>>q=new LinkedList<TreeNode<E>>();
	q.add(n);
	while(!q.isEmpty()){
	    c++;
	    n=q.remove();
	    ans+=n.getValue()+" ";
	    if(c==b){
		ans+="\n";
		b*=2;
		c=0;
	    }
	    if(n.left!=null)q.add(n.left);
	    if(n.right!=null)q.add(n.right);
	}
	return ans;
    }
    public static void main(String[] arr){
	BTree<Integer> t=new BTree<Integer>();
	for(int i=0;i<8;i++){
	    t.add(i);
	}
	System.out.println(t);
	t.inOrder(t.root);
    }
}
