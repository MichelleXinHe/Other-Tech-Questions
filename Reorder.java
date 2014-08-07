//it's similar to the first "missing positive" on leetcode!
public class Reorder {
	public static void reorder(int[] a, int[] b){
		if(a==null|b==null||a.length!=b.length||a.length<2) return;
		for(int i=0; i<a.length; i++){
			while(a[i]!=i+1){
				int t1=a[i];
				int t2=b[i];
				b[i]=b[a[i]-1];
				b[a[i]-1]=t2;
				
				a[i]=a[a[i]-1];
				//a[t1-1] is the previous a[a[i]-1]; since a[i] is updated in the last step
				a[t1-1]=t1;
			}
		}
	}
	
	public static void print(int[] a){
		for(int aa:a){
			System.out.print(aa+" ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a={3,2,4,1};
		int[] b={17, 5, 1,9};
		print(a);
		print(b);
		reorder(a, b);
		print(a);
		print(b);
	}

}
