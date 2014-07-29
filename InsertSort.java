/*
 * Algorithm sorting
 * 
 * Author: Xin He (xh2176@columbia.edu)
 */
public class InsertSort {
	public static void insertSort(int[] nums){
		if(nums==null||nums.length<2) return;
		for(int r=1; r<nums.length; r++){
			int key=nums[r];
			int i=r-1;
			for(; i>=0&&nums[i]>key;i--){
				nums[i+1]=nums[i];
			}
			nums[i+1]=key;
		}
	}
	
	public static void print(int[] array){
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] array1={};
		int[] array2={1};
		int[] array3={1, 2, 3, 4};
		int[] array4={4, 3, 2, 1};
		int[] array5={1, 4, 2, 3};
		int[] array6={1, 1, 1, 1};
		
		insertSort(array1);
		insertSort(array2);
		insertSort(array3);
		insertSort(array4);
		insertSort(array5);
		insertSort(array6);
		
		print(array1);
		print(array2);
		print(array3);
		print(array4);
		print(array5);
		print(array6);
	}

}
