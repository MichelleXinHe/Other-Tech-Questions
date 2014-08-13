import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Time complexity: O(n^2)
public class SortTwoQueues {
	public static Queue<Integer> sort(Queue<Integer> q1, Queue<Integer> q2){
		while(!q2.isEmpty()) q1.offer(q2.poll());
		int count=1;
		int n=q1.size()+q2.size();
		boolean flag=false;
		while(count<=n){
			Queue<Integer> empty=(flag)?q1:q2;
			Queue<Integer> used=(empty==q1)?q2:q1;
			int t=used.poll();
			while(!used.isEmpty()){
				int i=used.poll();
				if(t<i){
					empty.offer(i);
				}else{
					empty.offer(t);
					t=i;
				}
			}
			
			int count2=count-1;
			while(count2>0){
				used.offer(empty.poll());
				count2--;
			}
			used.offer(t);
			count++;
			flag=!flag;
		}
		
		return (q1.isEmpty())?q2:q1;
	}
	public static void main(String[] args) {
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		q1.add(0);
		q1.add(10);
		q1.add(5);
		q1.add(8);
		q1.add(2);
		q1.add(1);
		q1.add(1);
		
		q2.add(7);
		q2.add(10);
		q2.add(4);
		q2.add(3);
		
		Queue<Integer> result=sort(q1, q2);
		Iterator<Integer> it=result.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");

	}

}
