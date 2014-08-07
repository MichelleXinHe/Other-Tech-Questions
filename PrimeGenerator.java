//after a certain point, prime numbers are always in the form of 6*i+/-1
public class PrimeNumberGenerator {
	public static boolean[] generator(int n){
		if(n<2) return new boolean[1];
		
		boolean[] flag=new boolean[n+1];
		for(int i=2; i<=n; i++) flag[i]=true;
		int currentPrime=2;
		while(currentPrime<=n){
			cutoff(flag, currentPrime);
			currentPrime=nextPrime(flag, currentPrime);
		}
		return flag;
	}
	
	public static void cutoff(boolean[] flag, int current){
		for(int i=current*current; i<=flag.length-1; i+=current){
			flag[i]=false;
		}
	}
	
	public static int nextPrime(boolean[] flag, int current){
		int next=current+1;
		for(int i=next; i<flag.length; i++){
			if(flag[i]) return i;
		}
		return flag.length;
	}
	public static void main(String[] args) {
		boolean[] b=generator(20);
		for(int i=0; i<b.length; i++){
			if(b[i])
				System.out.println(i);
		}
	}

}
