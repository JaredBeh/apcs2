import java.util.*;
public class RunningMedian{
    private MyHeap lower=new MyHeap(),upper=new MyHeap(false);
    public void add(int val){
	int l=lower.size(),u=upper.size();
	if(l==0){
	    lower.add(val);
	    return;
	}
	if(l<u){
	    if(val>upper.peek()){
		int temp=val;
		val=upper.remove();
		upper.add(temp);
	    }
	    lower.add(val);
	}
	else if(l>u){
	    if(val<lower.peek()){
		int temp=val;
		val=lower.remove();
		lower.add(temp);
	    }
	    upper.add(val);
	}
	else{
	    if(val<upper.peek()){
		lower.add(val);
	    }
	    else{
		upper.add(val);
	    }
	}
    }
    public String toString(){
	return lower.toString()+upper.toString();
    }
    public double getMedian(){
	if(lower.size()==upper.size()){
	    return .5*(lower.peek()+upper.peek());
	}
	if(lower.size()>upper.size()){
	    return lower.peek();
	}
	return upper.peek();
    }
    public static void main(String[] args){
	RunningMedian barry=new RunningMedian();
	barry.add(3);
	barry.add(2);
	barry.add(10);
	barry.add(0);
	System.out.println(barry+"\n"+barry.getMedian());
    }
}
