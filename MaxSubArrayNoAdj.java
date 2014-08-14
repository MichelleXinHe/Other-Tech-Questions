/*
Algorithm:
Loop for all elements in arr[] and maintain two sums incl and excl where incl = Max sum including the previous element 
and excl = Max sum excluding the previous element.

Max sum excluding the current element will be max(incl, excl) and 
max sum including the current element will be excl + current element 
(Note that only excl is considered because elements cannot be adjacent).

At the end of the loop return max of incl and excl.
*/

public class MaxSubArrayNoAdj {
	public static int maxSub(int[] a){
		if(a==null||a.length==0) return 0;
		int in=a[0];
		int ex=0;
		for(int i=1; i<a.length; i++){
			int temp=ex;
			ex=Math.max(ex,  in);
			in=a[i]+temp;
		}
		return Math.max(ex, in);
	}
	public static void main(String[] args) {
		int[] a={5,  5, 10, 40, 50, 35};
		int r=maxSub(a);
		System.out.println(r);
	}

}
