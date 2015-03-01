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
		    if (board[i][x]<elev){
			ans+=elev-board[i][x];
		    }
		}
	    }
	    return ans*72*72;
	}
	int startrow=orders[n-1][0]-1;
	int startcol=orders[n-1][1]-1;
	int times=orders[n-1][2];
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
	if (a.length()<1){
	    a="4 6 22 2 28 25 20 32 34 36 27 25 20 20 30 34 24 20 20 20 20 30 20 20 14 14 20 20 1 4 4 1 1 10";
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
	for (int i=0;i<num;i++){
	    for (int j=0;j<3;j++){
		orders[i][j]=sc.nextInt();
	    }
	}
	System.out.println(create(num));
	//System.out.println(Arrays.deepToString(board));
    }
}
