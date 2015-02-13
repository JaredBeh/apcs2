public class NQueens{
    int[][] board;
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public NQueens(int size){
	board=new int[size][size];
    }
    public NQueens(){
	this(3);
    }
    public String name(){
	return "beh.jared";
    }
    public String toString(){
	String ans="\n";
	for (int i=0;i<board.length;i++){
	    for (int n=0;n<board[0].length;n++){
		ans+=board[i][n];
	    }
	    ans+="\n";
	}
	return ans;
    }
    public boolean solve(){
	return solve(0,0);
    }
    public boolean solve(int startx){
	return solve(startx,0);
    }
    public boolean solve(int startx,int starty){
	System.out.println(this);
	wait(20);
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
	while (x>-1&&y<board[0].length){
	    if (board[x][y]!=0){
		return false;
	    }
	    x--;
	    y++;
	}
	x=startx;
	y=starty;
	while(x>board.length&&y>-1){
	    if (board[x][y]!=0){
		return false;
	    }
	    x++;
	    y--;
	}
	board[startx][starty]=1;
	if (starty==board[0].length){
	    return true;
	}
	for (int i=0;i<board.length;i++){
	    if (solve(i,starty+1)){
		return true;
	    }
	}
	board[startx][starty]=0;
	return false;
    }
    public static void main(String[]args){
	NQueens a = new NQueens();
	a.solve(1,0);
    }
}