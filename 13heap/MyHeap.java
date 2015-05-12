import java.util.*;
public class MyHeap{
    public boolean maxornah;
    public int[]data=new int[7];
    public MyHeap(boolean isMax){
	maxornah=isMax;
    }
    public MyHeap(){
	this(true);
    }
    public String toString(){
	return Arrays.toString(data);
    }
    public int remove(){
	if(data[0]==0)throw new IndexOutOfBoundsException();
	data[0]--;
	int ans=data[1];
	data[1]=data[data[0]];
	swapDown();
	return ans;
    }
    public void swapDown(){
	int i=1;
	boolean left=false;
	if(maxornah){
	    while(data[i]<data[2*i]||data[i]<data[2*i+1]){
		left=data[2*i]>data[2*i+1];
		int temp=data[i];
		if(left){
		    data[i]=data[2*i];
		    data[2*i]=temp;
		    i*=2;
		}
		else{
		    data[i]=data[2*i+1];
		    data[2*i+1]=temp;
		    i=i*2+1;
		}
		
	    }
	}
    }
}