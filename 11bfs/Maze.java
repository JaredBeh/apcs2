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
    public class cord{
	int x,y;
	MyDeque<cord> breadcrumbs;
	public cord(int a,int b,MyDeque<cord> c){
	    x=a;
	    y=b;
	    breadcrumbs=c;
	}
	public cord(int a,int b){
	    x=a;y=b;
	}
    }
    public class frontier{
	MyDeque<cord> q;
	int mode;
	public int size(){
	    return q.size;
	}
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
    public boolean solve(boolean animate,int mode){
	frontier q=new frontier(new MyDeque<cord>(maxx*maxy),mode);
	q.add(new cord(startx,starty,new MyDeque<cord>()));
	boolean solved=false;
	while(q.size()>0&&!solved){
	    if(maze[q.get().x][q.get().y]=='E')solved=true;
	    else{
		int x=q.get().x;
		int y=q.get().y;
		MyDeque<cord>br=q.get().breadcrumbs;
		br.addLast(new cord(x,y));
		maze[x][y]='.';
		q.remove();
		for(int i=-1;i<2;i++){
		    for(int n=-1;n<2;n++){
			if(maze[x+i][y+n]==' ' ||
			   maze[x+i][y+n]=='E')q.add(new cord(x+i,y+n,br));
		    }
		}
	    }
	    if(animate)System.out.println(this.toString(animate));
	}
	if(solved){
	    ans=new int[q.get().breadcrumbs.size*2];
	    int index=0;
	    while(q.get().breadcrumbs.getFirst()!=null){
		cord a=q.get().breadcrumbs.removeFirst();
		ans[index]=a.x;
		ans[index++]=a.y;
		index++;
	    }
	}
	return solved;
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
