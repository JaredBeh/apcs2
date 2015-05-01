
import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private int tally;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
	tally=1;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public String toString(){
	return getData().toString();
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }
    public int getTally(){
	return tally;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public void incrementTally(){
	tally++;
    }
    public boolean decrementTally(){
	if(tally>1){
	    tally--;
	    return true;
	}
	return false;
    }
}



