class Solution {
    public int longestSubstring(String s, int k) {
        return longest(s.toCharArray(), 0, s.length(), k, 0);
    }
    
    private int longest(char[] s, int start, int end, int k, int longest) {
       //to count freq 
       int[] count = new int[26];
       
       for(int i=start; i<end; i++)
           count[s[i]-'a']++;
        
       for(int i=start; i<end; i++){
           if(count[s[i]-'a'] < k){ //if some char has freq less than k, split around this character
               if(i-start > longest){ // if left part can be longer than longest, only then check
                   longest = longest(s,start,i,k,longest);
               }
               
               //skip all less than k freq items
               while(i<end && count[s[i]-'a'] < k)
                   i++;
               
               //similarly if right sub arr can give better result, only then check
               if(end-i>longest)
                   longest = longest(s,i,end,k,longest);
               
               //return longest calculated
               return longest;
                   
           }
       }
        
       //nothing returned yet, means no less than k freq item
       // so return full length 
       return end-start; 
    }
}