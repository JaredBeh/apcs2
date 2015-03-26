import java.util.*;
public class MyDeque<T>{
    public Object[] data;
    public int f,l,size;
    public MyDeque(){
	this(10);
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
	l++;
	data[l]=value;
    }
    public static void main(String[]arr){
	MyDeque<Integer>q=new MyDeque<Integer>(1);
	q.addLast(2);
	q.addLast(3);
	System.out.println(q);
    }
}