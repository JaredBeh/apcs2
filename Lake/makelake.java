public class makelake{
    static int row,col,elev,num;
    static int[][] board;
    public makelake(){
	row=0;
	col=0;
	elev=0;
	num=0;
    }
    public static int create(int r,int c,int e,int n){
	board=new int[r][c];
	
	
    }
    public static void main(String[]args){
	row=Integer.parseInt(args[0]);
	col=Integer.parseInt(args[1]);
	elev=Integer.parseInt(args[2]);
	num=Integer.parseInt(args[3]);
	int A;
	int r=0;
	int c=0;
	for (A=4;A<row*col;A++){
	    if (r<row){
		board[r][c]=Integer.parseInt(args[A]);
		r++;
	    }
	    else{
		c++;
		board[0][c]=Integer.parseInt(args[A]);
		r=1;
	    }
	}
	int[][]orders=new int[num][3];
	int B=0;
	while(B<num){
	    orders[B][0]=Integer.parseInt(args[A+(B*3)]);
	    orders[B][1]=Integer.parseInt(args[A+(B*3)+1]);
	    orders[B][2]=Integer.parseInt(args[A+(B*3)+2]);
	    B++;
	}
    }
}
