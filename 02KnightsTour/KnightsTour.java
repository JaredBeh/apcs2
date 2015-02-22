import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i=0;i<board.length;i++){
	    for (int n=0;n<board[0].length;n++){
		if (board[i][n]<10){
		    ans+="_";
		}
		ans+=board[i][n]+" ";
	    }
	    ans+="\n";
	}
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board=new int[size][size];
    }
    public KnightsTour(){
	this(5);
    }
    

    public void solve(){
	
    }


    public void solve(int startx, int starty){
	
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
	if (x<0||y<0||x>=board.length||y>=board[0].length){
	    return false;
	}
	if (board[x][y]!=0){
	    return false;
	}
	if (currentMoveNumber==board.length*board[0].length){
	    return true;
	}
	if (currentMoveNumber<board.length*board[0].length){
	    board[x][y]=currentMoveNumber;
	    if (solve(x+1,y+2,currentMoveNumber+1)||
		solve(x+2,y+1,currentMoveNumber+1)||
		solve(x-1,y+2,currentMoveNumber+1)||
		solve(x+1,y-2,currentMoveNumber+1)||
		solve(x-2,y+1,currentMoveNumber+1)||
		solve(x+2,y-1,currentMoveNumber+1)||
		solve(x-1,y-2,currentMoveNumber+1)||
		solve(x-2,y-1,currentMoveNumber+1)){
		System.out.println(this);
		return true;
	    }
		
	}
	board[x][y]=0;
	return false;
    }
    public static void main(String[]args){
	KnightsTour a=new KnightsTour();
	System.out.println(a.solve(4,2,1));
    }

}