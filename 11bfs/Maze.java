//test using qiao.github.io/
import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    public int[]sol;
    private int maxx,maxy,startx,starty,endx,endy;
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
	    else if(c=='E'){
		endx=i%maxx;
		endy=i/maxx;
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
	int x,y,worth,steps;
	Point previous;
	public Point(int a,int b,Point p,int c,int s){
	    x=a;
	    y=b;
	    worth=c;
	    previous=p;
	    steps=s;
	}
	public Point(int a,int b,Point p,int c){
	    x=a;
	    y=b;
	    worth=c;
	    previous=p;
	}
	public Point(int a,int b,Point p){
	    x=a;y=b;
	    previous=p;
	    steps=p.steps+1;
	}
	public Point(int a,int b,int c){
	    x=a;y=b;worth=c;
	}
	public Point(int a,int b,int c,int s){
	    x=a;y=b;worth=c;steps=s;
	}
	public boolean hasPrev(){
	    return previous!=null;
	}
	public int getWorth(){return worth;}
	public Point getPrev(){return previous;}
	public int getX(){
	    return x;
	}
	public int getY(){return y;}
	public String toString(){
	    return "["+getX()+", "+getY()+"]";
	}
    }
    public class Frontier{
	MyDeque<Point> q;
	int mode;
	public int size(){
	    return q.size;
	}
	public Frontier(int m){
	    mode=m;
	    q=new MyDeque(maxx,m>1);
	}
	public Frontier(MyDeque<Point> c,int m){
	    mode=m;
	    q=c;
	}
	public String toString(){
	    return q.toString();
	}
	public void add(Point c,int v){
	    if(mode<2){
		add(c);
		return;
	    }
	    else{
		q.add(c,v);
	    }
	}
	public void add(Point c){
	    if(mode==0)q.addLast(c);
	    else if(mode==1){
		q.addFirst(c);
	    }
	    else{
		q.add(c,c.getWorth());
	    }
	}
	public Point remove(){
	    if(mode<2)return q.removeFirst();
	    return q.removeSmallest();
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
	int s=0;
	Point tst=p;
	while(tst.hasPrev()){
	    s++;
	    tst=tst.previous;
	}
	sol=new int[s*2];
	while(p.hasPrev()){
	    sol[i]=p.getX();
	    sol[i+1]=p.getY();
	    maze[p.getX()][p.getY()]='!';
	    i=i+2;
	    p=p.previous;
	}
    }
    private boolean solve(boolean animate, int mode){

	Frontier rest = new Frontier(mode);
	Point start = new Point(startx,starty,0,0);
	rest.add(start,0);//put the start into the Frontier 
		
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
		System.out.println(""+next.getX()+" "+next.getY());
		maze[next.getX()][next.getY()]='x';
		if(next.hasPrev()){
		    maze[next.getPrev().getX()][next.getPrev().getY()]='.';
		}
		for(Point p : getNeighbors(next)){
		    if(p!=null){
			if(mode<2){rest.add(p);}
			else if(mode==2){
			    rest.add(p,Math.abs(p.getX()-endx)+Math.abs(p.getY()-endy));
			}
			else{
			    rest.add(p,Math.abs(p.getX()-endx)+Math.abs(p.getY()-endy)+p.steps);
			}
		    }
		}

	    }
	}
	maze[startx][starty]='S';
	maze[endx][endy]='E';
	System.out.println(toString(true));
	System.out.println(Arrays.toString(sol));
	return solved;
    }
    public Point[] getNeighbors(Point next){
	Point[] ans=new Point[8];
	int ind=0;
	int x=next.getX();
	int y=next.getY();
	for (int xx=-1;xx<2;xx++){
	    for (int yy=-1;yy<2;yy++){
		if(xx!=0||yy!=0){
		    if(maze[x+xx][y+yy]==' '||maze[x+xx][y+yy]=='E'){
			ans[ind]=new Point(x+xx,y+yy,next);
			ind++;
		    }
		}
	    }
	}
	return ans;
    }
    public int[] solutionCoordinates(){return sol;}

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	return solve(animate,1);
    }
    public boolean solveBFS(boolean animate){
	return solve(animate,0);
    }
    public boolean solveBest(boolean animate){
	return solve(animate,2);
    }
    public boolean solveAStar(boolean animate){
	return solve(animate,3);
    }
    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveAStar(){
	return solveAStar(false);
    }
    public static void main(String[]arr){
	Maze a=new Maze("data1.dat");
	a.clearTerminal();
	//Point b=new Point(0,0);
	//System.out.println(a.getNeighbors(b));
	a.solve(true,3);
    }
    
}
