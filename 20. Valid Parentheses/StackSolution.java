class Solution {
    public boolean isValid(String s) {
        
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        
        //HashMap stores the correct pairs
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            //init a stack to store the ({[
            
            
            if (charMap.containsValue(s.charAt(i))) {
                st.push(s.charAt(i));
            } else if (st.empty() ||st.peek() != charMap.get(s.charAt(i))) {
                return false;
            } else st.pop();
        }
    
        return (!st.empty()) ? false:true;
        
    }
}