package com.numbguy.LeetCode.BackTrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
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
            dfs(candidates, i+1, target-candidates[i], item, rst);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] data = {10,1,2,7,6,1,5};
        List<List<Integer>> rst = new ArrayList<>();
        rst = combinationSumII(data, 8);
        System.out.println();
    }
}
