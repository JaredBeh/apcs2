import java.util.*;
public class Sorts{
    public static int[] merge(int[]a,int[]b){
	int ai=0;
	int bi=0;
	int[]ans=new int[a.length+b.length];
	while(ai<=a.length&&bi<=b.length){
	    if (ai==a.length){
		while(bi<b.length){
		    ans[ai+bi]=b[bi];
		    bi++;
		}
		return ans;
	    }
	    if (bi==b.length){
		while(ai<a.length){
		    ans[ai+bi]=a[ai];
		    ai++;
		}
		return ans;
	    }
	    if (a[ai]<b[bi]){
		ans[ai+bi]=a[ai];
		ai++;
	    }
	    else{
		ans[ai+bi]=b[bi];
		bi++;
	    }
	}
	return ans;
    }
    public static int[] mergesort(int[] a){
	if (a.length==1){
	    return a;
	}
	int[] b=new int[a.length/2];
	int[] c=new int[a.length-b.length];
	System.arraycopy(a,0,b,0,b.length);
	System.arraycopy(a,b.length,c,0,c.length);
	return merge(mergesort(b),mergesort(c));
    }
    public static void main(String[]args){
	int[]a=new int[999];
	Random r=new Random();
	for (int n=0;n<a.length;n++){
	    a[n]=r.nextInt(10);
	}
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(mergesort(a)));
	int[]b={1,2,3,4,5};
	int[]c={0,3,5,6};
	//System.out.println(Arrays.toString(merge(b,c)));
    }
}
