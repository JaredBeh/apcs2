import java.util.*;
public class Quick{
    public int quickSelect(int[]ary,int si,int ei,int num){
	//int[]D=new int[ary.length];
	//System.arraycopy(ary,0,D,0,si);
	//try{
	//    System.arraycopy(ary,ei+1,D,ei+1,ary.length-ei-1);
	//}catch(IndexOutOfBoundsException ex){};
	Random rand=new Random();
	int i=rand.nextInt(ei+1-si)+si;
	int p=ary[i];
	int e=ei;
	int s=si;
	for (int n=si;n<=e;n++){
	    
	    if (ary[n]<p){
		//D[si]=ary[n];
		si++;
	    }
	    else{
		//D[ei]=ary[n];
		int a=ary[ei];
		ary[ei]=ary[si];
		ary[si]=a;
		ei--;
	    }
	    
	    System.out.println(Arrays.toString(ary));
	}
	System.out.println(Arrays.toString(ary));
	System.out.println(p);
	if (si==num){
	    return ary[si];
	}
	if (si<num){
	    return quickSelect(ary,si+1,e,num);
	}
	return quickSelect(ary,s,si-1,num);
    }
    public static void main(String[]args){
	int[]a={3,1,2,5,4,7,6,8,9,0};
	Quick q=new Quick();
	q.quickSelect(a,0,a.length-1,8);
    }
}
