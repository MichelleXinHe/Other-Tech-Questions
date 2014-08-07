import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> min, max;
	public final static int SIZE=5;
	
	public MedianFinder(){
		min=new PriorityQueue<Integer>(SIZE, new MinComparator());
		max=new PriorityQueue<Integer>(SIZE, new MaxComparator());
	}
	
	public void insert(int x){
		if(min.size()==max.size()){//always insert into max
			if(max.peek()==null) max.offer(x);
			else{
				int i=max.peek();
				if(i>=x) max.offer(x);
				else{
					min.offer(x);
					max.offer(min.poll());
				}
			}
		}else{//insert into min
			int i=max.peek();
			if(i<x) min.offer(x);
			else{
				max.offer(x);
				min.offer(max.poll());
			}
		}
	}
	
	public double getMedian() throws Exception{
		if(max.size()==0) throw new Exception("Empty queue error");
		
		if(max.size()==min.size()) return  (double) (max.peek()+min.peek())/2;
		else return max.peek();
	}
	
	public static void main(String[] args) {
		MedianFinder mf=new MedianFinder();
		for(int i=0; i<20; i++){
			mf.insert(i);
			try{
				System.out.println(i+":"+mf.getMedian());
			}catch(Exception e){}
		}
	}

}
