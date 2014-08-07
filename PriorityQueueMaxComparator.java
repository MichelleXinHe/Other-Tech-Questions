
import java.util.Comparator;

public class MaxComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i, Integer j){
		if(i<j) return 1;
		else if(i==j) return 0;
		else return -1;
	}
}
