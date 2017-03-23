public class Solution {
    public String alienOrder(String[] words) {
        // topological sort
        // 1. build graph
        // 2. BFS
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words);
        return topSort(graph);
    }
    
    private void buildGraph(Map<Character, Set<Character>> graph, String[] words){
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!graph.containsKey(c)){
                    graph.put(c, new HashSet<>());
                }
            }
        }
        for(int i = 1; i < words.length; i++){
            String w1 = words[i - 1], w2 = words[i];
            for(int ii = 0; ii < Math.min(w1.length(), w2.length()); ii++){
                char tail = w1.charAt(ii), head = w2.charAt(ii); 
                if(tail != head){
                    graph.get(head).add(tail);
                    break;
                }
            }
        }
    }
    
    private String topSort(Map<Character, Set<Character>> graph){
        String res = "";
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> indeg = new HashMap<>();
        for(char k : graph.keySet()){
            indeg.put(k, graph.get(k).size());
            if(indeg.get(k) == 0)
                queue.add(k);
        }
        
        while(!queue.isEmpty()){
            char tail = queue.poll();
            res += tail + "";
            for(char k : graph.keySet()){ // cannot modify graph if using iterator on that, ConcurrentModificationException will occur
                if(graph.get(k).contains(tail)){
                    indeg.put(k, indeg.get(k) - 1); 
                    if(indeg.get(k) == 0) queue.add(k);
                }
            }   
        }
        for(char k : indeg.keySet()){
            if(indeg.get(k) != 0) return "";
        }
        return res;
    }
}