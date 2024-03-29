package wordBreak_II_140;

/*
 * https://leetcode.com/problems/word-break-ii/discuss/44264/Java-DFS-%2B-DP-clean-solution
 * 
 * https://leetcode.com/problems/word-break-ii/discuss/44329/Java-DP-and-Backtracking-Solution
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dfs {
	public List<String> wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, new HashMap<String, List<String>>());
    }

    public List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo){
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        
        for(String w : dict) {
            if(!s.startsWith(w)) {
                continue;
            }
            int end = w.length();
            if(end == n) {
                res.add(w);
            } else {
                List<String> sublist = dfs(s.substring(end), dict, memo);
                for(String item : sublist) {
                    item = w + " " + item;
                    res.add(item);
                }
            }
        }
        
        memo.put(s, res);
        return res;
    }
}
