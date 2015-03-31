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
	f=0;
	l=size-1;
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
    public void addLast(T value){
	resize();
	size++;
	if(f==-1||l==-1){
	    data[0]=value;
	    f=0;l=0;
	    return;
	}
	if(l==data.length-1)l=-1;
	l++;
	data[l]=value;
    }
    public T getFirst(){
	return data[f];
    }
    public T getLast(){
	return data[l];
    }
    public T removeFirst(){
	T ans=getFirst();
	data[f]=null;
	if(f==data.length)f=-1;
	f++;
	return ans;
    }
    public T removeLast(){
	T ans=getLast();
	data[l]=null;
	if(l==0)l=data.length;
	l--;
	return ans;
    }
    public static void main(String[]arr){
	MyDeque<Integer>q=new MyDeque<Integer>();
	for(int i=0;i<9;i++){
	    q.addFirst(-1*i);
	    q.addLast(i);
	}
	System.out.println(q.removeLast());
	System.out.println(q);
	System.out.println(""+q.f+" "+q.l);
    }
}
