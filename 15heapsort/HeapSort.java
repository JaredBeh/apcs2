import java.util.Arrays;
public class HeapSort{
    public static int[]data;
    public static int size;
    public HeapSort(int[] d,int s){
	data=d;
	size=s;
    }
    public static void HSort(){
	Heapify(data,size);
	for(int i=size-1;i>0;i--){
	    swap(0,i);
	    swapDown(0,i-1);
	}
    }
    public static void swap(int a,int b){
	int temp=data[a];
	data[a]=data[b];
	data[b]=temp;
    }
    public static void Heapify(int size){
	for(int i=size/2-1;i>=0;i--){
	    swapDown(i,size);
	}
    }
    public static void swapDown(int i,int end){
	if(2*i+1>=end){
	    return;
	}
	if(2*i+2>=end){
	    if(data[i]<data[2*i+1]){
		swap(i,2*i+1);
		swapDown(2*i+1,end);
	    }
	    return;
	}
	int a=2*i+1;
	if(data[a]<data[a+1]){
	    a++;
	}
	if(data[i]<data[a]){
	    swap(i,a);
	    swapDown(a,end);
	}
    }
    public static void main(String[] args){
	int[] b = {1,8,6,4,9,11,0,5};
	HeapSort a=new HeapSort(b,b.length);
	HeapSort.Heapify();
	System.out.println(Arrays.toString(HeapSort.data));
    }
}
