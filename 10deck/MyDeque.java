import java.util.*;
public class MyDeque<T>{
    public T[] data;
    public int f,l,size;
    public MyDeque(){
	this(10);
    }
    public MyDeque(int i){
	f=-1;l=-1;size=0;
	data=(T[])(new Object[i]);;
    }
    public String toString(){
	return Arrays.toString(data);
    }
    public String name(){return "beh.jared";}
    public void resize(){
	if(size<data.length)return;
	T[]d2=(T[])(new Object[size*2]);
	if(f==l){
	    d2[0]=data[f];
	}else if(f>l){
	    System.arraycopy(data,f,d2,0,size-f);
	    System.arraycopy(data,0,d2,size-f,f);
	}else{
	    System.arraycopy(data,f,d2,0,size);
	}
	data=d2;
    }
    public void addFirst(T value){
	resize();
	size++;
	if(f==-1||l==-1){
	    data[0]=value;
	    f=0;l=0;
	    return;
	}
	if(f==0)f=data.length;
	f--;
	data[f]=value;
    }
    public static void main(String[]arr){
	MyDeque<Integer>q=new MyDeque<Integer>();
	for(int i=0;i<11;i++){
	    q.addFirst(-1*i);
	    //q.addLast(i);
	}
	System.out.println(q);
    }
}
