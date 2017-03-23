/** 133 Clone Graph
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>(); // label -> new address
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        // idea: DFS
        if(map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        
        for(UndirectedGraphNode neighbor : node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
    }
}