// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indedegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        for(int [] prerequisite: prerequisites){
            int dep = prerequisite[0];
            int indep = prerequisite[1];
            indedegree[dep]++;
            if(!map.containsKey(indep)){
                map.put(indep, new ArrayList<>());
            }
            map.get(indep).add(dep);
        }

        //add independent course to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<indedegree.length;i++){
            if(indedegree[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;

        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> childCourse = map.get(cur);
            if(childCourse == null) continue;

            for(int child : childCourse){
                indedegree[child]--;
                if(indedegree[child] == 0){
                    q.add(child);
                    count++;
                    if(count == numCourses) return true;
                }
            }
        }
        return false;
    }
}