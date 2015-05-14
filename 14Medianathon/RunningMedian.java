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
	if(l>u){
	    if(val<lower.peek()){
		int temp=val;
		val=lower.remove();
		lower.add(temp);
	    }
	    upper.add(val);
	}
	if(l==u){
	    
	}
    }
}