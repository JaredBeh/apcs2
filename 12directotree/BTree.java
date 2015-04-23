import java.util.*;
import java.io.*;
public class BTree<E>{
    public static final int PRE_ORDER=0;
    public static final int IN_ORDER=1;
    public static final int POST_ORDER=2;
    private TreeNode<E> root;
    public Random r=new Random();
    public BTree(){
	root=null;
    }
    public BTree(E d){
	root=new TreeNode<E>(d);
    }
    public void add(E d){
	add(root,new TreeNode<E>(d));
    }
    public void add(TreeNode<E> curr,TreeNode<E> bn){
	if(curr.hasSpace()==0)curr.setLeft(bn);
	else if(curr.hasSpace()==1)curr.setRight(bn);
	else{
	    int a=r.nextInt(2);
	    if(a==0){
		add(curr.left,bn);
		return;
	    }
	    add(curr.right,bn);
	}
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
	    if(getLeft()==null)return 0;
	    if(getRight()==null)return 1;
	    return -1;
	}
    }
    public static void main(String arr){
	BTree<Integer> t=new BTree<Integer>();
	for(int i=0;i<8;i++){
	    t.add(i);
	}
    }
}