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
	if (args){
	    row=(int)args[0];
	    col=(int)args[1];
	    elev=(int)args[2];
	    num=(int)args[3];
	    int A;
	    int r=0;
	    int c=0;
	    for (A=4;A<row*col;A++){
		if (r<row){
		    board[r][c]=args[A];
		    r++;
		}
		else{
		    c++;
		    board[0][c]=args[A];
		    r=1;
		}
	    }
	    int[][]orders=new int[num][3];
	    int B=0;
	    while(B<num){
		orders[B][0]=(int)args[A+(B*3)];
		orders[B][1]=(int)args[A+(B*3)+1];
		orders[B][2]=(int)args[A+(B*3)+2];
		B++;
	    }
	}
    }
}