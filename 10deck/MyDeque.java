import java.util.*;
public class MyDeque<T>{
    public Object[] data;
    public int f,l,size;
    public MyDeque(){
	this(10);
    }
    public MyDeque(int i){
	f=1;l=0;size=0;
	data=new Object[i];
    }
    public String toString(){
	return Arrays.toString(data);
    }
    public void resize(){
	if (size>=data.length){
	    Object[]d2=new Object[size*2];
	    for (int i=f;i<size;i++){
		d2[i-f]=data[i];
	    }
	    if(f>l){
		for (int i=0;i<=l;i++){
		    d2[size+i-1]=data[i];
		}
	    }
	    f=0;
	    l=size;
	    data=d2;
	}
    }
    public void addFirst(T value){
	resize();
	if (f==0){
	    f=data.length;
	}
	f--;
	data[f]=value;
	size++;
    }
    public void addLast(T value){
	resize();
	size++;
	if(l==data.length-1)l=-1;
	l++;
	data[l]=value;
    }
    public static void main(String[]arr){
	MyDeque<Integer>q=new MyDeque<Integer>();
	for(int i=0;i<11;i++){
	    //q.addFirst(-1*i);
	    q.addLast(i);
	}
	System.out.println(q);
    }
}
