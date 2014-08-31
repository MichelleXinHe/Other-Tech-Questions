/*
 * Given a NxN matrix which contains all distinct 1 to n^2 numbers, write code to print sequence of increasing adjacent sequential numbers. 
	ex: 
	1 5 9 
	2 3 8 
	4 6 7 

	should print 
	6 7 8 9
 * 
 * 
 * Solution: dfs+helper matrix to record visiting status
 */
public class TwoDLongestSequence {
	static boolean[][] visited;
	static int n;
	public static int longestSequence(int[][] board){
		if(board==null) return 0;
		n=board.length;
		visited=new boolean[n][n];
		int max=0;
		int start=0;
		
		//use each unvisited element as the center of the sequence, 
		//and extend the sequence to the left and right from the center
		for(int i=0; i<n; i++){
			for(int j=0; j<n;j++){
				if(visited[i][j]) continue;
				visited[i][j]=true;
				int smaller=dfs(board, i, j, false);
				int larger=dfs(board, i, j, true);
				int len=1+smaller+larger;
				if(max<len){
					start=board[i][j]-smaller;
				}
				max=Math.max(max, len);
			}
		}
		for(int i=0; i<max; i++){
			System.out.print((start+i)+" ");
		}
		
		System.out.println();
		return max;
	}
	
	public static int dfs(int[][] board, int x, int y, boolean f){
		if(x<0||y<0||x>=n||y>=n) return 0;
		int d=(f==true)?-1:1;
		if(x>0&&board[x][y]==d+board[x-1][y]&&!visited[x-1][y]){
			visited[x-1][y]=true;
			return 1+dfs(board, x-1, y, f);
		}else if(x<n-1&&board[x][y]==d+board[x+1][y]&&!visited[x+1][y]){
			visited[x+1][y]=true;
			return 1+dfs(board, x+1, y, f);
		}else if(y>0&&board[x][y]==d+board[x][y-1]&&!visited[x][y-1]){
			visited[x][y-1]=true;
			return 1+dfs(board, x, y-1, f);
		}else if(y<n-1&&board[x][y]==d+board[x][y+1]&&!visited[x][y+1]){
			visited[x][y+1]=true;
			return 1+dfs(board, x, y+1, f);
		}
		return 0;
	}
	public static void main(String[] args) {
		int[][] board={{1, 5, 9}, {2, 3, 8}, {4, 6, 7}};
		int result=longestSequence(board);
		System.out.println(result);
	}

}
