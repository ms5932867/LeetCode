/* 126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
*/

public class Solution {
	Map<String,List<String>> map = new HashMap<>();
	List<List<String>> results = new ArrayList<>();
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {   	
        
        if (dict.size() == 0)
			return results;
        
        int minStep = Integer.MAX_VALUE;
        
        Queue<String> queue= new ArrayDeque<String>();
        queue.add(start);
        
		Map<String, Integer> steps = new HashMap<String,Integer>(); // map : word -> steps to it
		for (String string : dict){
		    steps.put(string, Integer.MAX_VALUE);
		}
		steps.put(start, 0);

		//BFS: build the adjacent graph along with finding the minimum steps
		while (!queue.isEmpty()) {
			String curW = queue.poll();
			
			int step = steps.get(curW) + 1; 
			//'step' indicates how many steps are needed from 'start' to 'curW' 
			if (step > minStep) break;
			
			for (int i = 0; i < curW.length(); i++){
			    StringBuilder builder = new StringBuilder(curW); 
				for (char ch='a'; ch <= 'z'; ch++){
					builder.setCharAt(i,ch);
					String nextW = builder.toString();
					
					if (steps.containsKey(nextW) && step <= steps.get(nextW)) {
                        if (step < steps.get(nextW)){
					    	queue.add(nextW);
					    	steps.put(nextW, step);
					    }
					    
					    if (!map.containsKey(nextW)){ //Build adjacent Graph
					        map.put(nextW, new LinkedList<String>());
					    }
					    map.get(nextW).add(curW);

					    if (nextW.equals(end)) {
					    	minStep = step;
					    }

					}
				}
			}
		}

    	//BackTracking
		LinkedList<String> tmp = new LinkedList<String>();
		backtrack(end, start, tmp);
		return results;        
    }
    
    private void backtrack(String word, String start, List<String> tmp){
    	if (word.equals(start)){
    		tmp.add(0, start);
    		results.add(new ArrayList<String>(tmp));
    		tmp.remove(0);
    		return;
    	}
    	tmp.add(0, word);
    	if (map.get(word) != null){
    		for (String s : map.get(word)){
    			backtrack(s, start, tmp);
    		}
    	}
    	tmp.remove(0);
    }
}