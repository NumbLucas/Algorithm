package com.numbguy.LeetCode.BackTrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), rst);
        return rst;
    }

    public static void dfs(int[] candidates, int index, int target, ArrayList<Integer> item, List<List<Integer>> rst) {
        if(target < 0)
            return;
        else if(target == 0) {
            rst.add(new ArrayList<>(item));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i > 0&& candidates[i] == candidates[i-1])
                continue;
            item.add(candidates[i]);
            dfs(candidates, i, target-candidates[i], item, rst);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] data = {2,3,7};
        List<List<Integer>> rst = combinationSum(data, 7);
        
    }
}
