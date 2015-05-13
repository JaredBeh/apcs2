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
    public void resize(){
	if(data[0]==data.length){
	    int[]d=new int[data[0]*2];
	    System.arraycopy(data,0,d,0,data[0]);
	    data=d;
	}
    }
    public boolean compare(int n){
	return n>1 && ((maxornah && data[n]>data[n/2])||(!maxornah && data[n]<data[n/2]));
    }
    public void add(int a){
	data[0]++;
	resize();
	int c=data[0];
	data[c]=a;
	while(compare(c)){
	    int temp=data[c];
	    data[c]=data[c/2];
	    data[c/2]=temp;
	    c/=2;
	}
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
    public static void main(String[] args){
	MyHeap a=new MyHeap();
	a.add(3);
	a.add(4);
	a.add(2);
	a.add(10);
	a.add(1);
	a.add(11);
	System.out.println(a);
    }
}
