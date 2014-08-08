//reference: http://www.geeksforgeeks.org/reservoir-sampling/

public class SelectRandomK {
	public static int[] selectRandomKElements(int[] array, int n, int k){
		//n is the total length of the array
		int[] result=new int[k];
		if(n<k) return result;
		//copy the first k elements to the result array
		for(int i=0; i<k;i++)
			result[i]=array[i];
		
		for(int i=k; i<n; i++){
		  //pick up a random value from 0 to i
			int j=(int) (Math.random()*i);

      //if j<k, then swap result[j] and array[i]
			if(j<k){
				result[j]=array[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] stream= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	    int k = 5;
	    int[] r=selectRandomKElements(stream, stream.length, k);
	    for(int i=0; i<r.length; i++){
	    	System.out.print(r[i]+" ");
	    
	    }
	    
    	System.out.println();

	}

}
