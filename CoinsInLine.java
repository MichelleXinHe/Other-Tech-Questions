/*
 * There are n coins in a line. (Assume n is even). 
 * Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
 * The player with the larger amount of money wins.
 * 
 * Would you rather go first or second? Does it matter?
 * Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.
 * solution:
 * 1) Count the sum of all coins that are odd-numbered. (Call this X)
 * 2) Count the sum of all coins that are even-numbered. (Call this Y)
 * 3) If X > Y, take the left-most coin first. Choose all odd-numbered coins in subsequent moves.
 * 4) If X < Y, take the right-most coin first. Choose all even-numbered coins in subsequent moves.
 * 5) If X == Y, you will guarantee to get a tie if you stick with taking only even-numbered/odd-numbered coins.
 * 
 * 
 * in this program using DP:
 * p(i.j) is the largest value the player can get from the set array(i, j)
 * 
 * rules:
 * i>j	p(i,j)=0
 * i=j	p(i,j)=a[i]
 * i<j  p(i,j)=max{a[i]+min(p(i+1,j-1),p(i+2,j),
 * 				   a[j]+min(p(i+1,j-1),p(i,j-2))}//since the opponent will always choose the one make you get min value from the rest of the set
 */

package CoinsLine;

public class CoinsInLine {
	
	//recursive method
	public static int recursive(int[] coins){
		int val=maxValue(coins, 0, coins.length-1);
		return val;
	}
	
	public static int maxValue(int[] coins, int s, int e){
		if(s>e) return 0;
		int val1=coins[s]+Math.min(maxValue(coins, s+2, e), maxValue(coins, s+1, e-1));
		int val2=coins[e]+Math.min(maxValue(coins, s, e-2), maxValue(coins, s+1, e-1));
		return Math.max(val1,val2);
	}
	
	//bottom up DP method
	public static int iterative(int[] coins){
		int n=coins.length;
		int[][] sum=new int[n][n];
		for(int i=0; i<n; i++){
			sum[i][i]=coins[i];
		}
		
		for(int i=1; i<n; i++){
			for(int j=i-1; j>=0; j--){
			  //be careful on the boundry of array
				int val1=coins[j]+((j<n-2)?Math.min(sum[j+1][i-1], sum[j+2][i]):0);
				int val2=coins[i]+((i>=2)?Math.min(sum[j][i-2], sum[j+1][i-1]):0);
				sum[j][i]=Math.max(val1, val2);
			}
		}
		return sum[0][n-1];
	}
	public static void main(String[] args) {
		int[] a = { 3, 2, 2, 3, 1, 2 };
		int[] b= {4, 1, 2, 4,5, 6,2, 10};
		System.out.println(recursive(a));
		System.out.println(iterative(a));

	}

}
