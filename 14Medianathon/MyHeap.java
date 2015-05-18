import java.util.*;
public class MyHeap{
    public String name(){
	return "beh.jared";
    }
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
	if(data[0]>=data.length-1){
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
    public int recompare(int n){
	if(n>data[0]/2 ||
	   (maxornah && data[n]>data[2*n] && data[n]>data[2*n+1]) ||
	   (!maxornah && data[n]<data[2*n] && data[n]<data[2*n+1])){
	    return -1;
	}
	if((maxornah && data[2*n]>data[2*n+1])||(!maxornah && data[2*n]<data[2*n+1])){
	    return 0;
	}
	return 1;
    }
    public int remove(){
	if(data[0]==0)throw new IndexOutOfBoundsException();
	resize();
	int ans=data[1];
	data[1]=data[data[0]];
	data[data[0]]=0;
	int c=1;
	int r=recompare(1);
	while(r>-1){
	    int temp=data[c];
	    data[c]=data[2*c+r];
	    data[2*c+r]=temp;
	    c=c*2+r;
	    r=recompare(c);
	}
	data[0]--;
	return ans;
    }
    public int peek(){
	if(data[0]<1)throw new IndexOutOfBoundsException();
	return data[1];
    }
    public int size(){
	return data[0];
    }
    public static void main(String[] args){
	MyHeap a=new MyHeap(false);
	a.add(3);
	a.add(4);
	a.add(2);
	a.add(10);
	a.add(1);
	a.add(11);
	a.remove();
	System.out.println(a);
    }
}
