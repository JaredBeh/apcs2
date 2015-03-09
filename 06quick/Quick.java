import java.util.*;
public class Quick{
    public static int[]ary;
    public static void quicksort(int[]ary){
	quicksort(ary,0,ary.length-1);
    }
    public static void quicksort(int[]ary,int low,int high){
	int l=0;
	int h=high;
	int i=rand.nextInt(high+1-low)+low;
	int test=ary[i];
	int temp=0;
	while(l<h){
	    while(ary[l]<test){
		if (l==high)break;
		l++;
	    }
	    if(ary[l]==test){
		
	    }
	    temp=ary[l];
	    ary[l]=ary[h];
	    ary[h]=temp;
	}
    }
    public static int quickSelect(int[]ary,int num){
	return quickSelect(ary,0,ary.length-1,num);
    }
    public static int quickSelect(int[]ary,int si,int ei,int num){
	Random rand=new Random();
	int i=rand.nextInt(ei+1-si)+si;
	int e=ei;
	int s=si;
	int test=ary[i];
	int temp=0;
        while (s<e){
	    while (ary[s]<test){
		if (s==ei)break;
		s++;
	    }
	    while(ary[e]>test){
		if (e==si)break;
		e--;
	    }
	    temp=ary[s];
	    ary[s]=ary[e];
	    ary[e]=temp;
	    System.out.println(Arrays.toString(ary));
	}
	System.out.println(test);
	if (s<num){
	    return quickSelect(ary,e,ei,num);
	}
	else if(s>num){
	    return quickSelect(ary,si,s,num);
	}
	return ary[s];
    }
    public static void main(String[]args){
	int[]a={3,1,2,5,4,7,6,8,9,0};
	Quick.quickSelect(a,0,a.length-1,5);
    }
}
