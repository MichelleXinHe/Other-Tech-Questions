//two methods for this problem
//1. reservoir sampling
//2. shuffle a deck of cards
public class Question3SelectRandomK {
	//reference: http://www.geeksforgeeks.org/reservoir-sampling/
	public static int[] selectRandomKElements1(int[] array, int n, int k){
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
	
	//this is a method similar to the method to shuffle a deck of cards
	public static int[] selectRandomKElements2(int[] array, int n, int k){
		int[] result=new int[k];
		for(int i=0; i<k;i++){
			int index=(int)(Math.random()*(n-i)+i);
			result[i]=array[index];
			array[index]=array[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] stream= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	    int k = 5;
	    int[] r=selectRandomKElements2(stream, stream.length, k);
	    for(int i=0; i<r.length; i++){
	    	System.out.print(r[i]+" ");
	    
	    }
	    
    	System.out.println();

	}

}
