class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //indegree: the prerequisites of current course
        //index is the cur course, val is the num of pre
        int[] indegree = new int[numCourses];
        //Hashmap to create <pre, List of curCourses>
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //pre [cur, pre]
        //add <pre, arraylist of curCourses> and increase indegree of curCouse
        for(int i = 0; i < prerequisites.length; i++) {
            //find the pre
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else { //pre not found
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
            //curCourse indegree++
            indegree[prerequisites[i][0]]++;
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        //find the course with 0 pre
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int cnt = 0; //count BFS visited how many courses to compare with numCouses
        while (!q.isEmpty()) {
            int start = q.poll(); //poll the course with 0 pre, which is the starting point
            cnt++;
            //get the cur of the the starting point
            List<Integer> list = map.get(start);
            if (list != null) {
                int n = list.size(); //how many cur couses has the start as their pre
                //loop through the cur couses and their indegrees--
                for (int i = 0; i < n; i++) {
                    int cur = list.get(i);
                    indegree[cur]--;
                
                //find the next start point, which has 0 indegree
                    if (indegree[cur] == 0) {
                        q.offer(cur);
                    }
                }
            }
            
        }
        return cnt == numCourses;
        
    }
}