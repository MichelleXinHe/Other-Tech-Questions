public class CheckPrimeNumber {
	public static boolean check(int n){
		if(n<2) return false;
		int sqrt=(int) Math.sqrt(n);
		for(int i=2; i<=sqrt; i++){
			if(n%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		for(int i=0; i<50; i++){
			System.out.println(i+": "+ check(i));
		}
	}

}
