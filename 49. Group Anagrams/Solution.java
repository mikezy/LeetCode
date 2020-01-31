class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> res = new HashMap<String, List>();
        
        for (String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            //use String key as the Key
            String key = String.valueOf(ca);
            //if key is not in hashmap, add key
            if(!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            //key is added, so add the value
            res.get(key).add(s);
        }
        
        return new ArrayList(res.values());
        

    }
    
   
}