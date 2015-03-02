import java.util.*;
public class ctravel{
    static int N=0;
    static int M=0;
    static int T=0;
    static int R1,C1,R2,C2;
    static char[][] board;
    static int[][]board2,board3;
    public static int cell(boolean b,int time){
	if (b){
	    for (int i=0;i<board.length;i++){
		for (int j=0;j<board[0].length;j++){
		    
		}
	    }
	}
    }
    public static int solve(int row,int col,int time){
	if (time==0){
	    if (row==R2&&col==C2){
		return 1;
	    }
	    return 0;
	}
	if (row<0||col<0||row>=N||col>=M){
	    return 0;
	}
	if (board[row][col]=='*'){
	    return 0;
	}
	return solve(row+1,col,time-1)+solve(row-1,col,time-1)+solve(row,col+1,time-1)+solve(row,col-1,time-1);
    }
    public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	String a=sc.nextLine();
	String[]b=a.split(" ");
	N=Integer.parseInt(b[0]);
	M=Integer.parseInt(b[1]);
	T=Integer.parseInt(b[2]);
	board=new char[N][M];
	board1=new int[N][M];
	board2=new int[N][M];
	for (int i=0;i<N;i++){
	    String c=sc.nextLine().replaceAll("\\s","");
	    char[]d=c.toCharArray();
	    for (int x=0;x<M;x++){
		board[i][x]=d[x];
		if (board[i][x]=='.'){
		    board1[i][x]=0;
		}
		else if(board[i][x]=='*'){
		    board1[i][x]=-1;
		}
	    }
	}
	for (int i=0;i<board1.length;i++){
	    board2[i]=board1[i].clone();
	}
	String e=sc.nextLine();
	String[]f=e.split(" ");
	R1=Integer.parseInt(f[0])-1;
	C1=Integer.parseInt(f[1])-1;
	R2=Integer.parseInt(f[2])-1;
	C2=Integer.parseInt(f[3])-1;
	System.out.println(solve(R1,C1,T));
    }
    
}
