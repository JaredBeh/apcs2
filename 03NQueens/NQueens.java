public class NQueens{
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
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
	this(4);
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
	return hide+clear+go(0,0)+ans+"\n"+show;
    }
    public boolean solve(){
	return solveHelper(0);
    }
    public boolean solveHelper(int startx){
	if (startx<board.length-1){
	    return solve(startx)||solveHelper(startx+1);
	}
	return solve(startx);
    }
    public boolean solve(int startx){
	return solve(startx,0);
    }
    public boolean solve(int startx,int starty){
	//System.out.println(this);
	//wait(20);
	if (startx<0||starty<0||startx>=board.length||starty>=board[0].length||board[startx][starty]!=0){
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
	for (int i=0;i<board.length;i++){
	    if (solve(i,starty+1)){
		return true;
	    }
	}
	if (starty>=board.length-1){
	    System.out.println(this);
	    return true;
	}
	board[startx][starty]=0;
	return false;
    }
    public static void main(String[]args){
	NQueens a = new NQueens();
	a.solve();
    }
}
