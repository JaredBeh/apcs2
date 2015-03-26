import java.util.*;
public class MyDeque<T>{
    public Object[] data;
    public int f,l,size;
    public MyDeque(){
	this(10);
    }
    public String name(){
	return "beh.jared";
    }
    public MyDeque(int i){
	f=0;l=0;size=0;
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
		for (int i=l;i>-1;i--){
		    d2[size-i-1]=data[i];
		}
	    }
	    data=d2;
	}
    }
    public void addFirst(T value){
	resize();
	data[f]=value;
	if (f==0){
	    f=data.length;
	}
	f--;
	size++;
    }
    public void addLast(T value){
	resize();
	data[l]=value;
	if (l==f)f--;
	if(f<0)f=data.length-1;
	if(l==data.length-1) l=-1;
	l++;
	size++;
    }
    public static void main(String[]arr){
	MyDeque<Integer>q=new MyDeque<Integer>();
	for(int i=0;i<5;i++){
	    q.addFirst(i);
	    q.addLast(-1*i);
	}
	System.out.println(q);
    }
}