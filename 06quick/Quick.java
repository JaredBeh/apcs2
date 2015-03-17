import java.util.*;
public class Quick{
    public static int[]ary;
    public static void quicksort(int[]ary){
	quicksort(ary,0,ary.length-1);
    }
    public String name(){
	return "beh.jared";
    }
    public static void quicksort(int[]ary,int low,int high){
	int l=0;
	int h=high;
	if (high<=low)return;
	int a=partition(ary,low,high);
	quicksort(ary,low,a-1);
	quicksort(ary,a+1,high);
	//System.out.println(Arrays.toString(ary));
    }
    public static int quickSelect(int[]ary,int num){
	return quickSelect(ary,0,ary.length-1,num);
    }
    public static int quickSelect(int[]ary,int si,int ei,int num){
	if (ei<=si)return si;
	int a=partition(ary,si,ei);
	int left=a-si;
	if (left<num){
	    return quickSelect(ary,a+1,ei,num-left-1);
	}
	if(left>num){
	    return quickSelect(ary,si,a-1,num);
	}
	return a;
    }
    public static int partition(int[]ary,int s,int e){
	Random rand=new Random();
	int i=rand.nextInt(e+1-s)+s;
	int temp=ary[i];
	ary[i]=ary[e];
	ary[e]=temp;
        for (int n=s;n<e;n++){
	    if(ary[n]<ary[e]){
		temp=ary[s];
		ary[s]=ary[n];
		ary[n]=temp;
		s++;
		//System.out.println(Arrays.toString(ary));
	    }
	}
	temp=ary[e];
	ary[e]=ary[s];
	ary[s]=temp;
	//System.out.println(ary[s]);
	return s;
    }
    public static void main(String[]args){
	int[] ary={3,1,2,5,4,7,6,8,9,0};
	quicksort(ary,0,ary.length-1);
	System.out.println(Arrays.toString(ary));
    }
}
