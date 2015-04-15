import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    public int[]ans;
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
	String ans="";
	for(int i=0;i<maze.length;i++){
	    ans+=Arrays.toString(maze[i])+"\n";
	}
	return ans;
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
    public class Point{
	int x,y;
	Point previous;
	public Point(int a,int b,Point p){
	    x=a;
	    y=b;
	    previous=p;
	}
	public Point(int a,int b){
	    x=a;y=b;
	}
	public boolean hasPrev(){
	    return previous!=null;
	}
	public int getX(){return x;}
	public int getY(){return y;}
    }
    public class Frontier{
	MyDeque<Point> q;
	int mode;
	public int size(){
	    return q.size;
	}
	public Frontier(int m){
	    mode=m;
	}
	public Frontier(MyDeque<Point> c,int m){
	    mode=m;
	    q=c;
	}
	public void add(Point c){
	    if(mode==0)q.addLast(c);
	    else{
		q.addFirst(c);
	    }
	}
	public Point remove(){
	    return q.removeFirst();
	}
	public Point get(){
	    return q.getFirst();
	}
	public boolean hasNext(){
	    return q.size>0;
	}
    }
    public void addCoordinatesToSolutionArray(Point p){
	int i=0;
	while(p.hasPrev()){
	    ans[i]=p.x;
	    ans[i++]=p.y;
	    i++;
	    p=p.previous;
	}
    }
    private boolean solve(boolean animate, int mode){

	Frontier rest = new Frontier(mode);
	Point start = new Point(startx,starty);

	rest.add(start);//put the start into the Frontier 
		
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(true));
	    }
	    //get the top
	    Point next = rest.remove();
	    //check if solved
	    if(maze[next.getX()][next.getY()]=='E'){
		//solved!
		solved = true;
		addCoordinatesToSolutionArray(next);

		//my point class has a reference to previous points, so the solution will be determined from the final point

	    }else{
		//not solved, so add neighbors to Frontier and mark the floor with x.
		maze[next.getX()][next.getY()]='x';
		for(Point p : getNeighbors(next)){
		    rest.add(p);
		}

	    }
	}
	return solved;
    }
    public Point[] getNeighbors(Point next){
	Point[] ans=new Point[8];
	int x=next.getX();
	int y=next.getY();
	for (int xx=-1;xx<2;xx++){
	    for (int yy=-1;yy<2;yy++){
		if(xx!=0||yy!=0){
		    if(maze[x+xx][y+yy]==' '||maze[x+xx][y+yy]=='E')ans[2+xx+yy]=new Point(x+xx,y+yy,next);
		}
	    }
	}
	return ans;
    }
    public int[] solutionCoordinates(){return ans;}

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	return solve(false,1);
    }
    public boolean solveBFS(){
	return solve(false,0);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    public static void main(String[]arr){
	Maze a=new Maze("data1.dat");
	a.solve(false,0);
    }
    
}
