public class Recursion implements hw1{
    public String name(){
	return "Beh,Jared";
    }
    public static void main(String[] args){
	Recursion a=new Recursion();
	System.out.println(a.name());
	System.out.println(a.fib(0));
	System.out.println(a.fib(1));
	System.out.println(a.fib(2));
	System.out.println(a.fib(9));
	System.out.println(a.sqrt(100));
    }
    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	else{
	    return factHelper(n,1);
	}
    }
    public int factHelper(int n,int ans){
	if (n<=1){
	    return ans;
	}
	else{
	    return factHelper(n-1,ans*n);
	}
    }
    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	else if(n<2){
	    return n;
	}
	else{
	    return fibHelper(n,0,1);
	}
    }
    public int fibHelper(int n,int f1,int f2){
	if (n==2){
	    return f1+f2;
	}
	else{
	    return fibHelper(n-1,f2,f1+f2);
	}
    }
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	else{
	    return sqrtHelper(n,1);
	}
    }
    public double sqrtHelper(double n,double guess){
	if (.9999*n<=guess*guess&&guess*guess<=1.0001*n){
	    return guess;
	}
	else{
	    return sqrtHelper(n,(n/guess+guess)/2);
	}
    }
}
