/**
 * 
 * @author xinhe
 *
 *Longest common subsequence of string m and n
 *rule:
 *
 */
public class LCS {
	public static String LCSMethod(String m, String n){
		int[][] c = new int[m.length()+1][n.length()+1];
		String[][] s = new String[m.length()+1][n.length()+1];
		for(int i=0; i<=m.length();i++){
			for(int j=0; j<=n.length();j++){
				s[i][j]="";
				c[i][j]=0;
			}
		}
		
		for(int i=m.length()-1; i>=0; i--){
			for(int j=n.length()-1; j>=0; j--){
				if(m.charAt(i)==n.charAt(j)){
					
					c[i][j] = 1 + c[i+1][j+1];
					s[i][j] = m.charAt(i) + s[i+1][j+1];
				}else{
					
					c[i][j] = Math.max(c[i][j+1], c[i+1][j]);
					s[i][j] = c[i][j+1]> c[i+1][j]? s[i][j+1]:s[i+1][j];
					
				}//else	
				
			}//for=n
			
		}//for-m
		
		for(int i=0; i<m.length();i++){
			for(int j=0; j<n.length();j++){
				System.out.print("s["+i+","+j+"]="+s[i][j]+"   ");
			}
			
			System.out.println("");
		}
		
		return s[0][0];
	}
	
	public static void main(String[] args){
		String m = "ab";
		String n = "acb";
		System.out.println(LCSMethod(m,n));
	}
}
