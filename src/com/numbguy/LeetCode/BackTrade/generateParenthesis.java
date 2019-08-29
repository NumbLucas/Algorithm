package com.numbguy.LeetCode.BackTrade;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<>();
        dfs(n, n, "", rst);
        return rst;
    }
    public void dfs(int left, int right, String s, List<String> rst) {
        if(0 == left&& 0 == right) {
            rst.add(new String(s));
            return;
        }

        if(left>0)
            dfs(left -1, right, s + "(", rst);
        if(right>left&&left>=0)
            dfs(left, right -1, s + ")", rst);

    }
}
