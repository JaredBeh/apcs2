public class maze{
    public char[][]mazesolve(char[][]maze){
	int x,y;
	for (int i=0;i<maze.length;i++){
	    for (int n=0;n<maze[0].length;n++){
		if (maze[i][n]=='S'){
		    x=n;
		    y=i;
		    break;
		}
	    }
	}
	return maze
    }
}
