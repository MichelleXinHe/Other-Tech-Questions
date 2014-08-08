import java.util.HashMap;


public class Knapsack {
	//iterative method
	public static int[][] knapsack2(int[] w, int[] v, int weight){
		int[][] result = new int[w.length+1][weight+1];
		for (int i=0;i<w.length;i++){
			for(int j=0; j<weight;j++){
				if(i==0||j==0) result[i][j]=0;
			}
		}
		
		for (int i=1;i<=w.length;i++){
			for(int j=1; j<=weight;j++){
				//System.out.println("i="+i+" j="+j);
				if(w[i-1]>j) result[i][j]=result[i-1][j];
				else result[i][j]=Math.max(result[i-1][j], result[i-1][j-w[i-1]]+v[i-1]);
			}
		}
		
		return result;
	}
	
	//recursive method
	private static int knapsack1(int i, int W, int[] weights, int[] values) {
	    if (i < 0) {
	        return 0;
	    }
	    if (weights[i] > W) {
	        return knapsack1(i-1, W, weights, values);
	    } else {
	        return Math.max(knapsack1(i-1, W, weights, values), knapsack1(i-1, W - weights[i], weights, values) + values[i]);
	    }
	}
	
	public static void main(String[] args){
		int[] values = new int[] {894, 260, 392, 281, 27};
	    int[] weights = new int[] {8, 6, 4, 0, 21};
	    int W = 30;
	    int[][] result=knapsack2( weights, values, W);
	  
	    for(int i=0;i<6;i++){
	    	for(int j=0;j<31;j++)
	    		System.out.println("i="+i+", j="+j+"="+result[i][j]);
	    }
		 //System.out.println(get(4, weights, values, W, map));
		 //System.out.println(knapsack(4, W, weights, values));

	}
}
