import java.util.Arrays;
public class HeapSort{
    public static int[]data;
    public static int size;
    public HeapSort(int[] d,int s){
	data=d;
	size=s;
    }
    public static void HSort(int[] d,int s){
	data=d;
	size=s;
	Heapify();
	int c=size-1;
	while(c>0){
	    swap(0,c);
	    c--;
	    swapDown(0,c);
	}
    }
    public static void Heapify(){
	int i=size/2-1;
	while(i>=0){
	    swapDown(i,size-1);
	    i--;
	}
    }
    public static void swapDown(int start,int end){
	int child;
	int root=start;
	while(root*2+1<=end){
	    child=root*2+1;
	    if(child+1<=end && data[child]<data[child+1]){
		child++;
	    }
	    if(data[root]<data[child]){
		swap(root,child);
	    }
	    root=child;
	}
    }
    public static void swap(int a,int b){
	int temp=data[a];
	data[a]=data[b];
	data[b]=temp;
    }
    public static void main(String[] args){
	int[]a={1,8,6,4,9,11,0,5};
	HeapSort.HSort(a,a.length);
	System.out.println(Arrays.toString(HeapSort.data));
    }
}
