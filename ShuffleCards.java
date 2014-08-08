public class ShuffleCard {
	public static void shuffle(int[] cards){
		int temp, index;
		for(int i=0; i<cards.length; i++){
			index=(int) (Math.random()*(cards.length-i))+i;
			temp=cards[i];
			cards[i]=cards[index];
			cards[index]=temp;
		}
	}
	public static void main(String[] args) {
		int[] cards=new int[52];
		for(int i=1; i<52; i++)
			cards[i-1]=i;
		for(int i=0; i<52; i++)
			System.out.print(cards[i]+" ");
		shuffle(cards);
		for(int i=0; i<52; i++)
			System.out.print(cards[i]+" ");
	}

}
