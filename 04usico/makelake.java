import java.util.*;
public class makelake{
    static int row,col,elev,num;
    static int[][] board;
    static int[][] orders;
    public static int create(int n){
	if (n==0){
	    int ans=0;
	    for (int i=0;i<board.length;i++){
		for (int x=0;x<board[0].length;x++){
		    if (board[i][x]>elev){
			ans+=board[i][x]-elev;
		    }
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
	String a="";
	for (int i=0;i<args.length;i++){
	    a+=""+args[i]+" ";
	}
	Scanner sc=new Scanner(a);
	row=sc.nextInt();
	col=sc.nextInt();
	elev=sc.nextInt();
	num=sc.nextInt();
	board=new int[row][col];
	for (int i=0;i<row;i++){
	    for (int j=0;j<col;j++){
		board[i][j]=sc.nextInt();
	    }
	}
	orders=new int[num][3];
	for (int i=0;i<row;i++){
	    for (int j=0;j<col;j++){
		orders[i][j]=sc.nextInt();
	    }
	}
	solve(num);
	System.out.println(Arrays.deepToString(board));
    }
}