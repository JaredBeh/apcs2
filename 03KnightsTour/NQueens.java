public class NQueen{
    int[][] board;
    public NQueen(int size){
	board=new int[size][size];
    }
    public NQueen(){
	this(4);
    }
    public String name(){
	return "beh.jared";
    }
    public String toString(){
	ans="\n";
	for (int i=0;i<board.length;i++;){
	    for (int n=0;n<board[0].length;n++){
		ans+=board[i][n];
	    }
	    ans+="\n";
	}
    }
    public boolean solve(){
	return solve(0,0,0);
    }
    public boolean solve(int startx){
	return solve(startx,0,0);
    }
    public boolean solve(int startx,int starty,int numQueens){
	if (startx<0||starty<0||startx>board.length||starty<board[0].length||board[startx][starty]!=0){
	    return false;
	}
	for (int i=0;i<board.length;i++){
	    if (board[i][starty]!=0){
		return false;
	    }
	}
	for (int i=0;i<board[0].length;i++){
	    if (board[startx][i]!=0){
		return false;
	    }
	}
	int x=startx;
	int y=starty;
	while(x>-1&&y>-1){
	    if (board[x][y]!=0){
		return false;
	    }
	    x--;
	    y--;
	}
	x=startx;
	y=starty;
	while(x<board.length&&y<board[0].length){
	    if (board[x][y]!=0){
		return false;
	    }
	    x++;
	    y++;
	}
	x=startx;
	y=starty;
	
    }
}