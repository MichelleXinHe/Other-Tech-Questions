import CtCILibrary.AssortedMethods;

//time complexity is O(R^2*C)
//take advantage of the algorithm: find the largest sum in an array is O(n)
//choose each row as the start row and end row, and find out the boundries of columns that the largest
//sum between that two rows.
public class MaxSum2D {
	//it doesnt matter if a is rectangle or square
	public static int TwoDArray(int[][] a){
		if(a==null||a.length==0) return 0;
		int r=a.length, c=a[0].length;
		int[][] s=new int[r][c];
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(i==0) s[i][j]=a[i][j];
				else s[i][j]=a[i][j]+s[i-1][j];
			}
		}
		int sr=0, er=0;
		int max=OneDArray(s[0]);//max is the gloabl variable to record the largest max sum
		for(int startRow=0; startRow<r; startRow++){
			for(int endRow=startRow; endRow<r; endRow++){
				int[] temp=new int[c];
				for(int i=0; i<c; i++){
					if(startRow==endRow) temp[i]=a[startRow][i];
					else{
						if(startRow==0) temp[i]=s[endRow][i];
						else temp[i]=s[endRow][i]-s[startRow-1][i];
					}
				}
				int current=OneDArray(temp);
				if(current>max){sr=startRow; er=endRow;}
				max=Math.max(max, current);
			}
		}
		System.out.println(sr+" "+er);
		return max;
	}
	
	public static int OneDArray(int[] a){
		if(a==null||a.length==0) return 0;
		int max=a[0], current=a[0];
		for(int i=1; i<a.length; i++){
			current=Math.max(current+a[i], a[i]);
			max=Math.max(current, max);
		}
		return max;
	}
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(5, 7, -100, 100);
		int sum = TwoDArray(matrix);
		AssortedMethods.printMatrix(matrix);
		System.out.println("sum="+sum);
		
		//int[] a={44, 88, 115, 72, -86,4, 148};
		//System.out.println(OneDArray(a));
	}

}
