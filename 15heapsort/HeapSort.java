import java.util.Arrays;
public class HeapSort{
    public int[]data;
    public void Heapify(int[] values){
	data=values;
	for(int i=data.length/2-1;i>=0;i--){
	    swapDown(i);
	}
    }
    public void swapDown(int i){
	if(2*i+1>=data.length){
	    return;
	}
	if(2*i+2>=data.length){
	    if(data[i]<data[2*i+1]){
		int temp=data[i];
		data[i]=data[i*2+1];
		data[2*i+1]=temp;
		swapDown(2*i+1);
	    }
	    return;
	}
	int a=2*i+1;
	if(data[a]<data[a+1]){
	    a++;
	}
	if(data[i]<data[a]){
	    int temp=data[i];
	    data[i]=data[a];
	    data[a]=temp;
	    swapDown(a);
	}
    }
    public static void main(String[] args){
	HeapSort a=new HeapSort();
	int[] b = {1,8,6,4,9,11,0,5};
	a.Heapify(b);
	System.out.println(Arrays.toString(a.data));
    }
}
