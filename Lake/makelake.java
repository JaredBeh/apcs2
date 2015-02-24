public class makelake{
    static int row,col,elev,num;
    static int[][] board;
    static int[][] orders;
    public makelake(){
	row=0;
	col=0;
	elev=0;
	num=0;
    }
    public static int create(int n){
	if (n==0){
	    int ans=0;
	    for (int i=0;i<board.length;i++){
		for (int x=0;x<board[0].length;x++){
		    ans+=board[i][x];
		}
	    }
	    return ans*72*72;
	}
	int startrow=orders[n][0]-1;
	int startcol=orders[n][1]-1;
	int times=orders[n][2];
	int greatest=0;
	for (int r=startrow;r<startrow+3;r++){
	    for (int c=startcol;c<startcol+3;c++){
		if (greatest<board[r][c]){
		    greatest=board[r][c];
		}
	    }
	}
	while (times>0){
	    for (int r=startrow;r<startrow+3;r++){
		for (int c=startcol;c<startcol+3;c++){
		    if (greatest==board[r][c]){
			board[r][c]-=1;
		    }
		}
	    }
	    times--;
	    greatest--;
	}
	return create(n-1);
	
    }
    public static void main(String[]args){
	row=Integer.parseInt(args[0]);
	col=Integer.parseInt(args[1]);
	elev=Integer.parseInt(args[2]);
	num=Integer.parseInt(args[3]);
	int A;
	int r=0;
	int c=0;
	board=new int[row][col];
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
	orders=new int[num][3];
	int B=0;
	while(B<num){
	    orders[B][0]=Integer.parseInt(args[A+(B*3)]);
	    orders[B][1]=Integer.parseInt(args[A+(B*3)+1]);
	    orders[B][2]=Integer.parseInt(args[A+(B*3)+2]);
	    B++;
	}
    }
    System.out.println(makelake.create(num));
}
