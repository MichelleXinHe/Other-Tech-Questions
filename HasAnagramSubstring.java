import java.util.HashMap;


public class HasAnagramSubstring {
	public static boolean hasAnagramSubstring(String a, String b){
		if(a==null||b==null||a.length()>b.length()) return false;
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<a.length(); i++){
			char c=a.charAt(i);
			if(map.containsKey(c)) map.put(c,  map.get(c)+1);
			else map.put(c, 1);
		}
		
		int m=a.length();
		
		for(int i=0; i<=b.length()-a.length(); i++){
			char c=b.charAt(i);
			if(map.containsKey(c)){
				boolean r=check(map, b.substring(i, i+m));
				if(r) return true;
			}
		}
		return false;
	}
	
	public static boolean check(HashMap<Character, Integer> map, String s){
		HashMap<Character, Integer> set=new HashMap<Character, Integer>(map);
		for(int i=0; i<s.length(); i++){
			char c=s.charAt(i);
			if(!set.containsKey(c)||set.get(c)<=0) return false;
			set.put(c, set.get(c)-1);
		}
		return true;
	}
	public static void main(String[] args) {
		String a="xyz";
		String b="afdgzyaksldfm";
		boolean r=hasAnagramSubstring(a, b);
		System.out.println(r);
	}

}
