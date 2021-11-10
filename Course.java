//Time Complexity : O(N^2);
//Space Complexity : O(N);
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();

        for(int[] pair : prerequisites){
            map.computeIfAbsent(pair[0],k -> new ArrayList<>()).add(pair[1]);
            indegree.put(pair[0],indegree.getOrDefault(pair[0],0));
            indegree.put(pair[1],indegree.getOrDefault(pair[1],0)+1);
        }

        Queue<Integer> q = new LinkedList<>();

        for(var e : indegree.entrySet()){
            if(e.getValue() == 0){
                q.add(e.getKey());
            }
        }

        int edges = prerequisites.length;
        int removedEdges = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(map.containsKey(curr)){
                for(int v : map.get(curr)){
                    indegree.put(v,indegree.get(v)-1);
                    removedEdges++;
                    if(indegree.get(v) == 0){
                        q.add(v);
                    }
                }
            }
        }

        return edges == removedEdges;
    }
}