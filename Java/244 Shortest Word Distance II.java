/* 244. Shortest Word Distance II
This is a follow up of Shortest Word Distance. The only difference is now you are given the 
list of words and your method will be called repeatedly many times with different parameters. 
How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that 
takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
*/

public class WordDistance {
	Map<String, List<Integer>> map;
	public WordDistance(String[] words) {
		map=new HashMap<String, List<Integer>>();
		for(int i=0; i<words.length; i++){
			String temp=words[i];
			if(map.containsKey(temp)){
				map.get(temp).add(i);
			}else{
				List<Integer> list=new ArrayList<Integer>();
				list.add(i);
				map.put(temp, list);
			}
		}
	}

	public int shortest(String word1, String word2) {
		int min=Integer.MAX_VALUE;
		List<Integer> list1=map.get(word1);
		List<Integer> list2=map.get(word2);
		int size1=list1.size(), size2=list2.size();
		int i=0, j=0;
		while(i< size1 && j<size2){
			int t1=list1.get(i), t2=list2.get(j);
			if(t1<t2){
				min=Math.min(min, t2-t1);
				i++;
			}else{
				min=Math.min(min, t1-t2);
				j++;
			}
		}                                
		return min;     
	}
}