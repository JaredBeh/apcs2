import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int maxx,maxy,startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    /** Same constructor as before...*/
    public Maze(String filename){
	startx=-1;
	starty=-1;
	String ans="";
	try{
	    Scanner in=new Scanner(new File(filename));
	    while(in.hasNext()){
		String line=in.nextLine();
		if(maxy==0){
		    maxx=line.length();
		}
		maxy++;
		ans+=line;
	    }
	}catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public String toString(){
	return Arrays.deepToString(maze);
    }

    public String toString(boolean animate){
	if(animate){
	    String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	    for(int i = 0; i < maxx * maxy; i++){
		if(i % maxx == 0 && i != 0){
		    ans += "\n";
		}
		char c =  maze[i % maxx][i / maxx];
		if(c == '#'){
		    ans += color(38,47)+c;
		}else{
		    ans += color(32,40)+c;
		}
	    }
	    return hide + go(0,0) + ans + "\n" + show + color(37,40);
	}
	else{
	    return toString();
	}
    }
    

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public class cord{
	int x,y;
	MyDeque<cord> breadcrumbs;
	public cord(int a,int b,MyDeque<cord> c){
	    x=a;
	    y=b;
	    breadcrumbs=c;
	}
	public cord(int a,int b){
	    this(a,b,null);
	}
    }
    public class frontier{
	MyDeque<cord> q;
	int mode;
	public frontier(MyDeque<cord> c,int m){
	    mode=m;
	    q=c;
	}
	public void add(cord c){
	    if(mode==0)q.addLast(c);
	    else{
		q.addFirst(c);
	    }
	}
	public cord remove(){
	    return q.removeFirst();
	}
	public cord get(){
	    return q.getFirst();
	}
    }
    public boolean solveBFS(boolean animate){
	MyDeque<cord> q=new MyDeque<cord>(maxx*maxy);
	q.addLast(new cord(startx,starty,new MyDeque<cord>()));
	boolean solved=false;
	while(!solved){
	    if(maze[q.getFirst().x][q.getFirst().y]=='E')solved=true;
	    else{
		int x=q.getFirst().x;
		int y=q.getFirst().y;
		MyDeque<cord> br=q.getFirst().breadcrumbs;
		maze[x][y]='.';
		for(int i=-1;i<2;i++){
		    for(int n=-1;n<2;n++){
			if(n!=0||i!=0)q.addLast(new cord(x+i,y+n,br.addLast(new cord(x,y))));
		    }
		}
		
	    }
	}
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
}