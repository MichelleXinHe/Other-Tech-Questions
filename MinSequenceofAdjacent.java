//DP
//wr is the right edge of current window, if current sum from wl to wr is larger than target
//narrow down the size of window by moving wl(abandon unecessary left elements)
//
/if the wr cannot make the current sum larger than target, namely if we use this wr as the right edge of the window
//we have to extend the left side of the window, which means the size of this window will be definitely larger
//than the previous one. so we can escape this wr and continue of the next right edge
public class MinSequenceofAdjacent {
	public static int minWindow(int[] nums, int sum){
		if(nums==null||nums.length==0) return 0;
		int n=nums.length;
		int min=n;
		int wl=0, wr=0;
		int currentSum=0;
		while(wr<n){
			currentSum+=nums[wr];
			while(currentSum-nums[wl]>=sum&&wl<wr){
				currentSum-=nums[wl];
				wl++;
			}
			
			if(currentSum>=sum){
				int len=wr-wl+1;
				min=Math.min(len, min);
			}
			wr++;
		}
		return min;
	}
	public static void main(String[] args) {
		int[] nums={2,1,1,4,3,6};
		int r=minWindow(nums, 8);
		System.out.println(r);
	}

}
